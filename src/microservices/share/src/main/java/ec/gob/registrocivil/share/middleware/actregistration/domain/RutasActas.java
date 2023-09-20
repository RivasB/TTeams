package ec.gob.registrocivil.share.middleware.actregistration.domain;

public class RutasActas {
    private String fecha;
    private String origen;
    private String rutaDocumento;
    private String secuencia;

    public RutasActas(String fecha, String origen, String rutaDocumento, String secuencia) {
        this.fecha = fecha;
        this.origen = origen;
        this.rutaDocumento = rutaDocumento;
        this.secuencia = secuencia;
    }

    public String getFecha() {
        return fecha;
    }

    public String getOrigen() {
        return origen;
    }

    public String getRutaDocumento() {
        return rutaDocumento;
    }

    public String getSecuencia() {
        return secuencia;
    }
}
