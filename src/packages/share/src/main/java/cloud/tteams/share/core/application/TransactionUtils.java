package cloud.tteams.share.core.application;

import java.security.SecureRandom;
import java.util.Base64;

public class TransactionUtils {

    private static final SecureRandom random = new SecureRandom();

    public static String generateUniqueCode() {
        byte[] bytes = new byte[12];
        random.nextBytes(bytes);
        String code = Base64.getUrlEncoder().encodeToString(bytes);
        return code.substring(0, 16);
    }
}
