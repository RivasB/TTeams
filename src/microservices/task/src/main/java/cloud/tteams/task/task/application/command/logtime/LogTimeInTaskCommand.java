package cloud.tteams.task.task.application.command.logtime;

import cloud.tteams.share.core.application.command.CommandMessage;
import cloud.tteams.share.core.domain.bus.command.ICommand;
import cloud.tteams.share.core.domain.bus.command.ICommandMessage;

import java.util.UUID;

public class LogTimeInTaskCommand implements ICommand {

    private final UUID id;
    private final Integer hours;

    public LogTimeInTaskCommand(UUID id, Integer hours) {
        this.id = id;
        this.hours = hours;
    }

    @Override
    public ICommandMessage getMessage() {
        return new CommandMessage(this.id, "LOG_TIME");
    }

    public UUID getId() {
        return id;
    }

    public Integer getHours() {
        return hours;
    }
}
