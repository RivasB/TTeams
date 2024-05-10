package cloud.tteams.share.comment.infrastructure.exception;

public class CommentNotFoundException extends RuntimeException {

    public CommentNotFoundException() {
        super("Requested comment not found!");
    }

}
