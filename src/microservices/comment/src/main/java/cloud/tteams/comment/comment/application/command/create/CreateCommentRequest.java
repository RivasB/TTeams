package cloud.tteams.comment.comment.application.command.create;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public class CreateCommentRequest{

    @NotBlank @NotNull
    private final String author;

    @NotNull
    private final UUID task;

    @NotBlank @NotNull
    private final String body;

    public CreateCommentRequest(String author, UUID task, String body) {
        this.author = author;
        this.task = task;
        this.body = body;
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
