package com.e2bnutrition.e2bbackend.model;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "laboratorio_consulta")
public class LaboratorioConsulta {

	@Id
	@Column(name="id_laboratorio_consulta")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLaboratorioConsulta;
	
	@Column(name = "resultados")
    private String resultados;
	
	@Column(name = "notas")
    private String notas;
	
	@ManyToOne
	@JoinColumn(name = "id_laboratorio")
    private Laboratorio laboratorio;
	
	@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="id_consulta")
	@JsonIgnore
    private Consulta consulta;

    public LaboratorioConsulta() {
		super();
    }
    
//, Consulta consulta
    public LaboratorioConsulta(Laboratorio laboratorio, String resultados, String notas) {
        super();
        this.laboratorio = laboratorio;
        this.resultados = resultados;
        this.notas = notas;
        //this.consulta = consulta;
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
