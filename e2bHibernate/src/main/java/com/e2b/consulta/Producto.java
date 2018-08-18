package com.e2b.consulta;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "producto")
public class Producto implements Serializable {
	
	@Id
	@Column(name = "id_producto")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProducto;
	private String nombre;
	private int stock;
	private String tamanio;
	private int precio;

	private Paquete paquete;
	private DetalleVentaProducto detalleVentaProducto;

	public Producto() {
		super();
	}

	public Producto(Long idProducto, String nombre, int stock, String tamanio, int precio, Paquete paquete, DetalleVentaProducto detalleVentaProducto) {
		super();
		this.idProducto = idProducto;
		this.nombre = nombre;
		this.stock = stock;
		this.tamanio = tamanio;
		this.precio = precio;
		this.paquete = paquete;
		this.detalleVentaProducto = detalleVentaProducto;
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

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public Paquete getPaquete() {
		return paquete;
	}

	public void setPaquete(Paquete paquete) {
		this.paquete = paquete;
	}

	public DetalleVentaProducto getDetalleVentaProducto() {
		return detalleVentaProducto;
	}

	public void setDetalleVentaProducto(DetalleVentaProducto detalleVentaProducto) {
		this.detalleVentaProducto = detalleVentaProducto;
	}
}
