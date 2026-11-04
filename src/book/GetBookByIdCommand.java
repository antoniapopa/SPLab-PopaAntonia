package book;

public class GetBookByIdCommand implements Command<Book> {
    private final CommandContext context;

    public GetBookByIdCommand(CommandContext context) {
        this.context = context;
    }

    @Override
    public Book execute() {
        Integer id = context.getBookId();
        return context.getBooksRepository().findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
    }
}