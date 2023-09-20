package ec.gob.registrocivil.identity.aplication.domain.service;

import org.springframework.data.domain.Pageable;

import ec.gob.registrocivil.identity.aplication.domain.Aplication;
import ec.gob.registrocivil.identity.aplication.domain.AplicationId;
import ec.gob.registrocivil.identity.aplication.domain.AplicationName;
import ec.gob.registrocivil.share.core.domain.MessagePaginatedResponse;

public interface IAplicationService {
    public void createAplication(Aplication aplication);

    public void delete(AplicationId id);

    public void updateAplication(Aplication aplication);

    public Aplication findById(AplicationId id);

    public MessagePaginatedResponse getPaginatedAplication(Pageable pageable, String filter);

    public Long countByName(AplicationName name);

    public Aplication findByName(AplicationName name);

    public Long countByIdIsNotAndName(AplicationId id, AplicationName name);
}
