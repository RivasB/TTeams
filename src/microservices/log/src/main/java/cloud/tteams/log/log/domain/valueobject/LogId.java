package cloud.tteams.log.log.domain.valueobject;

import cloud.tteams.share.core.domain.valueobject.Identifier;

import java.util.UUID;

public class LogId extends Identifier {

    private final UUID value;

    public LogId(UUID value) {
        this.value = value;
    }

    @Override
    public UUID value() {
        return value;
    }
}
