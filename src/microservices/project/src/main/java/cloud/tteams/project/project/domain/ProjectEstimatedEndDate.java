package cloud.tteams.project.project.domain;

import cloud.tteams.share.core.domain.DateValueObject;

import java.time.LocalDate;

public class ProjectEstimatedEndDate extends DateValueObject {

    public ProjectEstimatedEndDate(LocalDate value) {
        super(value);
    }

}
