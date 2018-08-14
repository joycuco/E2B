package com.e2b.consulta;

public class AntecedenteFamiliar {
    private Long idAntecedenteFamiliar;
    private String notas;
    private Paciente paciente;
    private Familiar familiar;
    private Enfermedad enfermedad;

    public AntecedenteFamiliar() {
    }

    public AntecedenteFamiliar(Long idAntecedenteFamiliar, String notas, Paciente paciente, Familiar familiar, Enfermedad enfermedad) {
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
