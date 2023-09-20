package ec.gob.registrocivil.identity.geographiclocation.infrastructure.adapter.command;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.gob.registrocivil.identity.geographiclocation.infrastructure.repository.hibernate.GeographicLocationDto;

public interface IGeographicLocationCommandJPARepository extends JpaRepository<GeographicLocationDto, UUID> {

}
