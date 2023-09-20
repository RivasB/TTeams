package ec.gob.registrocivil.identity.profile.domain;

import java.util.UUID;

import ec.gob.registrocivil.share.core.domain.Identifier;

public class ProfileId extends Identifier {

    public ProfileId(UUID value) {
        super(value);
    }

    @Override
    public String toString() {
        return "ProfileId [value=" + value.toString() + "]";
    }

    public UUID getValue() {
        return value;
    }

}
