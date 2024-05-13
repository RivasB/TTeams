package cloud.tteams.comment.comment.infrastructure.port;

import cloud.tteams.comment.comment.application.command.create.CreateCommentCommand;
import cloud.tteams.comment.comment.application.command.create.CreateCommentRequest;
import cloud.tteams.comment.comment.application.command.delete.DeleteCommentCommand;
import cloud.tteams.comment.comment.application.command.update.UpdateCommentCommand;
import cloud.tteams.comment.comment.application.command.update.UpdateCommentRequest;
import cloud.tteams.share.core.application.ApiResponse2xx;
import cloud.tteams.share.core.application.command.CommandMessage;
import cloud.tteams.share.core.infrastructure.bus.IMediator;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/comment")
@SecurityRequirement(name = "Bearer Authentication")
@Tag(name = "Command-Comment", description = " Command Comment API. Contains the command operations " +
        "that can be performed on a Comment.")
public class CommentCommandController {

    private final IMediator mediator;

    public CommentCommandController(IMediator mediator) {
        this.mediator = mediator;
    }

    @PostMapping
    public ResponseEntity<ApiResponse2xx> create(@RequestBody CreateCommentRequest request) {
        CreateCommentCommand command = new CreateCommentCommand(request);
        CommandMessage response = mediator.send(command);
        return ResponseEntity.ok(new ApiResponse2xx(response, HttpStatus.CREATED));
    }

    @PutMapping
    public  ResponseEntity<ApiResponse2xx> update(@RequestBody UpdateCommentRequest request){
        UpdateCommentCommand command = new UpdateCommentCommand(request);
        CommandMessage response = mediator.send(command);
        return ResponseEntity.ok(new ApiResponse2xx(response, HttpStatus.OK));
    }

    @DeleteMapping("{id}")
    public  ResponseEntity<ApiResponse2xx> delete(@PathVariable UUID id){
        DeleteCommentCommand command = new DeleteCommentCommand(id);
        CommandMessage response = mediator.send(command);
        return  ResponseEntity.ok(new ApiResponse2xx(response, HttpStatus.NO_CONTENT));
    }

}
