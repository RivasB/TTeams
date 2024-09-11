package cloud.tteams.identity.profile.application.command.delete;

import java.util.UUID;

import cloud.tteams.share.core.domain.bus.command.ICommand;
import cloud.tteams.share.core.domain.bus.command.ICommandMessage;

public record DeleteProfileCommand(UUID id) implements ICommand {

    public static DeleteProfileCommand fromRequest(DeleteProfileRequest request) {

        return new DeleteProfileCommand(request.id());
    }

    @Override
    public ICommandMessage getMessage() {
        return new DeleteProfileMessage(id);
    }

}
