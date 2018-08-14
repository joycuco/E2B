package com.e2b.consulta;

public class DetalleVentaPaquete {

    private Long idDetalleVentaPaquete;
    private Float descuento;
    private int cantidad;
    private Float total;

    private Paquete paquete;

    private Venta venta;

    public DetalleVentaPaquete() {
    }

    public DetalleVentaPaquete(Long idDetalleVentaPaquete, Float descuento, int cantidad, Float total, Venta venta) {
        this.idDetalleVentaPaquete = idDetalleVentaPaquete;
        this.descuento = descuento;
        this.cantidad = cantidad;
        this.total = total;
        this.venta = venta;
    }

    public Paquete getPaquete() {
        return paquete;
    }

    public void setPaquete(Paquete paquete) {
        this.paquete = paquete;
    }

    public Long getIdDetalleVentaPaquete() {
        return idDetalleVentaPaquete;
    }

    public void setIdDetalleVentaPaquete(Long idDetalleVentaPaquete) {
        this.idDetalleVentaPaquete = idDetalleVentaPaquete;
    }

    public Float getDescuento() {
        return descuento;
    }

    public void setDescuento(Float descuento) {
        this.descuento = descuento;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }
}
