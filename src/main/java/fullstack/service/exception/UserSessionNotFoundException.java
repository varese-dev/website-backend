package fullstack.service.exception;

public class UserSessionNotFoundException extends Exception {
    public UserSessionNotFoundException(String message) {
        super(message);
    }
}
