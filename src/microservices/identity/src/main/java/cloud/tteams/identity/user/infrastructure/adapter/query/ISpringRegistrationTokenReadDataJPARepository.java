package cloud.tteams.identity.user.infrastructure.adapter.query;

import java.util.Optional;
import java.util.UUID;

import cloud.tteams.identity.user.infrastructure.repository.hibernate.RegistrationTokenDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISpringRegistrationTokenReadDataJPARepository extends JpaRepository<RegistrationTokenDto, UUID> {

    public Optional<RegistrationTokenDto> findByOtp(String otp);

    public Optional<RegistrationTokenDto> findByUserId(UUID userId);
}
