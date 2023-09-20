package ec.gob.registrocivil.identity.profile.application.command.update;

import java.util.UUID;

import ec.gob.registrocivil.share.core.domain.bus.command.ICommandMessage;

public class UpdateProfileMessage implements ICommandMessage {

    private UUID id;

    private String command = "UPDATE_PROFILE";

    public UpdateProfileMessage(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public String getCommand() {
        return command;
    }
}
