package cloud.tteams.comment.comment.application.command.create;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateCommentRequest{

    @NotBlank @NotNull
    private final String author;

    @NotBlank @NotNull
    private final String body;

    public CreateCommentRequest(String author, String body) {
        this.author = author;
        this.body = body;
    }

    public String getAuthor() {
        return author;
    }

    public String getBody() {
        return body;
    }
}
