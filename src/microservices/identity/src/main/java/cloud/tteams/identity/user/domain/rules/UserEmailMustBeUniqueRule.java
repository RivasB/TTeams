package cloud.tteams.identity.user.domain.rules;

import cloud.tteams.identity.user.infrastructure.service.DomainUserService;
import cloud.tteams.share.core.domain.rules.BusinessRule;
import cloud.tteams.identity.user.domain.User;

public class UserEmailMustBeUniqueRule extends BusinessRule {

    private final DomainUserService userService;

    private final User user;

    public UserEmailMustBeUniqueRule(DomainUserService userService, User user) {
        super("User mail must be unique!");
        this.userService = userService;
        this.user = user;
    }

    @Override
    public boolean isBroken() {
        return userService.countByIdIsNotAndEmail(user.getId(), user.getEmail()) > 0;
    }
}
