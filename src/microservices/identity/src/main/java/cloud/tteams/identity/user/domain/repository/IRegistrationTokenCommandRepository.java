package cloud.tteams.identity.user.domain.repository;

import cloud.tteams.identity.user.domain.RegistrationToken;
import cloud.tteams.identity.user.domain.RegistrationTokenDateTime;

public interface IRegistrationTokenCommandRepository {
    public void create(RegistrationToken registrationToken);

    public void update(RegistrationToken registrationToken);

    public void delete(RegistrationToken registrationToken);

    public void deleteAllByEndingDateTimeBefore(RegistrationTokenDateTime datetime);
}
