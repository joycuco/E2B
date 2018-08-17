package com.e2b.consulta;

@Entity
@Table(name = "servicio")
public class Servicio implements Serializable{
	
	@Id
	@Column(name = "id_servicio")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idServicio;
	
	@Column(name = "nombre")
    private String nombre;
	
	@Column(name = "precio")
    private Float precio;
	
	@ManyToOne
	@JoinColumn(name = "id_servicio")
	private Paquete paquete;

    public Servicio() {
		super();
    }

    public Servicio(Long idServicio, String nombre, Float precio) {
		super();
        this.idServicio = idServicio;
        this.nombre = nombre;
        this.precio = precio;
    }

    public Long getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Long idServicio) {
        this.idServicio = idServicio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }
}
