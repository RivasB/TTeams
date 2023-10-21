package cloud.tteams.comment.comment.domain;

import cloud.tteams.share.core.domain.DateValueObject;

import java.time.LocalDate;

public class CommentCreatedAt extends DateValueObject {

    public CommentCreatedAt(LocalDate value) {
        super(value);
    }

}
