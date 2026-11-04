package book;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Entity
public class TableOfContents extends BaseElement {

    @ElementCollection
    private List<String> entries = new ArrayList<>();

    public TableOfContents() {
    }

    public List<String> getEntries() {
        return entries;
    }

    public void addEntry(String entry) {
        entries.add(entry);
    }

    public void render() {
        System.out.println("Table of Contents");
        for (String e : entries) {
            System.out.println(" - " + e);
        }
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}