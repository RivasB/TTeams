package cloud.tteams.identity.user.infrastructure.adapter.command;

import java.time.LocalDateTime;
import java.util.UUID;

import cloud.tteams.identity.user.infrastructure.repository.hibernate.RegistrationTokenDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISpringRegistrationTokenWriteDataJPARepository extends JpaRepository<RegistrationTokenDto, UUID> {

    void deleteByEndingDateTimeBefore(LocalDateTime dateTime);
}
