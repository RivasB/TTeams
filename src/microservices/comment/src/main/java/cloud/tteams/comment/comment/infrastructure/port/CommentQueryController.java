package cloud.tteams.comment.comment.infrastructure.port;


import cloud.tteams.comment.comment.application.CommentResponse;
import cloud.tteams.comment.comment.application.query.getall.GetAllCommentQuery;
import cloud.tteams.comment.comment.application.query.getbyid.GetByIdCommentQuery;
import cloud.tteams.share.core.application.ApiResponse2xx;
import cloud.tteams.share.core.application.query.MessagePaginatedResponse;
import cloud.tteams.share.core.infrastructure.bus.IMediator;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/comment")
@SecurityRequirement(name = "Bearer Authentication")
@Tag(name = "Query-Comment", description = " Query Comment API. Contains the query operations that can " +
        "be performed on a Comment.")
public class CommentQueryController {

    private final IMediator mediator;

    public CommentQueryController(IMediator mediator) {
        this.mediator = mediator;
    }

    @GetMapping
    public ResponseEntity<MessagePaginatedResponse> getAllCommentPaginated(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "20") Integer pageSize,
            @RequestParam(defaultValue = "name") String sortBy,
            @RequestParam(defaultValue = "asc") String sortType,
            @RequestParam(defaultValue = "") String task
            ) {
        Sort sort = (sortType.equals("asc")) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        GetAllCommentQuery query = new GetAllCommentQuery(task, pageable);
        MessagePaginatedResponse pageResponse = mediator.send(query);
        return ResponseEntity.ok(pageResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse2xx<CommentResponse>> getCommentById(@PathVariable UUID id) {
        GetByIdCommentQuery query = new GetByIdCommentQuery(id);
        CommentResponse commentResponse = mediator.send(query);
        return ResponseEntity.ok(new ApiResponse2xx<>(commentResponse, HttpStatus.OK));
    }

}
