package ec.gob.registrocivil.identity.user.domain.service;

import ec.gob.registrocivil.share.middleware.nui.infrastructure.service.Ciudadano;

public interface ICitizenService {

    public Ciudadano getCitizenByNUI(String nui);
}
