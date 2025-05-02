package cloud.tteams.log.log.domain.valueobject;

import cloud.tteams.share.core.domain.valueobject.StringValueObject;

public class LogMethodName extends StringValueObject {

    private final String value;

    public LogMethodName(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }
}
