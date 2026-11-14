package book;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;


@Component
public class AsyncRequestRegistry {
    private final Map<String, CompletableFuture<?>> requests = new ConcurrentHashMap<>();

    public String register(CompletableFuture<?> future) {
        String id = UUID.randomUUID().toString();
        requests.put(id, future);
        return id;
    }

    public Optional<RequestStatus> getStatus(String id) {
        CompletableFuture<?> future = requests.get(id);
        if (future == null) {
            return Optional.empty();
        }
        if (!future.isDone()) {
            return Optional.of(new RequestStatus(id, "PENDING", null, null));
        }
        try {
            return Optional.of(new RequestStatus(id, "DONE", future.join(), null));
        } catch (RuntimeException e) {
            Throwable cause = e.getCause() != null ? e.getCause() : e;
            return Optional.of(new RequestStatus(id, "FAILED", null, cause.getMessage()));
        }
    }
}