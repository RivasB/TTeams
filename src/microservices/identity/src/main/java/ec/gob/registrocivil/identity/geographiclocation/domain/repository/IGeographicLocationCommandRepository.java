package ec.gob.registrocivil.identity.geographiclocation.domain.repository;

import java.util.List;

import ec.gob.registrocivil.identity.geographiclocation.domain.GeographicLocation;

public interface IGeographicLocationCommandRepository {

    void create(GeographicLocation geographiclocation);

    void update(GeographicLocation geographiclocation);

    void delete(GeographicLocation geographiclocation);

    List<GeographicLocation> findAll();
}
