package book;

import jakarta.persistence.Entity;
import jakarta.persistence.Transient;

@Entity
public class Paragraph extends BaseElement {
    private String text;

    @Transient
    private AlignStrategy alignStrategy;

    public Paragraph() {
    }

    public Paragraph(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setAlignStrategy(AlignStrategy alignStrategy) {
        this.alignStrategy = alignStrategy;
    }

    public void render() {
        if (alignStrategy == null) {
            System.out.println("Paragraph: " + text);
        } else {
            alignStrategy.render(this, new Context(40));
        }
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}