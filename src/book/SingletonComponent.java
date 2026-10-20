package book;

import org.springframework.stereotype.Component;

@Component
public class SingletonComponent {
    public void operation() {
        System.out.println("SingletonComponent executat: " + this);
    }
}