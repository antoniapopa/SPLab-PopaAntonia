package book;
public class Main {
    public static void main(String[] args) throws Exception {
        Section cap1 = new Section("Capitolul 1");
        Paragraph p1 = new Paragraph("Paragraph 1");
        cap1.add(p1);
        Paragraph p2 = new Paragraph("Paragraph 2");
        cap1.add(p2);
        Paragraph p3 = new Paragraph("Paragraph 3");
        cap1.add(p3);
        Paragraph p4 = new Paragraph("Paragraph 4");
        cap1.add(p4);
        cap1.add(new ImageProxy("ImageOne"));
        cap1.add(new Image("ImageTwo"));
        cap1.add(new Paragraph("Some text"));
        cap1.add(new Table("Table 1"));

        BookStatistics stats = new BookStatistics();
        cap1.accept(stats);
        stats.printStatistics();

        System.out.println();
        Book book = new Book("Noapte buna, copii!");
        book.addAuthor(new Author("Radu Pavel", "Gheo"));

        Section c1 = new Section("Capitolul 1");
        Section c11 = new Section("Capitolul 1.1");
        Section c111 = new Section("Capitolul 1.1.1");
        book.addContent(new Paragraph("Multumesc celor care ..."));
        book.addContent(c1);
        c1.add(new Paragraph("Moto capitol"));
        c1.add(c11);
        c11.add(new Paragraph("Text from subchapter 1.1"));
        c11.add(c111);
        c111.add(new ImageProxy("Image subchapter 1.1.1"));
        c111.add(new Table("Tabel 1"));

        GenerateToC generateToC = new GenerateToC();
        book.accept(generateToC);
        book.addContentFirst(generateToC.getToC());

        System.out.println("--- Render ---");
        book.accept(new RenderContentVisitor());

        System.out.println();
        System.out.println("--- Statistics ---");
        BookStatistics bookStats = new BookStatistics();
        book.accept(bookStats);
        bookStats.printStatistics();
    }
}