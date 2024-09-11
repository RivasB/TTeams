package cloud.tteams.identity.user.domain.repository.otp;

import cloud.tteams.identity.user.domain.RegistrationToken;

import java.time.LocalDateTime;

public interface IRegistrationTokenCommandRepository {
    void create(RegistrationToken registrationToken);

    void update(RegistrationToken registrationToken);

    void delete(RegistrationToken registrationToken);

    void deleteAllByEndingDateTimeBefore(LocalDateTime datetime);
}
