package book;

public interface Element {
    void print();

    void accept(Visitor visitor);

    default void add(Element element) {
        throw new UnsupportedOperationException();
    }

    default void remove(Element element) {
        throw new UnsupportedOperationException();
    }

    default Element get(int index) {
        throw new UnsupportedOperationException();
    }
}