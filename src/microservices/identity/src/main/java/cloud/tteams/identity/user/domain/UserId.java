package cloud.tteams.identity.user.domain;

import java.util.UUID;

import cloud.tteams.share.core.domain.Identifier;

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
