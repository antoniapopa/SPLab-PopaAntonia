package book;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/books")
public class BooksController {

    private final CrudRepository<Book, Integer> booksRepository;

    public BooksController(CrudRepository<Book, Integer> booksRepository) {
        this.booksRepository = booksRepository;
    }

    private CommandContext newContext() {
        return new CommandContext(booksRepository);
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAll() {
        return ResponseEntity.ok(new GetAllBooksCommand(newContext()).execute());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(new GetBookByIdCommand(newContext().withBookId(id)).execute());
    }

    @PostMapping
    public ResponseEntity<Map<String, Integer>> create(@RequestBody BookRequest request) {
        Book book = new CreateBookCommand(newContext().withRequest(request)).execute();
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("id", book.getId()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> update(@PathVariable Integer id, @RequestBody BookRequest request) {
        return ResponseEntity.ok(
                new UpdateBookCommand(newContext().withBookId(id).withRequest(request)).execute());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        new DeleteBookCommand(newContext().withBookId(id)).execute();
        return ResponseEntity.noContent().build();
    }
}