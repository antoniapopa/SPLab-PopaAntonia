package book;

import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component("syncCommandExecutor")
public class SyncCommandExecutor implements CommandExecutor {
    @Override
    public <T> CompletableFuture<T> execute(Command<T> command) {
        return CompletableFuture.completedFuture(command.execute());
    }
}