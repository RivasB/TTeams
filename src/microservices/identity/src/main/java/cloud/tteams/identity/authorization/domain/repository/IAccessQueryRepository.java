package cloud.tteams.identity.authorization.domain.repository;

import cloud.tteams.identity.authorization.domain.Access;
import cloud.tteams.identity.authorization.domain.AccessId;
import cloud.tteams.share.core.domain.MessagePaginatedResponse;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface IAccessQueryRepository {

    Optional<Access> findById(AccessId id);

    MessagePaginatedResponse allAccessWithOutFilter(Pageable pageable);

    MessagePaginatedResponse allAccessWithFilter(Pageable pageable, String filter);

    Optional<Access> findByCode(String code);

    Long countByIdIsNotAndCode(UUID id, String code);
    
    public MessagePaginatedResponse findAll(Pageable pageable, String description, String code, String resource);

}
