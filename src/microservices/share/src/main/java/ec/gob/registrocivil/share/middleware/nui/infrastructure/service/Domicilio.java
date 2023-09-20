package ec.gob.registrocivil.share.middleware.nui.infrastructure.service;

public record Domicilio(
        String codigoDomicilio,
        String domicilio,
        String calle,
        String numeroCasa,
        String codigoParroquiaDomicilio,
        String codigoCantonDomicilio,
        String codigoProvinciaDomicilio,
        String codigoPaisDomicilio,
        String parroquiaDomicilio,
        String cantonDomicilio,
        String provinciaDomicilio,
        String paisDomicilio) {
}
