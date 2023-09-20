package ec.gob.registrocivil.identity.validation_mesh.application.query.find;

import java.util.UUID;

import ec.gob.registrocivil.share.core.domain.bus.query.IResponse;
import ec.gob.registrocivil.identity.validation_mesh.domain.Validation;

public class FindValidationResponse implements IResponse {

    private UUID id;

    private String cedulaCondition;

    private Boolean canCreateAVAccount;

    private Boolean canChangeName;

    private Boolean canPayRegistrationNotarialDeed;

    private Boolean canPayValidationOfDocuments;

    public FindValidationResponse(UUID id, String cedulaCondition, Boolean canCreateAVAccount, Boolean canChangeName,
            Boolean canPayRegistrationNotarialDeed, Boolean canPayValidationOfDocuments) {
        this.id = id;
        this.cedulaCondition = cedulaCondition;
        this.canCreateAVAccount = canCreateAVAccount;
        this.canChangeName = canChangeName;
        this.canPayRegistrationNotarialDeed = canPayRegistrationNotarialDeed;
        this.canPayValidationOfDocuments = canPayValidationOfDocuments;
    }

    public FindValidationResponse(Validation validation) {
        this.id = validation.getId().value();
        this.cedulaCondition = validation.getCedulaCondition().value();
        this.canCreateAVAccount = validation.getCanCreateAVAccount().value();
        this.canChangeName = validation.getCanChangeName().value();
        this.canPayRegistrationNotarialDeed = validation.getCanPayRegistrationNotarialDeed().value();
        this.canPayValidationOfDocuments = validation.getCanPayValidationOfDocuments().value();
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
