package cloud.tteams.identity.profile.application.command.update;

import java.util.UUID;

import cloud.tteams.share.core.domain.bus.command.ICommandMessage;

public class UpdateProfileMessage implements ICommandMessage {

    private final UUID id;

    private final String command;

    public UpdateProfileMessage(UUID id) {
        this.id = id;
        this.command = "UPDATE_PROFILE";
    }

    public UUID getId() {
        return id;
    }

    public String getCommand() {
        return command;
    }
}
