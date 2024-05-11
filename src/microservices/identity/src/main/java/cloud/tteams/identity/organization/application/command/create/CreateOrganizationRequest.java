package cloud.tteams.identity.organization.application.command.create;

import jakarta.validation.constraints.NotNull;

public class CreateOrganizationRequest {

    @NotNull
    private final String name;

    @NotNull
    private final String description;

    @NotNull
    private final String contact;

    public CreateOrganizationRequest(String name, String description, String contact) {
        this.name = name;
        this.description = description;
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getContact() {
        return contact;
    }
}
