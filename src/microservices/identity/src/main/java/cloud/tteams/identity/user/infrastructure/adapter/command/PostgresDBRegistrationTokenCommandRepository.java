package cloud.tteams.identity.user.infrastructure.adapter.command;

import cloud.tteams.identity.user.infrastructure.repository.hibernate.RegistrationTokenDto;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import cloud.tteams.identity.user.domain.RegistrationToken;
import cloud.tteams.identity.user.domain.RegistrationTokenDateTime;
import cloud.tteams.identity.user.domain.repository.IRegistrationTokenCommandRepository;
import jakarta.transaction.Transactional;

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
        registrationTokenRepository.save(new RegistrationTokenDto(registrationToken));
    }

    @Override
    public void update(RegistrationToken registrationToken) {
        registrationTokenRepository.save(new RegistrationTokenDto(registrationToken));
    }

    @Override
    public void delete(RegistrationToken registrationToken) {
        registrationTokenRepository.delete(new RegistrationTokenDto(registrationToken));
    }

    @Override
    @Transactional
    public void deleteAllByEndingDateTimeBefore(RegistrationTokenDateTime datetime) {
        registrationTokenRepository.deleteByEndingDateTimeBefore(datetime.value());
    }
}
