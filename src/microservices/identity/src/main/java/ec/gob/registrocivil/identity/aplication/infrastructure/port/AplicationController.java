package ec.gob.registrocivil.identity.aplication.infrastructure.port;

import java.util.UUID;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
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

import ec.gob.registrocivil.identity.aplication.application.command.create.CreateAplicationCommand;
import ec.gob.registrocivil.identity.aplication.application.command.create.CreateAplicationMessage;
import ec.gob.registrocivil.identity.aplication.application.command.create.CreateAplicationRequest;
import ec.gob.registrocivil.identity.aplication.application.command.delete.DeleteAplicationMessage;
import ec.gob.registrocivil.identity.aplication.application.command.delete.DeleteApplicatinCommand;
import ec.gob.registrocivil.identity.aplication.application.command.update.UpdateAplicationCommand;
import ec.gob.registrocivil.identity.aplication.application.command.update.UpdateAplicationMessage;
import ec.gob.registrocivil.identity.aplication.application.command.update.UpdateAplicationRequest;
import ec.gob.registrocivil.identity.aplication.application.query.getall.FindApplicationWithFilterQuery;
import ec.gob.registrocivil.identity.aplication.application.query.getbyid.FindApplicationByIdQuery;
import ec.gob.registrocivil.identity.aplication.application.query.getbyid.FindApplicationByIdResponse;
import ec.gob.registrocivil.share.core.application.ApiResponse2xx;
import ec.gob.registrocivil.share.core.domain.MessagePaginatedResponse;
import ec.gob.registrocivil.share.core.infrastructure.bus.IMediator;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotBlank;

@RestController
@RequestMapping("/api/aplication")
@SecurityRequirement(name = "Bearer Authentication")
@Tag(name = "Aplication", description = "The Aplication API. Contains all the operations that can be performed on a aplication.")
public class AplicationController {

    private final IMediator mediator;

    public AplicationController(IMediator mediator) {
        this.mediator = mediator;
    }

    // This workflow is implemented by 06-RFS3. Gestionar Aplicación
    @PostMapping
    public ResponseEntity<ApiResponse2xx<CreateAplicationMessage>> createAplication(
            @RequestBody CreateAplicationRequest request) {

        CreateAplicationCommand createCommand = CreateAplicationCommand.fromRequest(request);
        CreateAplicationMessage response = mediator.send(createCommand);

        return ResponseEntity.ok(new ApiResponse2xx<CreateAplicationMessage>(response, HttpStatus.CREATED));
    }

    // This workflow is implemented by 06-RFS3. Gestionar Aplicación
    @PutMapping
    public ResponseEntity<ApiResponse2xx<UpdateAplicationMessage>> updateAplication(
            @RequestBody UpdateAplicationRequest request) {

        UpdateAplicationCommand createCommand = UpdateAplicationCommand.fromRequest(request);
        UpdateAplicationMessage response = mediator.send(createCommand);

        return ResponseEntity.ok(new ApiResponse2xx<UpdateAplicationMessage>(response, HttpStatus.OK));
    }

    // This workflow is implemented by 06-RFS3. Gestionar Aplicación
    @GetMapping
    public ResponseEntity<MessagePaginatedResponse> getAllAplications(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "20") Integer pageSize,
            @RequestParam(defaultValue = "") String filter,
            @RequestParam(defaultValue = "name") String sortBy,
            @RequestParam(defaultValue = "asc") String sortType) {
        Sort sort = (sortType.equals("asc")) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

        FindApplicationWithFilterQuery query = new FindApplicationWithFilterQuery(pageable, filter);
        MessagePaginatedResponse pageResponse = mediator.send(query);

        return ResponseEntity.ok(pageResponse);
    }

    // This workflow is implemented by 06-RFS3. Gestionar Aplicación
    @GetMapping(path = "/{id}")
    public ResponseEntity<ApiResponse2xx<FindApplicationByIdResponse>> retrieveAplication(
            @NotBlank @PathVariable UUID id) {

        FindApplicationByIdQuery query = new FindApplicationByIdQuery(id);
        FindApplicationByIdResponse response = mediator.send(query);

        return ResponseEntity.ok(new ApiResponse2xx<FindApplicationByIdResponse>(response, HttpStatus.OK));
    }

    // This workflow is implemented by 06-RFS3. Gestionar Aplicación
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse2xx<DeleteAplicationMessage>> deleteAplication(
            @NotBlank @PathVariable("id") UUID id) {

        DeleteApplicatinCommand deleteCommand = new DeleteApplicatinCommand(id);
        DeleteAplicationMessage response = mediator.send(deleteCommand);

        return ResponseEntity.ok(new ApiResponse2xx<DeleteAplicationMessage>(response, HttpStatus.OK));
    }
}
