package com.e2b.e2bnutricion.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "paciente")

public class Paciente implements Serializable {
    @Id
    @Column(name = "id_paciente")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPaciente;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "tel_casa")
    private String telCasa;

    @Column(name = "tel_movil")
    private String telCel;

    @Column(name = "fecha_ingreso")
    private Date fechaIngreso;

    @Column(name = "enfermedades")
    private String enfermedades;

    @Column(name = "cirugias")
    private String cirugias;

    @Column(name = "alimentos_no_gustan")
    private String alimentosNoGustan;

    @Column(name = "alergia_alimentos")
    private String alergiaAlimentos;


    @Column(name = "alergia_medicamentos")
    private String alergiaMedicamentos;

    @OneToMany(mappedBy = "paciente")//add this to all One to Many
    private Set<AntecedenteFamiliar> antecedentes;

    @OneToMany(mappedBy = "paciente")
    private Set<Cita> citas;

    @OneToMany(mappedBy = "paciente")
    private Set<Consulta> consultas;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private  Usuario usuario;
	
	@OneToMany
    @JoinColumn(name ="id_venta")
	private Set<Venta> ventas;

    public Paciente() {
        super();
    }

    public Paciente(String nombre, String telCasa, String telCel, Date fechaIngreso, String enfermedades, String cirugias, String alimentosNoGustan, String alergiaAlimentos, Set<AntecedenteFamiliar> antecedentes, Set<Cita> citas, Usuario usuario, Set<Consulta> consultas) {
        super();
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
	
	
    public String getAlergiaMedicamentos() {
        return alergiaMedicamentos;
    }

    public void setAlergiaMedicamentos(String alergiaMedicamentos) {
        this.alergiaMedicamentos = alergiaMedicamentos;
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
