package cloud.tteams.project.project.domain.valueobject;

import cloud.tteams.share.core.domain.valueobject.DateValueObject;

import java.time.LocalDate;

public class ProjectStartDate extends DateValueObject {

    public ProjectStartDate(LocalDate value) {
        super(value);
    }

}
