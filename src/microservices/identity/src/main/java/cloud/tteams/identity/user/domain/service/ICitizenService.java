package cloud.tteams.identity.user.domain.service;

import cloud.tteams.share.middleware.nui.infrastructure.service.Ciudadano;

public interface ICitizenService {

    public Ciudadano getCitizenByNUI(String nui);
}
