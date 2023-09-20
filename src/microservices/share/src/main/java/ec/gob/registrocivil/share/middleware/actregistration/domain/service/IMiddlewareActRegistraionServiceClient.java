package ec.gob.registrocivil.share.middleware.actregistration.domain.service;

import ec.gob.registrocivil.share.middleware.actregistration.domain.ActRegistrationResponse;

public interface IMiddlewareActRegistraionServiceClient {
    
    ActRegistrationResponse getRegistrationAct(String numDocumento, int estadoCivil, int tipoServicio);
}
