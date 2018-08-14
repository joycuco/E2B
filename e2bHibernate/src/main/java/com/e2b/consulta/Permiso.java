package com.e2b.consulta;

public class Permiso {
    private Long idPersmiso;
    private String nombre;

    public Permiso() {
    }

    public Permiso(Long idPersmiso, String nombre) {
        this.idPersmiso = idPersmiso;
        this.nombre = nombre;
    }

    public Long getIdPersmiso() {
        return idPersmiso;
    }

    public void setIdPersmiso(Long idPersmiso) {
        this.idPersmiso = idPersmiso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
