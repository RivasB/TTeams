package cloud.tteams.task.task.domain.valueobject;

import cloud.tteams.share.core.domain.valueobject.DateValueObject;

import java.time.LocalDate;

public class TaskCompletionDate extends DateValueObject {
    public TaskCompletionDate(LocalDate value) {
        super(value);
    }
}
