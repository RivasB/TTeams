package cloud.tteams.identity.validation_mesh.domain;

import java.util.UUID;

import cloud.tteams.share.core.domain.Identifier;

public class ValidationByServiceId extends Identifier {

    public ValidationByServiceId(UUID value) {
        super(value);
    }

}
