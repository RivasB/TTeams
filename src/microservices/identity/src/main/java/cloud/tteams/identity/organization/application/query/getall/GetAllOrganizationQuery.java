package cloud.tteams.identity.organization.application.query.getall;

import cloud.tteams.share.core.domain.State;
import org.springframework.data.domain.Pageable;

import cloud.tteams.share.core.domain.bus.query.IQuery;

public class GetAllOrganizationQuery implements IQuery {

    private final Pageable pageable;
    private final String name;
    private final String description;
    private final String contact;
    private final State state;

    public GetAllOrganizationQuery(Pageable pageable, String name, String description, String contact, State state) {
        this.pageable = pageable;
        this.name = name;
        this.description = description;
        this.contact = contact;
        this.state = state;
    }

    public Pageable getPageable() {
        return pageable;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getContact() {
        return contact;
    }

    public State getState() {
        return state;
    }
}
