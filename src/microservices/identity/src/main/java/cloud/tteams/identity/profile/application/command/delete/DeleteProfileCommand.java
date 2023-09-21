package cloud.tteams.identity.profile.application.command.delete;

import java.util.UUID;

import cloud.tteams.share.core.domain.bus.command.ICommand;
import cloud.tteams.share.core.domain.bus.command.ICommandMessage;

public class DeleteProfileCommand implements ICommand {

    private UUID id;

    public DeleteProfileCommand(UUID id) {
        this.id = id;
    }

    public static DeleteProfileCommand fromRequest(DeleteProfileRequest request) {

        return new DeleteProfileCommand(request.getId());
    }

    public UUID getId() {
        return id;
    }

    @Override
    public ICommandMessage getMessage() {
        return new DeleteProfileMessage(id);
    }

}
