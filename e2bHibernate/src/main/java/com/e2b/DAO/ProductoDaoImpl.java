package com.e2b.DAO;

import com.e2b.model.Producto;

import java.util.List;

public class ProductoDaoImpl extends E2BSession implements ProductoDao{

    private E2BSession e2BSession;

    public ProductoDaoImpl() {
        e2BSession= new E2BSession();
    }

    public void saveProducto(Producto producto) {
        e2BSession.getSession().persist(producto);
        e2BSession.getSession().getTransaction().commit();
    }

    public void deleteProductoById(Long idProducto) {

    }

    public void updateProducto(Producto producto) {

    }

    public List<Producto> findAllProductos() {
        return null;
    }

    public Producto findById(Long idProducto) {
        return null;
    }

    public Producto findByNombre(String name) {
        return null;
    }
}
