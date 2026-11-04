package book;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Book extends Section {

    // fără REMOVE în cascadă: un autor poate avea mai multe cărți
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Author> authors = new ArrayList<>();

    public Book() {
    }

    public Book(String title) {
        super(title);
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void addAuthor(Author author) {
        authors.add(author);
    }

    public void addContent(Element e) {
        add(e);
    }

    public void addContentFirst(Element e) {
        children.add(0, e);
    }

    @Override
    public void render() {
        System.out.println("Book: " + title);
        System.out.println("Authors:");
        for (Author a : authors) {
            a.print();
        }
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
        for (Element e : children) {
            e.accept(visitor);
        }
    }
}