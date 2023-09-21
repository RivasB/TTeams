package cloud.tteams.identity.shared.application.spread;

import cloud.tteams.share.core.domain.bus.command.ICommandMessage;

public class SpreadMessage implements ICommandMessage {

    private String command;

    public SpreadMessage() {
        this.command = "SPREAD";
    }

    public String getCommand() {
        return command;
    }

}
