package cloud.tteams.share.core.infrastructure.bus.command;

import cloud.tteams.share.core.domain.bus.command.CommandHandlerExecutionError;
import cloud.tteams.share.core.domain.bus.command.CommandNotRegisteredError;
import cloud.tteams.share.core.domain.bus.command.ICommand;
import cloud.tteams.share.core.domain.bus.command.ICommandBus;
import cloud.tteams.share.core.domain.bus.command.ICommandHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@SuppressWarnings("all")
@Component
public class InMemoryCommandBus implements ICommandBus {

    private final Logger logger = LoggerFactory.getLogger(InMemoryCommandBus.class);

    private final CommandHandlersInformation information;

    private final ApplicationContext context;

    public InMemoryCommandBus(CommandHandlersInformation information, ApplicationContext context) {
        this.information = information;
        this.context = context;
    }

    @Override
    public void dispatch(ICommand command) throws CommandHandlerExecutionError {
        try {
            Class<? extends ICommandHandler> commandHandlerClass = information.search(command.getClass());

            ICommandHandler handler = context.getBean(commandHandlerClass);

            handler.handle(command);
        } catch (CommandNotRegisteredError ex) {
            throw new CommandHandlerExecutionError(ex);
        } catch (Exception exception) {
            logger.info("Error executing command: ", exception);
            throw exception;
        }
    }
}
