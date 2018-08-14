package com.e2b.consulta;

import java.util.Date;

public class Consultorio {
    private Long idConsultorio;
    private String direccion;
    private String telefono;
    private String fb;
    private String tw;
    private String estatus;
    private Date fechaApertura;

    private Empleado empleado;

    public Consultorio() {
    }

    public Consultorio(Long idConsultorio, String direccion, String telefono, String fb, String tw, String estatus, Date fechaApertura, Empleado empleado) {
        this.idConsultorio = idConsultorio;
        this.direccion = direccion;
        this.telefono = telefono;
        this.fb = fb;
        this.tw = tw;
        this.estatus = estatus;
        this.fechaApertura = fechaApertura;
        this.empleado = empleado;
    }

    public Long getIdConsultorio() {
        return idConsultorio;
    }

    public void setIdConsultorio(Long idConsultorio) {
        this.idConsultorio = idConsultorio;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFb() {
        return fb;
    }

    public void setFb(String fb) {
        this.fb = fb;
    }

    public String getTw() {
        return tw;
    }

    public void setTw(String tw) {
        this.tw = tw;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public Date getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(Date fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
}
