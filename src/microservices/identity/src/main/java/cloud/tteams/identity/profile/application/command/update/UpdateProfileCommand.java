package cloud.tteams.identity.profile.application.command.update;

import java.util.Collection;
import java.util.UUID;

import cloud.tteams.share.core.domain.State;
import cloud.tteams.share.core.domain.bus.command.ICommand;
import cloud.tteams.share.core.domain.bus.command.ICommandMessage;

public record UpdateProfileCommand(UUID id, String name, String description, State state, UUID organization,
                                   Collection<UUID> authorizations) implements ICommand {

    public static UpdateProfileCommand fromRequest(UpdateProfileRequest request) {

        return new UpdateProfileCommand(
                request.id(),
                request.name(),
                request.description(),
                request.state(),
                request.organization(),
                request.authorizations());
    }

    @Override
    public ICommandMessage getMessage() {
        return new UpdateProfileMessage(id);
    }
}
