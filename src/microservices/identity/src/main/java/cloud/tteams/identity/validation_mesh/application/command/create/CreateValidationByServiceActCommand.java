package cloud.tteams.identity.validation_mesh.application.command.create;

import java.util.UUID;

import cloud.tteams.share.core.domain.bus.command.ICommand;
import cloud.tteams.share.core.domain.bus.command.ICommandMessage;
import cloud.tteams.identity.validation_mesh.domain.ValidationCivilStatus;
import cloud.tteams.identity.validation_mesh.domain.ValidationServiceType;

public class CreateValidationByServiceActCommand implements ICommand {

    private UUID id;

    private UUID validation;

    private ValidationServiceType type;

    private ValidationCivilStatus status;

    private Boolean canRequestBirth;

    private Boolean canRequestMarriage;

    private Boolean canRequestDeath;

    private Boolean canRequestDeFactoUnion;

    public CreateValidationByServiceActCommand(UUID id, UUID validation, ValidationServiceType type,
            ValidationCivilStatus status, Boolean canRequestBirth, Boolean canRequestMarriage, Boolean canRequestDeath,
            Boolean canRequestDeFactoUnion) {
        this.id = id;
        this.validation = validation;
        this.type = type;
        this.status = status;
        this.canRequestBirth = canRequestBirth;
        this.canRequestMarriage = canRequestMarriage;
        this.canRequestDeath = canRequestDeath;
        this.canRequestDeFactoUnion = canRequestDeFactoUnion;
    }

    public CreateValidationByServiceActCommand(CreateValidationByServiceActRequest request) {
        this.id = UUID.randomUUID();
        this.validation = request.getValidation();
        this.type = request.getType();
        this.status = request.getStatus();
        this.canRequestBirth = request.getCanRequestBirth();
        this.canRequestMarriage = request.getCanRequestMarriage();
        this.canRequestDeath = request.getCanRequestDeath();
        this.canRequestDeFactoUnion = request.getCanRequestDeFactoUnion();
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

    @Override
    public ICommandMessage getMessage() {
        return new CreateValidationMessage(id);
    }

}
