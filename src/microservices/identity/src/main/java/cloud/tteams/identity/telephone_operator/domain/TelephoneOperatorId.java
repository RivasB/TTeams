package cloud.tteams.identity.telephone_operator.domain;

import java.util.UUID;

import cloud.tteams.share.core.domain.Identifier;

public class TelephoneOperatorId extends Identifier {

    public TelephoneOperatorId(UUID value) {
        super(value);
    }

    public UUID getValue() {
        return value;
    }
}
