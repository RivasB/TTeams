package cloud.tteams.task.task.application.command.assign;

import cloud.tteams.share.core.application.command.CommandMessage;
import cloud.tteams.share.core.domain.bus.command.ICommand;
import cloud.tteams.share.core.domain.bus.command.ICommandMessage;

import java.util.UUID;

public class AssignTaskCommand implements ICommand {

    private final UUID id;
    private final UUID userId;

    public AssignTaskCommand(UUID id, UUID userId) {
        this.id = id;
        this.userId = userId;
    }

    @Override
    public ICommandMessage getMessage() {
        return new CommandMessage(this.id, "ASSIGN USER");
    }

    public UUID getId() {
        return id;
    }

    public UUID getUserId() {
        return userId;
    }
}
