package cloud.tteams.task.task.domain.valueobject;

import cloud.tteams.share.core.domain.valueobject.DateValueObject;

import java.time.LocalDate;

public class TaskStartDate extends DateValueObject {

    public TaskStartDate(LocalDate value) {
        super(value);
    }

}
