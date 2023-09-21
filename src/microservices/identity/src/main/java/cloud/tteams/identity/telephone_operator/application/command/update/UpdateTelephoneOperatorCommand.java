package cloud.tteams.identity.telephone_operator.application.command.update;

import java.util.UUID;

import cloud.tteams.share.core.domain.bus.command.ICommand;
import cloud.tteams.share.core.domain.bus.command.ICommandMessage;

public class UpdateTelephoneOperatorCommand implements ICommand {

    private UUID id;

    private String name;

    public UpdateTelephoneOperatorCommand(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public static UpdateTelephoneOperatorCommand fromRequest(UpdateTelephoneOperatorRequest request) {

        return new UpdateTelephoneOperatorCommand(request.getId(), request.getName());
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public ICommandMessage getMessage() {
        return new UpdateTelephoneOperatorMessage(id);
    }
}
