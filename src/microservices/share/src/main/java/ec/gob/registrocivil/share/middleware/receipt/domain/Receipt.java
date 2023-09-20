
package ec.gob.registrocivil.share.middleware.receipt.domain;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Clase Java para comprobante complex type.
 *
 */

public class Receipt {

    private String claveAcceso;
    private Client cliente;
    private String codigoDocuMod;
    private String codigoDocumento;
    private BigDecimal compensacion;
    private BigDecimal descuento;
    private List<ReceiptDetails> detalleComprobanteList;
    private String establecimiento;
    private Establishment establecimientoObj;
    private String estado;
    private XMLGregorianCalendar fechaAutorizacion;
    private XMLGregorianCalendar fechaEmision;
    private XMLGregorianCalendar fechaEmisionMod;
    private XMLGregorianCalendar fechaSistema;
    private String formaPago;
    private long idAgencia;
    private String identificacionCli;
    private String ipGenera;
    private BigDecimal iva;
    private String motivo;
    private String nombreAgencia;
    private String nombreCli;
    private String numAutorizacion;
    private String numDocuMod;
    private Integer numIntentosEnvio;
    private String pedido;
    private String periodo;
    private Integer pkCodigoComp;
    private String puntoEmision;
    private String secuencial;
    private List<SriReceipt> sriComprobanteList;
    private BigDecimal subtotal;
    private BigDecimal subtotal0;
    private BigDecimal total;
    private String usuario;
    private BigDecimal valorMod;
    private String xmlComp;

    public Receipt(String claveAcceso, Client cliente, String codigoDocuMod, String codigoDocumento, BigDecimal compensacion, BigDecimal descuento,
                   List<ReceiptDetails> detalleComprobanteList, String establecimiento, Establishment establecimientoObj, String estado,
                   XMLGregorianCalendar fechaAutorizacion, XMLGregorianCalendar fechaEmision, XMLGregorianCalendar fechaEmisionMod,
                   XMLGregorianCalendar fechaSistema, String formaPago, long idAgencia, String identificacionCli, String ipGenera,
                   BigDecimal iva, String motivo, String nombreAgencia, String nombreCli, String numAutorizacion, String numDocuMod,
                   Integer numIntentosEnvio, String pedido, String periodo, Integer pkCodigoComp, String puntoEmision, String secuencial,
                   List<SriReceipt> sriComprobanteList, BigDecimal subtotal, BigDecimal subtotal0, BigDecimal total, String usuario, BigDecimal
                           valorMod, String xmlComp) {
        this.claveAcceso = claveAcceso;
        this.cliente = cliente;
        this.codigoDocuMod = codigoDocuMod;
        this.codigoDocumento = codigoDocumento;
        this.compensacion = compensacion;
        this.descuento = descuento;
        this.detalleComprobanteList = detalleComprobanteList;
        this.establecimiento = establecimiento;
        this.establecimientoObj = establecimientoObj;
        this.estado = estado;
        this.fechaAutorizacion = fechaAutorizacion;
        this.fechaEmision = fechaEmision;
        this.fechaEmisionMod = fechaEmisionMod;
        this.fechaSistema = fechaSistema;
        this.formaPago = formaPago;
        this.idAgencia = idAgencia;
        this.identificacionCli = identificacionCli;
        this.ipGenera = ipGenera;
        this.iva = iva;
        this.motivo = motivo;
        this.nombreAgencia = nombreAgencia;
        this.nombreCli = nombreCli;
        this.numAutorizacion = numAutorizacion;
        this.numDocuMod = numDocuMod;
        this.numIntentosEnvio = numIntentosEnvio;
        this.pedido = pedido;
        this.periodo = periodo;
        this.pkCodigoComp = pkCodigoComp;
        this.puntoEmision = puntoEmision;
        this.secuencial = secuencial;
        this.sriComprobanteList = sriComprobanteList;
        this.subtotal = subtotal;
        this.subtotal0 = subtotal0;
        this.total = total;
        this.usuario = usuario;
        this.valorMod = valorMod;
        this.xmlComp = xmlComp;
    }

    /**
     * Obtiene el valor de la propiedad claveAcceso.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClaveAcceso() {
        return claveAcceso;
    }

    /**
     * Define el valor de la propiedad claveAcceso.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClaveAcceso(String value) {
        this.claveAcceso = value;
    }

    /**
     * Obtiene el valor de la propiedad cliente.
     * 
     * @return
     *     possible object is
     *     {@link Client }
     *     
     */
    public Client getCliente() {
        return cliente;
    }

