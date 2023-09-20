package ec.gob.registrocivil.identity.geographiclocation.infrastructure.adapter.query;

import ec.gob.registrocivil.identity.geographiclocation.domain.GeographicLocationId;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import ec.gob.registrocivil.identity.geographiclocation.domain.GeographicLocationType;
import ec.gob.registrocivil.identity.geographiclocation.infrastructure.repository.hibernate.GeographicLocationDto;
import org.springframework.data.jpa.repository.Query;

public interface IGeographicLocationQueryJPARepository extends JpaRepository<GeographicLocationDto, UUID> {

        Page<GeographicLocationDto> getGeographicLocationDtoByNameContainingIgnoreCase(String filter,
                        Pageable pageable);

        Page<GeographicLocationDto> getGeographicLocationDtoByNameContainingIgnoreCaseOrTypeContainingIgnoreCase(
                        String filter, String filter2, Pageable pageable);

        Page<GeographicLocationDto> findAllByType(GeographicLocationType city, Pageable pageable);

        Page<GeographicLocationDto> getGeographicLocationDtoByNameContainingIgnoreCaseAndType(String filter,
                        GeographicLocationType city, Pageable pageable);
        
        @Query(value = "FROM GeographicLocationDto t WHERE t.parent.id=?1")
        Page<GeographicLocationDto> findByParent(UUID id, Pageable pageable);
    
}
