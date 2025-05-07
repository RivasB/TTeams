package cloud.tteams.comment.comment.application.command.update;

import cloud.tteams.comment.comment.domain.Comment;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public class UpdateCommentRequest {

    @NotBlank @NotNull
    private final UUID id;

    @NotBlank @NotNull
    private final String author;

    @NotNull
    private final UUID task;

    @NotBlank @NotNull
    private final String body;

    public UpdateCommentRequest(UUID id, String author, UUID task, String body) {
        this.id = id;
        this.author = author;
        this.task = task;
        this.body = body;
    }

    public UUID getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public UUID getTask() {
        return task;
    }

    public String getBody() {
        return body;
    }
}
