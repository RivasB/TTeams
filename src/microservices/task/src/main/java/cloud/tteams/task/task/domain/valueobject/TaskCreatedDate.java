package cloud.tteams.task.task.domain.valueobject;

import cloud.tteams.share.core.domain.valueobject.DateValueObject;

import java.time.LocalDate;

public class TaskCreatedDate extends DateValueObject {
    public TaskCreatedDate(LocalDate value) {
        super(value);
    }
}
