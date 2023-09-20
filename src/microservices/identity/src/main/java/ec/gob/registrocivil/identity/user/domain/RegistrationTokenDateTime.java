package ec.gob.registrocivil.identity.user.domain;

import java.time.LocalDateTime;

import ec.gob.registrocivil.share.core.domain.DateTimeValueObject;

public class RegistrationTokenDateTime extends DateTimeValueObject {

    public RegistrationTokenDateTime(LocalDateTime value) {
        super(value);
    }
}
