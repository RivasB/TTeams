package cloud.tteams.identity.user.domain;

import java.time.LocalDateTime;

import cloud.tteams.share.core.domain.DateTimeValueObject;

public class RegistrationTokenDateTime extends DateTimeValueObject {

    public RegistrationTokenDateTime(LocalDateTime value) {
        super(value);
    }
}
