package ec.gob.registrocivil.identity.aplication.application.command.update;

import java.util.Collection;
import java.util.UUID;

import ec.gob.registrocivil.identity.aplication.domain.AplicationState;

public class UpdateAplicationRequest {

    private String name;

    private String description;

    private AplicationState state;

    private Collection<UUID> access;

    public UpdateAplicationRequest(String name, String description, AplicationState state, Collection<UUID> access) {
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
