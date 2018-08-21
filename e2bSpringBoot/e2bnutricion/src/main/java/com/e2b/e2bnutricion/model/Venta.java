package com.e2b.e2bnutricion.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "venta")
public class Venta implements Serializable{
	
	@Id
	@Column(name = "id_venta")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVenta;
	
	@Column(name = "total")
    private Double total;
	
	@Column(name = "tipo_pago")
    private String tipoPago;
	
	@Column(name = "fecha_venta")
    private Date fechaVenta;
	
	@ManyToOne
	@JoinColumn(name = "id_paciente")
    private Paciente paciente;
	
	@ManyToOne
	@JoinColumn(name = "id_empleado")
    private  Empleado empleado;

	@OneToMany(mappedBy = "venta")
    private Set<DetalleVentaProducto> productos;

    @OneToMany(mappedBy = "venta")
    private Set<DetalleVentaServicio> servicios;

    @OneToMany(mappedBy = "venta")
    private Set<DetalleVentaPaquete> paquetes;

    public Venta() {
        super();
    }

    public Venta( Double total, String tipoPago, Date fechaVenta) {
        super();
        this.total = total;
        this.tipoPago = tipoPago;
        this.fechaVenta = fechaVenta;
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
