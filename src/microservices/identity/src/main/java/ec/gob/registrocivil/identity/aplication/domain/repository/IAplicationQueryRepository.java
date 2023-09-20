package ec.gob.registrocivil.identity.aplication.domain.repository;

import java.util.UUID;

import org.springframework.data.domain.Pageable;

import ec.gob.registrocivil.identity.aplication.domain.Aplication;
import ec.gob.registrocivil.identity.aplication.domain.AplicationId;
import ec.gob.registrocivil.share.core.domain.MessagePaginatedResponse;

public interface IAplicationQueryRepository {
    public Aplication findById(AplicationId id);

    public MessagePaginatedResponse allAplicationWithOutFilter(Pageable pageable);

    public MessagePaginatedResponse allAplicationWithFilter(Pageable pageable, String filter);

    public Long countByName(String name);

    public Aplication findByName(String name);

    public Long countByIdIsNotAndName(UUID id, String name);
}
