package book;
import java.util.ArrayList;
import java.util.List;

public class TableOfContents implements Element {
    private List<String> entries = new ArrayList<>();

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