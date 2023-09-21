package cloud.tteams.identity.agency.application.command.create;

import java.util.UUID;

import cloud.tteams.share.core.domain.bus.command.ICommand;
import cloud.tteams.share.core.domain.bus.command.ICommandMessage;

public class CreateAgencyCommand implements ICommand {

    private UUID id;

    private String name;

    private String description;

    private UUID country;

    private UUID province;

    private UUID canton;

    private UUID parroquia;

    private String region;

    private String latitude;

    private String longitude;

    public CreateAgencyCommand(String name, String description, UUID country, UUID province, UUID canton,
            UUID parroquia, String region, String latitude, String longitude) {

        this.id = UUID.randomUUID();
        this.name = name;
        this.description = description;
        this.country = country;
        this.province = province;
        this.canton = canton;
        this.parroquia = parroquia;
        this.region = region;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public static CreateAgencyCommand fromRequest(CreateAgencyRequest request) {

        return new CreateAgencyCommand(
                request.getName(),
                request.getDescription(),
                request.getCountry(),
                request.getProvince(),
                request.getCanton(),
                request.getParroquia(),
                request.getRegion(),
                request.getLatitude(),
                request.getLongitude());
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public UUID getCountry() {
        return country;
    }

    public UUID getProvince() {
        return province;
    }

    public UUID getCanton() {
        return canton;
    }

    public UUID getParroquia() {
        return parroquia;
    }

    public String getRegion() {
        return region;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    @Override
    public ICommandMessage getMessage() {
        return new CreateAgencyMessage(this.id);
    }

}
