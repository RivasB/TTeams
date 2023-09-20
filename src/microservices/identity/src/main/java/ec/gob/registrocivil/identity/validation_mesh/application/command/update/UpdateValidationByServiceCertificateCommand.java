package ec.gob.registrocivil.identity.validation_mesh.application.command.update;

import java.util.UUID;

import ec.gob.registrocivil.share.core.domain.bus.command.ICommand;
import ec.gob.registrocivil.share.core.domain.bus.command.ICommandMessage;
import ec.gob.registrocivil.identity.validation_mesh.domain.ValidationCivilStatus;
import ec.gob.registrocivil.identity.validation_mesh.domain.ValidationServiceType;

public class UpdateValidationByServiceCertificateCommand implements ICommand {

    private UUID id;

    private UUID validation;

    private ValidationServiceType type;

    private ValidationCivilStatus status;

    private Boolean canRequestBirth;

    private Boolean canRequestMarriage;

    private Boolean canRequestDeath;

    private Boolean canRequestDeFactoUnion;

    private Boolean canRequestIdentityAndCivilStatus;

    public UpdateValidationByServiceCertificateCommand(UUID id, UUID validation, ValidationServiceType type,
            ValidationCivilStatus status, Boolean canRequestBirth, Boolean canRequestMarriage, Boolean canRequestDeath,
            Boolean canRequestDeFactoUnion, Boolean canRequestIdentityAndCivilStatus) {
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

    public UpdateValidationByServiceCertificateCommand(UpdateValidationByServiceCertificateRequest request) {
        this.id = request.getId();
        this.validation = request.getValidation();
        this.type = request.getType();
        this.status = request.getStatus();
        this.canRequestBirth = request.getCanRequestBirth();
        this.canRequestMarriage = request.getCanRequestMarriage();
        this.canRequestDeath = request.getCanRequestDeath();
        this.canRequestDeFactoUnion = request.getCanRequestDeFactoUnion();
        this.canRequestIdentityAndCivilStatus = request.getCanRequestIdentityAndCivilStatus();
    }

    public UUID getId() {
        return id;
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

    @Override
    public ICommandMessage getMessage() {
        return new UpdateValidationMessage(id);
    }

}
