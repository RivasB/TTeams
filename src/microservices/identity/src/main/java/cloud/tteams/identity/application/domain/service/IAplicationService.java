package cloud.tteams.identity.application.domain.service;

import org.springframework.data.domain.Pageable;

import cloud.tteams.identity.application.domain.Aplication;
import cloud.tteams.identity.application.domain.AplicationId;
import cloud.tteams.identity.application.domain.AplicationName;
import cloud.tteams.share.core.domain.MessagePaginatedResponse;

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
