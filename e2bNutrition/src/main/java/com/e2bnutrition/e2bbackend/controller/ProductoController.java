package com.e2bnutrition.e2bbackend.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponentsBuilder;

import com.e2bnutrition.e2bbackend.model.Producto;
import com.e2bnutrition.e2bbackend.service.ProductoService;
import com.e2bnutrition.e2bbackend.utils.CustomMessageType;
import com.e2bnutrition.e2bbackend.utils.ValidateData;

@Controller
@RequestMapping("/v1")
public class ProductoController {
	
	@Autowired
	ProductoService _productoService;
	
	//POST
	@RequestMapping(value = "/productos", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<String> createProducto(@RequestBody Producto producto, UriComponentsBuilder uriComponentsBuilder){
		
		if (!ValidateData.isUsed(producto.getNombre())) {

			return new ResponseEntity(new CustomMessageType("El nombre del producto es requerido"), HttpStatus.CONFLICT);
			
		}
		
		if (_productoService.findByNombre(producto.getNombre())!=null) {
			
			return new ResponseEntity(new CustomMessageType("Ya existe el producto "+producto.getNombre()+" con el mismo nombre"), HttpStatus.CONFLICT);
		
		}
		_productoService.saveProducto(producto);
		
		Producto productoSaved = _productoService.findByNombre(producto.getNombre());
		

		HttpHeaders headers = new HttpHeaders();
		
		headers.setLocation(
				uriComponentsBuilder.path("/v1/productos/{id}").
				buildAndExpand(productoSaved.getIdProducto()).
				toUri());
		
		return new ResponseEntity<String>(headers,HttpStatus.OK);
	}
	
	//GET ALL	
	@RequestMapping(value = "/productos", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Producto>> getProductos(@RequestParam(value= "nombre", required = false) String nombre){
		
		List<Producto> productos = new ArrayList<>();
		
		//Si la URL tiene un nombre, buscamos ese producto
		if (nombre==null) {
			
			productos = _productoService.findAllProductos();
			
			if (productos.isEmpty()) {
				
				return new ResponseEntity(new CustomMessageType("No se encontraron productos"), HttpStatus.NO_CONTENT);
								
			}
			
			return new ResponseEntity<List<Producto>>(productos,HttpStatus.OK);
		}
		//si no hay nombre en la url, devolvemos todos los productos
		else {
			Producto producto = _productoService.findByNombre(nombre);
			
			if (producto== null) {
				
				return new ResponseEntity(new CustomMessageType("No se encontró el producto "+ nombre), HttpStatus.NO_CONTENT);
								
			}
			
			productos.add(producto);
			return new ResponseEntity<List<Producto>>(productos,HttpStatus.OK);
			
		}			
	}
	
	// GET ON BY ID
	@RequestMapping(value = "/productos/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<Producto> getCourseById(@PathVariable("id") Long idProducto){
		
		if(!ValidateData.isUsed(idProducto)) {
			return new ResponseEntity(new CustomMessageType("idProducto is required"), HttpStatus.CONFLICT);
		}
		
		Producto producto = _productoService.findById(idProducto);

		if (producto==null) {
			return new ResponseEntity(new CustomMessageType("No se encontró el producto "+ idProducto), HttpStatus.NO_CONTENT);
			
		}
		
		return new ResponseEntity<Producto>(producto,HttpStatus.OK);
	}
	
	//UPDATE
	@RequestMapping(value = "/productos/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<Producto> updateCourse(@PathVariable("id") Long idProducto, @RequestBody Producto producto){
		
		
		if(!ValidateData.isUsed(idProducto)) {
			return new ResponseEntity(new CustomMessageType("idProducto is required"), HttpStatus.CONFLICT);
		}
		
		Producto currentProducto = _productoService.findById(idProducto);

		if (currentProducto==null) {
			return new ResponseEntity(new CustomMessageType("No se encontró el producto "+ idProducto), HttpStatus.NO_CONTENT);
			
		}
		
		currentProducto.setNombre(producto.getNombre());
		currentProducto.setPrecio(producto.getPrecio());
		currentProducto.setStock(producto.getStock());
		currentProducto.setTamanio(producto.getTamanio());
		
		_productoService.updateProducto(currentProducto);
		
		return new ResponseEntity<Producto>(currentProducto,HttpStatus.OK);
			
	}
	
	// DELETE
	@RequestMapping(value = "/productos/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteProductoById(@PathVariable("id") Long idProducto){
		
		if(!ValidateData.isUsed(idProducto)) {
			return new ResponseEntity(new CustomMessageType("idProducto is required"), HttpStatus.CONFLICT);
		}
		
		Producto producto = _productoService.findById(idProducto);

		if (producto==null) {
			
			return new ResponseEntity(new CustomMessageType("No se encontró el producto "+ idProducto), HttpStatus.NO_CONTENT);
		}
		
		_productoService.deleteProductoById(idProducto);
		
		return new ResponseEntity<Producto>(producto,HttpStatus.OK);
	}
	
	
}