    /**
     * Define el valor de la propiedad cliente.
     * 
     * @param value
     *     allowed object is
     *     {@link Client }
     *     
     */
    public void setCliente(Client value) {
        this.cliente = value;
    }

    /**
     * Obtiene el valor de la propiedad codigoDocuMod.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoDocuMod() {
        return codigoDocuMod;
    }

    /**
     * Define el valor de la propiedad codigoDocuMod.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoDocuMod(String value) {
        this.codigoDocuMod = value;
    }

    /**
     * Obtiene el valor de la propiedad codigoDocumento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoDocumento() {
        return codigoDocumento;
    }

    /**
     * Define el valor de la propiedad codigoDocumento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoDocumento(String value) {
        this.codigoDocumento = value;
    }

    /**
     * Obtiene el valor de la propiedad compensacion.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCompensacion() {
        return compensacion;
    }

    /**
     * Define el valor de la propiedad compensacion.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCompensacion(BigDecimal value) {
        this.compensacion = value;
    }

    /**
     * Obtiene el valor de la propiedad descuento.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDescuento() {
        return descuento;
    }

    /**
     * Define el valor de la propiedad descuento.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDescuento(BigDecimal value) {
        this.descuento = value;
    }

    /**
     * Gets the value of the detalleComprobanteList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the detalleComprobanteList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDetalleComprobanteList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ReceiptDetails }
     * 
     * 
     */
    public List<ReceiptDetails> getDetalleComprobanteList() {
        if (detalleComprobanteList == null) {
            detalleComprobanteList = new ArrayList<ReceiptDetails>();
        }
        return this.detalleComprobanteList;
    }

    /**
     * Obtiene el valor de la propiedad establecimiento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstablecimiento() {
        return establecimiento;
    }

    /**
     * Define el valor de la propiedad establecimiento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstablecimiento(String value) {
        this.establecimiento = value;
    }

    /**
     * Obtiene el valor de la propiedad establecimientoObj.
     * 
     * @return
     *     possible object is
     *     {@link Establishment }
     *     
     */
    public Establishment getEstablecimientoObj() {
        return establecimientoObj;
    }

