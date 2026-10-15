package book;
public interface Element {
    void accept(Visitor visitor);

    default void add(Element e) {
        throw new UnsupportedOperationException();
    }

    default void remove(Element e) {
        throw new UnsupportedOperationException();
    }

    default Element get(int index) {
        throw new UnsupportedOperationException();
    }
}