package cloud.tteams.identity.user.application.command.register.data;

import java.util.UUID;

import cloud.tteams.share.core.domain.bus.command.ICommandMessage;

public class RegisterUserMessage implements ICommandMessage {

    private final UUID id;

    private final String command;

    public RegisterUserMessage(UUID id) {
        this.id = id;
        this.command = "REGISTER_USER";
    }

    public UUID getId() {
        return id;
    }

    public String getCommand() {
        return command;
    }

}
