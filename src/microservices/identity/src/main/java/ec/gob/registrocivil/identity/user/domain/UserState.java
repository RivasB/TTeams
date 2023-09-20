package ec.gob.registrocivil.identity.user.domain;

import java.util.Arrays;

public enum UserState {
    ACTIVE, INACTIVE;

    private static final UserState[] VALUES;

    static {
        VALUES = values();
    }

    public static UserState fromName(String value) {
        UserState state = Arrays.stream(VALUES).filter(ch -> ch.name().equals(value)).findFirst().orElse(null);
        return state;
    }
}
