package book;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;


@RestController
@RequestMapping("/books")
public class BooksController {

    private final CrudRepository<Book, Integer> booksRepository;
    private final AllBooksSubject allBooksSubject;
    private final CommandExecutor syncExecutor;
    private final CommandExecutor asyncExecutor;
    private final AsyncRequestRegistry requestRegistry;

    public BooksController(CrudRepository<Book, Integer> booksRepository,
                           AllBooksSubject allBooksSubject,
                           @Qualifier("syncCommandExecutor") CommandExecutor syncExecutor,
                           @Qualifier("asyncCommandExecutor") CommandExecutor asyncExecutor,
                           AsyncRequestRegistry requestRegistry) {
        this.booksRepository = booksRepository;
        this.allBooksSubject = allBooksSubject;
        this.syncExecutor = syncExecutor;
        this.asyncExecutor = asyncExecutor;
        this.requestRegistry = requestRegistry;
    }

    private CommandContext newContext() {
        return new CommandContext(booksRepository);
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAll() {
        return ResponseEntity.ok(syncExecutor.execute(new GetAllBooksCommand(newContext())).join());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(
                syncExecutor.execute(new GetBookByIdCommand(newContext().withBookId(id))).join());
    }


    @PostMapping
    public ResponseEntity<Map<String, String>> create(@RequestBody BookRequest request) {
        CompletableFuture<Book> future =
                asyncExecutor.execute(new CreateBookCommand(newContext().withRequest(request)));

        future.thenAccept(allBooksSubject::add);

        String requestId = requestRegistry.register(future);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(Map.of(
                "requestId", requestId,
                "statusUrl", "/books/requests/" + requestId));
    }

    @GetMapping("/requests/{requestId}")
    public ResponseEntity<RequestStatus> getRequestStatus(@PathVariable String requestId) {
        return requestRegistry.getStatus(requestId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> update(@PathVariable Integer id, @RequestBody BookRequest request) {
        return ResponseEntity.ok(syncExecutor.execute(
                new UpdateBookCommand(newContext().withBookId(id).withRequest(request))).join());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        syncExecutor.execute(new DeleteBookCommand(newContext().withBookId(id))).join();
        return ResponseEntity.noContent().build();
    }
}