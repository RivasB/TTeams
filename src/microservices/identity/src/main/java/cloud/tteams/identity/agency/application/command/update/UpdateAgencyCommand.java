package cloud.tteams.identity.agency.application.command.update;

import java.util.UUID;

import cloud.tteams.identity.agency.domain.AgencyState;
import cloud.tteams.share.core.domain.bus.command.ICommand;
import cloud.tteams.share.core.domain.bus.command.ICommandMessage;

public class UpdateAgencyCommand implements ICommand {

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

    private AgencyState state;

    public UpdateAgencyCommand() {
    }

    public UpdateAgencyCommand(UUID id, String name, String description, UUID country, UUID province, UUID canton,
            UUID parroquia, String region, String latitude, String longitude, AgencyState state) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.country = country;
        this.province = province;
        this.canton = canton;
        this.parroquia = parroquia;
        this.region = region;
        this.latitude = latitude;
        this.longitude = longitude;
        this.state = state;
    }

    public static UpdateAgencyCommand fromRequest(UpdateAgencyRequest request) {

        return new UpdateAgencyCommand(
                request.getId(),
                request.getName(),
                request.getDescription(),
                request.getCountry(),
                request.getProvince(),
                request.getCanton(),
                request.getParroquia(),
                request.getRegion(),
                request.getLatitude(),
                request.getLongitude(),
                request.getState());
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

    public AgencyState getState() {
        return state;
    }

    @Override
    public ICommandMessage getMessage() {
        return new UpdateAgencyMessage(id);
    }

}
