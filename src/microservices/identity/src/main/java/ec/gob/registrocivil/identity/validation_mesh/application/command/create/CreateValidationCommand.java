package ec.gob.registrocivil.identity.validation_mesh.application.command.create;

import java.util.UUID;

import ec.gob.registrocivil.share.core.domain.bus.command.ICommand;
import ec.gob.registrocivil.share.core.domain.bus.command.ICommandMessage;

public class CreateValidationCommand implements ICommand {

    private UUID id;

    private String cedulaCondition;

    private Boolean canCreateAVAccount;

    private Boolean canChangeName;

    private Boolean canPayRegistrationNotarialDeed;

    private Boolean canPayValidationOfDocuments;

    public CreateValidationCommand(UUID id, String cedulaCondition, Boolean canCreateAVAccount, Boolean canChangeName,
            Boolean canPayRegistrationNotarialDeed, Boolean canPayValidationOfDocuments) {
        this.id = id;
        this.cedulaCondition = cedulaCondition;
        this.canCreateAVAccount = canCreateAVAccount;
        this.canChangeName = canChangeName;
        this.canPayRegistrationNotarialDeed = canPayRegistrationNotarialDeed;
        this.canPayValidationOfDocuments = canPayValidationOfDocuments;
    }

    public CreateValidationCommand(CreateValidationRequest request) {
        this.id = UUID.randomUUID();
        this.cedulaCondition = request.getCedulaCondition();
        this.canCreateAVAccount = request.getCanCreateAVAccount();
        this.canChangeName = request.getCanChangeName();
        this.canPayRegistrationNotarialDeed = request.getCanPayRegistrationNotarialDeed();
        this.canPayValidationOfDocuments = request.getCanPayValidationOfDocuments();
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

    @Override
    public ICommandMessage getMessage() {
        return new CreateValidationMessage(id);
    }

}
