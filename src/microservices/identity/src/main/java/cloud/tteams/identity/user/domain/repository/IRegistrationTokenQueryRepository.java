package cloud.tteams.identity.user.domain.repository;

import java.util.Optional;

import cloud.tteams.identity.user.domain.RegistrationToken;
import cloud.tteams.identity.user.domain.RegistrationTokenId;
import cloud.tteams.identity.user.domain.RegistrationTokenOTP;
import cloud.tteams.identity.user.domain.UserId;

public interface IRegistrationTokenQueryRepository {

    RegistrationToken findById(RegistrationTokenId id);

    Optional<RegistrationToken> findByOtp(RegistrationTokenOTP otp);

    Optional<RegistrationToken> findByUserId(UserId userId);
}
