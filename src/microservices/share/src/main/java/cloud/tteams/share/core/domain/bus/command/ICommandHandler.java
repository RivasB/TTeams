package cloud.tteams.share.core.domain.bus.command;

public interface ICommandHandler<T extends ICommand> {
    void handle(T command);
}
