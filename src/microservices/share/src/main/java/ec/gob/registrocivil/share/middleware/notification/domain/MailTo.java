
package ec.gob.registrocivil.share.middleware.notification.domain;

/**
 * <p>Clase Java para datosDestino complex type.
 * 
 */

public class MailTo {

    protected String emailDestino;
    protected String nombreDestino;

    public MailTo(String emailDestino, String nombreDestino) {
        this.emailDestino = emailDestino;
        this.nombreDestino = nombreDestino;
    }

    /**
     * Obtiene el valor de la propiedad emailDestino.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmailDestino() {
        return emailDestino;
    }

    /**
     * Define el valor de la propiedad emailDestino.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmailDestino(String value) {
        this.emailDestino = value;
    }

    /**
     * Obtiene el valor de la propiedad nombreDestino.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreDestino() {
        return nombreDestino;
    }

    /**
     * Define el valor de la propiedad nombreDestino.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreDestino(String value) {
        this.nombreDestino = value;
    }

}
