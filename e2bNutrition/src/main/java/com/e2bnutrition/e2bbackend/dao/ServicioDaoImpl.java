package com.e2bnutrition.e2bbackend.dao;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.e2bnutrition.e2bbackend.model.Servicio;

import java.util.List;

import javax.transaction.Transactional;

@Repository
@Transactional
public class ServicioDaoImpl extends AbstractSession implements ServicioDao{

    @Override
    public void saveServicio(Servicio servicio) {
        getSession().persist(servicio);
    }
    @Override
    public void deleteServicioById(Long idServicio) {

        Servicio p = findById(idServicio);
        if(p!=null)
            getSession().delete(p);
    }
    @Override
    public void updateServicio(Servicio servicio) {
        getSession().update(servicio);
    }
    @Override
    public List<Servicio> findAllServicios() {
        return getSession().createQuery("from Servicio").list();
    }
    @Override
    public Servicio findById(Long idServicio) {
        return (Servicio)getSession().get(Servicio.class,idServicio);

    }
    @Override
    public Servicio findByNombre(String name) {
        return (Servicio) getSession().createQuery(
                "from Servicio where nombre = :nombre").setParameter("nombre",name).uniqueResult();
    }
}
