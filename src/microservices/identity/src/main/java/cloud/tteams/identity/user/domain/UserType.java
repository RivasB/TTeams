package cloud.tteams.identity.user.domain;

import java.util.Arrays;

public enum UserType {
    ADMIN, SPECIALIST, CITIZEN;

    private static final UserType[] VALUES;

    static {
        VALUES = values();
    }

    public static UserType fromName(String value) {
        return Arrays.stream(VALUES).filter(ch -> ch.name().equals(value)).findFirst().orElse(null);
    }
}
