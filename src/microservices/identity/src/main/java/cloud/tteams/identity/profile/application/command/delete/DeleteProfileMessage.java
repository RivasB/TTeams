package cloud.tteams.identity.profile.application.command.delete;

import java.util.UUID;

import cloud.tteams.share.core.domain.bus.command.ICommandMessage;

public class DeleteProfileMessage implements ICommandMessage {

    private UUID id;

    private final String command;

    public DeleteProfileMessage(UUID id) {
        this.id = id;
        this.command = "DELETE_PROFILE";
    }

    public UUID getId() {
        return id;
    }

    public String getCommand() {
        return command;
    }

}
