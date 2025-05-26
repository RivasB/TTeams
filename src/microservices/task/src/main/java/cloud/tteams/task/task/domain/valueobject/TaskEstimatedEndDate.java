package cloud.tteams.task.task.domain.valueobject;

import cloud.tteams.share.core.domain.valueobject.DateValueObject;

import java.time.LocalDate;

public class TaskEstimatedEndDate extends DateValueObject {

    public TaskEstimatedEndDate(LocalDate value) {
        super(value);
    }

}
