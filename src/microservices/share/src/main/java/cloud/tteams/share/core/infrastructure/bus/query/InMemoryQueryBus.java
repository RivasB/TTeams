package cloud.tteams.share.core.infrastructure.bus.query;

import cloud.tteams.share.core.domain.bus.query.IQuery;
import cloud.tteams.share.core.domain.bus.query.IQueryBus;
import cloud.tteams.share.core.domain.bus.query.IQueryHandler;
import cloud.tteams.share.core.domain.bus.query.IResponse;
import cloud.tteams.share.core.domain.bus.query.QueryHandlerExecutionError;
import cloud.tteams.share.core.domain.bus.query.QueryNotRegisteredError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@SuppressWarnings("all")
@Service
public final class InMemoryQueryBus implements IQueryBus {

    private static final Logger logger = LoggerFactory.getLogger(InMemoryQueryBus.class);

    private final QueryHandlersInformation information;

    private final ApplicationContext context;

    public InMemoryQueryBus(QueryHandlersInformation information, ApplicationContext context) {
        this.information = information;
        this.context = context;
    }

    @Override
    public IResponse ask(IQuery query) throws QueryHandlerExecutionError {
        try {
            Class<? extends IQueryHandler> queryHandlerClass = information.search(query.getClass());
            IQueryHandler handler = context.getBean(queryHandlerClass);
            return handler.handle(query);
        } catch (QueryNotRegisteredError ex) {
            throw new QueryHandlerExecutionError(ex);
        } catch (Exception exception) {
            logger.info("Error executing query: ", exception);
            throw exception;
        }
    }
}
