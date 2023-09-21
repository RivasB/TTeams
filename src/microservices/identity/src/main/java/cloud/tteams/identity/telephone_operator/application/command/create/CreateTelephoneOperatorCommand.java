package cloud.tteams.identity.telephone_operator.application.command.create;

import java.util.UUID;

import cloud.tteams.share.core.domain.bus.command.ICommand;
import cloud.tteams.share.core.domain.bus.command.ICommandMessage;

public class CreateTelephoneOperatorCommand implements ICommand {

    private UUID id;

    private String name;

    public CreateTelephoneOperatorCommand(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
    }

    public static CreateTelephoneOperatorCommand fromRequest(CreateTelephoneOperatorRequest request) {

        return new CreateTelephoneOperatorCommand(request.getName());
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public ICommandMessage getMessage() {
        return new CreateTelephoneOperatorMessage(id);
    }
}
