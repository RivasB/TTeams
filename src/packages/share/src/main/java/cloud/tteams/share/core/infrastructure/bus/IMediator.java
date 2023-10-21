package cloud.tteams.share.core.infrastructure.bus;

import cloud.tteams.share.core.domain.bus.command.ICommand;
import cloud.tteams.share.core.domain.bus.command.ICommandMessage;
import cloud.tteams.share.core.domain.bus.query.IQuery;
import cloud.tteams.share.core.domain.bus.query.IResponse;

public interface IMediator {
    <M extends ICommandMessage> M send(ICommand command);

    <R extends IResponse> R send(IQuery query);
}
