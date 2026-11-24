package book;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class BaseElement implements Element {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // parintele elementului; nu se salveaza in DB si nu apare in JSON
    @Transient
    @JsonIgnore
    private Element parent;

    public BaseElement() {
    }

    public Integer getId() {
        return id;
    }

    @JsonIgnore
    public Element getParent() {
        return parent;
    }

    public void setParent(Element parent) {
        this.parent = parent;
    }

    @Override
    public void accept(Visitor visitor) {
    }
}