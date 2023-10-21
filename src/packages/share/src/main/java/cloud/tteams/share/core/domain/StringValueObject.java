package cloud.tteams.share.core.domain;

import java.util.Objects;

public abstract class StringValueObject {

    protected final String value;

    protected StringValueObject() {
        this.value = null;
    }

    protected StringValueObject(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.value();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof StringValueObject instance) {
            return Objects.equals(value, instance.value);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
