package book;

public class UpdateBookCommand implements Command<Book> {
    private final CommandContext context;

    public UpdateBookCommand(CommandContext context) {
        this.context = context;
    }

    @Override
    public Book execute() {
        Integer id = context.getBookId();
        Book book = context.getBooksRepository().findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));

        BookRequest req = context.getRequest();
        if (req.title() != null) {
            book.setTitle(req.title());
        }
        if (req.authors() != null) {
            book.getAuthors().clear();
            for (BookRequest.AuthorRequest a : req.authors()) {
                book.addAuthor(new Author(a.name(), a.surname()));
            }
        }
        return context.getBooksRepository().save(book);
    }
}