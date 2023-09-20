package ec.gob.registrocivil.identity.geographiclocation.domain.service;

import org.springframework.data.domain.Pageable;

import ec.gob.registrocivil.identity.geographiclocation.domain.GeographicLocation;
import ec.gob.registrocivil.identity.geographiclocation.domain.GeographicLocationId;
import ec.gob.registrocivil.identity.geographiclocation.domain.GeographicLocationType;
import ec.gob.registrocivil.share.core.domain.MessagePaginatedResponse;

public interface IGeographicLocationService {

    void create(GeographicLocation geographiclocation);

    void update(GeographicLocation geographiclocation);

    void delete(GeographicLocation geographiclocation);

    GeographicLocation findById(GeographicLocationId geographicLocationId);

    MessagePaginatedResponse getPaginatedGeographicLocation(Pageable pageable, String filter);

    MessagePaginatedResponse getPaginatedByType(Pageable pageable, String filter, GeographicLocationType city);

    MessagePaginatedResponse findByParent(Pageable pageable, GeographicLocationId parent);

    void SpreadLocations();
}
