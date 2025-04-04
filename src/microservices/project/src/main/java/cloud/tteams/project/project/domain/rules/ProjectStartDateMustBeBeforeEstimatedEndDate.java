package cloud.tteams.project.project.domain.rules;

import cloud.tteams.project.project.domain.valueobject.ProjectEstimatedEndDate;
import cloud.tteams.project.project.domain.valueobject.ProjectStartDate;
import cloud.tteams.share.core.domain.rules.BusinessRule;

public class ProjectStartDateMustBeBeforeEstimatedEndDate extends BusinessRule {

    private final ProjectStartDate startDate;
    private final ProjectEstimatedEndDate endDate;

    public ProjectStartDateMustBeBeforeEstimatedEndDate(ProjectStartDate startDate, ProjectEstimatedEndDate endDate) {
        super("Start Date must be before Estimated End Date!");
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public boolean isBroken() {
        return !startDate.getValue().isBefore(endDate.getValue());
    }
}
