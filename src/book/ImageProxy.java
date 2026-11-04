package book;

import jakarta.persistence.Entity;
import jakarta.persistence.Transient;

@Entity
public class ImageProxy extends BaseElement {
    private String url;

    @Transient
    private Image realImg;

    public ImageProxy() {
    }

    public ImageProxy(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    private Image loadImage() {
        if (realImg == null) {
            realImg = new Image(url);
        }
        return realImg;
    }

    public void render() {
        loadImage().render();
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}