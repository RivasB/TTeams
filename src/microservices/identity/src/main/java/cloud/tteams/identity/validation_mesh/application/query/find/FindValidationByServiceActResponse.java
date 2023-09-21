package cloud.tteams.identity.validation_mesh.application.query.find;

import java.util.UUID;

import cloud.tteams.share.core.domain.bus.query.IResponse;
import cloud.tteams.identity.validation_mesh.domain.ValidationByService;
import cloud.tteams.identity.validation_mesh.domain.ValidationCivilStatus;
import cloud.tteams.identity.validation_mesh.domain.ValidationServiceType;

public class FindValidationByServiceActResponse implements IResponse {

    private UUID validation;

    private ValidationServiceType type;

    private ValidationCivilStatus status;

    private Boolean canRequestBirth;

    private Boolean canRequestMarriage;

    private Boolean canRequestDeath;

    private Boolean canRequestDeFactoUnion;

    public FindValidationByServiceActResponse(UUID validation, ValidationServiceType type, ValidationCivilStatus status,
            Boolean canRequestBirth, Boolean canRequestMarriage, Boolean canRequestDeath,
            Boolean canRequestDeFactoUnion) {
        this.validation = validation;
        this.type = type;
        this.status = status;
        this.canRequestBirth = canRequestBirth;
        this.canRequestMarriage = canRequestMarriage;
        this.canRequestDeath = canRequestDeath;
        this.canRequestDeFactoUnion = canRequestDeFactoUnion;
    }

    public FindValidationByServiceActResponse(ValidationByService validationByService) {
        this.validation = validationByService.getValidation().getId().value();
        this.type = validationByService.getType();
        this.status = validationByService.getStatus();
        this.canRequestBirth = validationByService.getCanRequestBirth().value();
        this.canRequestMarriage = validationByService.getCanRequestMarriage().value();
        this.canRequestDeath = validationByService.getCanRequestDeath().value();
        this.canRequestDeFactoUnion = validationByService.getCanRequestDeFactoUnion().value();
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

}
