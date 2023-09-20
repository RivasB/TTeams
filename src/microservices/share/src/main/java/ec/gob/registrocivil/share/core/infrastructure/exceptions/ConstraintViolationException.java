package ec.gob.registrocivil.share.core.infrastructure.exceptions;

public class ConstraintViolationException extends RuntimeException {
    public ConstraintViolationException(String message) {
        super(message);
    }
}
