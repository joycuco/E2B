package com.e2b.e2bnutricion.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "dieta")
public class Dieta implements Serializable {
    @Id
    @Column(name = "id_dieta")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDieta;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "k_cals")
    private int kc;

    @Column(name = "hs_c")
    private int hc;

    @Column(name = "proteinas")
    private int proteinas;

    @Column(name = "lipidos")
    private int lipidos;

    @OneToMany(mappedBy = "dieta")
    private Set<EjemploAlimento> ejemplosAlimentos;

    public Dieta() {
        super();
    }

    public Dieta(String tipo, int kc, int hc, int proteinas, int lipidos, Set<EjemploAlimento> ejemplosAlimentos) {
        super();
        this.tipo = tipo;
        this.kc = kc;
        this.hc = hc;
        this.proteinas = proteinas;
        this.lipidos = lipidos;
        this.ejemplosAlimentos = ejemplosAlimentos;
    }

    public Long getIdDieta() {
        return idDieta;
    }

    public void setIdDieta(Long idDieta) {
        this.idDieta = idDieta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getKc() {
        return kc;
    }

    public void setKc(int kc) {
        this.kc = kc;
    }

    public int getHc() {
        return hc;
    }

    public void setHc(int hc) {
        this.hc = hc;
    }

    public int getProteinas() {
        return proteinas;
    }

    public void setProteinas(int proteinas) {
        this.proteinas = proteinas;
    }

    public int getLipidos() {
        return lipidos;
    }

    public void setLipidos(int lipidos) {
        this.lipidos = lipidos;
    }

    public Set<EjemploAlimento> getEjemplosAlimentos() {
        return ejemplosAlimentos;
    }

    public void setEjemplosAlimentos(Set<EjemploAlimento> ejemplosAlimentos) {
        this.ejemplosAlimentos = ejemplosAlimentos;
    }
}
