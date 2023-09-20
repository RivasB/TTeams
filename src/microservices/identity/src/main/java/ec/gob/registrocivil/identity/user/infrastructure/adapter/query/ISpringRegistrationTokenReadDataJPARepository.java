package ec.gob.registrocivil.identity.user.infrastructure.adapter.query;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.gob.registrocivil.identity.user.infrastructure.repository.hibernate.RegistrationTokenDto;

public interface ISpringRegistrationTokenReadDataJPARepository extends JpaRepository<RegistrationTokenDto, UUID> {

    public Optional<RegistrationTokenDto> findByOtp(String otp);

    public Optional<RegistrationTokenDto> findByUserId(UUID userId);
}
