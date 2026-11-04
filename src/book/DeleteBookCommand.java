package book;

public class DeleteBookCommand implements Command<Void> {
    private final CommandContext context;

    public DeleteBookCommand(CommandContext context) {
        this.context = context;
    }

    @Override
    public Void execute() {
        Integer id = context.getBookId();
        if (!context.getBooksRepository().existsById(id)) {
            throw new BookNotFoundException(id);
        }
        context.getBooksRepository().deleteById(id);
        return null;
    }
}