package cloud.tteams.identity.user.domain.rules;

import cloud.tteams.identity.user.infrastructure.service.DomainUserService;
import cloud.tteams.share.core.domain.rules.BusinessRule;
import cloud.tteams.identity.user.domain.User;
import cloud.tteams.share.core.domain.exception.DomainErrorMessage;

public class UserEmailMustBeUniqueRule extends BusinessRule {
    private DomainUserService userService;

    private User user;

    public UserEmailMustBeUniqueRule(DomainUserService userService, User user) {
        super(DomainErrorMessage.USER_MAIL_UNIQUE, "User mail must be unique!");

        this.userService = userService;
        this.user = user;
    }

    @Override
    public boolean isBroken() {
        return null == user.getEmail() || userService.countByIdIsNotAndEmail(user.getId(), user.getEmail()) > 0;
    }
}
