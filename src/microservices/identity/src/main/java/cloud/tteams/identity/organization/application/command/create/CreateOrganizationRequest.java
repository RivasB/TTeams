package cloud.tteams.identity.organization.application.command.create;

import jakarta.validation.constraints.NotNull;

public record CreateOrganizationRequest(@NotNull String name, @NotNull String description, @NotNull String contact) {

    public CreateOrganizationRequest(String name, String description, String contact) {
        this.name = name;
        this.description = description;
        this.contact = contact;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public String description() {
        return description;
    }

    @Override
    public String contact() {
        return contact;
    }
}
