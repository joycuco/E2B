package com.e2b.consulta;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "laboratorio_consulta")
public class LaboratorioConsulta {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLaboratorioConsulta;
	
	@Column(name = "resultados")
    private String resultados;
	
	@Column(name = "notas")
    private String notas;
	
	@ManyToOne
	@JoinColumn(name = "id_laboratorio")
    private Laboratorio laboratorio;
	
	@ManyToOne
	@JoinColumn(name = "id_consulta")
    private Consulta consulta;

    public LaboratorioConsulta() {
		super();
    }

    public LaboratorioConsulta(Long idLaboratorioConsulta, Laboratorio laboratorio, String resultados, String notas, Consulta consulta) {
        super();
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
