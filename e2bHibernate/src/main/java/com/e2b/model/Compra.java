package com.e2b.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "compra")

public class Compra implements Serializable {

    @Id
    @Column(name = "id_compra")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCompra;

    @Column(name = "gasto")
    private Float gasto;

    @Column(name = "tipo_pago")
    private String tipoPago;

    @ManyToOne
    @JoinColumn(name = "id_empleado")
    private Empleado empleado;

    public Compra() {
        super();
    }

    public Compra( Float gasto, String tipoPago, Empleado empleado) {
        super();
        this.gasto = gasto;
        this.tipoPago = tipoPago;
        this.empleado = empleado;
    }

    public Long getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Long idCompra) {
        this.idCompra = idCompra;
    }

    public Float getGasto() {
        return gasto;
    }

    public void setGasto(Float gasto) {
        this.gasto = gasto;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
}
