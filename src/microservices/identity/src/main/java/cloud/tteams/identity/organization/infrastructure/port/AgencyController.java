package cloud.tteams.identity.organization.infrastructure.port;

import java.util.List;
import java.util.UUID;

import cloud.tteams.identity.organization.application.query.AgencyResponse;
import cloud.tteams.identity.organization.application.query.getall.FindAgencyWithFilterQuery;
import cloud.tteams.identity.organization.application.query.getbycanton.FindAgencyByCantonQuery;
import cloud.tteams.identity.organization.application.query.getbycanton.FindAgencyByCantonResponse;
import cloud.tteams.identity.organization.application.query.getbyid.FindAgencyByIdQuery;
import cloud.tteams.identity.organization.application.query.getbyid.FindAgencyByIdResponse;
import cloud.tteams.identity.organization.application.query.getbyprovince.FindAgencyByProvinceQuery;
import cloud.tteams.identity.organization.application.query.getbyprovince.FindAgencyByProvinceResponse;
import cloud.tteams.identity.organization.domain.AgencyState;
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

import cloud.tteams.identity.organization.application.command.create.CreateAgencyCommand;
import cloud.tteams.identity.organization.application.command.create.CreateAgencyMessage;
import cloud.tteams.identity.organization.application.command.create.CreateAgencyRequest;
import cloud.tteams.identity.organization.application.command.delete.DeleteAgencyCommand;
import cloud.tteams.identity.organization.application.command.delete.DeleteAgencyMessage;
import cloud.tteams.identity.organization.application.command.update.UpdateAgencyCommand;
import cloud.tteams.identity.organization.application.command.update.UpdateAgencyMessage;
import cloud.tteams.identity.organization.application.command.update.UpdateAgencyRequest;
import cloud.tteams.share.core.application.ApiResponse2xx;
import cloud.tteams.share.core.domain.MessagePaginatedResponse;
import cloud.tteams.share.core.infrastructure.bus.IMediator;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotBlank;

@RestController
@RequestMapping("/api/agency")
@SecurityRequirement(name = "Bearer Authentication")
@Tag(name = "Agency", description = "The Agency API. Contains all the operations that can be performed on a organization.")
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
