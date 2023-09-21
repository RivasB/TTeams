package cloud.tteams.identity.user.application.query.getbyidentification;

import cloud.tteams.share.core.domain.bus.query.IQuery;

public class FindUserByIdentificationQuery implements IQuery {

    private String identification;

    public FindUserByIdentificationQuery(String identification) {
        this.identification = identification;
    }

    public String getIdentification() {
        return identification;
    }

}
