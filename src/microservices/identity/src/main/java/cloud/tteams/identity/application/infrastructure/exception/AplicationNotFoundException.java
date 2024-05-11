package cloud.tteams.identity.application.infrastructure.exception;

public class AplicationNotFoundException extends RuntimeException {

    public AplicationNotFoundException(String message) {
        super(message);
    }

}
