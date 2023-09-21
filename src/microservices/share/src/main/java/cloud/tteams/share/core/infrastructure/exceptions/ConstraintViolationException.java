package cloud.tteams.share.core.infrastructure.exceptions;

public class ConstraintViolationException extends RuntimeException {
    public ConstraintViolationException(String message) {
        super(message);
    }
}
