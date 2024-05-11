package cloud.tteams.identity.authorization.infrastructure.exception;

public class AccessNotFoundException extends RuntimeException {

    public AccessNotFoundException() {
        super("Access not found!");
    }

    public AccessNotFoundException(String message) {
        super(message);
    }
}
