package fullstack.service.exception;

public class SmsSendingException extends RuntimeException {
    public SmsSendingException(String message) {
        super(message);
    }
}

