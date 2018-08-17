package com.e2b.consulta;

import java.util.Set;

public class Usuario {
    private Long idUsuario;
    private String usuario;
    private String password;
    private PermisoRol permisoRol;

    private Set<Empleado> empleados;

    public Usuario() {
    }

    public Usuario(Long idUsuario, String usuario, String password, PermisoRol permisoRol) {
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.password = password;
        this.permisoRol = permisoRol;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public Set<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Set<Empleado> empleados) {
        this.empleados = empleados;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public PermisoRol getPermisoRol() {
        return permisoRol;
    }

    public void setPermisoRol(PermisoRol permisoRol) {
        this.permisoRol = permisoRol;
    }
}
