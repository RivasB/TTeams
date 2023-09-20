package ec.gob.registrocivil.identity.aplication.domain;

import ec.gob.registrocivil.share.core.domain.Identifier;
import java.util.UUID;

public class AplicationId extends Identifier {

    public AplicationId(UUID value) {
        super(value);
    }

    @Override
    public String toString() {
        return "AplicationId [value=" + value.toString() + "]";
    }

    public UUID getValue() {
        return value;
    }

}
