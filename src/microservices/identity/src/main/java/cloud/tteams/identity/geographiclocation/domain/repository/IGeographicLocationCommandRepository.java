package cloud.tteams.identity.geographiclocation.domain.repository;

import java.util.List;

import cloud.tteams.identity.geographiclocation.domain.GeographicLocation;

public interface IGeographicLocationCommandRepository {

    void create(GeographicLocation geographiclocation);

    void update(GeographicLocation geographiclocation);

    void delete(GeographicLocation geographiclocation);

    List<GeographicLocation> findAll();
}
