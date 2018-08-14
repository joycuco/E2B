package com.e2b.consulta;

public class DetalleVentaServicio {


    private Long idDetalleVentaServicio;
    private Float descuento;
    private Float total;

    private Venta venta;

    public DetalleVentaServicio() {
    }

    public DetalleVentaServicio(Long idDetalleVentaServicio, Float descuento, Float total, Venta venta) {
        this.idDetalleVentaServicio = idDetalleVentaServicio;
        this.descuento = descuento;
        this.total = total;
        this.venta = venta;
    }

    public Long getIdDetalleVentaServicio() {
        return idDetalleVentaServicio;
    }

    public void setIdDetalleVentaServicio(Long idDetalleVentaServicio) {
        this.idDetalleVentaServicio = idDetalleVentaServicio;
    }

    public Float getDescuento() {
        return descuento;
    }

    public void setDescuento(Float descuento) {
        this.descuento = descuento;
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
