package book;

public class GenerateToC implements Visitor {
    private TableOfContents toc = new TableOfContents();
    private int level = 0;

    @Override
    public void visit(Book book) {
        toc.addEntry(book.getTitle());
        level++;
        for (Element e : book.getElements()) {
            e.accept(this);
        }
        level--;
    }

    @Override
    public void visit(Section section) {
        toc.addEntry("  ".repeat(level) + section.getTitle());
        level++;
        for (Element e : section.getChildren()) {
            e.accept(this);
        }
        level--;
    }

    @Override
    public void visit(TableOfContents t) { }

    @Override
    public void visit(Paragraph paragraph) { }

    @Override
    public void visit(ImageProxy imageProxy) { }

    @Override
    public void visit(Table table) { }

    public TableOfContents getToC() {
        return toc;
    }
}