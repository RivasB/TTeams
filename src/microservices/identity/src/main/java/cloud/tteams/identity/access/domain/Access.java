package cloud.tteams.identity.access.domain;

public final class Access {

    private final AccessId id;

    private final AccessCode code;

    private final AccessDescription description;

    private final AccessResourceCode resourceCode;

    public Access(AccessId id, AccessCode code, AccessDescription description, AccessResourceCode resourceCode) {
        this.id = id;
        this.code = code;
        this.description = description;
        this.resourceCode = resourceCode;
    }

    public AccessId getId() {
        return id;
    }

    public AccessResourceCode getResourceCode() {
        return resourceCode;
    }

    public AccessCode getCode() {
        return code;
    }

    public AccessDescription getDescription() {
        return description;
    }

}
