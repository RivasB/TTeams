
package ec.gob.registrocivil.share.middleware.suri.domain;

/**
 * <p>Clase Java para duplicadoRespuesta complex type.
 * 
 */
public class DuplicateInfo {

    private String codigoResp;
    private String condicionCedulado;
    private CitizenData datosCiudadano;
    private String descripcionResp;
    private String nombreCompleto;
    private String nui;

    public DuplicateInfo(String codigoResp, String condicionCedulado, CitizenData datosCiudadano, String descripcionResp,
                         String nombreCompleto, String nui) {
        this.codigoResp = codigoResp;
        this.condicionCedulado = condicionCedulado;
        this.datosCiudadano = datosCiudadano;
        this.descripcionResp = descripcionResp;
        this.nombreCompleto = nombreCompleto;
        this.nui = nui;
    }

    /**
     * Obtiene el valor de la propiedad codigoResp.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoResp() {
        return codigoResp;
    }

    /**
     * Define el valor de la propiedad codigoResp.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoResp(String value) {
        this.codigoResp = value;
    }

    /**
     * Obtiene el valor de la propiedad condicionCedulado.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCondicionCedulado() {
        return condicionCedulado;
    }

    /**
     * Define el valor de la propiedad condicionCedulado.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCondicionCedulado(String value) {
        this.condicionCedulado = value;
    }

    /**
     * Obtiene el valor de la propiedad datosCiudadano.
     * 
     * @return
     *     possible object is
     *     {@link CitizenData }
     *     
     */
    public CitizenData getDatosCiudadano() {
        return datosCiudadano;
    }

    /**
     * Define el valor de la propiedad datosCiudadano.
     * 
     * @param value
     *     allowed object is
     *     {@link CitizenData }
     *     
     */
    public void setDatosCiudadano(CitizenData value) {
        this.datosCiudadano = value;
    }

    /**
     * Obtiene el valor de la propiedad descripcionResp.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescripcionResp() {
        return descripcionResp;
    }

    /**
     * Define el valor de la propiedad descripcionResp.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescripcionResp(String value) {
        this.descripcionResp = value;
    }

    /**
     * Obtiene el valor de la propiedad nombreCompleto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    /**
     * Define el valor de la propiedad nombreCompleto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreCompleto(String value) {
        this.nombreCompleto = value;
    }

    /**
     * Obtiene el valor de la propiedad nui.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNui() {
        return nui;
    }

    /**
     * Define el valor de la propiedad nui.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNui(String value) {
        this.nui = value;
    }

}
