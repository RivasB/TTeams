package cloud.tteams.identity.authorization.infrastructure.exception;

public class AuthorizationNotFoundException extends RuntimeException {

    public AuthorizationNotFoundException() {
        super("Authorization not found!");
    }

}
