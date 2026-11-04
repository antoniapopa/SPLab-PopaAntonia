package book;

import jakarta.persistence.Entity;
import java.util.concurrent.TimeUnit;

@Entity
public class Image extends BaseElement {
    private String url;

    // folosit de Hibernate la citirea din DB (fără sleep)
    public Image() {
    }

    public Image(String name) {
        this.url = name;
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getUrl() {
        return url;
    }

    public void render() {
        System.out.println("Image with name:" + url);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}