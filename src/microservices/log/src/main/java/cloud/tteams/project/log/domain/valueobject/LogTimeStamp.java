package cloud.tteams.project.log.domain.valueobject;

import cloud.tteams.share.core.domain.valueobject.DateTimeValueObject;

import java.time.LocalDateTime;

public class LogTimeStamp extends DateTimeValueObject {

    private final LocalDateTime value;

    public LogTimeStamp(LocalDateTime value) {
        this.value = value;
    }

    @Override
    public LocalDateTime value() {
        return value;
    }
}
