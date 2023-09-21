package cloud.tteams.identity.access.domain.service;

import cloud.tteams.identity.access.domain.Access;
import cloud.tteams.identity.access.domain.AccessCode;
import cloud.tteams.identity.access.domain.AccessId;
import cloud.tteams.share.core.domain.MessagePaginatedResponse;
import org.springframework.data.domain.Pageable;

public interface IAccessService {

    Access findById(AccessId id);

    Access findByCode(AccessCode code);

    MessagePaginatedResponse getPaginatedAccess(Pageable pageable, String description, String code, String resource);

    Long countByIdIsNotAndCode(AccessId id, AccessCode code);

}
