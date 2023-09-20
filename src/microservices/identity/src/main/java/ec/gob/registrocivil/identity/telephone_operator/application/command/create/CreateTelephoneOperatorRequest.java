package ec.gob.registrocivil.identity.telephone_operator.application.command.create;

public class CreateTelephoneOperatorRequest {

    private String name;

    public CreateTelephoneOperatorRequest() {
    }

    public CreateTelephoneOperatorRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
