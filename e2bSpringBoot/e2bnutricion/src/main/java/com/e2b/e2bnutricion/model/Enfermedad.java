package com.e2b.e2bnutricion.model;

import javax.persistence.*;

@Entity
@Table(name = "enfermedad")
public class Enfermedad {
    @Id
    @Column(name = "id_enfermedad")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEnfermedad;

    @Column(name = "nombre")
    private String nombre;

    @OneToOne
    @JoinColumn(name = "id_antecedentes_familiares")
    private AntecedenteFamiliar antecedenteFamiliar;

    public Enfermedad() {
        super();
    }

    public Enfermedad(String nombre, AntecedenteFamiliar antecedenteFamiliar) {
        super();
        this.nombre = nombre;
        this.antecedenteFamiliar = antecedenteFamiliar;
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
