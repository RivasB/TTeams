package cloud.tteams.identity.user.domain.rules;

import cloud.tteams.identity.user.infrastructure.adapter.query.user.PostgresDBUserQueryRepository;
import cloud.tteams.share.core.domain.rules.BusinessRule;
import cloud.tteams.identity.user.domain.User;

public class UserEmailMustBeUniqueRule extends BusinessRule {

    private final PostgresDBUserQueryRepository postgresDBUserQueryRepository;

    private final User user;

    public UserEmailMustBeUniqueRule(PostgresDBUserQueryRepository postgresDBUserQueryRepository, User user) {
        super("User mail must be unique!");
        this.postgresDBUserQueryRepository = postgresDBUserQueryRepository;
        this.user = user;
    }

    @Override
    public boolean isBroken() {
        return postgresDBUserQueryRepository.existByEmailAndIdNot(user.getId(), user.getEmail());
    }
}
