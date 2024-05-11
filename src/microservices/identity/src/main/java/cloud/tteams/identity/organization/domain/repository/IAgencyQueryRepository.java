package cloud.tteams.identity.organization.domain.repository;

import java.util.List;
import java.util.UUID;

import cloud.tteams.identity.organization.domain.AgencyState;
import org.springframework.data.domain.Pageable;

import cloud.tteams.identity.organization.domain.Agency;
import cloud.tteams.identity.organization.domain.AgencyId;
import cloud.tteams.identity.geographiclocation.domain.GeographicLocationId;
import cloud.tteams.share.core.domain.MessagePaginatedResponse;

public interface IAgencyQueryRepository {
    public Agency findById(AgencyId id);

    public MessagePaginatedResponse allAgencyWithOutFilter(Pageable pageable);

    public MessagePaginatedResponse allAgencyWithFilter(Pageable pageable, String filter);

    public Long countByName(String name);

    public Agency findByName(String name);

    public Long countByIdIsNotAndName(UUID id, String name);

    public List<Agency> findAgencyByProvince(GeographicLocationId geographicLocationId);
    
    public List<Agency> findAgencyByCanton(GeographicLocationId geographicLocationId);

    MessagePaginatedResponse findAll(Pageable pageable, String name, String province, String canton, String description, String latitude, String longitude, AgencyState state, String filter);
}
