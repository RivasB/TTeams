package cloud.tteams.identity.user.application.command.register.data;

import java.util.UUID;

import cloud.tteams.share.core.domain.bus.command.ICommandMessage;

public class RegisterCitizenMessage implements ICommandMessage {

    private final UUID id;

    private String command = "REGISTER_USER";

    public RegisterCitizenMessage(UUID id) {
        this.id = id;
    }

    public RegisterCitizenMessage(UUID id, String code) {
        this.id = id;
        this.command = "REGISTER_USER - CODE: " + code;
    }

    public UUID getId() {
        return id;
    }

    public String getCommand() {
        return command;
    }

}
