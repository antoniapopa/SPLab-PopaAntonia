package book;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final CrudRepository<Book, Integer> booksRepository;

    public DataLoader(CrudRepository<Book, Integer> booksRepository) {
        this.booksRepository = booksRepository;
    }

    @Override
    public void run(String... args) {
        if (!booksRepository.findAll().isEmpty()) {
            return;
        }
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

        booksRepository.save(book);
    }
}