package ec.gob.registrocivil.share.core.infrastructure.bus;

import ec.gob.registrocivil.share.core.domain.bus.command.ICommand;
import ec.gob.registrocivil.share.core.domain.bus.command.ICommandMessage;
import ec.gob.registrocivil.share.core.domain.bus.query.IQuery;
import ec.gob.registrocivil.share.core.domain.bus.query.IResponse;

public interface IMediator {
    <M extends ICommandMessage> M send(ICommand command);

    <R extends IResponse> R send(IQuery query);
}
