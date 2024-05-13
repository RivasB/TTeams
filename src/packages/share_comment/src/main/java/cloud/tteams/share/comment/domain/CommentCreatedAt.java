package cloud.tteams.share.comment.domain;

import cloud.tteams.share.core.domain.valueobject.DateValueObject;

import java.time.LocalDate;

public class CommentCreatedAt extends DateValueObject {

    public CommentCreatedAt(LocalDate value) {
        super(value);
    }

}
