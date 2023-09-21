package cloud.tteams.identity.user.domain.rules;

import cloud.tteams.identity.user.domain.service.IPasswordEncoder;
import cloud.tteams.share.core.domain.rules.BusinessRule;
import cloud.tteams.identity.user.domain.User;
import cloud.tteams.identity.user.domain.UserPassword;
import cloud.tteams.share.core.domain.exception.DomainErrorMessage;

public class UserPasswordMatchRule extends BusinessRule {

    private IPasswordEncoder passwordEncoder;

    private User user;

    private UserPassword oldPassword;

    public UserPasswordMatchRule(IPasswordEncoder passwordEncoder, User user, UserPassword oldPassword) {
        super(DomainErrorMessage.USER_OLD_PASSWORD_NOT_MATCH, "The old password provided does not match!");
        this.passwordEncoder = passwordEncoder;
        this.user = user;
        this.oldPassword = oldPassword;
    }

    @Override
    public boolean isBroken() {

        return !passwordEncoder.matches(oldPassword.value(), user.getPassword().value());
    }

}
