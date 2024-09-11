package cloud.tteams.identity.user.domain.rules;

import cloud.tteams.identity.user.domain.repository.user.IUserQueryRepository;
import cloud.tteams.share.core.domain.rules.BusinessRule;
import cloud.tteams.identity.user.domain.User;

public class UserIdentificationMustBeUniqueRule extends BusinessRule {

    private final IUserQueryRepository queryRepository;

    private final User user;

    public UserIdentificationMustBeUniqueRule(IUserQueryRepository queryRepository, User user) {
        super("User identification must be unique!");
        this.queryRepository = queryRepository;
        this.user = user;
    }

    @Override
    public boolean isBroken() {
        return queryRepository.countByIdIsNotAndIdentification(user.getId(), user.getIdentification()) > 0;
    }
}
