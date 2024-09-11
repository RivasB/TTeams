package cloud.tteams.identity.user.domain.rules;

import cloud.tteams.share.core.domain.rules.BusinessRule;

public class UserPasswordRequiredRule extends BusinessRule {

    private final String password;

    public UserPasswordRequiredRule(String password) {
        super("User password is required!");
        this.password = password;
    }

    @Override
    public boolean isBroken() {
        return password.isBlank();
    }

}
