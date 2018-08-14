package com.e2b.consulta;

public class Enfermedad {
    private Long idEnfermedad;
    private String nombre;

    public Enfermedad() {
    }

    public Enfermedad(Long idEnfermedad, String nombre) {
        this.idEnfermedad = idEnfermedad;
        this.nombre = nombre;
    }

    public Long getIdEnfermedad() {
        return idEnfermedad;
    }

    public void setIdEnfermedad(Long idEnfermedad) {
        this.idEnfermedad = idEnfermedad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
