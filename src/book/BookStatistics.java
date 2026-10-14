package book;

public class BookStatistics implements Visitor {
    private int books, sections, tocs, paragraphs, images, tables;

    @Override
    public void visit(Book book) {
        books++;
        for (Element e : book.getElements()) {
            e.accept(this);
        }
    }

    @Override
    public void visit(Section section) {
        sections++;
        for (Element e : section.getChildren()) {
            e.accept(this);
        }
    }

    @Override
    public void visit(TableOfContents toc) {
        tocs++;
    }

    @Override
    public void visit(Paragraph paragraph) {
        paragraphs++;
    }

    @Override
    public void visit(ImageProxy imageProxy) {
        images++;
    }

    @Override
    public void visit(Table table) {
        tables++;
    }

    public void printStatistics() {
        System.out.println("Book statistics:");
        System.out.println("  Books: " + books);
        System.out.println("  Sections: " + sections);
        System.out.println("  Tables of contents: " + tocs);
        System.out.println("  Paragraphs: " + paragraphs);
        System.out.println("  Images: " + images);
        System.out.println("  Tables: " + tables);
    }
}