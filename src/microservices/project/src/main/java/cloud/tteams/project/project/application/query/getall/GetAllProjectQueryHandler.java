package cloud.tteams.project.project.application.query.getall;

import cloud.tteams.share.core.application.query.MessagePaginatedResponse;
import cloud.tteams.share.core.domain.bus.query.IQueryHandler;
import org.springframework.stereotype.Component;

@Component
public class GetAllProjectQueryHandler implements IQueryHandler<GetAllProjectQuery, MessagePaginatedResponse> {
    @Override
    public MessagePaginatedResponse handle(GetAllProjectQuery query) {
        return null;
    }
}
