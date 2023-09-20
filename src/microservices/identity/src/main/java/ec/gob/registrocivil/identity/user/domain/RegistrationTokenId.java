package ec.gob.registrocivil.identity.user.domain;

import java.util.UUID;

import ec.gob.registrocivil.share.core.domain.Identifier;

public class RegistrationTokenId extends Identifier {

    public RegistrationTokenId(UUID value) {
        super(value);
    }
}
