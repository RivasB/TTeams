package cloud.tteams.identity.organization.domain.repository;

import java.util.UUID;

import cloud.tteams.identity.organization.domain.Organization;
import cloud.tteams.share.core.domain.State;
import org.springframework.data.domain.Pageable;

import cloud.tteams.share.core.application.query.MessagePaginatedResponse;

public interface IOrganizationQueryRepository {
    Organization findById(UUID id);
    MessagePaginatedResponse findAll(Pageable pageable, String name, String description, String contact, State state);
}
