package cloud.tteams.identity.user.domain.service;

public interface IPasswordEncoder {

    String encode(String password);

    boolean matches(CharSequence rawPassword, String encodedPassword);
}
