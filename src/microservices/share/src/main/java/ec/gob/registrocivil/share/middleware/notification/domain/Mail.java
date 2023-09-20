
package ec.gob.registrocivil.share.middleware.notification.domain;


import java.util.ArrayList;
import java.util.List;


/**
 * <p>Clase Java para enviarMail complex type.
 * 
 */
public class Mail {
    
    private String codigoEmail;
    
    private String nombreOrigen;
    
    private String emailOrigen;
    
    private List<MailTo> datosDestino;

    private List<MailCc> datosCC;
    
    private String asunto;
    
    private String emailCuerpo;

    public Mail(String codigoEmail, String nombreOrigen, String emailOrigen, List<MailTo> datosDestino,
                List<MailCc> datosCC, String asunto, String emailCuerpo) {
        this.codigoEmail = codigoEmail;
        this.nombreOrigen = nombreOrigen;
        this.emailOrigen = emailOrigen;
        this.datosDestino = datosDestino;
        this.datosCC = datosCC;
        this.asunto = asunto;
        this.emailCuerpo = emailCuerpo;
    }

    /**
     * Obtiene el valor de la propiedad codigoEmail.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoEmail() {
        return codigoEmail;
    }

    /**
     * Define el valor de la propiedad codigoEmail.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoEmail(String value) {
        this.codigoEmail = value;
    }

    /**
     * Obtiene el valor de la propiedad nombreOrigen.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreOrigen() {
        return nombreOrigen;
    }

    /**
     * Define el valor de la propiedad nombreOrigen.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreOrigen(String value) {
        this.nombreOrigen = value;
    }

    /**
     * Obtiene el valor de la propiedad emailOrigen.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmailOrigen() {
        return emailOrigen;
    }

    /**
     * Define el valor de la propiedad emailOrigen.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmailOrigen(String value) {
        this.emailOrigen = value;
    }

    /**
     * Gets the value of the datosDestino property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the datosDestino property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDatosDestino().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MailTo }
     * 
     * 
     */
    public List<MailTo> getDatosDestino() {
        if (datosDestino == null) {
            datosDestino = new ArrayList<MailTo>();
        }
        return this.datosDestino;
    }

    /**
     * Gets the value of the datosCC property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the datosCC property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDatosCC().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MailCc }
     * 
     * 
     */
    public List<MailCc> getDatosCC() {
        if (datosCC == null) {
            datosCC = new ArrayList<MailCc>();
        }
        return this.datosCC;
    }

    /**
     * Obtiene el valor de la propiedad asunto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAsunto() {
        return asunto;
    }

    /**
     * Define el valor de la propiedad asunto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAsunto(String value) {
        this.asunto = value;
    }

    /**
     * Obtiene el valor de la propiedad emailCuerpo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmailCuerpo() {
        return emailCuerpo;
    }

    /**
     * Define el valor de la propiedad emailCuerpo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmailCuerpo(String value) {
        this.emailCuerpo = value;
    }

}
