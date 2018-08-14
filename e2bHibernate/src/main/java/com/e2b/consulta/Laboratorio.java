package com.e2b.consulta;

public class Laboratorio {

    private Long idLaboratorio;
    private String nombre;
    private String detalle;

    public Laboratorio() {
    }

    public Laboratorio(Long idLaboratorio, String nombre, String detalle) {
        this.idLaboratorio = idLaboratorio;
        this.nombre = nombre;
        this.detalle = detalle;
    }

    public Long getIdLaboratorio() {
        return idLaboratorio;
    }

    public void setIdLaboratorio(Long idLaboratorio) {
        this.idLaboratorio = idLaboratorio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
}
