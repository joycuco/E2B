package com.e2b.consulta;

public class Compra {
    private Long idCompra;
    private Float gasto;
    private String tipoPago;
    private Empleado empleado;

    public Compra() {
    }

    public Compra(Long idCompra, Float gasto, String tipoPago, Empleado empleado) {
        this.idCompra = idCompra;
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
