package cloud.tteams.identity.shared.application.spread;

import cloud.tteams.share.core.domain.bus.command.ICommand;
import cloud.tteams.share.core.domain.bus.command.ICommandMessage;

public class SpreadCommand implements ICommand {

    @Override
    public ICommandMessage getMessage() {
        return new SpreadMessage();
    }

}
