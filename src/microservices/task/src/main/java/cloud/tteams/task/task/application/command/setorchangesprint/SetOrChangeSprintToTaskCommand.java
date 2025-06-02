package cloud.tteams.task.task.application.command.setorchangesprint;

import cloud.tteams.share.core.application.command.CommandMessage;
import cloud.tteams.share.core.domain.bus.command.ICommand;
import cloud.tteams.share.core.domain.bus.command.ICommandMessage;

import java.util.UUID;

public class SetOrChangeSprintToTaskCommand implements ICommand {

    private final UUID id;
    private final UUID sprint;

    public SetOrChangeSprintToTaskCommand(UUID id, UUID sprint) {
        this.id = id;
        this.sprint = sprint;
    }

    @Override
    public ICommandMessage getMessage() {
        return new CommandMessage(this.id, "SET_OR_CHANGE_SPRINT");
    }

    public UUID getId() {
        return id;
    }

    public UUID getSprint() {
        return sprint;
    }
}
