package cloud.tteams.identity.user.domain.rules;

import cloud.tteams.share.core.domain.rules.BusinessRule;

public class UserEmailRequiredRule extends BusinessRule {

    private final String email;

    public UserEmailRequiredRule(String email) {
        super("User first name is required!");

        this.email = email;
    }

    @Override
    public boolean isBroken() { return email.isBlank(); }
}
