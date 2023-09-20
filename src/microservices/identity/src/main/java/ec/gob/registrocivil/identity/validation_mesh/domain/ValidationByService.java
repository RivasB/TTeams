package ec.gob.registrocivil.identity.validation_mesh.domain;

public class ValidationByService {

    private ValidationByServiceId id;

    private Validation validation;

    private ValidationServiceType type;

    private ValidationCivilStatus status;

    private ValidationCondition canRequestBirth;

    private ValidationCondition canRequestMarriage;

    private ValidationCondition canRequestDeath;

    private ValidationCondition canRequestDeFactoUnion;

    private ValidationCondition canRequestIdentityAndCivilStatus;

    public ValidationByService(ValidationByServiceId id, Validation validation, ValidationServiceType type,
            ValidationCivilStatus status, ValidationCondition canRequestBirth, ValidationCondition canRequestMarriage,
            ValidationCondition canRequestDeath, ValidationCondition canRequestDeFactoUnion) {
        this.id = id;
        this.validation = validation;
        this.type = type;
        this.status = status;
        this.canRequestBirth = canRequestBirth;
        this.canRequestMarriage = canRequestMarriage;
        this.canRequestDeath = canRequestDeath;
        this.canRequestDeFactoUnion = canRequestDeFactoUnion;
        this.canRequestIdentityAndCivilStatus = null;
    }

    public ValidationByService(ValidationByServiceId id, Validation validation, ValidationServiceType type,
            ValidationCivilStatus status, ValidationCondition canRequestBirth, ValidationCondition canRequestMarriage,
            ValidationCondition canRequestDeath, ValidationCondition canRequestDeFactoUnion,
            ValidationCondition canRequestIdentityAndCivilStatus) {
        this.id = id;
        this.validation = validation;
        this.type = type;
        this.status = status;
        this.canRequestBirth = canRequestBirth;
        this.canRequestMarriage = canRequestMarriage;
        this.canRequestDeath = canRequestDeath;
        this.canRequestDeFactoUnion = canRequestDeFactoUnion;
        this.canRequestIdentityAndCivilStatus = canRequestIdentityAndCivilStatus;
    }

    public ValidationByServiceId getId() {
        return id;
    }

    public Validation getValidation() {
        return validation;
    }

    public ValidationServiceType getType() {
        return type;
    }

    public ValidationCivilStatus getStatus() {
        return status;
    }

    public ValidationCondition getCanRequestBirth() {
        return canRequestBirth;
    }

    public ValidationCondition getCanRequestMarriage() {
        return canRequestMarriage;
    }

    public ValidationCondition getCanRequestDeath() {
        return canRequestDeath;
    }

    public ValidationCondition getCanRequestDeFactoUnion() {
        return canRequestDeFactoUnion;
    }

    public ValidationCondition getCanRequestIdentityAndCivilStatus() {
        return canRequestIdentityAndCivilStatus;
    }

}
