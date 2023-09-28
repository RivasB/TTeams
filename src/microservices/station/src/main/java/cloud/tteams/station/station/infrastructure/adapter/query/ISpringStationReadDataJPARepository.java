package cloud.tteams.station.station.infrastructure.adapter.query;


import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;
import org.springframework.data.jpa.domain.Specification;

public interface ISpringStationReadDataJPARepository extends JpaRepository<AccessDto, UUID> {

    Page<AccessDto> getAccessDtoByCodeContainingIgnoreCaseOrDescriptionContainingIgnoreCase(
            String code, String description, Pageable pageable);
    
    <T> Page<AccessDto> findAll(Specification<T> tSpecification, Pageable pageable);

}
