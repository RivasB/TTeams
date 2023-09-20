
package ec.gob.registrocivil.share.middleware.receipt.domain;

/**
 * <p>Clase Java para Establishment complex type.

 * 
 */
public class Establishment {

    protected String denominacionAgencia;
    protected String direccion;
    protected String estado;
    protected EstablishmentPK id;
    protected String puntoEmision;
    protected int secuencialActual;

    public Establishment(String denominacionAgencia, String direccion, String estado, EstablishmentPK id, String puntoEmision, int secuencialActual) {
        this.denominacionAgencia = denominacionAgencia;
        this.direccion = direccion;
        this.estado = estado;
        this.id = id;
        this.puntoEmision = puntoEmision;
        this.secuencialActual = secuencialActual;
    }

    /**
     * Obtiene el valor de la propiedad denominacionAgencia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDenominacionAgencia() {
        return denominacionAgencia;
    }

    /**
     * Define el valor de la propiedad denominacionAgencia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDenominacionAgencia(String value) {
        this.denominacionAgencia = value;
    }

    /**
     * Obtiene el valor de la propiedad direccion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Define el valor de la propiedad direccion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDireccion(String value) {
        this.direccion = value;
    }

    /**
     * Obtiene el valor de la propiedad estado.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Define el valor de la propiedad estado.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstado(String value) {
        this.estado = value;
    }

    /**
     * Obtiene el valor de la propiedad id.
     * 
     * @return
     *     possible object is
     *     {@link EstablishmentPK }
     *     
     */
    public EstablishmentPK getId() {
        return id;
    }

    /**
     * Define el valor de la propiedad id.
     * 
     * @param value
     *     allowed object is
     *     {@link EstablishmentPK }
     *     
     */
    public void setId(EstablishmentPK value) {
        this.id = value;
    }

    /**
     * Obtiene el valor de la propiedad puntoEmision.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPuntoEmision() {
        return puntoEmision;
    }

    /**
     * Define el valor de la propiedad puntoEmision.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPuntoEmision(String value) {
        this.puntoEmision = value;
    }

    /**
     * Obtiene el valor de la propiedad secuencialActual.
     * 
     */
    public int getSecuencialActual() {
        return secuencialActual;
    }

    /**
     * Define el valor de la propiedad secuencialActual.
     * 
     */
    public void setSecuencialActual(int value) {
        this.secuencialActual = value;
    }

}
