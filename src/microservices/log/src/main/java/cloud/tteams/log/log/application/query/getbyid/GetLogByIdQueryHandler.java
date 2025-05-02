package cloud.tteams.log.log.application.query.getbyid;

import cloud.tteams.log.log.application.query.LogResponse;
import cloud.tteams.log.log.domain.Log;
import cloud.tteams.log.log.domain.service.ILogDomainService;
import cloud.tteams.log.log.domain.valueobject.LogId;
import cloud.tteams.share.core.domain.bus.query.IQueryHandler;
import org.springframework.stereotype.Component;

@Component
public class GetLogByIdQueryHandler implements IQueryHandler<GetLogByIdQuery, LogResponse> {

    private final ILogDomainService logDomainService;

    public GetLogByIdQueryHandler(ILogDomainService logDomainService) {
        this.logDomainService = logDomainService;
    }

    @Override
    public LogResponse handle(GetLogByIdQuery query) {
        LogId id = new LogId(query.getId());
        Log log = logDomainService.getById(id);
        return new LogResponse(log);
    }
}
