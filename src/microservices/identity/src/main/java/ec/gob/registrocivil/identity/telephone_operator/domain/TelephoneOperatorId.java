package ec.gob.registrocivil.identity.telephone_operator.domain;

import java.util.UUID;

import ec.gob.registrocivil.share.core.domain.Identifier;

public class TelephoneOperatorId extends Identifier {

    public TelephoneOperatorId(UUID value) {
        super(value);
    }

    public UUID getValue() {
        return value;
    }
}
