package ec.gob.registrocivil.share.middleware.receipt.domain;

import java.math.BigDecimal;

public class BillDetails {
    private BigDecimal cantidad;
    private String codigoAuxiliar;
    private String codigoPrincipal;
    private String descripcion;
    private BigDecimal descuentoDetalle;
    private BigDecimal porcentajeIva;
    private BigDecimal precio;
    private BigDecimal totalDetalle;

    public BillDetails(BigDecimal cantidad, String codigoAuxiliar, String codigoPrincipal,
            String descripcion, BigDecimal descuentoDetalle, BigDecimal porcentajeIva, BigDecimal precio, BigDecimal totalDetalle) {
        this.cantidad = cantidad;
        this.codigoAuxiliar = codigoAuxiliar;
        this.codigoPrincipal = codigoPrincipal;
        this.descripcion = descripcion;
        this.descuentoDetalle = descuentoDetalle;
        this.porcentajeIva = porcentajeIva;
        this.precio = precio;
        this.totalDetalle = totalDetalle;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public String getCodigoAuxiliar() {
        return codigoAuxiliar;
    }

    public String getCodigoPrincipal() {
        return codigoPrincipal;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public BigDecimal getDescuentoDetalle() {
        return descuentoDetalle;
    }

    public BigDecimal getPorcentajeIva() {
        return porcentajeIva;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public BigDecimal getTotalDetalle() {
        return totalDetalle;
    }
    
}
