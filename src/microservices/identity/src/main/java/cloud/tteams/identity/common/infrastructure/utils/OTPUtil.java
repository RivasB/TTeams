package cloud.tteams.identity.common.infrastructure.utils;

import java.util.Random;

import org.springframework.beans.factory.annotation.Value;

public class OTPUtil {

    @Value("${user.validation.otp.length:6}")
    private static int REGISTRATION_OTP_LENGTH = 6;

    private OTPUtil() {
    }

    public static String genOTP() {
        String values = "0123456789";

        Random random = new Random();

        char[] otp = new char[REGISTRATION_OTP_LENGTH];

        for (int i = 0; i < REGISTRATION_OTP_LENGTH; i++) {
            otp[i] = values.charAt(random.nextInt(values.length()));
        }

        return String.valueOf(otp);
    }

}