    /**
     * Define el valor de la propiedad establecimientoObj.
     * 
     * @param value
     *     allowed object is
     *     {@link Establishment }
     *     
     */
    public void setEstablecimientoObj(Establishment value) {
        this.establecimientoObj = value;
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
     * Obtiene el valor de la propiedad fechaAutorizacion.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaAutorizacion() {
        return fechaAutorizacion;
    }

    /**
     * Define el valor de la propiedad fechaAutorizacion.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaAutorizacion(XMLGregorianCalendar value) {
        this.fechaAutorizacion = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaEmision.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaEmision() {
        return fechaEmision;
    }

    /**
     * Define el valor de la propiedad fechaEmision.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaEmision(XMLGregorianCalendar value) {
        this.fechaEmision = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaEmisionMod.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaEmisionMod() {
        return fechaEmisionMod;
    }

    /**
     * Define el valor de la propiedad fechaEmisionMod.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaEmisionMod(XMLGregorianCalendar value) {
        this.fechaEmisionMod = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaSistema.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaSistema() {
        return fechaSistema;
    }

    /**
     * Define el valor de la propiedad fechaSistema.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaSistema(XMLGregorianCalendar value) {
        this.fechaSistema = value;
    }

    /**
     * Obtiene el valor de la propiedad formaPago.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFormaPago() {
        return formaPago;
    }

    /**
     * Define el valor de la propiedad formaPago.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFormaPago(String value) {
        this.formaPago = value;
    }

    /**
     * Obtiene el valor de la propiedad idAgencia.
     * 
     */
    public long getIdAgencia() {
        return idAgencia;
    }

    /**
     * Define el valor de la propiedad idAgencia.
     * 
     */
    public void setIdAgencia(long value) {
        this.idAgencia = value;
    }

    /**
     * Obtiene el valor de la propiedad identificacionCli.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdentificacionCli() {
        return identificacionCli;
    }

    /**
     * Define el valor de la propiedad identificacionCli.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdentificacionCli(String value) {
        this.identificacionCli = value;
    }

    /**
     * Obtiene el valor de la propiedad ipGenera.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIpGenera() {
        return ipGenera;
    }

    /**
     * Define el valor de la propiedad ipGenera.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIpGenera(String value) {
        this.ipGenera = value;
    }

    /**
     * Obtiene el valor de la propiedad iva.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getIva() {
        return iva;
    }

    /**
     * Define el valor de la propiedad iva.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setIva(BigDecimal value) {
        this.iva = value;
    }

    /**
     * Obtiene el valor de la propiedad motivo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMotivo() {
        return motivo;
    }

    /**
     * Define el valor de la propiedad motivo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMotivo(String value) {
        this.motivo = value;
    }

    /**
     * Obtiene el valor de la propiedad nombreAgencia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreAgencia() {
        return nombreAgencia;
    }

    /**
     * Define el valor de la propiedad nombreAgencia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreAgencia(String value) {
        this.nombreAgencia = value;
    }

    /**
     * Obtiene el valor de la propiedad nombreCli.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreCli() {
        return nombreCli;
    }

    /**
     * Define el valor de la propiedad nombreCli.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreCli(String value) {
        this.nombreCli = value;
    }

    /**
     * Obtiene el valor de la propiedad numAutorizacion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumAutorizacion() {
        return numAutorizacion;
    }

    /**
     * Define el valor de la propiedad numAutorizacion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumAutorizacion(String value) {
        this.numAutorizacion = value;
    }

    /**
     * Obtiene el valor de la propiedad numDocuMod.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumDocuMod() {
        return numDocuMod;
    }

    /**
     * Define el valor de la propiedad numDocuMod.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumDocuMod(String value) {
        this.numDocuMod = value;
    }

    /**
     * Obtiene el valor de la propiedad numIntentosEnvio.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumIntentosEnvio() {
        return numIntentosEnvio;
    }

    /**
     * Define el valor de la propiedad numIntentosEnvio.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumIntentosEnvio(Integer value) {
        this.numIntentosEnvio = value;
    }

    /**
     * Obtiene el valor de la propiedad pedido.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPedido() {
        return pedido;
    }

    /**
     * Define el valor de la propiedad pedido.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPedido(String value) {
        this.pedido = value;
    }

    /**
     * Obtiene el valor de la propiedad periodo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPeriodo() {
        return periodo;
    }

    /**
     * Define el valor de la propiedad periodo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPeriodo(String value) {
        this.periodo = value;
    }

    /**
     * Obtiene el valor de la propiedad pkCodigoComp.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPkCodigoComp() {
        return pkCodigoComp;
    }

    /**
     * Define el valor de la propiedad pkCodigoComp.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPkCodigoComp(Integer value) {
        this.pkCodigoComp = value;
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
     * Obtiene el valor de la propiedad secuencial.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSecuencial() {
        return secuencial;
    }

    /**
     * Define el valor de la propiedad secuencial.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSecuencial(String value) {
        this.secuencial = value;
    }

    /**
     * Gets the value of the sriComprobanteList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the sriComprobanteList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSriComprobanteList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SriReceipt }
     * 
     * 
     */
    public List<SriReceipt> getSriComprobanteList() {
        if (sriComprobanteList == null) {
            sriComprobanteList = new ArrayList<SriReceipt>();
        }
        return this.sriComprobanteList;
    }

    /**
     * Obtiene el valor de la propiedad subtotal.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSubtotal() {
        return subtotal;
    }

    /**
     * Define el valor de la propiedad subtotal.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSubtotal(BigDecimal value) {
        this.subtotal = value;
    }

    /**
     * Obtiene el valor de la propiedad subtotal0.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSubtotal0() {
        return subtotal0;
    }

    /**
     * Define el valor de la propiedad subtotal0.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSubtotal0(BigDecimal value) {
        this.subtotal0 = value;
    }

    /**
     * Obtiene el valor de la propiedad total.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTotal() {
        return total;
    }

    /**
     * Define el valor de la propiedad total.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTotal(BigDecimal value) {
        this.total = value;
    }

    /**
     * Obtiene el valor de la propiedad usuario.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Define el valor de la propiedad usuario.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsuario(String value) {
        this.usuario = value;
    }

    /**
     * Obtiene el valor de la propiedad valorMod.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getValorMod() {
        return valorMod;
    }

    /**
     * Define el valor de la propiedad valorMod.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setValorMod(BigDecimal value) {
        this.valorMod = value;
    }

    /**
     * Obtiene el valor de la propiedad xmlComp.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXmlComp() {
        return xmlComp;
    }

    /**
     * Define el valor de la propiedad xmlComp.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXmlComp(String value) {
        this.xmlComp = value;
    }

}
