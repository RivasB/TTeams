package cloud.tteams.share.core.domain.valueobject;

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

@SuppressWarnings("all")
public abstract class CollectionValueObject<T> implements Serializable {

    protected final Collection<T> value;

    protected CollectionValueObject(Collection<T> value) {
        this.value = value;
    }

    protected CollectionValueObject() {
        this.value = null;
    }

    public Collection<T> value() {
        return value;
    }

    public Collection<T> getValue() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CollectionValueObject instance) {
            if (value == null || instance.value == null) {
                return value == instance.value;
            }
            if (value.size() != instance.value.size()) {
                return false;
            }
            return value.containsAll(instance.value) && instance.value.containsAll(value);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
