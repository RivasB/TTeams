
package ec.gob.registrocivil.share.middleware.receipt.domain;

/**
 * <p>Clase Java para sriComprobante complex type.

 */

public class SriReceipt {

    protected Integer pkCodigoSrico;
    protected String estadoSrico;
    protected String mensaje;
    protected String xml;

    /**
     * Obtiene el valor de la propiedad pkCodigoSrico.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPkCodigoSrico() {
        return pkCodigoSrico;
    }

    /**
     * Define el valor de la propiedad pkCodigoSrico.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPkCodigoSrico(Integer value) {
        this.pkCodigoSrico = value;
    }

    /**
     * Obtiene el valor de la propiedad estadoSrico.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstadoSrico() {
        return estadoSrico;
    }

    /**
     * Define el valor de la propiedad estadoSrico.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstadoSrico(String value) {
        this.estadoSrico = value;
    }

    /**
     * Obtiene el valor de la propiedad mensaje.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * Define el valor de la propiedad mensaje.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMensaje(String value) {
        this.mensaje = value;
    }

    /**
     * Obtiene el valor de la propiedad xml.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXml() {
        return xml;
    }

    /**
     * Define el valor de la propiedad xml.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXml(String value) {
        this.xml = value;
    }

}
