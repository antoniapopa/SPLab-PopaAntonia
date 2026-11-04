package book;

public interface Command<T> {
    T execute();
}