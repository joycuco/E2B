package com.e2bnutrition.e2bbackend.dao;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.e2bnutrition.e2bbackend.model.Producto;

import java.util.List;

import javax.transaction.Transactional;

@Repository
@Transactional
public class ProductoDaoImpl extends AbstractSession implements ProductoDao{

    @Override
    public void saveProducto(Producto producto) {
        getSession().persist(producto);
    }
    @Override
    public void deleteProductoById(Long idProducto) {

        Producto p = findById(idProducto);
        if(p!=null)
            getSession().delete(p);
    }
    @Override
    public void updateProducto(Producto producto) {
        getSession().update(producto);
    }
    @Override
    public List<Producto> findAllProductos() {
        return getSession().createQuery("from Producto").list();
    }
    @Override
    public Producto findById(Long idProducto) {
        return (Producto)getSession().get(Producto.class,idProducto);

    }
    @Override
    public Producto findByNombre(String name) {
        return (Producto) getSession().createQuery(
                "from Producto where nombre = :nombre").setParameter("nombre",name).uniqueResult();
    }
}
