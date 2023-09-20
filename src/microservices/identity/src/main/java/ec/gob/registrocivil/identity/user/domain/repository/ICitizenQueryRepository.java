package ec.gob.registrocivil.identity.user.domain.repository;

import ec.gob.registrocivil.identity.user.domain.soap.Ciudadano;

public interface ICitizenQueryRepository {

    public Ciudadano findCitizenByNui(String nui);
}
