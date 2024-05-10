package cloud.tteams.comment.comment.domain.rules;

import cloud.tteams.share.core.domain.rules.BusinessRule;

public class AuthorValidation extends BusinessRule {

    private final String author;

    private final String updatingAuthor;
    public AuthorValidation(String author, String updatingAuthor) {
        super("The comment can not be modifying by other than his owner");
        this.author = author;
        this.updatingAuthor = updatingAuthor;
    }

    @Override
    public boolean isBroken() {
        return !author.equals(updatingAuthor);
    }
}
