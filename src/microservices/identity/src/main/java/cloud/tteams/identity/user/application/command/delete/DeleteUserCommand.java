package cloud.tteams.identity.user.application.command.delete;

import java.util.UUID;

import cloud.tteams.share.core.domain.bus.command.ICommand;
import cloud.tteams.share.core.domain.bus.command.ICommandMessage;

public class DeleteUserCommand implements ICommand {

    private UUID id;

    public DeleteUserCommand(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    @Override
    public ICommandMessage getMessage() {
        return new DeleteUserMessage(id);
    }

}
