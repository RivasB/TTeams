package ec.gob.registrocivil.identity.user.domain.rules;

import ec.gob.registrocivil.share.core.domain.rules.BusinessRule;
import ec.gob.registrocivil.identity.user.domain.User;
import ec.gob.registrocivil.identity.user.domain.UserPassword;
import ec.gob.registrocivil.identity.user.domain.service.IPasswordEncoder;
import ec.gob.registrocivil.share.core.domain.exception.DomainErrorMessage;

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
