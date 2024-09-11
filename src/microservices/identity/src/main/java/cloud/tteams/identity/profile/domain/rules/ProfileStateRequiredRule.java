package cloud.tteams.identity.profile.domain.rules;

import cloud.tteams.share.core.domain.State;
import cloud.tteams.share.core.domain.rules.BusinessRule;

import java.util.Objects;

public class ProfileStateRequiredRule extends BusinessRule {

    private final State state;

    public ProfileStateRequiredRule(State state) {
        super("Profile state is required!");
        this.state = state;
    }

    @Override
    public boolean isBroken() {
        return Objects.isNull(state);
    }
}
