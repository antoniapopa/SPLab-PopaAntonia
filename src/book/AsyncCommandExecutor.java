package book;

import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@Component("asyncCommandExecutor")
public class AsyncCommandExecutor implements CommandExecutor {
    private final ExecutorService pool = Executors.newFixedThreadPool(4);

    @Override
    public <T> CompletableFuture<T> execute(Command<T> command) {
        return CompletableFuture.supplyAsync(command::execute, pool);
    }

    @PreDestroy
    public void shutdown() {
        pool.shutdown();
    }
}