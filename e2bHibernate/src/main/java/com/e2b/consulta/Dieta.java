package com.e2b.consulta;

public class Dieta {
    private Long idDieta;
    private String tipo;
    private int kc;
    private int hc;
    private int proteinas;
    private int lipidos;
    private Set<EjemploAlimento> ejemplosAlimentos;

    public Dieta() {
    }

    public Dieta(Long idDieta, String tipo, int kc, int hc, int proteinas, int lipidos, Set<EjemploAlimento> ejemplosAlimentos) {
        this.idDieta = idDieta;
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
