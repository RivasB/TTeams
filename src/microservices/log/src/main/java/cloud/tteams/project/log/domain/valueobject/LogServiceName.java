package cloud.tteams.project.log.domain.valueobject;

import cloud.tteams.share.core.domain.valueobject.StringValueObject;

public class LogServiceName extends StringValueObject {

    private final String value;

    public LogServiceName(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }
}
