package cloud.tteams.identity.application.application.command.delete;

import java.util.UUID;

import cloud.tteams.share.core.domain.bus.command.ICommand;
import cloud.tteams.share.core.domain.bus.command.ICommandMessage;

public class DeleteApplicatinCommand implements ICommand {

    private UUID id;

    public DeleteApplicatinCommand(UUID id) {
        this.id = id;
    }

    public static DeleteApplicatinCommand fromRequest(DeleteApplicationRequest request) {

        return new DeleteApplicatinCommand(request.getId());
    }

    public UUID getId() {
        return id;
    }

    @Override
    public ICommandMessage getMessage() {
        return new DeleteAplicationMessage(id);
    }

}
