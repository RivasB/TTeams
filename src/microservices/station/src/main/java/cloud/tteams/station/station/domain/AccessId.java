package cloud.tteams.identity.access.domain;

import java.util.UUID;

import cloud.tteams.share.core.domain.Identifier;

public class AccessId extends Identifier {

    public AccessId(UUID value) {
        super(value);
    }
}
