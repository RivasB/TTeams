package cloud.tteams.identity.user.infrastructure.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import cloud.tteams.identity.user.domain.service.IPasswordEncoder;

@Component
public class PasswordEncoder implements IPasswordEncoder {

    private final BCryptPasswordEncoder encoder;

    public PasswordEncoder(BCryptPasswordEncoder encoder) {
        this.encoder = encoder;
    }

    @Override
    public String encode(String password) {

        return encoder.encode(password);
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {

        return encoder.matches(rawPassword, encodedPassword);
    }
}
