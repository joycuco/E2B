package com.e2b.consulta;

public class DetalleVentaProducto {

    private Long idDetalleVentaProducto;
    private Float descuento;
    private int cantidad;
    private Float total;

    private Venta venta;
    private Producto producto;

    public DetalleVentaProducto() {
    }

    public DetalleVentaProducto(Long idDetalleVentaProducto, Float descuento, int cantidad, Float total, Venta venta, Producto producto) {
        this.idDetalleVentaProducto = idDetalleVentaProducto;
        this.descuento = descuento;
        this.cantidad = cantidad;
        this.total = total;
        this.venta = venta;
        this.producto = producto;
    }

    public Long getIdDetalleVentaProducto() {
        return idDetalleVentaProducto;
    }

    public void setIdDetalleVentaProducto(Long idDetalleVentaProducto) {
        this.idDetalleVentaProducto = idDetalleVentaProducto;
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

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
