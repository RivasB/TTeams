package cloud.tteams.comment.comment.application.command.create;

import cloud.tteams.comment.comment.domain.Comment;
import cloud.tteams.comment.comment.domain.service.ICommentDomainService;
import cloud.tteams.share.core.domain.bus.command.ICommandHandler;
import org.springframework.stereotype.Component;

@Component
public class CreateCommentCommandHandler implements ICommandHandler<CreateCommentCommand> {

    private final ICommentDomainService service;

    public CreateCommentCommandHandler(ICommentDomainService service) {
        this.service = service;
    }
    @Override
    public void handle(CreateCommentCommand command) {
        Comment toPersist = command.toAggregate();
        service.create(toPersist);
    }
}
