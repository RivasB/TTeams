package ec.gob.registrocivil.identity.access.domain.service;

import ec.gob.registrocivil.identity.access.domain.Access;
import ec.gob.registrocivil.identity.access.domain.AccessCode;
import ec.gob.registrocivil.identity.access.domain.AccessId;
import ec.gob.registrocivil.share.core.domain.MessagePaginatedResponse;
import org.springframework.data.domain.Pageable;

public interface IAccessService {

    Access findById(AccessId id);

    Access findByCode(AccessCode code);

    MessagePaginatedResponse getPaginatedAccess(Pageable pageable, String description, String code, String resource);

    Long countByIdIsNotAndCode(AccessId id, AccessCode code);

}
