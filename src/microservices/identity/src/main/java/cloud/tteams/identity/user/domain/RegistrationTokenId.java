package cloud.tteams.identity.user.domain;

import java.util.UUID;

import cloud.tteams.share.core.domain.Identifier;

public class RegistrationTokenId extends Identifier {

    public RegistrationTokenId(UUID value) {
        super(value);
    }
}
