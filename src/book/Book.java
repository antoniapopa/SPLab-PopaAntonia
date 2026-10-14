package book;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private String title;
    private List<Author> authors = new ArrayList<>();
    private List<Element> elements = new ArrayList<>();

    public Book(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public List<Element> getElements() {
        return elements;
    }

    public void addAuthor(Author author) {
        authors.add(author);
    }

    public void addContent(Element element) {
        elements.add(element);
    }

    public void addContentFirst(Element element) {
        elements.add(0, element);
    }

    public void print() {
        System.out.println("Book: " + title);
        for (Author a : authors) {
            a.print();
        }
        for (Element e : elements) {
            e.print();
        }
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}