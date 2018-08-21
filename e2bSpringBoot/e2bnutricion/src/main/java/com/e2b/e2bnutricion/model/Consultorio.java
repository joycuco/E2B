package com.e2b.e2bnutricion.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "consultorio")
public class Consultorio {
    @Id
    @Column(name = "id_consultorio")
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long idConsultorio;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "fb")
    private String fb;

    @Column(name = "twitter")
    private String tw;

    @Column(name = "estatus")
    private String estatus;

    @Column(name = "fecha_apertura")
    private Date fechaApertura;

    //@ManyToOne
    //@JoinColumn(name = "id_empleado")
    //private Empleado encargado;

    @OneToMany(mappedBy = "consultorio")
    private Set<Empleado> empleados;

    public Consultorio() {
        super();
    }

    public Consultorio(String direccion, String telefono, String fb, String tw, String estatus, Date fechaApertura) {
        super();
        this.direccion = direccion;
        this.telefono = telefono;
        this.fb = fb;
        this.tw = tw;
        this.estatus = estatus;
        this.fechaApertura = fechaApertura;
    }

    public Set<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Set<Empleado> empleados) {
        this.empleados = empleados;
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
}
