package com.e2b.consulta;

import javax.persistence.*;
import java.io.Serializable;

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

    @ManyToOne
    @JoinColumn(name = "id_familiar")
    private Familiar familiar;

    @ManyToOne
    @JoinColumn(name = "id_enfermedad")
    private Enfermedad enfermedad;

    public AntecedenteFamiliar() {
        super();
    }

    public AntecedenteFamiliar(Long idAntecedenteFamiliar, String notas, Paciente paciente, Familiar familiar, Enfermedad enfermedad) {
        super();
        this.idAntecedenteFamiliar = idAntecedenteFamiliar;
        this.notas = notas;
        this.paciente = paciente;
        this.familiar = familiar;
        this.enfermedad = enfermedad;
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

    public Familiar getFamiliar() {
        return familiar;
    }

    public void setFamiliar(Familiar familiar) {
        this.familiar = familiar;
    }

    public Enfermedad getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(Enfermedad enfermedad) {
        this.enfermedad = enfermedad;
    }
}
