package cloud.tteams.log.log.application.query.getall;

import cloud.tteams.log.log.application.query.LogResponse;
import cloud.tteams.log.log.domain.Log;
import cloud.tteams.log.log.domain.service.ILogDomainService;
import cloud.tteams.share.core.application.query.MessagePaginatedResponse;
import cloud.tteams.share.core.domain.bus.query.IQueryHandler;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetAllLogQueryHandler implements IQueryHandler<GetAllLogQuery, MessagePaginatedResponse> {

    private final ILogDomainService logDomainService;

    public GetAllLogQueryHandler(ILogDomainService logDomainService) {
        this.logDomainService = logDomainService;
    }

    @Override
    public MessagePaginatedResponse handle(GetAllLogQuery query) {
        Page<Log> logPage = logDomainService.getAll(query.pageable(), query.filters());
        List<LogResponse> responseList = logPage.getContent()
                .stream()
                .map(LogResponse::new).toList();
        return new MessagePaginatedResponse(responseList, logPage);
    }
}
