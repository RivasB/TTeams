package ec.gob.registrocivil.identity.user.domain.repository;

import ec.gob.registrocivil.identity.user.domain.RegistrationToken;
import ec.gob.registrocivil.identity.user.domain.RegistrationTokenDateTime;

public interface IRegistrationTokenCommandRepository {
    public void create(RegistrationToken registrationToken);

    public void update(RegistrationToken registrationToken);

    public void delete(RegistrationToken registrationToken);

    public void deleteAllByEndingDateTimeBefore(RegistrationTokenDateTime datetime);
}
