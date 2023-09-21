package cloud.tteams.identity.validation_mesh.application.command.update;

import org.springframework.stereotype.Component;

import cloud.tteams.share.core.domain.bus.command.ICommandHandler;
import cloud.tteams.identity.validation_mesh.domain.Validation;
import cloud.tteams.identity.validation_mesh.domain.ValidationByService;
import cloud.tteams.identity.validation_mesh.domain.ValidationByServiceId;
import cloud.tteams.identity.validation_mesh.domain.ValidationCivilStatus;
import cloud.tteams.identity.validation_mesh.domain.ValidationCondition;
import cloud.tteams.identity.validation_mesh.domain.ValidationId;
import cloud.tteams.identity.validation_mesh.domain.ValidationServiceType;
import cloud.tteams.identity.validation_mesh.domain.service.IValidationService;

@Component
public class UpdateValidationByServiceCertificateCommandHandler
        implements ICommandHandler<UpdateValidationByServiceCertificateCommand> {

    private final IValidationService validatinoService;

    public UpdateValidationByServiceCertificateCommandHandler(IValidationService validatinoService) {
        this.validatinoService = validatinoService;
    }

    @Override
    public void handle(UpdateValidationByServiceCertificateCommand command) {
        ValidationByServiceId id = new ValidationByServiceId(command.getId());

        Validation validation = validatinoService.findValidationById(new ValidationId(command.getValidation()));

        ValidationServiceType type = command.getType();

        ValidationCivilStatus status = command.getStatus();

        ValidationCondition canRequestBirth = new ValidationCondition(command.getCanRequestBirth());

        ValidationCondition canRequestMarriage = new ValidationCondition(command.getCanRequestMarriage());

        ValidationCondition canRequestDeath = new ValidationCondition(command.getCanRequestDeath());

        ValidationCondition canRequestDeFactoUnion = new ValidationCondition(command.getCanRequestDeFactoUnion());

        ValidationCondition canRequestIdentityAndCivilStatus = new ValidationCondition(
                command.getCanRequestIdentityAndCivilStatus());

        ValidationByService validationByService = new ValidationByService(id, validation, type, status, canRequestBirth,
                canRequestMarriage, canRequestDeath, canRequestDeFactoUnion, canRequestIdentityAndCivilStatus);

        validatinoService.updateValidationByService(validationByService);
    }

}
