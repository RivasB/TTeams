package ec.gob.registrocivil.identity.profile.domain;

import java.util.Arrays;

public enum ProfileState {
    ACTIVE("activo"), INACTIVE("inactivo");

    private static final ProfileState[] NAMES;

    private final String value;

    ProfileState(String value) {
        this.value = value;
    }

    static {
        NAMES = values();
    }

    public static ProfileState fromName(String name) {
        return Arrays.stream(NAMES).filter(ch -> ch.name().equals(name)).findFirst().orElse(null);
    }

    public static ProfileState fromValue(String value) {
        return Arrays.stream(NAMES).filter(ch -> ch.getValue().equals(value)).findFirst().orElse(null);
    }

    public String getValue() {
        return value;
    }
}
