package ec.gob.registrocivil.identity.validation_mesh.application.command.create;

import org.springframework.stereotype.Component;

import ec.gob.registrocivil.share.core.domain.bus.command.ICommandHandler;
import ec.gob.registrocivil.identity.validation_mesh.domain.Validation;
import ec.gob.registrocivil.identity.validation_mesh.domain.ValidationByService;
import ec.gob.registrocivil.identity.validation_mesh.domain.ValidationByServiceId;
import ec.gob.registrocivil.identity.validation_mesh.domain.ValidationCivilStatus;
import ec.gob.registrocivil.identity.validation_mesh.domain.ValidationCondition;
import ec.gob.registrocivil.identity.validation_mesh.domain.ValidationId;
import ec.gob.registrocivil.identity.validation_mesh.domain.ValidationServiceType;
import ec.gob.registrocivil.identity.validation_mesh.domain.service.IValidationService;

@Component
public class CreateValidationByServiceActCommandHandler
        implements ICommandHandler<CreateValidationByServiceActCommand> {

    private final IValidationService validatinoService;

    public CreateValidationByServiceActCommandHandler(IValidationService validatinoService) {
        this.validatinoService = validatinoService;
    }

    @Override
    public void handle(CreateValidationByServiceActCommand command) {
        ValidationByServiceId id = new ValidationByServiceId(command.getId());

        Validation validation = validatinoService.findValidationById(new ValidationId(command.getValidation()));

        ValidationServiceType type = command.getType();

        ValidationCivilStatus status = command.getStatus();

        ValidationCondition canRequestBirth = new ValidationCondition(command.getCanRequestBirth());

        ValidationCondition canRequestMarriage = new ValidationCondition(command.getCanRequestMarriage());

        ValidationCondition canRequestDeath = new ValidationCondition(command.getCanRequestDeath());

        ValidationCondition canRequestDeFactoUnion = new ValidationCondition(command.getCanRequestDeFactoUnion());

        ValidationByService validationByService = new ValidationByService(id, validation, type, status, canRequestBirth,
                canRequestMarriage, canRequestDeath, canRequestDeFactoUnion);

        validatinoService.createValidationByService(validationByService);
    }

}
