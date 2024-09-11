package cloud.tteams.identity.user.domain.rules;

import cloud.tteams.share.core.domain.rules.BusinessRule;

public class UserLastNameRequiredRule extends BusinessRule {

    private final String lastName;

    public UserLastNameRequiredRule(String lastName) {
        super("User last name is required!");
        this.lastName = lastName;
    }

    @Override
    public boolean isBroken() {
        return lastName.isBlank();
    }

}
