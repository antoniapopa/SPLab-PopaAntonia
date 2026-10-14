package book;

import java.util.ArrayList;
import java.util.List;

public class TableOfContents implements Element {
    private List<String> entries = new ArrayList<>();

    public void addEntry(String entry) {
        entries.add(entry);
    }

    public List<String> getEntries() {
        return entries;
    }

    @Override
    public void print() {
        System.out.println("Table of Contents");
        for (String entry : entries) {
            System.out.println(entry);
        }
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}