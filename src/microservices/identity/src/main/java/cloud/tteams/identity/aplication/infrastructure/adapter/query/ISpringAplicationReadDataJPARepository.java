package cloud.tteams.identity.aplication.infrastructure.adapter.query;

import java.util.Optional;
import java.util.UUID;

import cloud.tteams.identity.aplication.infrastructure.repository.hibernate.AplicationDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import cloud.tteams.identity.aplication.domain.AplicationId;

public interface ISpringAplicationReadDataJPARepository extends JpaRepository<AplicationDto, UUID> {

    Page<AplicationDto> getAplicationDtoByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(
            String name, String description, Pageable pageable);

    Page<AplicationDto> findAll(Pageable pageable);

    public Optional<AplicationDto> findById(AplicationId id);

    public Long countByName(String name);

    public Optional<AplicationDto> findByName(String name);

    public Long countByIdIsNotAndName(UUID id, String name);
}
