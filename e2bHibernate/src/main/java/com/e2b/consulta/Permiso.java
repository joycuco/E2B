package com.e2b.consulta;

@Entity
@Table(name = "permiso")
public class Permiso implements Serializable{
	@Id
	@Column(name = "id_permiso")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPersmiso;
	
	@Column(name = "nombre")
    private String nombre;

    public Permiso() {
		super();
    }

    public Permiso(Long idPersmiso, String nombre) {
		super();
        this.idPersmiso = idPersmiso;
        this.nombre = nombre;
    }

    public Long getIdPersmiso() {
        return idPersmiso;
    }

    public void setIdPersmiso(Long idPersmiso) {
        this.idPersmiso = idPersmiso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
