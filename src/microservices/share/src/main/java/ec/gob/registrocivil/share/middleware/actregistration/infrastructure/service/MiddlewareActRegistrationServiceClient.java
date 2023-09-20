package ec.gob.registrocivil.share.middleware.actregistration.infrastructure.service;

import ec.gob.registrocivil.share.middleware.actregistration.domain.ActRegistrationResponse;
import ec.gob.registrocivil.share.middleware.actregistration.domain.RespuestaActasRegistrales;
import ec.gob.registrocivil.share.middleware.actregistration.domain.service.IMiddlewareActRegistraionServiceClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
class MiddlewareActRegistrationServiceClient implements IMiddlewareActRegistraionServiceClient {

    private static final Logger logger = LoggerFactory.getLogger(MiddlewareActRegistrationServiceClient.class);

    private final MiddlewareActRegistrationFeignClient middlewareActRegistrationFeignClient;

    public MiddlewareActRegistrationServiceClient(MiddlewareActRegistrationFeignClient middlewareActRegistrationFeignClient) {
        this.middlewareActRegistrationFeignClient = middlewareActRegistrationFeignClient;
    }

    @Override
    public ActRegistrationResponse getRegistrationAct(String numDocumento, int estadoCivil, int tipoServicio) {
        try {
            RespuestaActasRegistrales response = this.middlewareActRegistrationFeignClient.getRegistrationAct(numDocumento, estadoCivil, tipoServicio);
            if (response.isAccedeServicio()) {
                /*Logica para obtener un PDF desde un FTP*/
                return new ActRegistrationResponse(true, "Generando Acta Registral Satisfactoriamente.", GenerateActRegistrationMockup.generarPdfBase64());
            }
        } catch (Exception e) {
            logger.error("Error obtaining citizen information: ", e);
        }
        
        return new ActRegistrationResponse(false, "Usuario no aplica al servicio.", GenerateActRegistrationNoAplicaMockup.generarPdfBase64());
    }

}
