package ec.gob.registrocivil.share.middleware.actregistration.domain;

public class ActRegistrationResponse {
    private boolean accedeServicio;
    private String mensajeRespuesta;
    private byte[] document;

    public ActRegistrationResponse(boolean accedeServicio, String mensajeRespuesta, byte[] document) {
        this.accedeServicio = accedeServicio;
        this.mensajeRespuesta = mensajeRespuesta;
        this.document = document;
    }

    public boolean isAccedeServicio() {
        return accedeServicio;
    }

    public String getMensajeRespuesta() {
        return mensajeRespuesta;
    }

    public byte[] getDocument() {
        return document;
    }

}
