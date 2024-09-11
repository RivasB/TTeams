package cloud.tteams.identity.user.infrastructure.adapter.query.otp;

import java.util.Optional;
import java.util.UUID;

import cloud.tteams.identity.user.infrastructure.repository.hibernate.RegistrationTokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISpringRegistrationTokenReadDataJPARepository extends JpaRepository<RegistrationTokenEntity, UUID> {

    Optional<RegistrationTokenEntity> findByOtp(String otp);

}
