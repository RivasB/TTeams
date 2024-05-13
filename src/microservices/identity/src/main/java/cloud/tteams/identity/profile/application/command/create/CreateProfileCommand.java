package cloud.tteams.identity.profile.application.command.create;

import java.util.Collection;
import java.util.UUID;

import cloud.tteams.share.core.domain.bus.command.ICommand;
import cloud.tteams.share.core.domain.bus.command.ICommandMessage;

public class CreateProfileCommand implements ICommand {

    private UUID id;

    private String name;

    private String description;

    private ProfileState state;

    private UUID agency;

    private Collection<UUID> access;

    public CreateProfileCommand(String name, String description, ProfileState state, UUID agency,
            Collection<UUID> access) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.description = description;
        this.state = state;
        this.agency = agency;
        this.access = access;
    }

    public static CreateProfileCommand fromRequest(CreateProfileRequest request) {

        return new CreateProfileCommand(
                request.getName(),
                request.getDescription(),
                request.getState(),
                request.getAgency(),
                request.getAccess());
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

    public ProfileState getState() {
        return state;
    }

    public UUID getAgency() {
        return agency;
    }

    public Collection<UUID> getAccess() {
        return access;
    }

    @Override
    public ICommandMessage getMessage() {
        return new CreateProfileMessage(id);
    }

}
