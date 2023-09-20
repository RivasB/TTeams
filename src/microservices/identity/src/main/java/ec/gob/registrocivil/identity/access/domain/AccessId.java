package ec.gob.registrocivil.identity.access.domain;

import java.util.UUID;

import ec.gob.registrocivil.share.core.domain.Identifier;

public class AccessId extends Identifier {

    public AccessId(UUID value) {
        super(value);
    }
}
