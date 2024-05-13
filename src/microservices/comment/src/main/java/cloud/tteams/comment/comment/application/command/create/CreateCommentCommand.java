package cloud.tteams.comment.comment.application.command.create;

import cloud.tteams.comment.comment.domain.Comment;
import cloud.tteams.share.core.application.command.CommandMessage;
import cloud.tteams.share.core.domain.bus.command.ICommand;
import cloud.tteams.share.core.domain.bus.command.ICommandMessage;
import cloud.tteams.share.core.domain.event.EventType;

import java.util.UUID;

public class CreateCommentCommand implements ICommand {

    private final UUID id;

    private final String author;

    private final String body;

    public CreateCommentCommand(UUID id, String author, String body) {
        this.id = UUID.randomUUID();
        this.author = author;
        this.body = body;
    }

    public CreateCommentCommand(CreateCommentRequest request) {
        this.id = UUID.randomUUID();
        this.author = request.getAuthor();
        this.body = request.getBody();
    }

    public Comment toAggregate(){
        return new Comment(this.id, this.author, this.body);
    }

    @Override
    public ICommandMessage getMessage() {
        return new CommandMessage(this.id, EventType.CREATED.toString());
    }
}
