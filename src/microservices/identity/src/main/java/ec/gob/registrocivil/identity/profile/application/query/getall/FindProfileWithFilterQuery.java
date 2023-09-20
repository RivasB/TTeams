package ec.gob.registrocivil.identity.profile.application.query.getall;

import ec.gob.registrocivil.identity.profile.domain.ProfileState;
import org.springframework.data.domain.Pageable;

import ec.gob.registrocivil.share.core.domain.bus.query.IQuery;

import java.util.UUID;

public class FindProfileWithFilterQuery implements IQuery {

    private final Pageable pageable;

    private final String filter;

    private final String name;

    private final String description;

    private final ProfileState state;
    
    private final UUID agencyId;

    public FindProfileWithFilterQuery(Pageable pageable, String filter, String name, String description,
                                      ProfileState state, UUID agencyId) {
        this.pageable = pageable;
        this.filter = filter;
        this.name = name;
        this.description = description;
        this.state = state;
        this.agencyId = agencyId;
    }

    public Pageable getPageable() {
        return pageable;
    }

    public String getFilter() {
        return filter;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public ProfileState getState() {
        return state;
    }

    public UUID getAgencyId() {
        return agencyId;
    }
}
