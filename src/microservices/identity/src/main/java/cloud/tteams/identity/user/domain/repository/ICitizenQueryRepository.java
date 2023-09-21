package cloud.tteams.identity.user.domain.repository;

import cloud.tteams.identity.user.domain.soap.Ciudadano;

public interface ICitizenQueryRepository {

    public Ciudadano findCitizenByNui(String nui);
}
