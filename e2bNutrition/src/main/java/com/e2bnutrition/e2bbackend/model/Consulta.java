package com.e2bnutrition.e2bbackend.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "consulta")
public class Consulta implements Serializable {

    @Id
    @Column(name = "id_consulta")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idConsulta;

    @Column(name = "complexion")
    private String complexion;

    @Column(name = "peso")
    private Float peso;

    @Column(name = "estatura")
    private Float estatura;

    @Column(name = "munieca")
    private Float munieca;

    @Column(name = "cadera")
    private Float cadera;

    @Column(name = "cintura")
    private Float cintura;

    @Column(name = "imc")
    private Float imc;

    @Column(name = "peso_ideal")
    private Float pesoIdeal;

    @Column(name = "p_grasa")
    private Float pGrasa;

    @Column(name = "masa_magra")
    private Float masaMagra;

    /*@ManyToOne
    @JoinColumn(name = "id_paciente")
    private Paciente paciente;*/

    @ManyToOne
    @JoinColumn(name = "id_dieta")
    private Dieta dieta;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_consulta")
    private Set<LaboratorioConsulta> laboratoriosConsulta;


    public Consulta(){
        super();
    }
//, Paciente paciente, Dieta dieta, Set<LaboratorioConsulta> laboratoriosConsulta
    public Consulta(String complexion, Float peso, Float estatura, Float munieca, Float cadera, Float cintura, Float imc, Float pesoIdeal) {
        super();
        this.complexion = complexion;
        this.peso = peso;
        this.estatura = estatura;
        this.munieca = munieca;
        this.cadera = cadera;
        this.cintura = cintura;
        this.imc = imc;
        this.pesoIdeal = pesoIdeal;
        /*this.paciente = paciente;
        this.dieta = dieta;
        this.laboratoriosConsulta = laboratoriosConsulta;*/
    }

    public Float getpGrasa() {
        return pGrasa;
    }

    public void setpGrasa(Float pGrasa) {
        this.pGrasa = pGrasa;
    }

    public Float getMasaMagra() {
        return masaMagra;
    }

    public void setMasaMagra(Float masaMagra) {
        this.masaMagra = masaMagra;
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

    /*public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }*/

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
