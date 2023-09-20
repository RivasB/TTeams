package ec.gob.registrocivil.identity.validation_mesh.domain;

public class Validation {

    private ValidationId id;

    private ValidationDescription cedulaCondition;

    private ValidationCondition canCreateAVAccount;

    private ValidationCondition canChangeName;

    private ValidationCondition canPayRegistrationNotarialDeed;

    private ValidationCondition canPayValidationOfDocuments;

    public Validation(ValidationId id, ValidationDescription cedulaCondition, ValidationCondition canCreateAVAccount,
            ValidationCondition canChangeName, ValidationCondition canPayRegistrationNotarialDeed,
            ValidationCondition canPayValidationOfDocuments) {
        this.id = id;
        this.cedulaCondition = cedulaCondition;
        this.canCreateAVAccount = canCreateAVAccount;
        this.canChangeName = canChangeName;
        this.canPayRegistrationNotarialDeed = canPayRegistrationNotarialDeed;
        this.canPayValidationOfDocuments = canPayValidationOfDocuments;
    }

    public ValidationId getId() {
        return id;
    }

    public ValidationDescription getCedulaCondition() {
        return cedulaCondition;
    }

    public ValidationCondition getCanCreateAVAccount() {
        return canCreateAVAccount;
    }

    public ValidationCondition getCanChangeName() {
        return canChangeName;
    }

    public ValidationCondition getCanPayRegistrationNotarialDeed() {
        return canPayRegistrationNotarialDeed;
    }

    public ValidationCondition getCanPayValidationOfDocuments() {
        return canPayValidationOfDocuments;
    }

}
