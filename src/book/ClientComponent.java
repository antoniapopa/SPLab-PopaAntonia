package book;

import org.springframework.stereotype.Component;

@Component("clientComponent")
public class ClientComponent {
    private final TransientComponent transientComponent;
    private final SingletonComponent singletonComponent;

    public ClientComponent(TransientComponent transientComponent, SingletonComponent singletonComponent) {
        this.transientComponent = transientComponent;
        this.singletonComponent = singletonComponent;
    }

    public void operation() {
        System.out.println("ClientComponent executat: " + this);
    }
}