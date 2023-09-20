package ec.gob.registrocivil.share.middleware.nui.infrastructure.service;

import ec.gob.registrocivil.share.core.application.ApiResponse2xx;
import ec.gob.registrocivil.share.core.domain.exception.BusinessException;
import ec.gob.registrocivil.share.core.domain.exception.DomainErrorMessage;
import ec.gob.registrocivil.share.middleware.nui.domain.service.IMiddlewareNuiServiceClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
class MiddlewareNuiServiceClient implements IMiddlewareNuiServiceClient {

    private static final Logger logger = LoggerFactory.getLogger(MiddlewareNuiServiceClient.class);

    private final MiddlewareNuiFeignClient middlewareNuiFeignClient;

    MiddlewareNuiServiceClient(MiddlewareNuiFeignClient middlewareNuiFeignClient) {
        this.middlewareNuiFeignClient = middlewareNuiFeignClient;
    }

    @Override
    public Ciudadano getCitizenByNui(String nui) {
        try {
            SoapResponse response = middlewareNuiFeignClient.getCitizenByNui(nui);
            return response.getCiudadano();
        } catch (Exception e) {
            logger.error("Error obtaining citizen information by nui: ", e);
            throw new BusinessException(DomainErrorMessage.FAILED_CONNECT_SURI, "Failed response, to connect the suri server or nui not exist");
        }
    }

    @Override
    public VerifyRelationshipResponse verifyRelationship(String firstNui, String secondNui, RelationshipType relationship) {
        try {
            ApiResponse2xx<VerifyRelationshipResponse> response = middlewareNuiFeignClient.verifyRelationship(firstNui, secondNui, relationship);
            return response.getData();
        } catch (Exception e) {
            logger.error("Error getting relationship: ", e);
            throw new BusinessException(DomainErrorMessage.FAILED_CONNECT_SURI, "Failed response, to connect the suri server or nui not exist");
        }

    }

}
