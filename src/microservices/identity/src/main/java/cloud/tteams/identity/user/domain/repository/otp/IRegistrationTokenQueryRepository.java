package cloud.tteams.identity.user.domain.repository.otp;

import java.util.Optional;
import java.util.UUID;

import cloud.tteams.identity.user.domain.RegistrationToken;

public interface IRegistrationTokenQueryRepository {

    RegistrationToken findById(UUID id);

    Optional<RegistrationToken> findByOtp(String otp);
}
