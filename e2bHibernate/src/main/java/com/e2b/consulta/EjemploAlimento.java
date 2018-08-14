package com.e2b.consulta;

import java.sql.Time;

public class EjemploAlimento {
    private Long ejemploAlimento;
    private Dieta dieta;
    private Receta receta;
    private String tipo;
    private Time hora;
    private String notas;

    public EjemploAlimento() {
    }

    public EjemploAlimento(Long ejemploAlimento, Dieta dieta, Receta receta, String tipo, Time hora, String notas) {
        this.ejemploAlimento = ejemploAlimento;
        this.dieta = dieta;
        this.receta = receta;
        this.tipo = tipo;
        this.hora = hora;
        this.notas = notas;
    }

    public Long getEjemploAlimento() {
        return ejemploAlimento;
    }

    public void setEjemploAlimento(Long ejemploAlimento) {
        this.ejemploAlimento = ejemploAlimento;
    }

    public Dieta getDieta() {
        return dieta;
    }

    public void setDieta(Dieta dieta) {
        this.dieta = dieta;
    }

    public Receta getReceta() {
        return receta;
    }

    public void setReceta(Receta receta) {
        this.receta = receta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }
}
