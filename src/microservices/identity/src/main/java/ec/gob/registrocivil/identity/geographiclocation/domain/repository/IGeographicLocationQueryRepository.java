package ec.gob.registrocivil.identity.geographiclocation.domain.repository;

import org.springframework.data.domain.Pageable;

import ec.gob.registrocivil.identity.geographiclocation.domain.GeographicLocation;
import ec.gob.registrocivil.identity.geographiclocation.domain.GeographicLocationId;
import ec.gob.registrocivil.identity.geographiclocation.domain.GeographicLocationType;
import ec.gob.registrocivil.share.core.domain.MessagePaginatedResponse;

public interface IGeographicLocationQueryRepository {

    GeographicLocation findById(GeographicLocationId geographicLocationId);

    MessagePaginatedResponse allGeographicLocationWithFilter(Pageable pageable, String filter);

    MessagePaginatedResponse allGeographicLocationWithOutFilter(Pageable pageable);

    MessagePaginatedResponse allLocationsWithFilter(Pageable pageable, String filter, GeographicLocationType type);

    MessagePaginatedResponse allLocationsWithOutFilter(Pageable pageable, GeographicLocationType type);
    
    MessagePaginatedResponse findByParent(Pageable pageable, GeographicLocationId parent);

}
