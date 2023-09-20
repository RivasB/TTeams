package ec.gob.registrocivil.share.middleware.receipt.domain;

public class ReceiptInfo {
    private String claveAcceso;
    private String codigoError;
    private boolean error;
    private String estadoComprobante;
    private String mensaje;
    private String numFactura;

    public ReceiptInfo(String claveAcceso, String codigoError, boolean error, String estadoComprobante, String mensaje, String numFactura) {
        this.claveAcceso = claveAcceso;
        this.codigoError = codigoError;
        this.error = error;
        this.estadoComprobante = estadoComprobante;
        this.mensaje = mensaje;
        this.numFactura = numFactura;
    }

    public String getClaveAcceso() {
        return claveAcceso;
    }

    public String getCodigoError() {
        return codigoError;
    }

    public boolean isError() {
        return error;
    }

    public String getEstadoComprobante() {
        return estadoComprobante;
    }

    public String getMensaje() {
        return mensaje;
    }

    public String getNumFactura() {
        return numFactura;
    }
}
