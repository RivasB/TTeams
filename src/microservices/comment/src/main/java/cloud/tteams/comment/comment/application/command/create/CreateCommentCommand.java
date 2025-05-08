package cloud.tteams.comment.comment.application.command.create;

import cloud.tteams.comment.comment.domain.Comment;
import cloud.tteams.share.core.application.command.CommandMessage;
import cloud.tteams.share.core.domain.bus.command.ICommand;
import cloud.tteams.share.core.domain.bus.command.ICommandMessage;
import cloud.tteams.share.core.domain.event.EventType;

import java.util.UUID;

public class CreateCommentCommand implements ICommand {

    private final UUID id;

    private final UUID task;

    private final String body;

    public CreateCommentCommand(CreateCommentRequest request) {
        this.id = UUID.randomUUID();
        this.task = request.getTask();
        this.body = request.getBody();
    }

    public Comment toAggregate(){
        return new Comment(this.id, null, this.task, this.body);
    }

    @Override
    public ICommandMessage getMessage() {
        return new CommandMessage(this.id, EventType.CREATED.toString());
    }
}
