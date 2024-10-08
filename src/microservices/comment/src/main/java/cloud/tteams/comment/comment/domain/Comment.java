package cloud.tteams.comment.comment.domain;


import cloud.tteams.comment.comment.domain.rules.AuthorValidation;
import cloud.tteams.comment.comment.domain.rules.BodyMinAndMaxExtension;
import cloud.tteams.share.core.domain.AggregateRoot;
import cloud.tteams.share.core.domain.rules.RulesChecker;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

public class Comment extends AggregateRoot<Comment> {
    private final UUID id;

    private final String author;

    private String body;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public Comment(UUID id, String author, String body, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.author = author;
        this.body = body;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Comment(UUID id, String author, String body) {
        this.id = id;
        this.author = author;
        this.body = body;
    }

    @Override
    public void update(Comment comment){
        Optional.ofNullable(comment.getAuthor()).ifPresent(valor ->
                RulesChecker.checkRule(new AuthorValidation(this.author, valor)));
        Optional.ofNullable(comment.getBody()).ifPresent(valor ->
        {
            RulesChecker.checkRule(new BodyMinAndMaxExtension(valor));
            this.body = valor;
        });
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
