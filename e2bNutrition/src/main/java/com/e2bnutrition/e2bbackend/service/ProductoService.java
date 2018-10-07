package com.e2bnutrition.e2bbackend.service;

import java.util.List;

import com.e2bnutrition.e2bbackend.model.Producto;

public interface ProductoService {


	void saveProducto(Producto producto);
	
	void deleteProductoById(Long idProducto);
	
	void updateProducto(Producto producto);
		
	List<Producto> findAllProductos();
	
	Producto findById(Long idProducto);
	
	Producto findByNombre(String nombre);
	
	//List<Producto> findByIdPaquete(Long idPaquete);

}
