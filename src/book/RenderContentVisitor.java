package book;

public class RenderContentVisitor implements Visitor {
    @Override
    public void visit(Book book) {
        System.out.println("Book: " + book.getTitle());
        System.out.println("Authors:");
        for (Author a : book.getAuthors()) {
            a.print();
        }
        for (Element e : book.getElements()) {
            e.accept(this);
        }
    }

    @Override
    public void visit(Section section) {
        System.out.println(section.getTitle());
        for (Element e : section.getChildren()) {
            e.accept(this);
        }
    }

    @Override
    public void visit(TableOfContents toc) {
        toc.print();
    }

    @Override
    public void visit(Paragraph paragraph) {
        paragraph.print();
    }

    @Override
    public void visit(ImageProxy imageProxy) {
        imageProxy.print();
    }

    @Override
    public void visit(Table table) {
        table.print();
    }
}