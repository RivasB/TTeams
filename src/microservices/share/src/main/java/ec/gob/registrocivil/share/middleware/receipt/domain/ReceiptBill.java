package ec.gob.registrocivil.share.middleware.receipt.domain;

import java.math.BigDecimal;
import java.util.List;

public class ReceiptBill {
    private BigDecimal compensacion;
    private BigDecimal descuento;
    private List<BillDetails> detalleComprobanteList;
    private String establecimiento;
    private String formaPago;
    private Long idAgencia;
    private String ip;
    private BigDecimal iva;
    private String nuiCliente;
    private String pedido;
    private String puntoEmision;
    private BigDecimal subtotal;
    private BigDecimal subtotal0;
    private BigDecimal total;
    private String usuario;

    public ReceiptBill(BigDecimal compensacion, BigDecimal descuento, List<BillDetails> detalleComprobanteList,
            String establecimiento, String formaPago, Long idAgencia, String ip, BigDecimal iva, String nuiCliente, 
            String pedido, String puntoEmision, BigDecimal subtotal, BigDecimal subtotal0, BigDecimal total, String usuario) {
        this.compensacion = compensacion;
        this.descuento = descuento;
        this.detalleComprobanteList = detalleComprobanteList;
        this.establecimiento = establecimiento;
        this.formaPago = formaPago;
        this.idAgencia = idAgencia;
        this.ip = ip;
        this.iva = iva;
        this.nuiCliente = nuiCliente;
        this.pedido = pedido;
        this.puntoEmision = puntoEmision;
        this.subtotal = subtotal;
        this.subtotal0 = subtotal0;
        this.total = total;
        this.usuario = usuario;
    }

    public BigDecimal getCompensacion() {
        return compensacion;
    }

    public BigDecimal getDescuento() {
        return descuento;
    }

    public List<BillDetails> getDetalleComprobanteList() {
        return detalleComprobanteList;
    }

    public String getEstablecimiento() {
        return establecimiento;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public Long getIdAgencia() {
        return idAgencia;
    }

    public String getIp() {
        return ip;
    }

    public BigDecimal getIva() {
        return iva;
    }

    public String getNuiCliente() {
        return nuiCliente;
    }

    public String getPedido() {
        return pedido;
    }

    public String getPuntoEmision() {
        return puntoEmision;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public BigDecimal getSubtotal0() {
        return subtotal0;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public String getUsuario() {
        return usuario;
    }

}
