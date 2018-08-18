package com.e2b.consulta;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "laboratorio")
public class Laboratorio implements Serializable{

	@Id
	@Column(name = "id_laboratorio")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLaboratorio;
	
	@Column(name = "nombre")
    private String nombre;
	
	@Column(name = "detalle")
    private String detalle;

    public Laboratorio() {
		super();
    }

    public Laboratorio(Long idLaboratorio, String nombre, String detalle) {
		super();
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
