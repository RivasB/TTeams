package ec.gob.registrocivil.identity.user.infrastructure.adapter.command;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.gob.registrocivil.identity.user.infrastructure.repository.hibernate.RegistrationTokenDto;

public interface ISpringRegistrationTokenWriteDataJPARepository extends JpaRepository<RegistrationTokenDto, UUID> {

    void deleteByEndingDateTimeBefore(LocalDateTime dateTime);
}
