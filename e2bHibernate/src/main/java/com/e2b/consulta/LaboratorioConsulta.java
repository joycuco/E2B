package com.e2b.consulta;

public class LaboratorioConsulta {

    private Long idLaboratorioConsulta;
    private Laboratorio laboratorio;
    private String resultados;
    private String notas;

    private Consulta consulta;

    public LaboratorioConsulta() {
    }

    public LaboratorioConsulta(Long idLaboratorioConsulta, Laboratorio laboratorio, String resultados, String notas, Consulta consulta) {
        this.idLaboratorioConsulta = idLaboratorioConsulta;
        this.laboratorio = laboratorio;
        this.resultados = resultados;
        this.notas = notas;
        this.consulta = consulta;
    }

    public Long getIdLaboratorioConsulta() {
        return idLaboratorioConsulta;
    }

    public void setIdLaboratorioConsulta(Long idLaboratorioConsulta) {
        this.idLaboratorioConsulta = idLaboratorioConsulta;
    }

    public Laboratorio getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(Laboratorio laboratorio) {
        this.laboratorio = laboratorio;
    }

    public String getResultados() {
        return resultados;
    }

    public void setResultados(String resultados) {
        this.resultados = resultados;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }
}
