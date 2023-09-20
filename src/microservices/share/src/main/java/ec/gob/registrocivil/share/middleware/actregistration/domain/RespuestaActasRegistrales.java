package ec.gob.registrocivil.share.middleware.actregistration.domain;

import java.util.List;

public class RespuestaActasRegistrales {
    private boolean accedeServicio;
    private int codigoRespuesta;
    private String directorioActas;
    private List<RutasActas> listaRutasDocumentos;
    private String mensajeRespuesta;

    public RespuestaActasRegistrales(boolean accedeServicio, int codigoRespuesta, String directorioActas, 
            List<RutasActas> listaRutasDocumentos, String mensajeRespuesta) {
        this.accedeServicio = accedeServicio;
        this.codigoRespuesta = codigoRespuesta;
        this.directorioActas = directorioActas;
        this.listaRutasDocumentos = listaRutasDocumentos;
        this.mensajeRespuesta = mensajeRespuesta;
    }

    public boolean isAccedeServicio() {
        return accedeServicio;
    }

    public int getCodigoRespuesta() {
        return codigoRespuesta;
    }

    public String getDirectorioActas() {
        return directorioActas;
    }

    public List<RutasActas> getListaRutasDocumentos() {
        return listaRutasDocumentos;
    }

    public String getMensajeRespuesta() {
        return mensajeRespuesta;
    }

}
