package cloud.tteams.project.project.domain.valueobject;

import cloud.tteams.share.core.domain.valueobject.DateValueObject;

import java.time.LocalDate;

public class ProjectEstimatedEndDate extends DateValueObject {

    public ProjectEstimatedEndDate(LocalDate value) {
        super(value);
    }

}
