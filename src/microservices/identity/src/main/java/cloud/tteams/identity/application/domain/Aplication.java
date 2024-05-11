package cloud.tteams.identity.application.domain;

public class Aplication {
    private AplicationId id;
    private AplicationName name;
    private AplicationDescription description;
    private AplicationState state;
    private AplicationAccessSet access;

    public Aplication(AplicationId id, AplicationName name, AplicationDescription description, AplicationState state,
            AplicationAccessSet access) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.state = state;
        this.access = access;
    }

    public AplicationId getId() {
        return id;
    }

    public AplicationName getName() {
        return name;
    }

    public AplicationDescription getDescription() {
        return description;
    }

    public AplicationState getState() {
        return state;
    }

    public AplicationAccessSet getAccess() {
        return access;
    }

}
