package cloud.tteams.share.user.domain;

import cloud.tteams.share.core.domain.valueobject.Identifier;

import java.util.UUID;


public class UserId extends Identifier {
    private UUID value;

    public UserId(UUID value) {
        super(value);
        this.value = value;
    }

    @Override
    public String toString() {
        return "UserId [value=" + value.toString() + "]";
    }

    public UUID getValue() {
        return value;
    }
}
