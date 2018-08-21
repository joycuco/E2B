package com.e2b.e2bnutricion.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable{
	
	@Id
	@Column(name = "id_usuario")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;
	
	@Column(name = "usuario")
    private String usuario;
	
	@Column(name = "password")
    private String password;
	
	@ManyToOne
	@JoinColumn(name = "id_permiso_rol")
    private PermisoRol permisoRol;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "usuario_empleado",
            joinColumns = @JoinColumn(name = "id_usuario"),
            inverseJoinColumns = @JoinColumn(name = "id_empleado")
    )
    private Set<Empleado> empleados;

    public Usuario() {
		super();
    }

    public Usuario(String usuario, String password, PermisoRol permisoRol) {
        super();

        this.usuario = usuario;
        this.password = password;
        this.permisoRol = permisoRol;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public Set<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Set<Empleado> empleados) {
        this.empleados = empleados;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public PermisoRol getPermisoRol() {
        return permisoRol;
    }

    public void setPermisoRol(PermisoRol permisoRol) {
        this.permisoRol = permisoRol;
    }
}
