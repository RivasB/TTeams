package ec.gob.registrocivil.share.middleware.certificationsimple.infrastructure.service;

import ec.gob.registrocivil.share.core.domain.exception.BusinessException;
import ec.gob.registrocivil.share.core.domain.exception.DomainErrorMessage;
import ec.gob.registrocivil.share.middleware.certificationsimple.domain.SimpleCertification;
import ec.gob.registrocivil.share.middleware.certificationsimple.domain.TypeCertification;
import ec.gob.registrocivil.share.middleware.certificationsimple.domain.service.IMiddlewareCertificationSimpleServiceClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
class MiddlewareCertificationSimpleServiceClient implements IMiddlewareCertificationSimpleServiceClient {

    private static final Logger logger = LoggerFactory.getLogger(MiddlewareCertificationSimpleServiceClient.class);

    private final MiddlewareCertificationSimpleFeignClient middlewareCertificationSimpleFeignClient;

    public MiddlewareCertificationSimpleServiceClient(MiddlewareCertificationSimpleFeignClient middlewareCertificationSimpleFeignClient) {
        this.middlewareCertificationSimpleFeignClient = middlewareCertificationSimpleFeignClient;
    }

    @Override
    public SimpleCertification generateCertificadoSimple(String nui, TypeCertification tipoCertificado) {
        try {
            return this.middlewareCertificationSimpleFeignClient.generateCertificadoSimple(nui, tipoCertificado);
        } catch (Exception e) {
            throw new BusinessException(DomainErrorMessage.FAILED_CONNECT_SURI, "Failed response, to connect the suri server or nui not exist");
        }
    }

}
