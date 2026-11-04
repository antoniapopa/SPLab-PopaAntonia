package book;

public class CommandContext {
    private final CrudRepository<Book, Integer> booksRepository;
    private Integer bookId;
    private BookRequest request;

    public CommandContext(CrudRepository<Book, Integer> booksRepository) {
        this.booksRepository = booksRepository;
    }

    public CrudRepository<Book, Integer> getBooksRepository() {
        return booksRepository;
    }

    public Integer getBookId() {
        return bookId;
    }

    public CommandContext withBookId(Integer bookId) {
        this.bookId = bookId;
        return this;
    }

    public BookRequest getRequest() {
        return request;
    }

    public CommandContext withRequest(BookRequest request) {
        this.request = request;
        return this;
    }
}