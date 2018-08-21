package com.e2b.e2bnutricion.dao;

import com.e2b.e2bnutricion.model.Producto;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import java.util.List;


public class ProductoDaoImpl extends AbstractSession implements ProductoDao{

    public void saveProducto(Producto producto) {
        getSession().persist(producto);
    }

    public void deleteProductoById(Long idProducto) {

        Producto p = findById(idProducto);
        if(p!=null)
            getSession().delete(p);

    }

    public void updateProducto(Producto producto) {
        getSession().update(producto);
    }

    public List<Producto> findAllProductos() {
        return getSession().createQuery("from oriducto").list();
    }

    public Producto findById(Long idProducto) {
        return (Producto)getSession().get(Producto.class,idProducto);

    }

    public Producto findByNombre(String name) {
        return (Producto) getSession().createQuery(
                "from Producto where nombre = :nombre").setParameter("nombre",name).uniqueResult();
    }
}
