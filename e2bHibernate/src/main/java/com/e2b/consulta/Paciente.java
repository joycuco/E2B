package com.e2b.consulta;

import java.util.Date;
import java.util.Set;

public class Paciente {
    private Long idPaciente;
    private String nombre;
    private String telCasa;
    private String telCel;
    private Date fechaIngreso;
    private String enfermedades;
    private String cirugias;
    private String alimentosNoGustan;
    private String alergiaAlimentos;


    private Set<AntecedenteFamiliar> antecedentes;
    private Set<Cita> citas;
    private  Usuario usuario;
    private Set<Consulta> consultas;

    public Paciente() {
    }

    public Paciente(Long idPaciente, String nombre, String telCasa, String telCel, Date fechaIngreso, String enfermedades, String cirugias, String alimentosNoGustan, String alergiaAlimentos, Set<AntecedenteFamiliar> antecedentes, Set<Cita> citas, Usuario usuario, Set<Consulta> consultas) {
        this.idPaciente = idPaciente;
        this.nombre = nombre;
        this.telCasa = telCasa;
        this.telCel = telCel;
        this.fechaIngreso = fechaIngreso;
        this.enfermedades = enfermedades;
        this.cirugias = cirugias;
        this.alimentosNoGustan = alimentosNoGustan;
        this.alergiaAlimentos = alergiaAlimentos;
        this.antecedentes = antecedentes;
        this.citas = citas;
        this.usuario = usuario;
        this.consultas = consultas;
    }

    public Long getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Long idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelCasa() {
        return telCasa;
    }

    public void setTelCasa(String telCasa) {
        this.telCasa = telCasa;
    }

    public String getTelCel() {
        return telCel;
    }

    public void setTelCel(String telCel) {
        this.telCel = telCel;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getEnfermedades() {
        return enfermedades;
    }

    public void setEnfermedades(String enfermedades) {
        this.enfermedades = enfermedades;
    }

    public String getCirugias() {
        return cirugias;
    }

    public void setCirugias(String cirugias) {
        this.cirugias = cirugias;
    }

    public String getAlimentosNoGustan() {
        return alimentosNoGustan;
    }

    public void setAlimentosNoGustan(String alimentosNoGustan) {
        this.alimentosNoGustan = alimentosNoGustan;
    }

    public String getAlergiaAlimentos() {
        return alergiaAlimentos;
    }

    public void setAlergiaAlimentos(String alergiaAlimentos) {
        this.alergiaAlimentos = alergiaAlimentos;
    }

    public Set<AntecedenteFamiliar> getAntecedentes() {
        return antecedentes;
    }

    public void setAntecedentes(Set<AntecedenteFamiliar> antecedentes) {
        this.antecedentes = antecedentes;
    }

    public Set<Cita> getCitas() {
        return citas;
    }

    public void setCitas(Set<Cita> citas) {
        this.citas = citas;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Set<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(Set<Consulta> consultas) {
        this.consultas = consultas;
    }
}
