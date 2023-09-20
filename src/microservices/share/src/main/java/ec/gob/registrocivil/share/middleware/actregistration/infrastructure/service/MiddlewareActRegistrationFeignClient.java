package ec.gob.registrocivil.share.middleware.actregistration.infrastructure.service;

import ec.gob.registrocivil.share.middleware.actregistration.domain.RespuestaActasRegistrales;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "middleware", path = "/api/registrales", contextId = "registrales")
interface MiddlewareActRegistrationFeignClient {

    @RequestMapping(value = "/acta", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    RespuestaActasRegistrales getRegistrationAct(@RequestParam(name = "numDocumento", required = true) String numDocumento,
                                                 @RequestParam(name = "estadoCivil", required = true) int estadoCivil,
                                                 @RequestParam(name = "tipoServicio", required = true) int tipoServicio);

}
