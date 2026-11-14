package book;

public class CreateBookCommand implements Command<Book> {
    private final CommandContext context;

    public CreateBookCommand(CommandContext context) {
        this.context = context;
    }

    @Override
    public Book execute() {
        BookRequest req = context.getRequest();


        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        Book book = new Book(req.title());
        if (req.authors() != null) {
            for (BookRequest.AuthorRequest a : req.authors()) {
                book.addAuthor(new Author(a.name(), a.surname()));
            }
        }
        return context.getBooksRepository().save(book);
    }
}