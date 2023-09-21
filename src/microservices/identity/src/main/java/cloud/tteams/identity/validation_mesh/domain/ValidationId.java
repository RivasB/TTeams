package cloud.tteams.identity.validation_mesh.domain;

import java.util.UUID;

import cloud.tteams.share.core.domain.Identifier;

public class ValidationId extends Identifier {

    public ValidationId(UUID value) {
        super(value);
    }

}
