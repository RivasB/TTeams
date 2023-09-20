package ec.gob.registrocivil.identity.validation_mesh.application.command.create;

import org.springframework.stereotype.Component;

import ec.gob.registrocivil.share.core.domain.bus.command.ICommandHandler;
import ec.gob.registrocivil.identity.validation_mesh.domain.Validation;
import ec.gob.registrocivil.identity.validation_mesh.domain.ValidationCondition;
import ec.gob.registrocivil.identity.validation_mesh.domain.ValidationDescription;
import ec.gob.registrocivil.identity.validation_mesh.domain.ValidationId;
import ec.gob.registrocivil.identity.validation_mesh.domain.service.IValidationService;

@Component
public class CreateValidationCommandHandler implements ICommandHandler<CreateValidationCommand> {

    private final IValidationService validatinoService;

    public CreateValidationCommandHandler(IValidationService validatinoService) {
        this.validatinoService = validatinoService;
    }

    @Override
    public void handle(CreateValidationCommand command) {
        ValidationId id = new ValidationId(command.getId());

        ValidationDescription cedulaCondition = new ValidationDescription(command.getCedulaCondition());

        ValidationCondition canCreateAVAccount = new ValidationCondition(command.getCanCreateAVAccount());

        ValidationCondition canChangeName = new ValidationCondition(command.getCanChangeName());

        ValidationCondition canPayRegistrationNotarialDeed = new ValidationCondition(
                command.getCanPayRegistrationNotarialDeed());

        ValidationCondition canPayValidationOfDocuments = new ValidationCondition(
                command.getCanPayValidationOfDocuments());

        Validation validation = new Validation(id, cedulaCondition, canCreateAVAccount, canChangeName,
                canPayRegistrationNotarialDeed, canPayValidationOfDocuments);

        validatinoService.createValidation(validation);
    }

}
