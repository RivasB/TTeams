package cloud.tteams.share.core.domain;

import java.util.Objects;

public abstract class IntegerValueObject {

    protected Integer value;

    protected IntegerValueObject(Integer value) {
        this.value = value;
    }

    public Integer value() {
        return value;
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof IntegerValueObject instance) {
            return Objects.equals(value, instance.value);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
