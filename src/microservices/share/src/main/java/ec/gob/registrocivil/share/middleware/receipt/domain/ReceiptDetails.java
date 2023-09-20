
package ec.gob.registrocivil.share.middleware.receipt.domain;

import java.math.BigDecimal;


/**
 * <p>Clase Java para detalleComprobante complex type.
 *
 */

public class ReceiptDetails {

    protected Integer pkCodigoDeta;
    protected String codigoPrincipal;
    protected String descripcion;
    protected BigDecimal cantidad;
    protected BigDecimal precio;
    protected BigDecimal descuentoDetalle;
    protected BigDecimal totalDetalle;
    protected BigDecimal porcentajeIva;
    protected String aplicaNc;

    public ReceiptDetails(Integer pkCodigoDeta, String codigoPrincipal, String descripcion, BigDecimal cantidad, BigDecimal precio,
                          BigDecimal descuentoDetalle, BigDecimal totalDetalle, BigDecimal porcentajeIva, String aplicaNc) {
        this.pkCodigoDeta = pkCodigoDeta;
        this.codigoPrincipal = codigoPrincipal;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precio = precio;
        this.descuentoDetalle = descuentoDetalle;
        this.totalDetalle = totalDetalle;
        this.porcentajeIva = porcentajeIva;
        this.aplicaNc = aplicaNc;
    }

    /**
     * Obtiene el valor de la propiedad pkCodigoDeta.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPkCodigoDeta() {
        return pkCodigoDeta;
    }

    /**
     * Define el valor de la propiedad pkCodigoDeta.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPkCodigoDeta(Integer value) {
        this.pkCodigoDeta = value;
    }

    /**
     * Obtiene el valor de la propiedad codigoPrincipal.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoPrincipal() {
        return codigoPrincipal;
    }

    /**
     * Define el valor de la propiedad codigoPrincipal.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoPrincipal(String value) {
        this.codigoPrincipal = value;
    }

    /**
     * Obtiene el valor de la propiedad descripcion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Define el valor de la propiedad descripcion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescripcion(String value) {
        this.descripcion = value;
    }

    /**
     * Obtiene el valor de la propiedad cantidad.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCantidad() {
        return cantidad;
    }

    /**
     * Define el valor de la propiedad cantidad.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCantidad(BigDecimal value) {
        this.cantidad = value;
    }

    /**
     * Obtiene el valor de la propiedad precio.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPrecio() {
        return precio;
    }

    /**
     * Define el valor de la propiedad precio.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPrecio(BigDecimal value) {
        this.precio = value;
    }

    /**
     * Obtiene el valor de la propiedad descuentoDetalle.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDescuentoDetalle() {
        return descuentoDetalle;
    }

    /**
     * Define el valor de la propiedad descuentoDetalle.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDescuentoDetalle(BigDecimal value) {
        this.descuentoDetalle = value;
    }

    /**
     * Obtiene el valor de la propiedad totalDetalle.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTotalDetalle() {
        return totalDetalle;
    }

    /**
     * Define el valor de la propiedad totalDetalle.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTotalDetalle(BigDecimal value) {
        this.totalDetalle = value;
    }

    /**
     * Obtiene el valor de la propiedad porcentajeIva.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPorcentajeIva() {
        return porcentajeIva;
    }

    /**
     * Define el valor de la propiedad porcentajeIva.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPorcentajeIva(BigDecimal value) {
        this.porcentajeIva = value;
    }

    /**
     * Obtiene el valor de la propiedad aplicaNc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAplicaNc() {
        return aplicaNc;
    }

    /**
     * Define el valor de la propiedad aplicaNc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAplicaNc(String value) {
        this.aplicaNc = value;
    }

}
