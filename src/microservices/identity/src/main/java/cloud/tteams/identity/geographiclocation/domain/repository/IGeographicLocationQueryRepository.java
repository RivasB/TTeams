package cloud.tteams.identity.geographiclocation.domain.repository;

import org.springframework.data.domain.Pageable;

import cloud.tteams.identity.geographiclocation.domain.GeographicLocation;
import cloud.tteams.identity.geographiclocation.domain.GeographicLocationId;
import cloud.tteams.identity.geographiclocation.domain.GeographicLocationType;
import cloud.tteams.share.core.domain.MessagePaginatedResponse;

public interface IGeographicLocationQueryRepository {

    GeographicLocation findById(GeographicLocationId geographicLocationId);

    MessagePaginatedResponse allGeographicLocationWithFilter(Pageable pageable, String filter);

    MessagePaginatedResponse allGeographicLocationWithOutFilter(Pageable pageable);

    MessagePaginatedResponse allLocationsWithFilter(Pageable pageable, String filter, GeographicLocationType type);

    MessagePaginatedResponse allLocationsWithOutFilter(Pageable pageable, GeographicLocationType type);
    
    MessagePaginatedResponse findByParent(Pageable pageable, GeographicLocationId parent);

}
