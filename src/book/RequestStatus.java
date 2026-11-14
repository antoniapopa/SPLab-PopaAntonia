package book;

public record RequestStatus(String requestId, String status, Object result, String error) {
}