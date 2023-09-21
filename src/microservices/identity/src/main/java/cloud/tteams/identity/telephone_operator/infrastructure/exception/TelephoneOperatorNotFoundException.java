package cloud.tteams.identity.telephone_operator.infrastructure.exception;

public class TelephoneOperatorNotFoundException extends RuntimeException {

    public TelephoneOperatorNotFoundException() {
        super("Telephone Operator not found!");
    }

    public TelephoneOperatorNotFoundException(String message) {
        super(message);
    }

}
