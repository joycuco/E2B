package com.e2b.consulta;

import java.util.Set;

public class Empleado {

    private Long idEmpleado;
    private String nombre;
    private String direccion;
    private String telCasa;
    private String telCel;
    private String correo;
    private String puesto;
    private String estatus;

    private Consultorio consultorio;
    private Set<Usuario> usuarios;

    public Empleado() {
        super();
    }

    public Empleado(Long idEmpleado, String nombre, String direccion, String telCasa, String telCel, String correo, String puesto, String estatus, Set<Usuario> usuarios) {
        super();
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telCasa = telCasa;
        this.telCel = telCel;
        this.correo = correo;
        this.puesto = puesto;
        this.estatus = estatus;
        this.usuarios = usuarios;
    }

    public Long getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Long idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelCasa() {
        return telCasa;
    }

    public void setTelCasa(String telCasa) {
        this.telCasa = telCasa;
    }

    public String getTelCel() {
        return telCel;
    }

    public void setTelCel(String telCel) {
        this.telCel = telCel;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public Set<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Set<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
