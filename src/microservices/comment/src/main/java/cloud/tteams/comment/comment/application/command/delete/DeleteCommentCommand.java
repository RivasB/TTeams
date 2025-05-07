package cloud.tteams.comment.comment.application.command.delete;

import cloud.tteams.share.core.application.command.CommandMessage;
import cloud.tteams.share.core.domain.bus.command.ICommand;
import cloud.tteams.share.core.domain.bus.command.ICommandMessage;
import cloud.tteams.share.core.domain.event.EventType;

import java.util.UUID;

public class DeleteCommentCommand implements ICommand {

    private final UUID id;

    public DeleteCommentCommand(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    @Override
    public ICommandMessage getMessage() {
        return new CommandMessage(this.id, EventType.DELETED.toString());
    }
}
