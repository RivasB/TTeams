package cloud.tteams.share.core.domain.bus.query;

import cloud.tteams.share.core.infrastructure.exceptions.UnauthorizedException;

public interface IQueryHandler<Q extends IQuery, R extends IResponse> {
    R handle(Q query) throws UnauthorizedException;
}
