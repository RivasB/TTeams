package cloud.tteams.share.core.domain.valueobject;

import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

@SuppressWarnings("all")
public abstract class MapValueObject implements Serializable {

    protected final Map<String, Object> value;

    protected MapValueObject(Map<String, Object> value) {
        this.value = value;
    }

    protected MapValueObject() {
        this.value = null;
    }

    public Map<String, Object> value() {
        return value;
    }

    public Map<String, Object> getValue() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LongIdentifier instance) {
            return Objects.equals(value, instance.value);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
