package cloud.tteams.identity.profile.application.command.delete;

import java.util.Objects;
import java.util.UUID;

import cloud.tteams.share.core.domain.bus.command.ICommand;
import cloud.tteams.share.core.domain.bus.command.ICommandMessage;

public final class DeleteProfileCommand implements ICommand {
    private final UUID id;

    public DeleteProfileCommand(UUID id) {
        this.id = id;
    }

    public static DeleteProfileCommand fromRequest(DeleteProfileRequest request) {

        return new DeleteProfileCommand(request.id());
    }

    @Override
    public ICommandMessage getMessage() {
        return new DeleteProfileMessage(id);
    }

    public UUID id() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (DeleteProfileCommand) obj;
        return Objects.equals(this.id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "DeleteProfileCommand[" +
                "id=" + id + ']';
    }


}
