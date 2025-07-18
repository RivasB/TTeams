package cloud.tteams.task.task.application.command.delete;

import cloud.tteams.share.core.application.command.CommandMessage;
import cloud.tteams.share.core.domain.bus.command.ICommand;
import cloud.tteams.share.core.domain.bus.command.ICommandMessage;

import java.util.UUID;

public class DeleteTaskCommand implements ICommand {

    private final UUID id;

    public DeleteTaskCommand(UUID id) {
        this.id = id;
    }

    @Override
    public ICommandMessage getMessage() {
        return new CommandMessage(this.id, "DELETED");
    }

    public UUID getId() {
        return id;
    }
}
