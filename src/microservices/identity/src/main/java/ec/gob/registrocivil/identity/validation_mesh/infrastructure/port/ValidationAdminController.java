package ec.gob.registrocivil.identity.validation_mesh.infrastructure.port;

import java.util.UUID;

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
import ec.gob.registrocivil.identity.validation_mesh.application.command.create.CreateValidationByServiceActCommand;
import ec.gob.registrocivil.identity.validation_mesh.application.command.create.CreateValidationByServiceActCommandHandler;
import ec.gob.registrocivil.identity.validation_mesh.application.command.create.CreateValidationByServiceActRequest;
import ec.gob.registrocivil.identity.validation_mesh.application.command.create.CreateValidationByServiceCertificateCommand;
import ec.gob.registrocivil.identity.validation_mesh.application.command.create.CreateValidationByServiceCertificateCommandHandler;
import ec.gob.registrocivil.identity.validation_mesh.application.command.create.CreateValidationByServiceCertificateRequest;
import ec.gob.registrocivil.identity.validation_mesh.application.command.create.CreateValidationByServiceResponse;
import ec.gob.registrocivil.identity.validation_mesh.application.command.create.CreateValidationCommand;
import ec.gob.registrocivil.identity.validation_mesh.application.command.create.CreateValidationCommandHandler;
import ec.gob.registrocivil.identity.validation_mesh.application.command.create.CreateValidationMessage;
import ec.gob.registrocivil.identity.validation_mesh.application.command.create.CreateValidationRequest;
import ec.gob.registrocivil.identity.validation_mesh.application.command.delete.DeleteValidationResponse;
import ec.gob.registrocivil.identity.validation_mesh.application.command.update.UpdateValidationByServiceActCommand;
import ec.gob.registrocivil.identity.validation_mesh.application.command.update.UpdateValidationByServiceActCommandHandler;
import ec.gob.registrocivil.identity.validation_mesh.application.command.update.UpdateValidationByServiceActRequest;
import ec.gob.registrocivil.identity.validation_mesh.application.command.update.UpdateValidationByServiceCertificateCommand;
import ec.gob.registrocivil.identity.validation_mesh.application.command.update.UpdateValidationByServiceCertificateCommandHandler;
import ec.gob.registrocivil.identity.validation_mesh.application.command.update.UpdateValidationByServiceCertificateRequest;
import ec.gob.registrocivil.identity.validation_mesh.application.command.update.UpdateValidationByServiceResponse;
import ec.gob.registrocivil.identity.validation_mesh.application.command.update.UpdateValidationCommand;
import ec.gob.registrocivil.identity.validation_mesh.application.command.update.UpdateValidationCommandHandler;
import ec.gob.registrocivil.identity.validation_mesh.application.command.update.UpdateValidationMessage;
import ec.gob.registrocivil.identity.validation_mesh.application.command.update.UpdateValidationRequest;
import ec.gob.registrocivil.identity.validation_mesh.application.query.find.FindValidationByServiceActQuery;
import ec.gob.registrocivil.identity.validation_mesh.application.query.find.FindValidationByServiceActQueryHandler;
import ec.gob.registrocivil.identity.validation_mesh.application.query.find.FindValidationByServiceActResponse;
import ec.gob.registrocivil.identity.validation_mesh.application.query.find.FindValidationByServiceCertificateQuery;
import ec.gob.registrocivil.identity.validation_mesh.application.query.find.FindValidationByServiceCertificateQueryHandler;
import ec.gob.registrocivil.identity.validation_mesh.application.query.find.FindValidationByServiceCertificateResponse;
import ec.gob.registrocivil.identity.validation_mesh.application.query.find.FindValidationQuery;
import ec.gob.registrocivil.identity.validation_mesh.application.query.find.FindValidationQueryHandler;
import ec.gob.registrocivil.identity.validation_mesh.application.query.find.FindValidationResponse;
import ec.gob.registrocivil.identity.validation_mesh.domain.Validation;
import ec.gob.registrocivil.identity.validation_mesh.domain.ValidationByService;
import ec.gob.registrocivil.identity.validation_mesh.domain.ValidationByServiceId;
import ec.gob.registrocivil.identity.validation_mesh.domain.ValidationCivilStatus;
import ec.gob.registrocivil.identity.validation_mesh.domain.ValidationId;
import ec.gob.registrocivil.identity.validation_mesh.domain.ValidationServiceType;
import ec.gob.registrocivil.identity.validation_mesh.infrastructure.service.DomainValidationService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotBlank;

