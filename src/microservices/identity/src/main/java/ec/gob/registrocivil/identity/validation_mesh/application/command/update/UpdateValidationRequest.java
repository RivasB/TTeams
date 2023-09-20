package ec.gob.registrocivil.identity.validation_mesh.application.command.update;

import java.util.UUID;

public class UpdateValidationRequest {

    private UUID id;

    private String cedulaCondition;

    private Boolean canCreateAVAccount;

    private Boolean canChangeName;

    private Boolean canPayRegistrationNotarialDeed;

    private Boolean canPayValidationOfDocuments;

    public UpdateValidationRequest(UUID id, String cedulaCondition, Boolean canCreateAVAccount, Boolean canChangeName,
            Boolean canPayRegistrationNotarialDeed, Boolean canPayValidationOfDocuments) {
        this.id = id;
        this.cedulaCondition = cedulaCondition;
        this.canCreateAVAccount = canCreateAVAccount;
        this.canChangeName = canChangeName;
        this.canPayRegistrationNotarialDeed = canPayRegistrationNotarialDeed;
        this.canPayValidationOfDocuments = canPayValidationOfDocuments;
    }

    public UUID getId() {
        return id;
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
