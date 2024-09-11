package cloud.tteams.identity.user.infrastructure.adapter.command.otp;

import cloud.tteams.identity.user.infrastructure.repository.hibernate.RegistrationTokenEntity;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import cloud.tteams.identity.user.domain.RegistrationToken;
import cloud.tteams.identity.user.domain.repository.otp.IRegistrationTokenCommandRepository;
import jakarta.transaction.Transactional;

import java.time.LocalDateTime;

@Component
@Primary
public class PostgresDBRegistrationTokenCommandRepository implements IRegistrationTokenCommandRepository {

    private final ISpringRegistrationTokenWriteDataJPARepository registrationTokenRepository;

    public PostgresDBRegistrationTokenCommandRepository(
            ISpringRegistrationTokenWriteDataJPARepository registrationTokenRepository) {
        this.registrationTokenRepository = registrationTokenRepository;
    }

    @Override
    public void create(RegistrationToken registrationToken) {
        registrationTokenRepository.save(new RegistrationTokenEntity(registrationToken));
    }

    @Override
    public void update(RegistrationToken registrationToken) {
        registrationTokenRepository.save(new RegistrationTokenEntity(registrationToken));
    }

    @Override
    public void delete(RegistrationToken registrationToken) {
        registrationTokenRepository.delete(new RegistrationTokenEntity(registrationToken));
    }

    @Override
    @Transactional
    public void deleteAllByEndingDateTimeBefore(LocalDateTime datetime) {
        registrationTokenRepository.deleteByEndingDateTimeBefore(datetime);
    }
}
