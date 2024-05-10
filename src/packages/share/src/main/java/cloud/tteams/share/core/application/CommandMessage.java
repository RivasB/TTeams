package cloud.tteams.share.core.application;

import cloud.tteams.share.core.domain.bus.command.ICommandMessage;

import java.util.UUID;

public class CommandMessage implements ICommandMessage {

    private final UUID id;

    private final String command;

    public CommandMessage(UUID id, String command) {
        this.id = id;
        this.command = command;
    }

    public UUID getId() {
        return id;
    }

    public String getCommand() {
        return command;
    }
}
