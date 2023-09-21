package cloud.tteams.identity.profile.application.command.create;

import java.util.UUID;

import cloud.tteams.share.core.domain.bus.command.ICommandMessage;

public class CreateProfileMessage implements ICommandMessage {

    private UUID id;

    private String command = "CREATE_PROFILE";

    public CreateProfileMessage(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public String getCommand() {
        return command;
    }

}
