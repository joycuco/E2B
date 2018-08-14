package com.e2b.consulta;

import java.util.Set;

public class Paquete {
    private Long idPaquete;
    private String nombre;
    private Float precio;
    private Set<Producto> productos;
    private Set<Servicio> servicios;

    public Paquete() {
    }

    public Paquete(Long idPaquete, String nombre, Float precio, Set<Producto> productos, Set<Servicio> servicios) {
        this.idPaquete = idPaquete;
        this.nombre = nombre;
        this.precio = precio;
        this.productos = productos;
        this.servicios = servicios;
    }

    public Long getIdPaquete() {
        return idPaquete;
    }

    public void setIdPaquete(Long idPaquete) {
        this.idPaquete = idPaquete;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public Set<Producto> getProductos() {
        return productos;
    }

    public void setProductos(Set<Producto> productos) {
        this.productos = productos;
    }

    public Set<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(Set<Servicio> servicios) {
        this.servicios = servicios;
    }
}
