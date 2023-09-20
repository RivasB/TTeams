package ec.gob.registrocivil.identity.user.domain.repository;

import java.util.Optional;

import ec.gob.registrocivil.identity.user.domain.RegistrationToken;
import ec.gob.registrocivil.identity.user.domain.RegistrationTokenId;
import ec.gob.registrocivil.identity.user.domain.RegistrationTokenOTP;
import ec.gob.registrocivil.identity.user.domain.UserId;

public interface IRegistrationTokenQueryRepository {

    RegistrationToken findById(RegistrationTokenId id);

    Optional<RegistrationToken> findByOtp(RegistrationTokenOTP otp);

    Optional<RegistrationToken> findByUserId(UserId userId);
}
