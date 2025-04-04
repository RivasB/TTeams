package cloud.tteams.project.log.domain.valueobject;

import cloud.tteams.share.core.domain.valueobject.StringValueObject;

public class LogMessage extends StringValueObject {

    private final String value;

    public LogMessage(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }
}
