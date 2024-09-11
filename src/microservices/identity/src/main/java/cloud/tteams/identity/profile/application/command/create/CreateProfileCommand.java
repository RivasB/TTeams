package cloud.tteams.identity.profile.application.command.create;

import java.util.Collection;
import java.util.UUID;

import cloud.tteams.share.core.domain.State;
import cloud.tteams.share.core.domain.bus.command.ICommand;
import cloud.tteams.share.core.domain.bus.command.ICommandMessage;

public class CreateProfileCommand implements ICommand {

    private final UUID id;

    private final String name;

    private final String description;

    private final State state;

    private final UUID organization;

    Collection<UUID> authorizations;

    public CreateProfileCommand(String name, String description, State state, UUID organization, Collection<UUID> authorizations) {
        this.organization = organization;
        this.authorizations = authorizations;
        this.id = UUID.randomUUID();
        this.name = name;
        this.description = description;
        this.state = state;
    }

    public static CreateProfileCommand fromRequest(CreateProfileRequest request) {

        return new CreateProfileCommand(
                request.name(),
                request.description(),
                request.state(),
                request.organization(),
                request.authorizations());
    }

    @Override
    public ICommandMessage getMessage() {
        return new CreateProfileMessage(id);
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public State getState() {
        return state;
    }

    public UUID getOrganization() {
        return organization;
    }

    public Collection<UUID> getAuthorizations() {
        return authorizations;
    }
}
