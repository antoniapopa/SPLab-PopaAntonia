package book;
public class Table implements Element {
    private String title;

    public Table(String title) {
        this.title = title;
    }

    public void render() {
        System.out.println("Table with title:" + title);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}