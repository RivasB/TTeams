package cloud.tteams.identity.user.domain.rules;

import cloud.tteams.identity.user.infrastructure.service.DomainUserService;
import cloud.tteams.share.core.domain.rules.BusinessRule;
import cloud.tteams.identity.user.domain.User;
import cloud.tteams.share.core.domain.exception.DomainErrorMessage;

public class UserIdentificationMustBeUniqueRule extends BusinessRule {

    private DomainUserService userService;

    private User user;

    public UserIdentificationMustBeUniqueRule(DomainUserService userService, User user) {
        super(DomainErrorMessage.USER_IDENTIFICATION_UNIQUE, "User identification must be unique!");

        this.userService = userService;
        this.user = user;
    }

    @Override
    public boolean isBroken() {
        return null == user.getIdentification()
                || userService.countByIdIsNotAndIdentification(user.getId(), user.getIdentification()) > 0;
    }
}
