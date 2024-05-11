package cloud.tteams.identity.shared.infrastructure.utils;

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

    public static String genPassword() {
        String numbers = "0123456789";
        String capitalCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCase = "abcdefghijklmnopqrstuvwxyz";
        String symbols = "/*-+.,<>!@#$%^&*()_=";
        String values = numbers + capitalCase + lowerCase + symbols;

        Random random = new Random();

        int len = 15;

        char[] otp = new char[len];

        otp[0] = numbers.charAt(random.nextInt(numbers.length()));
        otp[1] = capitalCase.charAt(random.nextInt(capitalCase.length()));
        otp[2] = lowerCase.charAt(random.nextInt(lowerCase.length()));
        otp[3] = symbols.charAt(random.nextInt(symbols.length()));
        for (int i = 4; i < len; i++) {
            otp[i] = values.charAt(random.nextInt(values.length()));
        }

        return String.valueOf(otp);
    }
}
