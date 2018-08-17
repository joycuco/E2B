package com.e2b.consulta;

@Entity
@Table(name = "rol")
public class Rol implements Serializable{
	
	@Id
	@Column(name = "id_rol")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRol;
	
	@Column(name = "nombre")
    private String nombre;

    public Rol() {
		super();
    }

    public Rol(Long idRol, String nombre) {
		super();
        this.idRol = idRol;
        this.nombre = nombre;
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
}
