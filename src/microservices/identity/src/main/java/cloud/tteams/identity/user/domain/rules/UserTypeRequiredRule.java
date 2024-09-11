package cloud.tteams.identity.user.domain.rules;

import cloud.tteams.share.core.domain.rules.BusinessRule;
import cloud.tteams.identity.user.domain.UserType;

import java.util.Objects;

public class UserTypeRequiredRule extends BusinessRule {

    private final UserType type;

    public UserTypeRequiredRule(UserType type) {
        super("User type is required!");
        this.type = type;
    }

    @Override
    public boolean isBroken() {
        return Objects.isNull(this.type);
    }
}
