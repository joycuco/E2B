package com.e2bnutrition.e2bbackend.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "enfermedad")
public class Enfermedad implements Serializable{

	@Id
	@Column(name = "id_enfermedad")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEnfermedad;
	
	@Column(name = "nombre")
    private String nombre;
	
	@Column(name = "detalle")
    private String detalle;

    public Enfermedad() {
		super();
    }

    public Enfermedad( String nombre, String detalle) {
		super();
        this.nombre = nombre;
        this.detalle = detalle;
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

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
}
