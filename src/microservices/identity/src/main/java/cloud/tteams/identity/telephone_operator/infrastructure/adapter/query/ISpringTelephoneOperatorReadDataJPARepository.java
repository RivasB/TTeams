package cloud.tteams.identity.telephone_operator.infrastructure.adapter.query;

import java.util.Optional;
import java.util.UUID;

import cloud.tteams.identity.telephone_operator.infrastructure.repository.hibernate.TelephoneOperatorDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISpringTelephoneOperatorReadDataJPARepository extends JpaRepository<TelephoneOperatorDto, UUID> {

    public Optional<TelephoneOperatorDto> findByName(String name);

    public Long countByIdIsNotAndName(UUID id, String name);

    public Page<TelephoneOperatorDto> getTelephoneOperatorDtoByNameContainingIgnoreCase(String name, Pageable pageable);
}
