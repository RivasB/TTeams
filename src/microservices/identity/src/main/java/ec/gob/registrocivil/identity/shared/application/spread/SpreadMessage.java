package ec.gob.registrocivil.identity.shared.application.spread;

import ec.gob.registrocivil.share.core.domain.bus.command.ICommandMessage;

public class SpreadMessage implements ICommandMessage {

    private String command;

    public SpreadMessage() {
        this.command = "SPREAD";
    }

    public String getCommand() {
        return command;
    }

}
