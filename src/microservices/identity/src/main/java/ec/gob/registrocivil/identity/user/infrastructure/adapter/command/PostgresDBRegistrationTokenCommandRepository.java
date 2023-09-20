package ec.gob.registrocivil.identity.user.infrastructure.adapter.command;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import ec.gob.registrocivil.identity.user.domain.RegistrationToken;
import ec.gob.registrocivil.identity.user.domain.RegistrationTokenDateTime;
import ec.gob.registrocivil.identity.user.domain.repository.IRegistrationTokenCommandRepository;
import ec.gob.registrocivil.identity.user.infrastructure.repository.hibernate.RegistrationTokenDto;
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
