package cloud.tteams.identity.validation_mesh.application.query.find;

import java.util.UUID;

import cloud.tteams.share.core.domain.bus.query.IResponse;
import cloud.tteams.identity.validation_mesh.domain.ValidationByService;
import cloud.tteams.identity.validation_mesh.domain.ValidationCivilStatus;
import cloud.tteams.identity.validation_mesh.domain.ValidationServiceType;

public class FindValidationByServiceCertificateResponse implements IResponse {

    private UUID validation;

    private ValidationServiceType type;

    private ValidationCivilStatus status;

    private Boolean canRequestBirth;

    private Boolean canRequestMarriage;

    private Boolean canRequestDeath;

    private Boolean canRequestDeFactoUnion;

    private Boolean canRequestIdentityAndCivilStatus;

    public FindValidationByServiceCertificateResponse(UUID validation, ValidationServiceType type,
            ValidationCivilStatus status, Boolean canRequestBirth, Boolean canRequestMarriage, Boolean canRequestDeath,
            Boolean canRequestDeFactoUnion, Boolean canRequestIdentityAndCivilStatus) {
        this.validation = validation;
        this.type = type;
        this.status = status;
        this.canRequestBirth = canRequestBirth;
        this.canRequestMarriage = canRequestMarriage;
        this.canRequestDeath = canRequestDeath;
        this.canRequestDeFactoUnion = canRequestDeFactoUnion;
        this.canRequestIdentityAndCivilStatus = canRequestIdentityAndCivilStatus;
    }

    public FindValidationByServiceCertificateResponse(ValidationByService validationByService) {
        this.validation = validationByService.getValidation().getId().value();
        this.type = validationByService.getType();
        this.status = validationByService.getStatus();
        this.canRequestBirth = validationByService.getCanRequestBirth().value();
        this.canRequestMarriage = validationByService.getCanRequestMarriage().value();
        this.canRequestDeath = validationByService.getCanRequestDeath().value();
        this.canRequestDeFactoUnion = validationByService.getCanRequestDeFactoUnion().value();
        this.canRequestIdentityAndCivilStatus = validationByService.getCanRequestIdentityAndCivilStatus().value();
    }

    public UUID getValidation() {
        return validation;
    }

    public ValidationServiceType getType() {
        return type;
    }

    public ValidationCivilStatus getStatus() {
        return status;
    }

    public Boolean getCanRequestBirth() {
        return canRequestBirth;
    }

    public Boolean getCanRequestMarriage() {
        return canRequestMarriage;
    }

    public Boolean getCanRequestDeath() {
        return canRequestDeath;
    }

    public Boolean getCanRequestDeFactoUnion() {
        return canRequestDeFactoUnion;
    }

    public Boolean getCanRequestIdentityAndCivilStatus() {
        return canRequestIdentityAndCivilStatus;
    }

}
