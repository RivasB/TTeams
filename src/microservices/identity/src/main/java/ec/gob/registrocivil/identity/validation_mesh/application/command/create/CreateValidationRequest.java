package ec.gob.registrocivil.identity.validation_mesh.application.command.create;

public class CreateValidationRequest {

    private String cedulaCondition;

    private Boolean canCreateAVAccount;

    private Boolean canChangeName;

    private Boolean canPayRegistrationNotarialDeed;

    private Boolean canPayValidationOfDocuments;

    public CreateValidationRequest(String cedulaCondition, Boolean canCreateAVAccount, Boolean canChangeName,
            Boolean canPayRegistrationNotarialDeed, Boolean canPayValidationOfDocuments) {
        this.cedulaCondition = cedulaCondition;
        this.canCreateAVAccount = canCreateAVAccount;
        this.canChangeName = canChangeName;
        this.canPayRegistrationNotarialDeed = canPayRegistrationNotarialDeed;
        this.canPayValidationOfDocuments = canPayValidationOfDocuments;
    }

    public String getCedulaCondition() {
        return cedulaCondition;
    }

    public Boolean getCanCreateAVAccount() {
        return canCreateAVAccount;
    }

    public Boolean getCanChangeName() {
        return canChangeName;
    }

    public Boolean getCanPayRegistrationNotarialDeed() {
        return canPayRegistrationNotarialDeed;
    }

    public Boolean getCanPayValidationOfDocuments() {
        return canPayValidationOfDocuments;
    }

}
