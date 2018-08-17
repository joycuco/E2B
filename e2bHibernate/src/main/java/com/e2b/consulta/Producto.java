package com.e2b.consulta;

@Entity
@Table(name = "producto")
public class Producto implements Serializable{
	
	@Id
	@Column(name = "id_producto")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProducto;
	
	
	private String nombre;
	private Paquete paquete;
}
