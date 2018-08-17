package com.e2b.consulta;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "antecedentes_familiares")

public class AntecedenteFamiliar implements Serializable {

    @Id
    @Column(name = "id_antecedentes_familiares")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAntecedenteFamiliar;

    @Column(name = "notas")
    private String notas;

    @ManyToOne
    @JoinColumn(name = "id_paciente")
    private Paciente paciente;

    @OneToMany(mappedBy = "antecedenteFamiliar")
    private Set<Familiar> familiares;


    @OneToMany(mappedBy = "antecedenteFamiliar")
    private Set<Enfermedad> enfermedades;

    public AntecedenteFamiliar() {
        super();
    }

    public AntecedenteFamiliar(Long idAntecedenteFamiliar, String notas, Paciente paciente, Set<Familiar> familiares, Set<Enfermedad> enfermedades) {
        this.idAntecedenteFamiliar = idAntecedenteFamiliar;
        this.notas = notas;
        this.paciente = paciente;
        this.familiares = familiares;
        this.enfermedades = enfermedades;
    }

    public Long getIdAntecedenteFamiliar() {
        return idAntecedenteFamiliar;
    }

    public void setIdAntecedenteFamiliar(Long idAntecedenteFamiliar) {
        this.idAntecedenteFamiliar = idAntecedenteFamiliar;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Set<Familiar> getFamiliares() {
        return familiares;
    }

    public void setFamiliares(Set<Familiar> familiares) {
        this.familiares = familiares;
    }

    public Set<Enfermedad> getEnfermedades() {
        return enfermedades;
    }

    public void setEnfermedades(Set<Enfermedad> enfermedades) {
        this.enfermedades = enfermedades;
    }
}
