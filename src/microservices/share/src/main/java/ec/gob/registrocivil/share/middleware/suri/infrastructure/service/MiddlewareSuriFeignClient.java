package ec.gob.registrocivil.share.middleware.suri.infrastructure.service;

import ec.gob.registrocivil.share.middleware.suri.domain.DuplicateInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "middleware", path = "/api/suri", contextId = "suri")
public interface MiddlewareSuriFeignClient {

    @GetMapping(path = "/valida/duplicado")
    DuplicateInfo validateDuplicate(@RequestParam(name = "nui", required = true) String nui,
                                    @RequestParam(name = "tipoDocumento", required = true) Integer documentType);

    @GetMapping(path = "/registro/duplicado")
    DuplicateInfo createDuplicate( @RequestParam(name = "nui", required = true) String nui,
                                   @RequestParam(name = "tipoDocumento", required = true) Integer documentType,
                                   @RequestParam(name = "numComprobante", required = true) String receiptNumber,
                                   @RequestParam(name = "idAgenciaImpresion", required = true) Integer printedAgencyId,
                                   @RequestParam(name = "nuiOperador", required = true) String nuiOperator,
                                   @RequestParam(name = "idAgenciaOperador", required = true) Integer operatorAgencyId,
                                   @RequestParam(name = "canal", required = true) String canal);

    @GetMapping(path = "/registro/NPasaporte")
    Integer passportNumberByYear(@RequestParam(name = "numComprobante", required = true) String receiptNumber);

    @GetMapping(path = "/registro/PVRenovacion")
    String firstPasportRenovation(@RequestParam(name = "numComprobante", required = true) String receiptNumber,
                                  @RequestParam(name = "abreviacionTipoDocumento", required = true) String documentTypeAcronym ,
                                  @RequestParam(name = "desHistoricoPasaporte", required = true) String desPassportHistory);

    @GetMapping(path = "/registro/CVRenovacion")
    String  firstIdentitycardRenovation(@RequestParam(name = "numComprobante", required = true)String receiptNumber);
}
