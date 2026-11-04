package book;

import java.util.List;

public record BookRequest(String title, List<AuthorRequest> authors) {
    public record AuthorRequest(String name, String surname) {
    }
}