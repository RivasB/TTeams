package ec.gob.registrocivil.share.middleware.certificationsimple.domain.service;

import ec.gob.registrocivil.share.middleware.certificationsimple.domain.SimpleCertification;
import ec.gob.registrocivil.share.middleware.certificationsimple.domain.TypeCertification;

public interface IMiddlewareCertificationSimpleServiceClient {
    public SimpleCertification generateCertificadoSimple(String nui, TypeCertification tipoCertificado);
}
