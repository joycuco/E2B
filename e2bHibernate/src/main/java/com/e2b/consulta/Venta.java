package com.e2b.consulta;

import java.util.Date;
import java.util.Set;

public class Venta {
    private Long idVenta;
    private Double total;
    private String tipoPago;
    private Date fechaVenta;
    private Paciente paciente;
    private  Empleado empleado;

    private Set<DetalleVentaProducto> productos;
    private Set<DetalleVentaServicio> servicios;
    private Set<DetalleVentaPaquete> paquetes;

    public Venta() {
    }

    public Venta(Long idVenta, Double total, String tipoPago, Date fechaVenta, Paciente paciente, Empleado empleado, Set<DetalleVentaProducto> productos, Set<DetalleVentaServicio> servicios, Set<DetalleVentaPaquete> paquetes) {
        this.idVenta = idVenta;
        this.total = total;
        this.tipoPago = tipoPago;
        this.fechaVenta = fechaVenta;
        this.paciente = paciente;
        this.empleado = empleado;
        this.productos = productos;
        this.servicios = servicios;
        this.paquetes = paquetes;
    }

    public Long getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Long idVenta) {
        this.idVenta = idVenta;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Set<DetalleVentaProducto> getProductos() {
        return productos;
    }

    public void setProductos(Set<DetalleVentaProducto> productos) {
        this.productos = productos;
    }

    public Set<DetalleVentaServicio> getServicios() {
        return servicios;
    }

    public void setServicios(Set<DetalleVentaServicio> servicios) {
        this.servicios = servicios;
    }

    public Set<DetalleVentaPaquete> getPaquetes() {
        return paquetes;
    }

    public void setPaquetes(Set<DetalleVentaPaquete> paquetes) {
        this.paquetes = paquetes;
    }
}
