package cloud.tteams.identity.user.infrastructure.adapter.command.otp;

import java.time.LocalDateTime;
import java.util.UUID;

import cloud.tteams.identity.user.infrastructure.repository.hibernate.RegistrationTokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISpringRegistrationTokenWriteDataJPARepository extends JpaRepository<RegistrationTokenEntity, UUID> {

    void deleteByEndingDateTimeBefore(LocalDateTime dateTime);
}
