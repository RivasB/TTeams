package ec.gob.registrocivil.identity.aplication.application;

import ec.gob.registrocivil.identity.aplication.domain.Aplication;
import ec.gob.registrocivil.identity.aplication.domain.AplicationState;
import java.util.UUID;

public class AplicationResponse {

    private UUID id;

    private String name;

    private String description;

    private AplicationState state;

    public AplicationResponse(Aplication response) {
        this.id = response.getId().getValue();
        this.name = response.getName().getValue();
        this.description = response.getDescription().getValue();
        this.state = response.getState();
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

}
