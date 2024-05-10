package cloud.tteams.comment.comment.application.command.update;

import cloud.tteams.share.core.application.CommandMessage;
import cloud.tteams.share.core.domain.bus.command.ICommand;
import cloud.tteams.share.core.domain.bus.command.ICommandMessage;
import cloud.tteams.share.core.domain.event.EventType;

import java.util.UUID;

public class UpdateCommentCommand implements ICommand {

    private final UUID id;

    private final String author;

    private final String body;

    public UpdateCommentCommand(UUID id, String author, String body) {
        this.id = id;
        this.author = author;
        this.body = body;
    }

    public UpdateCommentCommand(UpdateCommentRequest request) {
        this.id = request.getId();
        this.author = request.getAuthor();
        this.body = request.getBody();
    }

    public UUID getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getBody() {
        return body;
    }

    @Override
    public ICommandMessage getMessage() {
        return new CommandMessage(this.id, EventType.UPDATED.toString());
    }
}
