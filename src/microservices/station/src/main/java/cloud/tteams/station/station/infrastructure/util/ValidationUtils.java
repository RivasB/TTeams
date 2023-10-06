package cloud.tteams.station.station.infrastructure.util;

import java.util.regex.Pattern;


public class ValidationUtils {
    private static final String LATITUDE_REGEX = "^[-+]?([1-8]?\\d(\\.\\d+)?|90(\\.0+)?)$";
    private static final String LONGITUDE_REGEX = "^[-+]?((1[0-7]|[1-9])?\\d(\\.\\d+)?|180(\\.0+)?)$";

    public static void isValidLatitude(String latitude) {
        if (Pattern.matches(LATITUDE_REGEX, latitude)){
            throw new IllegalArgumentException();
        }
    }

    public static void isValidLongitude(String longitude) {
        if (Pattern.matches(LONGITUDE_REGEX, longitude)){
            throw new IllegalArgumentException();
        }
    }
}
