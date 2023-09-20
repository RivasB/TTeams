package ec.gob.registrocivil.identity.access.application;

import ec.gob.registrocivil.identity.access.domain.Access;

import java.util.UUID;

public class AccessResponse {

    private final UUID id;

    private final String code;

    private final String description;

    private final String resourceCode;

    public AccessResponse(UUID id, String code, String description, String resourceCode) {
        this.id = id;
        this.code = code;
        this.description = description;
        this.resourceCode = resourceCode;
    }


    public AccessResponse(Access access) {
        this.id = access.getId().value();
        this.code = access.getCode().value();
        this.description = access.getDescription().value();
        this.resourceCode = access.getResourceCode().value();
    }

    public UUID getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public String getResourceCode() {
        return resourceCode;
    }
}
