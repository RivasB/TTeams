package ec.gob.registrocivil.share.middleware.nui.domain.service;

import ec.gob.registrocivil.share.middleware.nui.infrastructure.service.Ciudadano;
import ec.gob.registrocivil.share.middleware.nui.infrastructure.service.RelationshipType;
import ec.gob.registrocivil.share.middleware.nui.infrastructure.service.VerifyRelationshipResponse;

public interface IMiddlewareNuiServiceClient {

    Ciudadano getCitizenByNui(String nui);

    VerifyRelationshipResponse verifyRelationship(String firstNui, String secondNui, RelationshipType relationship);

}