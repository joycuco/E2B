package com.e2bnutrition.e2bbackend.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e2bnutrition.e2bbackend.dao.ProductoDao;
import com.e2bnutrition.e2bbackend.model.Producto;

@Service("productoService")
@Transactional
public class ProductoServiceImpl implements ProductoService{
	
	@Autowired
	private ProductoDao _productoDao;

	@Override
	public void saveProducto(Producto producto) {
		// TODO Auto-generated method stub
		_productoDao.saveProducto(producto);
		
	}

	@Override
	public void deleteProductoById(Long idProducto) {
		// TODO Auto-generated method stub
		_productoDao.deleteProductoById(idProducto);
		
	}

	@Override
	public void updateProducto(Producto producto) {
		// TODO Auto-generated method stub
		_productoDao.updateProducto(producto);
		
	}

	@Override
	public List<Producto> findAllProductos() {
		// TODO Auto-generated method stub
		return _productoDao.findAllProductos();
	}

	@Override
	public Producto findById(Long idProducto) {
		// TODO Auto-generated method stub
		return _productoDao.findById(idProducto);
	}

	@Override
	public Producto findByNombre(String nombre) {
		// TODO Auto-generated method stub
		return _productoDao.findByNombre(nombre);
	}

}
