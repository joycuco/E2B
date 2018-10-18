package com.e2bnutrition.e2bbackend.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "Empleado")
public class Empleado implements Serializable {

    @Id
    @Column(name = "id_empleado")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmpleado;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "tel_casa")
    private String telCasa;

    @Column(name = "tel_movil")
    private String telCel;

    @Column(name = "correo")
    private String correo;

    @Column(name = "puesto")
    private String puesto;

    @Column(name = "estatus")
    private String estatus;

	/*@OneToMany(mappedBy = "empleado")
	private Set<Venta> ventas;
	
	//para el encargado
    @ManyToOne
    @JoinColumn(name = "id_consultorio")
    private Consultorio consultorio;

    //los empleados del consultorio
   // @OneToMany(mappedBy = "encargado")
    //private Set<Consultorio> consultorios;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "usuario_empleado",
            joinColumns = @JoinColumn(name = "id_empleado"),
            inverseJoinColumns = @JoinColumn(name = "id_usuario")
    )
    
    private Set<Usuario> usuarios;*/

    public Empleado() {
        super();
    }

    public Empleado(String nombre, String direccion, String telCasa, String telCel, String correo, String puesto, String estatus) {
        super();
        this.nombre = nombre;
        this.direccion = direccion;
        this.telCasa = telCasa;
        this.telCel = telCel;
        this.correo = correo;
        this.puesto = puesto;
        this.estatus = estatus;
        //this.usuarios = usuarios;
    }

    public Long getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Long idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

   /* public Set<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Set<Usuario> usuarios) {
        this.usuarios = usuarios;
    }*/
}