@RestController
@RequestMapping("/api/backoffice/validation")
@SecurityRequirement(name = "Bearer Authentication")
@Tag(name = "Backoffice Validation Mesh", description = "The Validation Mesh API. Contains all the operations that can be performed on the validation mesh.")
public class ValidationAdminController {

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

    public ValidationAdminController(DomainValidationService validationService,
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
        CreateValidationMessage response = null;

        return ResponseEntity.ok(new ApiResponse2xx<CreateValidationMessage>(response, HttpStatus.CREATED));
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse2xx<UpdateValidationMessage>> updateValidation(
            @RequestBody UpdateValidationRequest request) {

        UpdateValidationCommand command = new UpdateValidationCommand(request);
        updateValidationCommandHandler.handle(command);
        UpdateValidationMessage response = null;

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
        FindValidationResponse response = findValidationQueryHandler.handle(query);

        return ResponseEntity.ok(new ApiResponse2xx<FindValidationResponse>(response, HttpStatus.OK));
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse2xx<FindValidationResponse>> findValidationById(
            @NotBlank @PathVariable UUID id) {

        Validation validation = validationService.findValidationById(new ValidationId(id));
        FindValidationResponse response = new FindValidationResponse(validation);

        return ResponseEntity.ok(new ApiResponse2xx<FindValidationResponse>(response, HttpStatus.OK));
    }

    // Validation By Service - Certificate

    @PostMapping(value = "/certificate", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse2xx<CreateValidationByServiceResponse>> createValidationByServiceCertificate(
            @RequestBody CreateValidationByServiceCertificateRequest request) {

        CreateValidationByServiceCertificateCommand command = new CreateValidationByServiceCertificateCommand(request);
        createValidationByServiceCertificateCommandHandler.handle(command);
        CreateValidationByServiceResponse response = new CreateValidationByServiceResponse(command.getId());

        return ResponseEntity.ok(new ApiResponse2xx<CreateValidationByServiceResponse>(response, HttpStatus.CREATED));
    }

    @PutMapping(value = "/certificate", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse2xx<UpdateValidationByServiceResponse>> createValidationByServiceCertificate(
            @RequestBody UpdateValidationByServiceCertificateRequest request) {

        UpdateValidationByServiceCertificateCommand command = new UpdateValidationByServiceCertificateCommand(request);
        updateValidationByServiceCertificateCommandHandler.handle(command);
        UpdateValidationByServiceResponse response = new UpdateValidationByServiceResponse(command.getId());

        return ResponseEntity.ok(new ApiResponse2xx<UpdateValidationByServiceResponse>(response, HttpStatus.OK));
    }

    @DeleteMapping(value = "/certificate/{id}")
    public ResponseEntity<ApiResponse2xx<DeleteValidationResponse>> createValidationByServiceCertificate(
            @NotBlank @PathVariable UUID id) {

        validationService.deleteValidationByService(new ValidationByServiceId(id));
        DeleteValidationResponse response = new DeleteValidationResponse(id);

        return ResponseEntity.ok(new ApiResponse2xx<DeleteValidationResponse>(response, HttpStatus.OK));
    }

    @GetMapping(value = "/certificate", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse2xx<FindValidationByServiceCertificateResponse>> findValidationByServiceCertificateWithConditions(
            @RequestParam(required = true) String cedulaCondition,
            @RequestParam(required = true) ValidationServiceType type,
            @RequestParam(required = true) ValidationCivilStatus status) {

        FindValidationByServiceCertificateQuery query = new FindValidationByServiceCertificateQuery(cedulaCondition,
                type, status);
        FindValidationByServiceCertificateResponse response = findValidationByServiceCertificateQueryHandler
                .handle(query);

        return ResponseEntity
                .ok(new ApiResponse2xx<FindValidationByServiceCertificateResponse>(response, HttpStatus.OK));
    }

    @GetMapping(value = "/certificate/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse2xx<FindValidationByServiceCertificateResponse>> findValidationByServiceCertificateById(
            @NotBlank @PathVariable UUID id) {

        ValidationByService validationByService = validationService
                .findValidationByServiceById(new ValidationByServiceId(id));
        FindValidationByServiceCertificateResponse response = new FindValidationByServiceCertificateResponse(
                validationByService);

        return ResponseEntity
                .ok(new ApiResponse2xx<FindValidationByServiceCertificateResponse>(response, HttpStatus.OK));
    }

    // Validation By Service - Act

    @PostMapping(value = "/act", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse2xx<CreateValidationByServiceResponse>> createValidationByServiceAct(
            @RequestBody CreateValidationByServiceActRequest request) {

        CreateValidationByServiceActCommand command = new CreateValidationByServiceActCommand(request);
        createValidationByServiceActCommandHandler.handle(command);
        CreateValidationByServiceResponse response = new CreateValidationByServiceResponse(command.getId());

        return ResponseEntity.ok(new ApiResponse2xx<CreateValidationByServiceResponse>(response, HttpStatus.CREATED));
    }

    @PutMapping(value = "/act", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse2xx<UpdateValidationByServiceResponse>> createValidationByServiceAct(
            @RequestBody UpdateValidationByServiceActRequest request) {

        UpdateValidationByServiceActCommand command = new UpdateValidationByServiceActCommand(request);
        updateValidationByServiceActCommandHandler.handle(command);
        UpdateValidationByServiceResponse response = new UpdateValidationByServiceResponse(command.getId());

        return ResponseEntity.ok(new ApiResponse2xx<UpdateValidationByServiceResponse>(response, HttpStatus.OK));
    }

    @DeleteMapping(value = "/act/{id}")
    public ResponseEntity<ApiResponse2xx<DeleteValidationResponse>> createValidationByServiceAct(
            @NotBlank @PathVariable UUID id) {

        validationService.deleteValidationByService(new ValidationByServiceId(id));
        DeleteValidationResponse response = new DeleteValidationResponse(id);

        return ResponseEntity.ok(new ApiResponse2xx<DeleteValidationResponse>(response, HttpStatus.OK));
    }

    @GetMapping(value = "/act", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse2xx<FindValidationByServiceActResponse>> findValidationByServiceActWithConditions(
            @RequestParam(required = true) String cedulaCondition,
            @RequestParam(required = true) ValidationServiceType type,
            @RequestParam(required = true) ValidationCivilStatus status) {

        FindValidationByServiceActQuery query = new FindValidationByServiceActQuery(cedulaCondition, type, status);
        FindValidationByServiceActResponse response = findValidationByServiceActQueryHandler.handle(query);

        return ResponseEntity.ok(new ApiResponse2xx<FindValidationByServiceActResponse>(response, HttpStatus.OK));
    }

    @GetMapping(value = "/act/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse2xx<FindValidationByServiceActResponse>> findValidationByServiceActById(
            @NotBlank @PathVariable UUID id) {

        ValidationByService validationByService = validationService
                .findValidationByServiceById(new ValidationByServiceId(id));
        FindValidationByServiceActResponse response = new FindValidationByServiceActResponse(validationByService);

        return ResponseEntity.ok(new ApiResponse2xx<FindValidationByServiceActResponse>(response, HttpStatus.OK));
    }

}
