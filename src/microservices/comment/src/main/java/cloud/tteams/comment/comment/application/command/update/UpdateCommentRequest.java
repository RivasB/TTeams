package cloud.tteams.comment.comment.application.command.update;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public class UpdateCommentRequest {

    @NotBlank @NotNull
    private final UUID id;

    @NotBlank @NotNull
    private final String body;

    public UpdateCommentRequest(UUID id, String body) {
        this.id = id;
        this.body = body;
    }

    public UUID getId() {
        return id;
    }

    public String getBody() {
        return body;
    }
}
