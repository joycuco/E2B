package com.e2b.consulta;

public class Familiar {

    private Long idFamiliar;
    private String parentesco;
    private AntecedenteFamiliar antecedenteFamiliar;

    public Familiar() {
    }

    public Familiar(Long idFamiliar, String parentesco) {
        this.idFamiliar = idFamiliar;
        this.parentesco = parentesco;
    }

    public Long getIdFamiliar() {
        return idFamiliar;
    }

    public void setIdFamiliar(Long idFamiliar) {
        this.idFamiliar = idFamiliar;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }
}