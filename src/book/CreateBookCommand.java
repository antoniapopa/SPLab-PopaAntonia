package book;

public class CreateBookCommand implements Command<Book> {
    private final CommandContext context;

    public CreateBookCommand(CommandContext context) {
        this.context = context;
    }

    @Override
    public Book execute() {
        BookRequest req = context.getRequest();
        Book book = new Book(req.title());
        if (req.authors() != null) {
            for (BookRequest.AuthorRequest a : req.authors()) {
                book.addAuthor(new Author(a.name(), a.surname()));
            }
        }
        book = context.getBooksRepository().save(book);
        return book;
    }
}