package cloud.tteams.task.task.application.command.seteffort;

import cloud.tteams.share.core.application.command.CommandMessage;
import cloud.tteams.share.core.domain.bus.command.ICommand;
import cloud.tteams.share.core.domain.bus.command.ICommandMessage;

import java.util.UUID;

public class SetEffortInTaskCommand implements ICommand {

    private final UUID id;
    private final Integer effort;

    public SetEffortInTaskCommand(UUID id, Integer effort) {
        this.id = id;
        this.effort = effort;
    }

    @Override
    public ICommandMessage getMessage() {
        return new CommandMessage(this.id, "SET_EFFORT");
    }

    public UUID getId() {
        return id;
    }

    public Integer getEffort() {
        return effort;
    }
}
