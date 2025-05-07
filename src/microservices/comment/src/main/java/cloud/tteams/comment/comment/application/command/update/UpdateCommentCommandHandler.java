package cloud.tteams.comment.comment.application.command.update;

import cloud.tteams.comment.comment.domain.Comment;
import cloud.tteams.comment.comment.domain.service.ICommentDomainService;
import cloud.tteams.share.core.domain.bus.command.ICommandHandler;
import org.springframework.stereotype.Component;

@Component
public class UpdateCommentCommandHandler implements ICommandHandler<UpdateCommentCommand> {

    private final ICommentDomainService service;

    public UpdateCommentCommandHandler(ICommentDomainService service) {
        this.service = service;
    }

    @Override
    public void handle(UpdateCommentCommand command) {
        Comment updated = command.toAggregate();
        service.update(updated);
    }
}
