package ec.gob.registrocivil.identity.aplication.infrastructure.adapter.query;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import ec.gob.registrocivil.identity.aplication.domain.AplicationId;
import ec.gob.registrocivil.identity.aplication.infrastructure.repository.hibernate.AplicationDto;

public interface ISpringAplicationReadDataJPARepository extends JpaRepository<AplicationDto, UUID> {

    Page<AplicationDto> getAplicationDtoByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(
            String name, String description, Pageable pageable);

    Page<AplicationDto> findAll(Pageable pageable);

    public Optional<AplicationDto> findById(AplicationId id);

    public Long countByName(String name);

    public Optional<AplicationDto> findByName(String name);

    public Long countByIdIsNotAndName(UUID id, String name);
}
