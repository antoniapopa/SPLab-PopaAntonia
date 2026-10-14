package book;

public class Main {
    public static void main(String[] args) throws Exception {
        Book book = new Book("Noapte buna, copii!");
        book.addAuthor(new Author("Radu Pavel", "Gheo"));

        Section cap1 = new Section("Capitolul 1");
        Section cap11 = new Section("Capitolul 1.1");
        Section cap111 = new Section("Capitolul 1.1.1");
        book.addContent(new Paragraph("Multumesc celor care ..."));
        book.addContent(cap1);
        cap1.add(new Paragraph("Moto capitol"));
        cap1.add(cap11);
        cap11.add(new Paragraph("Text from subchapter 1.1"));
        cap11.add(cap111);
        cap111.add(new ImageProxy("Image subchapter 1.1.1"));
        cap111.add(new Table("Tabel 1"));

        GenerateToC generateToC = new GenerateToC();
        book.accept(generateToC);
        TableOfContents toc = generateToC.getToC();
        book.addContentFirst(toc);

        System.out.println("--- Render ---");
        book.accept(new RenderContentVisitor());

        System.out.println();
        System.out.println("--- Statistics ---");
        BookStatistics stats = new BookStatistics();
        book.accept(stats);
        stats.printStatistics();
    }
}