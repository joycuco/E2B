package com.e2b.e2bnutricion.dao;



import com.e2b.e2bnutricion.model.Producto;

import java.util.List;

public interface ProductoDao {

    void saveProducto(Producto producto);
    void deleteProductoById(Long idProducto);
    void updateProducto(Producto producto);

    List<Producto> findAllProductos();
    Producto findById(Long idProducto);
    Producto findByNombre(String name);
}
