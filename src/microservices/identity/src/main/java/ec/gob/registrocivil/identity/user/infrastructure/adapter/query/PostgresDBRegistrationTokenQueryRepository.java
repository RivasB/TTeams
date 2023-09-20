package ec.gob.registrocivil.identity.user.infrastructure.adapter.query;

import java.util.Optional;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import ec.gob.registrocivil.share.core.infrastructure.exceptions.ResourceNotFoundException;
import ec.gob.registrocivil.identity.user.domain.RegistrationToken;
import ec.gob.registrocivil.identity.user.domain.RegistrationTokenId;
import ec.gob.registrocivil.identity.user.domain.RegistrationTokenOTP;
import ec.gob.registrocivil.identity.user.domain.UserId;
import ec.gob.registrocivil.identity.user.domain.repository.IRegistrationTokenQueryRepository;
import ec.gob.registrocivil.identity.user.infrastructure.repository.hibernate.RegistrationTokenDto;

@Component
@Primary
public class PostgresDBRegistrationTokenQueryRepository implements IRegistrationTokenQueryRepository {

    private final ISpringRegistrationTokenReadDataJPARepository registrationTokenRepository;

    public PostgresDBRegistrationTokenQueryRepository(
            ISpringRegistrationTokenReadDataJPARepository registrationTokenRepository) {
        this.registrationTokenRepository = registrationTokenRepository;
    }

    @Override
    public RegistrationToken findById(RegistrationTokenId id) {
        Optional<RegistrationTokenDto> registrationTokenEntity = registrationTokenRepository.findById(id.value());

        if (!registrationTokenEntity.isPresent())
            throw new ResourceNotFoundException("Registration Token not found for ID");

        return registrationTokenEntity.get().toAggregate();
    }

    @Override
    public Optional<RegistrationToken> findByOtp(RegistrationTokenOTP otp) {
        Optional<RegistrationTokenDto> registrationTokenEntity = registrationTokenRepository.findByOtp(otp.value());

        if (!registrationTokenEntity.isPresent())
            return Optional.empty();

        return Optional.of(registrationTokenEntity.get().toAggregate());
    }

    @Override
    public Optional<RegistrationToken> findByUserId(UserId userId) {
        Optional<RegistrationTokenDto> registrationTokenEntity = registrationTokenRepository
                .findByUserId(userId.value());

        if (!registrationTokenEntity.isPresent())
            return Optional.empty();

        return Optional.of(registrationTokenEntity.get().toAggregate());
    }
}
