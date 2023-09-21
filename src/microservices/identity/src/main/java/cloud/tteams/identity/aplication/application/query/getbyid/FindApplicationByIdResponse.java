package cloud.tteams.identity.aplication.application.query.getbyid;

import java.util.Collection;
import java.util.UUID;

import cloud.tteams.identity.access.application.AccessResponse;
import cloud.tteams.identity.aplication.domain.Aplication;
import cloud.tteams.identity.aplication.domain.AplicationState;
import cloud.tteams.share.core.domain.bus.query.IResponse;

public class FindApplicationByIdResponse implements IResponse {

    private UUID id;

    private String name;

    private String description;

    private AplicationState state;

    private Collection<AccessResponse> access;

    public FindApplicationByIdResponse(UUID id, String name, String description, AplicationState state,
            Collection<AccessResponse> access) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.state = state;
        this.access = access;
    }

    public FindApplicationByIdResponse(Aplication application) {
        this.id = application.getId().value();
        this.name = application.getName().value();
        this.description = application.getDescription().value();
        this.state = application.getState();
        this.access = application.getAccess().getValue().stream().map(AccessResponse::new).toList();
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

    public AplicationState getState() {
        return state;
    }

    public Collection<AccessResponse> getAccess() {
        return access;
    }

}
