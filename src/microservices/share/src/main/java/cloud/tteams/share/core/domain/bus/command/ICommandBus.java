package cloud.tteams.share.core.domain.bus.command;

public interface ICommandBus {
    void dispatch(ICommand command) throws CommandHandlerExecutionError;
}
