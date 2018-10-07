package com.e2b;

import com.e2b.DAO.ProductoDao;
import com.e2b.DAO.ProductoDaoImpl;
import com.e2b.model.Producto;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


class Main {

    public static void main(String[] args){
        System.out.println("Start");

        //Save product
        /*Producto producto= new Producto("producto2",10,"pequeño",100.00f);
        ProductoDaoImpl productoDao= new ProductoDaoImpl();
        productoDao.saveProducto(producto);
*/

        //get all
        /*ProductoDaoImpl productoDao= new ProductoDaoImpl();
        List<Producto> productos = productoDao.findAllProductos();

        for (Producto p : productos) {
            System.out.println(p.getNombre());
        }*/

        //get One by ID
        /*ProductoDaoImpl productoDao= new ProductoDaoImpl();
        Producto p = productoDao.findById(1l);
        System.out.println(p.getNombre());*/

        //get One by name
        /*ProductoDaoImpl productoDao= new ProductoDaoImpl();
        Producto p =productoDao.findByNombre("producto1");
        System.out.println(p.getNombre());

        //Update
        p.setNombre("Updated 1");
        productoDao.updateProducto(p);
        System.out.println(p.getNombre());*/

        ProductoDaoImpl productoDao= new ProductoDaoImpl();
        productoDao.deleteProductoById(4L);







    }
}
