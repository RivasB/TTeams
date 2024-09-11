package cloud.tteams.identity.profile.domain.rules;

import cloud.tteams.identity.organization.domain.Organization;

import java.util.Objects;

import cloud.tteams.share.core.domain.rules.BusinessRule;

public class ProfileOrganizationRequiredRule extends BusinessRule {

    private final Organization organization;

    public ProfileOrganizationRequiredRule(Organization organization) {
        super("Profile organization is required!");
        this.organization = organization;
    }

    @Override
    public boolean isBroken() {
        return Objects.isNull(organization);
    }
}
