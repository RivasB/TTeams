package ec.gob.registrocivil.identity.telephone_operator.infrastructure.port;

import java.util.UUID;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ec.gob.registrocivil.share.core.application.ApiResponse2xx;
import ec.gob.registrocivil.share.core.domain.MessagePaginatedResponse;
import ec.gob.registrocivil.share.core.infrastructure.bus.IMediator;
import ec.gob.registrocivil.identity.telephone_operator.application.command.create.CreateTelephoneOperatorCommand;
import ec.gob.registrocivil.identity.telephone_operator.application.command.create.CreateTelephoneOperatorMessage;
import ec.gob.registrocivil.identity.telephone_operator.application.command.create.CreateTelephoneOperatorRequest;
import ec.gob.registrocivil.identity.telephone_operator.application.command.delete.DeleteTelephoneOperatorCommand;
import ec.gob.registrocivil.identity.telephone_operator.application.command.delete.DeleteTelephoneOperatorMessage;
import ec.gob.registrocivil.identity.telephone_operator.application.command.update.UpdateTelephoneOperatorCommand;
import ec.gob.registrocivil.identity.telephone_operator.application.command.update.UpdateTelephoneOperatorMessage;
import ec.gob.registrocivil.identity.telephone_operator.application.command.update.UpdateTelephoneOperatorRequest;
import ec.gob.registrocivil.identity.telephone_operator.application.query.getall.FindTelephoneOperatorWithFilterQuery;
import ec.gob.registrocivil.identity.telephone_operator.application.query.getbyid.FindTelephoneOperatorByIdQuery;
import ec.gob.registrocivil.identity.telephone_operator.application.query.getbyid.FindTelephoneOperatorByIdResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotBlank;

@RestController
@RequestMapping("/api/operator")
@SecurityRequirement(name = "Bearer Authentication")
@Tag(name = "Telephone Operator", description = "The Telephone Operator API. Contains all the operations that can be performed on a Telephone Operator.")
public class TelephoneOperatorController {

    private final IMediator mediator;

    public TelephoneOperatorController(IMediator mediator) {
        this.mediator = mediator;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse2xx<CreateTelephoneOperatorMessage>> createTelephoneOperator(
            @RequestBody CreateTelephoneOperatorRequest request) {

        CreateTelephoneOperatorCommand createCommand = CreateTelephoneOperatorCommand.fromRequest(request);
        CreateTelephoneOperatorMessage response = mediator.send(createCommand);

        return ResponseEntity.ok(new ApiResponse2xx<CreateTelephoneOperatorMessage>(response, HttpStatus.CREATED));
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse2xx<UpdateTelephoneOperatorMessage>> updateTelephoneOperator(
            @RequestBody UpdateTelephoneOperatorRequest request) {

        UpdateTelephoneOperatorCommand updateCommand = UpdateTelephoneOperatorCommand.fromRequest(request);
        UpdateTelephoneOperatorMessage response = mediator.send(updateCommand);

        return ResponseEntity.ok(new ApiResponse2xx<UpdateTelephoneOperatorMessage>(response, HttpStatus.OK));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse2xx<DeleteTelephoneOperatorMessage>> deleteTelephoneOperator(
            @NotBlank @PathVariable("id") UUID id) {

        DeleteTelephoneOperatorCommand deleteCommand = new DeleteTelephoneOperatorCommand(id);
        DeleteTelephoneOperatorMessage response = mediator.send(deleteCommand);

        return ResponseEntity.ok(new ApiResponse2xx<DeleteTelephoneOperatorMessage>(response, HttpStatus.OK));
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse2xx<FindTelephoneOperatorByIdResponse>> retrieveAccess(
            @NotBlank @PathVariable UUID id) {

        FindTelephoneOperatorByIdQuery query = new FindTelephoneOperatorByIdQuery(id);
        FindTelephoneOperatorByIdResponse response = mediator.send(query);

        return ResponseEntity.ok(new ApiResponse2xx<FindTelephoneOperatorByIdResponse>(response, HttpStatus.OK));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MessagePaginatedResponse> getAllAccess(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "20") Integer pageSize,
            @RequestParam(defaultValue = "") String filter,
            @RequestParam(defaultValue = "name") String sortBy,
            @RequestParam(defaultValue = "asc") String sortType) {

        Sort sort = (sortType.equals("asc")) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

        FindTelephoneOperatorWithFilterQuery query = new FindTelephoneOperatorWithFilterQuery(pageable, filter);
        MessagePaginatedResponse pageResponse = mediator.send(query);

        return ResponseEntity.ok(pageResponse);
    }

}
