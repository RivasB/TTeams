package cloud.tteams.project.project.application.command.delete;

import cloud.tteams.share.core.domain.bus.command.ICommand;
import cloud.tteams.share.core.domain.bus.command.ICommandMessage;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class DeleteProjectCommand implements ICommand {

    private final UUID uuid;

    @Override
    public ICommandMessage getMessage() {
        return null;
    }
}
