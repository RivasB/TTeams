package ec.gob.registrocivil.share.core.infrastructure.bus;

import ec.gob.registrocivil.share.core.domain.bus.command.ICommand;
import ec.gob.registrocivil.share.core.domain.bus.command.ICommandMessage;
import ec.gob.registrocivil.share.core.domain.bus.query.IQuery;
import ec.gob.registrocivil.share.core.domain.bus.query.IResponse;
import ec.gob.registrocivil.share.core.infrastructure.bus.command.InMemoryCommandBus;
import ec.gob.registrocivil.share.core.infrastructure.bus.query.InMemoryQueryBus;
import org.springframework.stereotype.Component;

@Component
public class MediatorImpl implements IMediator {

    private final InMemoryCommandBus commandBus;

    private final InMemoryQueryBus queryBus;

    public MediatorImpl(InMemoryCommandBus commandBus, InMemoryQueryBus queryBus) {
        this.commandBus = commandBus;
        this.queryBus = queryBus;
    }

    @Override
    public <M extends ICommandMessage> M send(ICommand command) {
        commandBus.dispatch(command);
        return (M) command.getMessage();
    }

    @Override
    public <R extends IResponse> R send(IQuery query) {
        return (R) queryBus.ask(query);
    }

}
