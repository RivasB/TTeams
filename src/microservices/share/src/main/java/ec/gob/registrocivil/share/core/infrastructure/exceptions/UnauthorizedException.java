package ec.gob.registrocivil.share.core.infrastructure.exceptions;

public class UnauthorizedException extends Exception {
    public UnauthorizedException(String message) {
        super(message);
    }
}