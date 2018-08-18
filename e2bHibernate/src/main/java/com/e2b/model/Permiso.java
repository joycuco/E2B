package com.e2b.model;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "permiso")
public class Permiso implements Serializable{
	@Id
	@Column(name = "id_permiso")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPermiso;
	
	@Column(name = "nombre")
    private String nombre;

	@ManyToOne
    @JoinColumn(name = "id_permiso_rol")
	private PermisoRol permisoRol;

    public Permiso() {
		super();
    }

    public Permiso(Long idPermiso, String nombre, PermisoRol permisoRol) {
        this.idPermiso = idPermiso;
        this.nombre = nombre;
        this.permisoRol = permisoRol;
    }

    public Long getIdPermiso() {
        return idPermiso;
    }

    public void setIdPermiso(Long idPermiso) {
        this.idPermiso = idPermiso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public PermisoRol getPermisoRol() {
        return permisoRol;
    }

    public void setPermisoRol(PermisoRol permisoRol) {
        this.permisoRol = permisoRol;
    }
}
