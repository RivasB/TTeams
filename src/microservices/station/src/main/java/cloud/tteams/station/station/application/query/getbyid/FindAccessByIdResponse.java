package cloud.tteams.identity.access.application.query.getbyid;

import cloud.tteams.identity.access.domain.Access;
import cloud.tteams.share.core.domain.bus.query.IResponse;

import java.util.UUID;

public class FindAccessByIdResponse implements IResponse {

    private final UUID id;

    private final String code;

    private final String resourceCode;

    private final String description;


    public FindAccessByIdResponse(Access access) {
        this.id = access.id().value();
        this.code = access.code().value();
        this.description = access.description().value();
        this.resourceCode = access.resourceCode().value();
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
