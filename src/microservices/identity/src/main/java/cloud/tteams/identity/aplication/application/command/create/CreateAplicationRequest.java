package cloud.tteams.identity.aplication.application.command.create;

import java.util.Collection;
import java.util.UUID;

import cloud.tteams.identity.aplication.domain.AplicationState;

public class CreateAplicationRequest {

    private String name;

    private String description;

    private AplicationState state;

    private Collection<UUID> access;

    public CreateAplicationRequest(String name, String description, AplicationState state, Collection<UUID> access) {
        this.name = name;
        this.description = description;
        this.state = state;
        this.access = access;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public AplicationState getState() {
        return state;
    }

    public Collection<UUID> getAccess() {
        return access;
    }
}
