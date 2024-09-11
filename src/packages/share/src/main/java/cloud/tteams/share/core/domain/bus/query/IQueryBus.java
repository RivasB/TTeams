package cloud.tteams.share.core.domain.bus.query;

import cloud.tteams.share.core.infrastructure.exceptions.UnauthorizedException;

public interface IQueryBus {
    <R> R ask(IQuery query) throws QueryHandlerExecutionError, UnauthorizedException;
}
