package cloud.tteams.comment.comment.application.command.delete;

import cloud.tteams.comment.comment.domain.service.ICommentDomainService;
import cloud.tteams.share.core.domain.bus.command.ICommandHandler;
import org.springframework.stereotype.Component;

@Component
public class DeleteCommentCommandHandler implements ICommandHandler<DeleteCommentCommand> {

    private final ICommentDomainService service;

    public DeleteCommentCommandHandler(ICommentDomainService service) {
        this.service = service;
    }

    @Override
    public void handle(DeleteCommentCommand command) {
        service.delete(command.getId());
    }
}
