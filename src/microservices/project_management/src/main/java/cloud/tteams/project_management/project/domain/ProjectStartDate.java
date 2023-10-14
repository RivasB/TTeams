package cloud.tteams.project_management.project.domain;

import cloud.tteams.share.core.domain.DateValueObject;

import java.time.LocalDate;

public class ProjectStartDate extends DateValueObject {

    public ProjectStartDate(LocalDate value) {
        super(value);
    }

}
