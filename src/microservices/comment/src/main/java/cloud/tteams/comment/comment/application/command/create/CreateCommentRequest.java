package cloud.tteams.comment.comment.application.command.create;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public class CreateCommentRequest{

    @NotNull
    private final UUID task;

    @NotBlank @NotNull
    private final String body;

    public CreateCommentRequest(UUID task, String body) {
        this.task = task;
        this.body = body;
    }

    public UUID getTask() {
        return task;
    }

    public String getBody() {
        return body;
    }
}
