package com.e2b.e2bnutricion.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "detalle_venta_paquete")
public class DetalleVentaPaquete implements Serializable {

    @Id
    @Column(name = "id_detalle_venta_paquete")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDetalleVentaPaquete;

    @Column(name = "descuento")
    private Float descuento;

    @Column(name = "cantidad")
    private int cantidad;

    @Column(name = "costo")
    private Float total;

    @ManyToOne
    @JoinColumn(name = "id_paquete")
    private Paquete paquete;

    @ManyToOne
    @JoinColumn(name = "id_venta")
    private Venta venta;

    public DetalleVentaPaquete() {
        super();
    }

    public DetalleVentaPaquete(Float descuento, int cantidad, Float total, Venta venta) {
        super();
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
