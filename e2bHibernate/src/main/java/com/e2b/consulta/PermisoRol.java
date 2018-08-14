package com.e2b.consulta;

public class PermisoRol {
    private Long idPermisoRol;
    private Permiso permiso;
    private Rol rol;

    public PermisoRol() {
    }

    public PermisoRol(Long idPermisoRol, Permiso permiso, Rol rol) {
        this.idPermisoRol = idPermisoRol;
        this.permiso = permiso;
        this.rol = rol;
    }

    public Long getIdPermisoRol() {
        return idPermisoRol;
    }

    public void setIdPermisoRol(Long idPermisoRol) {
        this.idPermisoRol = idPermisoRol;
    }

    public Permiso getPermiso() {
        return permiso;
    }

    public void setPermiso(Permiso permiso) {
        this.permiso = permiso;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}
