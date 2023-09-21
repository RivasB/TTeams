package cloud.tteams.identity.aplication.domain;

import cloud.tteams.share.core.domain.Identifier;
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
