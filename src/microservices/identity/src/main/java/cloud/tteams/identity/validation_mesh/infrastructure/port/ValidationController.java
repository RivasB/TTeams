package cloud.tteams.identity.validation_mesh.infrastructure.port;

import java.util.UUID;

import cloud.tteams.identity.validation_mesh.infrastructure.service.DomainValidationService;
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

import cloud.tteams.share.core.application.ApiResponse2xx;
import cloud.tteams.identity.validation_mesh.application.command.create.CreateValidationByServiceActCommandHandler;
import cloud.tteams.identity.validation_mesh.application.command.create.CreateValidationByServiceCertificateCommandHandler;
import cloud.tteams.identity.validation_mesh.application.command.create.CreateValidationCommand;
import cloud.tteams.identity.validation_mesh.application.command.create.CreateValidationCommandHandler;
import cloud.tteams.identity.validation_mesh.application.command.create.CreateValidationMessage;
import cloud.tteams.identity.validation_mesh.application.command.create.CreateValidationRequest;
import cloud.tteams.identity.validation_mesh.application.command.delete.DeleteValidationResponse;
import cloud.tteams.identity.validation_mesh.application.command.update.UpdateValidationByServiceActCommandHandler;
import cloud.tteams.identity.validation_mesh.application.command.update.UpdateValidationByServiceCertificateCommandHandler;
import cloud.tteams.identity.validation_mesh.application.command.update.UpdateValidationCommand;
import cloud.tteams.identity.validation_mesh.application.command.update.UpdateValidationCommandHandler;
import cloud.tteams.identity.validation_mesh.application.command.update.UpdateValidationMessage;
import cloud.tteams.identity.validation_mesh.application.command.update.UpdateValidationRequest;
import cloud.tteams.identity.validation_mesh.application.query.find.FindValidationByServiceActQueryHandler;
import cloud.tteams.identity.validation_mesh.application.query.find.FindValidationByServiceCertificateQueryHandler;
import cloud.tteams.identity.validation_mesh.application.query.find.FindValidationQuery;
import cloud.tteams.identity.validation_mesh.application.query.find.FindValidationQueryHandler;
import cloud.tteams.identity.validation_mesh.application.query.find.FindValidationResponse;
import cloud.tteams.identity.validation_mesh.domain.ValidationId;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotBlank;

@RestController
@RequestMapping("/api/validation")
@SecurityRequirement(name = "Bearer Authentication")
@Tag(name = "Validation Mesh", description = "The Validation Mesh API. Contains all the operations that can be performed on the validation mesh.")
public class ValidationController {

    private final DomainValidationService validationService;

    private final CreateValidationCommandHandler createValidationCommandHandler;
    private final UpdateValidationCommandHandler updateValidationCommandHandler;
    private final FindValidationQueryHandler findValidationQueryHandler;

    private final CreateValidationByServiceActCommandHandler createValidationByServiceActCommandHandler;
    private final UpdateValidationByServiceActCommandHandler updateValidationByServiceActCommandHandler;
    private final FindValidationByServiceActQueryHandler findValidationByServiceActQueryHandler;

    private final CreateValidationByServiceCertificateCommandHandler createValidationByServiceCertificateCommandHandler;
    private final UpdateValidationByServiceCertificateCommandHandler updateValidationByServiceCertificateCommandHandler;
    private final FindValidationByServiceCertificateQueryHandler findValidationByServiceCertificateQueryHandler;

    // Validation Routes

    public ValidationController(DomainValidationService validationService,
            CreateValidationCommandHandler createValidationCommandHandler,
            UpdateValidationCommandHandler updateValidationCommandHandler,
            FindValidationQueryHandler findValidationQueryHandler,
            CreateValidationByServiceActCommandHandler createValidationByServiceActCommandHandler,
            UpdateValidationByServiceActCommandHandler updateValidationByServiceActCommandHandler,
            FindValidationByServiceActQueryHandler findValidationByServiceActQueryHandler,
            CreateValidationByServiceCertificateCommandHandler createValidationByServiceCertificateCommandHandler,
            UpdateValidationByServiceCertificateCommandHandler updateValidationByServiceCertificateCommandHandler,
            FindValidationByServiceCertificateQueryHandler findValidationByServiceCertificateQueryHandler) {
        this.validationService = validationService;
        this.createValidationCommandHandler = createValidationCommandHandler;
        this.updateValidationCommandHandler = updateValidationCommandHandler;
        this.findValidationQueryHandler = findValidationQueryHandler;
        this.createValidationByServiceActCommandHandler = createValidationByServiceActCommandHandler;
        this.updateValidationByServiceActCommandHandler = updateValidationByServiceActCommandHandler;
        this.findValidationByServiceActQueryHandler = findValidationByServiceActQueryHandler;
        this.createValidationByServiceCertificateCommandHandler = createValidationByServiceCertificateCommandHandler;
        this.updateValidationByServiceCertificateCommandHandler = updateValidationByServiceCertificateCommandHandler;
        this.findValidationByServiceCertificateQueryHandler = findValidationByServiceCertificateQueryHandler;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse2xx<CreateValidationMessage>> createValidation(
            @RequestBody CreateValidationRequest request) {

        CreateValidationCommand command = new CreateValidationCommand(request);
        createValidationCommandHandler.handle(command);
        CreateValidationMessage response = new CreateValidationMessage(command.getId());

        return ResponseEntity.ok(new ApiResponse2xx<CreateValidationMessage>(response, HttpStatus.CREATED));
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse2xx<UpdateValidationMessage>> updateValidation(
            @RequestBody UpdateValidationRequest request) {

        UpdateValidationCommand command = new UpdateValidationCommand(request);
        updateValidationCommandHandler.handle(command);
        UpdateValidationMessage response = new UpdateValidationMessage(command.getId());

        return ResponseEntity.ok(new ApiResponse2xx<UpdateValidationMessage>(response, HttpStatus.OK));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse2xx<DeleteValidationResponse>> deleteValidation(@NotBlank @PathVariable UUID id) {

        validationService.deleteValidation(new ValidationId(id));
        DeleteValidationResponse response = new DeleteValidationResponse(id);

        return ResponseEntity.ok(new ApiResponse2xx<DeleteValidationResponse>(response, HttpStatus.OK));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse2xx<FindValidationResponse>> findValidationWithConditions(
            @RequestParam(required = true) String cedulaCondition) {

        FindValidationQuery query = new FindValidationQuery(cedulaCondition);
        FindValidationResponse response = null;
        // findValidationQueryHandler.handle(query);

        return ResponseEntity.ok(new ApiResponse2xx<FindValidationResponse>(response, HttpStatus.OK));
    }
}
