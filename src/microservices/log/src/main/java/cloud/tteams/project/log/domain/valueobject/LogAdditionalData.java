package cloud.tteams.project.log.domain.valueobject;

import cloud.tteams.share.core.domain.valueobject.MapValueObject;

import java.util.Map;

public class LogAdditionalData extends MapValueObject {

    private final Map<String, Object> value;

    public LogAdditionalData(Map<String, Object> value) {
        this.value = value;
    }

    @Override
    public Map<String, Object> value() {
        return value;
    }
}
