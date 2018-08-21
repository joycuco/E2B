package com.e2b.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "detalle_venta_servicio")
public class DetalleVentaServicio implements Serializable {

    @Id
    @Column(name = "id_detalle_venta_servicio")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDetalleVentaServicio;

    @Column(name = "descuento")
    private Float descuento;

    @Column(name = "costo")
    private Float total;

    @ManyToOne
    @JoinColumn(name = "id_venta")
    private Venta venta;

    public DetalleVentaServicio() {
        super();
    }

    public DetalleVentaServicio( Float descuento, Float total, Venta venta) {
        super();
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
