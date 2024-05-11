package cloud.tteams.identity.authorization.infrastructure.adapter.query;

import cloud.tteams.identity.authorization.infrastructure.repository.hibernate.AccessDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;
import org.springframework.data.jpa.domain.Specification;

public interface ISpringAccessReadDataJPARepository extends JpaRepository<AccessDto, UUID> {

    Page<AccessDto> getAccessDtoByCodeContainingIgnoreCaseOrDescriptionContainingIgnoreCase(
            String code, String description, Pageable pageable);
    
    <T> Page<AccessDto> findAll(Specification<T> tSpecification, Pageable pageable);

    AccessDto findByCode(String code);

    Long countByIdIsNotAndCode(UUID id, String code);

}
