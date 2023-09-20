package ec.gob.registrocivil.identity.agency.application.query.getall;

import ec.gob.registrocivil.identity.agency.domain.AgencyState;
import jakarta.persistence.Column;
import org.springframework.data.domain.Pageable;

import ec.gob.registrocivil.share.core.domain.bus.query.IQuery;

public class FindAgencyWithFilterQuery implements IQuery {

    private Pageable pageable;
    private String name;
    private String province;
    private String canton;
    private String description;
    private String latitude;
    private String longitude;
    private AgencyState state;
    private String filter;

    public FindAgencyWithFilterQuery(Pageable pageable, String name, String province, String canton, String description, String latitude, String longitude, AgencyState state, String filter) {
        this.pageable = pageable;
        this.name = name;
        this.province = province;
        this.canton = canton;
        this.description = description;
        this.latitude = latitude;
        this.longitude = longitude;
        this.state = state;
        this.filter = filter;
    }

    public Pageable getPageable() {
        return pageable;
    }

    public String getName() {
        return name;
    }

    public String getProvince() {
        return province;
    }

    public String getCanton() {
        return canton;
    }

    public String getDescription() {
        return description;
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

    public String getFilter() {
        return filter;
    }
}
