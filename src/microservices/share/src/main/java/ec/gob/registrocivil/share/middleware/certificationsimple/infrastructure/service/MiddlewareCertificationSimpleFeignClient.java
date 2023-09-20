package ec.gob.registrocivil.share.middleware.certificationsimple.infrastructure.service;

import ec.gob.registrocivil.share.middleware.certificationsimple.domain.SimpleCertification;
import ec.gob.registrocivil.share.middleware.certificationsimple.domain.TypeCertification;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//@FeignClient(value = "http://localhost:8088", path = "/api/certificado", contextId = "certificationSimples")
@FeignClient(value = "middleware", path = "/api/certificado", contextId = "certificationSimples")
interface MiddlewareCertificationSimpleFeignClient {

    @RequestMapping(value = "/simple", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    SimpleCertification generateCertificadoSimple(@RequestParam(name = "nui", required = true) String nui,
                                                 @RequestParam(name = "tipoCertificado", required = true) TypeCertification tipoCertificado);

}
