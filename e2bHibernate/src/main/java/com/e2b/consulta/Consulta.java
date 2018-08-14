package com.e2b.consulta;

import java.util.Set;

public class Consulta {

    private Long idConsulta;
    private String complexion;
    private Float peso;
    private Float estatura;
    private Float munieca;
    private Float cadera;
    private Float cintura;
    private Float imc;
    private Float pesoIdeal;

    private Paciente paciente;
    private Dieta dieta;
    private Set<LaboratorioConsulta> laboratoriosConsulta;

    public Consulta() {
    }

    public Consulta(Long idConsulta, String complexion, Float peso, Float estatura, Float munieca, Float cadera, Float cintura, Float imc, Float pesoIdeal, Paciente paciente, Dieta dieta, Set<LaboratorioConsulta> laboratoriosConsulta) {
        this.idConsulta = idConsulta;
        this.complexion = complexion;
        this.peso = peso;
        this.estatura = estatura;
        this.munieca = munieca;
        this.cadera = cadera;
        this.cintura = cintura;
        this.imc = imc;
        this.pesoIdeal = pesoIdeal;
        this.paciente = paciente;
        this.dieta = dieta;
        this.laboratoriosConsulta = laboratoriosConsulta;
    }

    public Long getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(Long idConsulta) {
        this.idConsulta = idConsulta;
    }

    public String getComplexion() {
        return complexion;
    }

    public void setComplexion(String complexion) {
        this.complexion = complexion;
    }

    public Float getPeso() {
        return peso;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
    }

    public Float getEstatura() {
        return estatura;
    }

    public void setEstatura(Float estatura) {
        this.estatura = estatura;
    }

    public Float getMunieca() {
        return munieca;
    }

    public void setMunieca(Float munieca) {
        this.munieca = munieca;
    }

    public Float getCadera() {
        return cadera;
    }

    public void setCadera(Float cadera) {
        this.cadera = cadera;
    }

    public Float getCintura() {
        return cintura;
    }

    public void setCintura(Float cintura) {
        this.cintura = cintura;
    }

    public Float getImc() {
        return imc;
    }

    public void setImc(Float imc) {
        this.imc = imc;
    }

    public Float getPesoIdeal() {
        return pesoIdeal;
    }

    public void setPesoIdeal(Float pesoIdeal) {
        this.pesoIdeal = pesoIdeal;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Dieta getDieta() {
        return dieta;
    }

    public void setDieta(Dieta dieta) {
        this.dieta = dieta;
    }

    public Set<LaboratorioConsulta> getLaboratoriosConsulta() {
        return laboratoriosConsulta;
    }

    public void setLaboratoriosConsulta(Set<LaboratorioConsulta> laboratoriosConsulta) {
        this.laboratoriosConsulta = laboratoriosConsulta;
    }
}
