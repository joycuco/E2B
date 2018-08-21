package com.e2b.model;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "rol")
public class Rol implements Serializable{
	
	@Id
	@Column(name = "id_rol")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRol;
	
	@Column(name = "nombre")
    private String nombre;

	@OneToMany(mappedBy = "rol")
	private Set<PermisoRol> permisoRol;

    public Rol() {
		super();
    }

    public Rol(String nombre, Set<PermisoRol> permisoRol) {
        super();
        this.nombre = nombre;
        this.permisoRol = permisoRol;
    }

    public Long getIdRol() {
        return idRol;
    }

    public void setIdRol(Long idRol) {
        this.idRol = idRol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<PermisoRol> getPermisoRol() {
        return permisoRol;
    }

    public void setPermisoRol(Set<PermisoRol> permisoRol) {
        this.permisoRol = permisoRol;
    }
}
