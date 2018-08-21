package com.e2b.e2bnutricion.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "detalle_venta_producto")
public class DetalleVentaProducto implements Serializable {

    @Id
    @Column(name = "id_detalle_venta_producto")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDetalleVentaProducto;

    @Column(name = "descuento")
    private Float descuento;

    @Column(name = "cantidad")
    private int cantidad;

    @Column(name = "costo")
    private Float total;

    @ManyToOne
    @JoinColumn(name = "id_venta")
    private Venta venta;

    @ManyToOne(optional = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_producto")
    private Producto producto;

    public DetalleVentaProducto() {
        super();
    }

    public DetalleVentaProducto(Float descuento, int cantidad, Float total, Venta venta, Producto producto) {
        super();
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
