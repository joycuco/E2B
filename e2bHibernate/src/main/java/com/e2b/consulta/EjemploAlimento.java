package com.e2b.consulta;

import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;

@Entity
@Table(name = "ejemplo_alimento")
public class EjemploAlimento implements Serializable {

    @Id
    @Column(name = "id_ejemplo_alimento")
    private Long idEjemploAlimento;

    @Column(name = "tipo_alimento")
    private String tipo;

    @Column(name = "hora")
    private Time hora;

    @Column(name = "notas")
    private String notas;

    @ManyToOne
    @JoinColumn(name = "id_dieta")
    private Dieta dieta;

    @ManyToOne
    @JoinColumn(name = "id_receta")
    private Receta receta;

    public EjemploAlimento() {
        super();
    }

    public EjemploAlimento(Long idEjemploAlimento, Dieta dieta, Receta receta, String tipo, Time hora, String notas) {
        super();
        this.idEjemploAlimento = idEjemploAlimento;
        this.dieta = dieta;
        this.receta = receta;
        this.tipo = tipo;
        this.hora = hora;
        this.notas = notas;
    }

    public Long getEjemploAlimento() {
        return idEjemploAlimento;
    }

    public void setEjemploAlimento(Long idEjemploAlimento) {
        this.idEjemploAlimento = idEjemploAlimento;
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
