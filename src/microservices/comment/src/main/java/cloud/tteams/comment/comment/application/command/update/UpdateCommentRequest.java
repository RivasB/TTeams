package cloud.tteams.comment.comment.application.command.update;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public class UpdateCommentRequest {

    @NotBlank @NotNull
    private final UUID id;

    @NotBlank @NotNull
    private final String author;

    @NotBlank @NotNull
    private final String body;

    public UpdateCommentRequest(UUID id, String author, String body) {
        this.id = id;
        this.author = author;
        this.body = body;
    }

    public UUID getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getBody() {
        return body;
    }
}
