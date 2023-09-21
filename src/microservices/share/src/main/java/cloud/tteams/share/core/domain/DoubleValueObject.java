package cloud.tteams.share.core.domain;

import java.util.Objects;

public abstract class DoubleValueObject {

    protected final Double value;

    protected DoubleValueObject() {
        this.value = null;
    }

    protected DoubleValueObject(Double value) {
        this.value = value;
    }

    public Double value() {
        return value;
    }

    public Double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.value().toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DoubleValueObject instance) {
            return Objects.equals(value, instance.value);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
