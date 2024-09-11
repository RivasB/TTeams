package cloud.tteams.identity.user.domain.rules;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cloud.tteams.share.core.domain.rules.BusinessRule;

public class UserPasswordMustBeSecureRule extends BusinessRule {

    private final String password;

    public UserPasswordMustBeSecureRule(String password) {
        super("User password must have at least 6 characters, capital letters and special characters");
        this.password = password;
    }

    @Override
    public boolean isBroken() {
        // This pattern checks for a len between 6 and 32 characters, at least 1 capital
        // case, 1 lower case, 1 special character
        Pattern pattern = Pattern.compile("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[\\p{P}\\p{S}]).{6,32}$");
        Matcher matcher = pattern.matcher(password);
        return !matcher.matches();
    }
}
