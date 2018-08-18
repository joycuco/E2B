package com.e2b;

import com.e2b.DAO.ProductoDao;
import com.e2b.DAO.ProductoDaoImpl;
import com.e2b.model.Producto;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


class Main {

    public static void main(String[] args){
        System.out.println("Start");
        Producto producto= new Producto("producto2",10,"pequeño",100.00f);
        ProductoDaoImpl productoDao= new ProductoDaoImpl();
        productoDao.saveProducto(producto);
    }
}
