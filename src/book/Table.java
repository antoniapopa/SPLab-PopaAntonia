package book;

import jakarta.persistence.Entity;

@Entity
@jakarta.persistence.Table(name = "BookTable")
public class Table extends BaseElement {
    private String title;

    public Table() {
    }

    public Table(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void render() {
        System.out.println("Table with title:" + title);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}