package ec.gob.registrocivil.identity.shared.application.spread;

import ec.gob.registrocivil.share.core.domain.bus.command.ICommand;
import ec.gob.registrocivil.share.core.domain.bus.command.ICommandMessage;

public class SpreadCommand implements ICommand {

    @Override
    public ICommandMessage getMessage() {
        return new SpreadMessage();
    }

}
