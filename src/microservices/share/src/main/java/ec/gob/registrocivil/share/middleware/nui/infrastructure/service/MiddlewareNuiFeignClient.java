package ec.gob.registrocivil.share.middleware.nui.infrastructure.service;

import ec.gob.registrocivil.share.core.application.ApiResponse2xx;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "middleware", path = "/api/nui")
//@FeignClient(value = "http://localhost:8088", path = "/api/nui")
interface MiddlewareNuiFeignClient {

    @RequestMapping(value = "/{nui}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    SoapResponse getCitizenByNui(@PathVariable("nui") String nui);

    @RequestMapping(method = RequestMethod.GET, path = "/relationship/check", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    ApiResponse2xx<VerifyRelationshipResponse> verifyRelationship(@RequestParam(name = "firstNui", required = true) String firstNui,
                                                                  @RequestParam(name = "secondNui", required = true) String secondNui,
                                                                  @RequestParam(name = "relationship", required = true) RelationshipType relationship);
}
