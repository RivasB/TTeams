package ec.gob.registrocivil.identity.access.application.query.getbyid;

import ec.gob.registrocivil.identity.access.domain.Access;
import ec.gob.registrocivil.share.core.domain.bus.query.IResponse;

import java.util.UUID;

public class FindAccessByIdResponse implements IResponse {

    private final UUID id;

    private final String code;

    private final String resourceCode;

    private final String description;


    public FindAccessByIdResponse(Access access) {
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
