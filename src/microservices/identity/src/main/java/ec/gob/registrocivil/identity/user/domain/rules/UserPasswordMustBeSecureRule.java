package ec.gob.registrocivil.identity.user.domain.rules;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ec.gob.registrocivil.share.core.domain.rules.BusinessRule;
import ec.gob.registrocivil.identity.user.domain.UserPassword;
import ec.gob.registrocivil.share.core.domain.exception.DomainErrorMessage;

public class UserPasswordMustBeSecureRule extends BusinessRule {

    private UserPassword password;

    public UserPasswordMustBeSecureRule(UserPassword password) {
        super(DomainErrorMessage.USER_PASSWORD_STRONG, "User password must be secure!");
        this.password = password;
    }

    @Override
    public boolean isBroken() {
        // This pattern checks for a len betwen 6 and 32 characters, at least 1 capital
        // case, 1 lower case, 1 special character
        Pattern pattern = Pattern.compile("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[\\p{P}\\p{S}]).{6,32}$");
        Matcher matcher = pattern.matcher(password.value());

        return !matcher.matches();
    }
}
