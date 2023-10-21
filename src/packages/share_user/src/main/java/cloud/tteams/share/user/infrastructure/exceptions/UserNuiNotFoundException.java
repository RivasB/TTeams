package cloud.tteams.share.user.infrastructure.exceptions;

public class UserNuiNotFoundException extends RuntimeException {

    public UserNuiNotFoundException() {
        super("User nui not found!");
    }

    public UserNuiNotFoundException(String message) {
        super(message);
    }
}
