package cloud.tteams.identity.user.domain.service;

public interface IPasswordEncoder {

    public String encode(String password);

    public boolean matches(CharSequence rawPassword, String encodedPassword);
}
