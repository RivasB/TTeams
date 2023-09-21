package cloud.tteams.identity.user.infrastructure.adapter.query;

import java.util.Optional;

import cloud.tteams.identity.user.infrastructure.repository.hibernate.RegistrationTokenDto;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import cloud.tteams.share.core.infrastructure.exceptions.ResourceNotFoundException;
import cloud.tteams.identity.user.domain.RegistrationToken;
import cloud.tteams.identity.user.domain.RegistrationTokenId;
import cloud.tteams.identity.user.domain.RegistrationTokenOTP;
import cloud.tteams.identity.user.domain.UserId;
import cloud.tteams.identity.user.domain.repository.IRegistrationTokenQueryRepository;

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
