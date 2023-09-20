package ec.gob.registrocivil.identity.validation_mesh.domain;

import java.util.UUID;

import ec.gob.registrocivil.share.core.domain.Identifier;

public class ValidationId extends Identifier {

    public ValidationId(UUID value) {
        super(value);
    }

}
