package cloud.tteams.comment.comment.application.command.update;

import cloud.tteams.comment.comment.domain.Comment;
import cloud.tteams.share.core.application.command.CommandMessage;
import cloud.tteams.share.core.domain.bus.command.ICommand;
import cloud.tteams.share.core.domain.bus.command.ICommandMessage;
import cloud.tteams.share.core.domain.event.EventType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public class UpdateCommentCommand implements ICommand {

    private final UUID id;

    private final String author;

    private final UUID task;

    private final String body;

    public UpdateCommentCommand(UpdateCommentRequest request) {
        this.id = request.getId();
        this.author = request.getAuthor();
        this.task = request.getTask();
        this.body = request.getBody();
    }

    public Comment toAggregate(){
        return new Comment(this.id, this.author, this.task, this.body);
    }

    public UUID getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public UUID getTask() {
        return task;
    }

    public String getBody() {
        return body;
    }

    @Override
    public ICommandMessage getMessage() {
        return new CommandMessage(this.id, EventType.UPDATED.toString());
    }
}
