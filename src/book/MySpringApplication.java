package book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MySpringApplication {
    public static void main(String[] args) {
        // Obținem contextul Spring Boot
        ApplicationContext context = SpringApplication.run(MySpringApplication.class, args);

        // Preluăm o instanță de TransientComponent din contextul DI
        TransientComponent transientBean = context.getBean(TransientComponent.class);
        transientBean.operation();

        // Fiecare cerere creează o nouă instanță (prototype scope)
        transientBean = context.getBean(TransientComponent.class);
        transientBean.operation();

        // Preluăm o instanță de SingletonComponent din contextul DI
        SingletonComponent singletonBean = context.getBean(SingletonComponent.class);
        singletonBean.operation();

        // Fiecare cerere va returna aceeași instanță unică (singleton scope)
        singletonBean = context.getBean(SingletonComponent.class);
        singletonBean.operation();

        // Preluăm o instanță de ClientComponent
        ClientComponent c = context.getBean(ClientComponent.class);
        c.operation();

        // Preluăm instanța din context după numele bean-ului
        c = context.getBean("clientComponent", ClientComponent.class);
        c.operation();
    }
}