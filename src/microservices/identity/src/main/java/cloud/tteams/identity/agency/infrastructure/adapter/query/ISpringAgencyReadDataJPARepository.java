package cloud.tteams.identity.agency.infrastructure.adapter.query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import cloud.tteams.identity.agency.infrastructure.repository.hibernate.AgencyDto;
import cloud.tteams.identity.geographiclocation.infrastructure.repository.hibernate.GeographicLocationDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISpringAgencyReadDataJPARepository extends JpaRepository<AgencyDto, UUID> {

    Page<AgencyDto> getAgencyDtoByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(
            String name, String description, Pageable pageable);

    Page<AgencyDto> findAll(Pageable pageable);

    Optional<AgencyDto> findByName(String name);

    Long countByName(String name);

    Long countByIdIsNotAndName(UUID id, String name);

    List<AgencyDto> findAgencyDtoByProvince(GeographicLocationDto geographicLocationDto);
    
    List<AgencyDto> findAgencyDtoByCanton(GeographicLocationDto geographicLocationDto);

    <T> Page<AgencyDto> findAll(Specification<T> tSpecification, Pageable pageable);
}
