package book;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Section extends BaseElement {
    protected String title;

    @OneToMany(targetEntity = BaseElement.class, cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderColumn(name = "elementOrder")
    protected List<Element> children = new ArrayList<>();

    public Section() {
    }

    public Section(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Element> getChildren() {
        return children;
    }

    // verifica daca elementul are deja un parinte; daca nu, il leaga de sectiunea curenta
    protected void attachChild(Element e) {
        BaseElement child = (BaseElement) e;
        if (child.getParent() != null) {
            throw new IllegalStateException(
                    "Elementul apartine deja altei sectiuni si nu poate fi adaugat de doua ori");
        }
        child.setParent(this);
    }

    @Override
    public void add(Element e) {
        attachChild(e);
        children.add(e);
    }

    @Override
    public void remove(Element e) {
        if (children.remove(e)) {
            ((BaseElement) e).setParent(null);
        }
    }

    @Override
    public Element get(int index) {
        return children.get(index);
    }

    public void render() {
        System.out.println(title);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
        for (Element e : children) {
            e.accept(visitor);
        }
    }
}