package cloud.tteams.identity.user.domain.rules;

import cloud.tteams.identity.user.domain.service.IPasswordEncoder;
import cloud.tteams.share.core.domain.rules.BusinessRule;
import cloud.tteams.identity.user.domain.User;

public class UserPasswordMatchRule extends BusinessRule {

    private final IPasswordEncoder passwordEncoder;

    private final User user;

    private final String oldPassword;

    public UserPasswordMatchRule(IPasswordEncoder passwordEncoder, User user, String oldPassword) {
        super("The old password provided does not match!");
        this.passwordEncoder = passwordEncoder;
        this.user = user;
        this.oldPassword = oldPassword;
    }

    @Override
    public boolean isBroken() {

        return !passwordEncoder.matches(oldPassword, user.getPassword());
    }

}
