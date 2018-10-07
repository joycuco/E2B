package com.e2bnutrition.e2bbackend.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "receta")
public class Receta implements Serializable{
	
	@Id
	@Column(name = "id_receta")
	@GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long idReceta;
	
	@Column(name = "nombre")
    private String nombre;
	
	@Column(name = "ingredientes")
    private String ingredientes;
	
	@Column(name = "info_nutrimental")
    private String infoNutrimental;
	
	@Column(name = "verduras")
    private float verduras;
	
	@Column(name = "carnes")
    private float cernes;
	
	@Column(name = "aceites")
    private float aceites;
	
	@Column(name = "semillas")
    private float semillas;

    public Receta() {
		super();
    }

    public Receta(String nombre, String ingredientes, String infoNutrimental, float verduras, float cernes, float aceites, float semillas) {
        super();
        this.nombre = nombre;
        this.ingredientes = ingredientes;
        this.infoNutrimental = infoNutrimental;
        this.verduras = verduras;
        this.cernes = cernes;
        this.aceites = aceites;
        this.semillas = semillas;
    }

    public Long getIdReceta() {
        return idReceta;
    }

    public void setIdReceta(Long idReceta) {
        this.idReceta = idReceta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getInfoNutrimental() {
        return infoNutrimental;
    }

    public void setInfoNutrimental(String infoNutrimental) {
        this.infoNutrimental = infoNutrimental;
    }

    public float getVerduras() {
        return verduras;
    }

    public void setVerduras(float verduras) {
        this.verduras = verduras;
    }

    public float getCernes() {
        return cernes;
    }

    public void setCernes(float cernes) {
        this.cernes = cernes;
    }

    public float getAceites() {
        return aceites;
    }

    public void setAceites(float aceites) {
        this.aceites = aceites;
    }

    public float getSemillas() {
        return semillas;
    }

    public void setSemillas(float semillas) {
        this.semillas = semillas;
    }
}
