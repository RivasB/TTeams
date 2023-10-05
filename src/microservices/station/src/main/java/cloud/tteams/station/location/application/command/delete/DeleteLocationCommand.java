package cloud.tteams.station.location.application.command.delete;

import cloud.tteams.share.core.domain.bus.command.ICommand;
import cloud.tteams.share.core.domain.bus.command.ICommandMessage;

import java.util.UUID;

public class DeleteLocationCommand implements ICommand {

    private final UUID id;

    public DeleteLocationCommand(UUID id) {
        this.id = id;
    }

    public DeleteLocationCommand (DeleteLocationRequest request){
        this.id = request.getId();
    }

    @Override
    public ICommandMessage getMessage() {
        return new DeleteLocationMessage(this.id);
    }

    public UUID getId() {
        return id;
    }
}