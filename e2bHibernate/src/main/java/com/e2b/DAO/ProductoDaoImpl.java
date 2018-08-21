package com.e2b.DAO;

import com.e2b.model.Producto;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

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

        Producto p = new Producto();
        p.setIdProducto(idProducto);

        e2BSession.getSession().delete(p);
        e2BSession.getSession().getTransaction().commit();
        //e2BSession.getSession().flush();

    }

    public void updateProducto(Producto producto) {

        e2BSession.getSession().persist(producto);
        e2BSession.getSession().getTransaction().commit();

    }

    public List<Producto> findAllProductos() {
        return e2BSession.getSession().createQuery("from Producto").list();
    }

    public Producto findById(Long idProducto) {
        return (Producto) e2BSession.getSession().get(Producto.class, idProducto);

    }

    public Producto findByNombre(String name) {
        Criteria criteria = e2BSession.getSession().createCriteria(Producto.class);
        return (Producto)criteria.add(Restrictions.eq("nombre", name)).uniqueResult();
    }
}
