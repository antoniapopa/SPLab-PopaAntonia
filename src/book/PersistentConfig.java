package book;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersistentConfig {

    @Bean
    public CrudRepository<Book, Integer> booksCrudRepository(BooksRepository repo) {
        return new JpaRepositoryAdapter<>(repo);
    }

    @Bean
    public CrudRepository<Author, Integer> authorsCrudRepository(AuthorsRepository repo) {
        return new JpaRepositoryAdapter<>(repo);
    }
}