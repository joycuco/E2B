package com.e2bnutrition.e2bbackend.dao;


import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.e2bnutrition.e2bbackend.model.Empleado;

import java.util.List;

import javax.transaction.Transactional;

@Repository
@Transactional
public class EmpleadoDaoImpl extends AbstractSession implements EmpleadoDao{

    @Override
    public void saveEmpleado(Empleado empleado) {
        getSession().persist(empleado);
    }
    @Override
    public void deleteEmpleadoById(Long idEmpleado) {

        Empleado p = findById(idEmpleado);
        if(p!=null)
            getSession().delete(p);
    }
    @Override
    public void updateEmpleado(Empleado empleado) {
        getSession().update(empleado);
    }
    @Override
    public List<Empleado> findAllEmpleados() {
        return getSession().createQuery("from Empleado").list();
    }
    @Override
    public Empleado findById(Long idEmpleado) {
        return (Empleado)getSession().get(Empleado.class,idEmpleado);

    }
    @Override
    public Empleado findByNombre(String name) {
        return (Empleado) getSession().createQuery(
                "from Empleado where nombre = :nombre").setParameter("nombre",name).uniqueResult();
    }
}

