package cloud.tteams.identity.user.domain.rules;

import cloud.tteams.share.core.domain.rules.BusinessRule;

public class UserFirstNameRequiredRule extends BusinessRule {

    private final String firstName;

    public UserFirstNameRequiredRule(String firstName) {
        super("User first name is required!");
        this.firstName = firstName;
    }

    @Override
    public boolean isBroken() {
        return firstName.isBlank();
    }
}
