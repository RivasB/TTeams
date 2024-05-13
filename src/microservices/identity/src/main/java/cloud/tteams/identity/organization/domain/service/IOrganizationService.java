package cloud.tteams.identity.organization.domain.service;

import java.util.UUID;

import cloud.tteams.share.core.domain.State;
import org.springframework.data.domain.Pageable;

import cloud.tteams.identity.organization.domain.Organization;
import cloud.tteams.share.core.application.query.MessagePaginatedResponse;

public interface IOrganizationService {
    public void create(Organization organization);

    public void update(Organization organization);

    public void delete(UUID id);

    public Organization findById(UUID id);

    MessagePaginatedResponse getAll(Pageable pageable, String name, String description, String contact,
                                    State state);

    public void spreadAgencys();
}
