package ec.gob.registrocivil.identity.agency.infrastructure.port;

import java.util.List;
import java.util.UUID;

import ec.gob.registrocivil.identity.agency.domain.AgencyState;
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

import ec.gob.registrocivil.identity.agency.application.command.create.CreateAgencyCommand;
import ec.gob.registrocivil.identity.agency.application.command.create.CreateAgencyMessage;
import ec.gob.registrocivil.identity.agency.application.command.create.CreateAgencyRequest;
import ec.gob.registrocivil.identity.agency.application.command.delete.DeleteAgencyCommand;
import ec.gob.registrocivil.identity.agency.application.command.delete.DeleteAgencyMessage;
import ec.gob.registrocivil.identity.agency.application.command.update.UpdateAgencyCommand;
import ec.gob.registrocivil.identity.agency.application.command.update.UpdateAgencyMessage;
import ec.gob.registrocivil.identity.agency.application.command.update.UpdateAgencyRequest;
import ec.gob.registrocivil.identity.agency.application.query.AgencyResponse;
import ec.gob.registrocivil.identity.agency.application.query.getall.FindAgencyWithFilterQuery;
import ec.gob.registrocivil.identity.agency.application.query.getbycanton.FindAgencyByCantonQuery;
import ec.gob.registrocivil.identity.agency.application.query.getbycanton.FindAgencyByCantonResponse;
import ec.gob.registrocivil.identity.agency.application.query.getbyid.FindAgencyByIdQuery;
import ec.gob.registrocivil.identity.agency.application.query.getbyid.FindAgencyByIdResponse;
import ec.gob.registrocivil.identity.agency.application.query.getbyprovince.FindAgencyByProvinceQuery;
import ec.gob.registrocivil.identity.agency.application.query.getbyprovince.FindAgencyByProvinceResponse;
import ec.gob.registrocivil.share.core.application.ApiResponse2xx;
import ec.gob.registrocivil.share.core.domain.MessagePaginatedResponse;
import ec.gob.registrocivil.share.core.infrastructure.bus.IMediator;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotBlank;

@RestController
@RequestMapping("/api/agency")
@SecurityRequirement(name = "Bearer Authentication")
@Tag(name = "Agency", description = "The Agency API. Contains all the operations that can be performed on a agency.")
public class AgencyController {

    private final IMediator mediator;

    public AgencyController(IMediator mediator) {
        this.mediator = mediator;
    }

    // This workflow is implemented by 06-RFS2. Gestionar Agencia
    @PostMapping
    public ResponseEntity<ApiResponse2xx<CreateAgencyMessage>> createAgency(
            @RequestBody CreateAgencyRequest request) {

        CreateAgencyCommand createCommand = CreateAgencyCommand.fromRequest(request);
        CreateAgencyMessage response = mediator.send(createCommand);

        return ResponseEntity.ok(new ApiResponse2xx<CreateAgencyMessage>(response, HttpStatus.CREATED));
    }

    // This workflow is implemented by 06-RFS2. Gestionar Agencia
    @PutMapping
    public ResponseEntity<ApiResponse2xx<UpdateAgencyMessage>> updateAgency(
            @RequestBody UpdateAgencyRequest request) {

        UpdateAgencyCommand updateCommand = UpdateAgencyCommand.fromRequest(request);
        UpdateAgencyMessage response = mediator.send(updateCommand);

        return ResponseEntity.ok(new ApiResponse2xx<UpdateAgencyMessage>(response, HttpStatus.OK));
    }

    // This workflow is implemented by 06-RFS2. Gestionar Agencia
    @GetMapping
    public ResponseEntity<MessagePaginatedResponse> getAllAgencies(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "20") Integer pageSize,
            @RequestParam(defaultValue = "") String filter,
            @RequestParam(defaultValue = "") String name,
            @RequestParam(defaultValue = "") String province,
            @RequestParam(defaultValue = "") String canton,
            @RequestParam(defaultValue = "") String description,
            @RequestParam(defaultValue = "") String latitude,
            @RequestParam(defaultValue = "") String longitude,
            @RequestParam(defaultValue = "ACTIVE") AgencyState state,
            @RequestParam(defaultValue = "name") String sortBy,
            @RequestParam(defaultValue = "asc") String sortType) {
        Sort sort = (sortType.equals("asc")) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

        FindAgencyWithFilterQuery findQuery = new FindAgencyWithFilterQuery(pageable, name, province, canton, description, latitude, longitude, state, filter);
        MessagePaginatedResponse pageResponse = mediator.send(findQuery);

        return ResponseEntity.ok(pageResponse);
    }

    // This workflow is implemented by 06-RFS2. Gestionar Agencia
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse2xx<DeleteAgencyMessage>> deleteAgency(@NotBlank @PathVariable("id") UUID id) {

        DeleteAgencyCommand deleteCommand = new DeleteAgencyCommand(id);
        DeleteAgencyMessage response = mediator.send(deleteCommand);

        return ResponseEntity.ok(new ApiResponse2xx<DeleteAgencyMessage>(response, HttpStatus.OK));
    }

    // This workflow is implemented by 06-RFS2. Gestionar Agencia
    @GetMapping(path = "/{id}")
    public ResponseEntity<ApiResponse2xx<FindAgencyByIdResponse>> retrieveAgency(@NotBlank @PathVariable UUID id) {

        FindAgencyByIdQuery query = new FindAgencyByIdQuery(id);
        FindAgencyByIdResponse response = mediator.send(query);

        return ResponseEntity.ok(new ApiResponse2xx<FindAgencyByIdResponse>(response, HttpStatus.OK));
    }

    @GetMapping("/by")
    public ResponseEntity<ApiResponse2xx<List<AgencyResponse>>> retrieveAgencyByProvince(
            @NotBlank @RequestParam UUID province) {

        FindAgencyByProvinceQuery findQuery = new FindAgencyByProvinceQuery(province);
        FindAgencyByProvinceResponse response = mediator.send(findQuery);

        return ResponseEntity.ok(new ApiResponse2xx<List<AgencyResponse>>(response.getAgencies(), HttpStatus.OK));
    }

    @GetMapping("/by/canton")
    public ResponseEntity<ApiResponse2xx<List<AgencyResponse>>> retrieveAgencyByCanton(
            @NotBlank @RequestParam UUID canton) {

        FindAgencyByCantonQuery findQuery = new FindAgencyByCantonQuery(canton);
        FindAgencyByCantonResponse response = mediator.send(findQuery);

        return ResponseEntity.ok(new ApiResponse2xx<List<AgencyResponse>>(response.getAgencies(), HttpStatus.OK));
    }
}
