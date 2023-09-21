package cloud.tteams.identity.user.domain.rules;

import cloud.tteams.identity.user.domain.UserProfileSet;
import cloud.tteams.identity.user.domain.UserType;
import cloud.tteams.share.core.domain.exception.DomainErrorMessage;
import cloud.tteams.share.core.domain.rules.BusinessRule;

public class UserProfilesRequiredRule extends BusinessRule {

    private final UserProfileSet profiles;

    private final UserType userType;

    public UserProfilesRequiredRule(UserType userType, UserProfileSet profiles) {
        super(DomainErrorMessage.USER_PROFILES_REQUIRED, "User profiles are required!");
        this.userType = userType;
        this.profiles = profiles;
    }

    @Override
    public boolean isBroken() {
        return userType == UserType.SPECIALIST && profiles == null;
    }
}
