package book;

public class Main {
    public static void main(String[] args) {
        Book book = new Book("Noobs guide to design patterns");
        book.addAuthor(new Author("Antonia", "Popa"));

        Section cap1 = new Section("Capitolul 1");
        cap1.add(new Paragraph("Primul paragraf"));
        cap1.add(new Image("poza.png"));

        Section sub = new Section("Subcapitolul 1.1");
        sub.add(new Table("Tabel comparativ"));
        cap1.add(sub);

        book.addContent(new TableOfContents());
        book.addContent(cap1);

        book.print();
    }
}