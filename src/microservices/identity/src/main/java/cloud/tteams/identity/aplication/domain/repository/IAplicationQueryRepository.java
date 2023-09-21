package cloud.tteams.identity.aplication.domain.repository;

import java.util.UUID;

import org.springframework.data.domain.Pageable;

import cloud.tteams.identity.aplication.domain.Aplication;
import cloud.tteams.identity.aplication.domain.AplicationId;
import cloud.tteams.share.core.domain.MessagePaginatedResponse;

public interface IAplicationQueryRepository {
    public Aplication findById(AplicationId id);

    public MessagePaginatedResponse allAplicationWithOutFilter(Pageable pageable);

    public MessagePaginatedResponse allAplicationWithFilter(Pageable pageable, String filter);

    public Long countByName(String name);

    public Aplication findByName(String name);

    public Long countByIdIsNotAndName(UUID id, String name);
}
