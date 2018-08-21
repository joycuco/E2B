package com.e2b.e2bnutricion.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "producto")
public class Producto implements Serializable {
	
	@Id
	@Column(name = "id_producto")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProducto;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "stock")
	private int stock;

	@Column(name = "tamanio")
	private String tamanio;

	@Column(name = "precio")
	private float precio;

	@ManyToMany(cascade = {
			CascadeType.PERSIST,
			CascadeType.MERGE
	})
	@JoinTable(name = "detalle_paquete",
			joinColumns = @JoinColumn(name = "id_producto"),
			inverseJoinColumns = @JoinColumn(name = "id_paquete")
	)
	private Set<Paquete> paquetes;

	@OneToMany(mappedBy = "producto")
	private Set<DetalleVentaProducto> detalleVentasProductos;

	public Producto() {
		super();
	}

	public Producto(String nombre, int stock, String tamanio, float precio) {
		super();
		this.nombre = nombre;
		this.stock = stock;
		this.tamanio = tamanio;
		this.precio = precio;
	}

	public Long getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getTamanio() {
		return tamanio;
	}

	public void setTamanio(String tamanio) {
		this.tamanio = tamanio;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public Set<Paquete> getPaquetes() {
		return paquetes;
	}

	public void setPaquetes(Set<Paquete> paquetes) {
		this.paquetes = paquetes;
	}

	public Set<DetalleVentaProducto> getDetalleVentasProductos() {
		return detalleVentasProductos;
	}

	public void setDetalleVentasProductos(Set<DetalleVentaProducto> detalleVentasProductos) {
		this.detalleVentasProductos = detalleVentasProductos;
	}
}
