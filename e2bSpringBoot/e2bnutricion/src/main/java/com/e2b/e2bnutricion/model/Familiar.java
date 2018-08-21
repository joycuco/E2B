package com.e2b.e2bnutricion.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "familiar")
public class Familiar implements Serializable{

	@Id
	@Column(name = "id_familiar")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFamiliar;
	
	@Column(name = "parentesco")
    private String parentesco;

    @OneToOne
    @JoinColumn(name = "id_antecedentes_familiares")
    private AntecedenteFamiliar antecedenteFamiliar;

    public Familiar() {
		super();
    }

    public Familiar(String parentesco) {
		super();
        this.parentesco = parentesco;
    }

    public Long getIdFamiliar() {
        return idFamiliar;
    }

    public void setIdFamiliar(Long idFamiliar) {
        this.idFamiliar = idFamiliar;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }
}