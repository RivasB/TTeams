package cloud.tteams.identity.user.infrastructure.adapter.query.otp;

import java.util.Optional;
import java.util.UUID;

import cloud.tteams.identity.user.infrastructure.repository.hibernate.RegistrationTokenEntity;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import cloud.tteams.share.core.infrastructure.exceptions.ResourceNotFoundException;
import cloud.tteams.identity.user.domain.RegistrationToken;
import cloud.tteams.identity.user.domain.repository.otp.IRegistrationTokenQueryRepository;

@Component
@Primary
public class PostgresDBRegistrationTokenQueryRepository implements IRegistrationTokenQueryRepository {

    private final ISpringRegistrationTokenReadDataJPARepository registrationTokenRepository;

    public PostgresDBRegistrationTokenQueryRepository(
            ISpringRegistrationTokenReadDataJPARepository registrationTokenRepository) {
        this.registrationTokenRepository = registrationTokenRepository;
    }

    @Override
    public RegistrationToken findById(UUID id) {
        Optional<RegistrationTokenEntity> registrationTokenEntity = registrationTokenRepository.findById(id);
        if (registrationTokenEntity.isEmpty())
            throw new ResourceNotFoundException(String.format("Registration token with id '%s' not found", id));
        return registrationTokenEntity.get().toAggregate();
    }

    @Override
    public Optional<RegistrationToken> findByOtp(String otp) {
        Optional<RegistrationTokenEntity> registrationTokenEntity = registrationTokenRepository.findByOtp(otp);
        return registrationTokenEntity.map(RegistrationTokenEntity::toAggregate);
    }
}
