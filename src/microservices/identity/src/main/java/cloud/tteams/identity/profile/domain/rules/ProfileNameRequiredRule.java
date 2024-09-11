package cloud.tteams.identity.profile.domain.rules;

import cloud.tteams.share.core.domain.rules.BusinessRule;

public class ProfileNameRequiredRule extends BusinessRule {

    private final String name;

    public ProfileNameRequiredRule(String name) {
        super("Profile name is required!");
        this.name = name;
    }

    @Override
    public boolean isBroken() {
        return null == name || name.isBlank();
    }
}
