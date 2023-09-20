
package ec.gob.registrocivil.share.middleware.receipt.domain;

/**
 * <p>Clase Java para establecimientoPK complex type.

 * 
 */
public class EstablishmentPK {

    private Long idAgencia;
    private String numeroEstablecimiento;

    public EstablishmentPK(Long idAgencia, String numeroEstablecimiento) {
        this.idAgencia = idAgencia;
        this.numeroEstablecimiento = numeroEstablecimiento;
    }

    /**
     * Obtiene el valor de la propiedad idAgencia.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdAgencia() {
        return idAgencia;
    }

    /**
     * Define el valor de la propiedad idAgencia.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdAgencia(Long value) {
        this.idAgencia = value;
    }

    /**
     * Obtiene el valor de la propiedad numeroEstablecimiento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroEstablecimiento() {
        return numeroEstablecimiento;
    }

    /**
     * Define el valor de la propiedad numeroEstablecimiento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroEstablecimiento(String value) {
        this.numeroEstablecimiento = value;
    }

}
