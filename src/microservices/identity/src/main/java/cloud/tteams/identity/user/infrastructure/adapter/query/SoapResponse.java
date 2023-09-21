package cloud.tteams.identity.user.infrastructure.adapter.query;

import cloud.tteams.identity.user.domain.soap.Ciudadano;

public class SoapResponse {

    protected String codigo;

    protected String mensaje;

    protected Ciudadano ciudadano;

    public SoapResponse() {
    }

    public SoapResponse(String codigo, String mensaje, Ciudadano ciudadano) {
        this.codigo = codigo;
        this.mensaje = mensaje;
        this.ciudadano = ciudadano;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public Ciudadano getCiudadano() {
        return ciudadano;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("SoapResponse [codigo=");
        builder.append(codigo);
        builder.append(", mensaje=");
        builder.append(mensaje);
        builder.append(", ciudadano=");
        builder.append(ciudadano);
        builder.append("]");
        return builder.toString();
    }

}
