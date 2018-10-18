package com.e2bnutrition.e2bbackend.dao;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.e2bnutrition.e2bbackend.model.Paquete;

import java.util.List;

import javax.transaction.Transactional;

@Repository
@Transactional
public class PaqueteDaoImpl extends AbstractSession implements PaqueteDao{

    @Override
    public void savePaquete(Paquete paquete) {
        getSession().persist(paquete);
    }
    @Override
    public void deletePaqueteById(Long idPaquete) {

        Paquete p = findById(idPaquete);
        if(p!=null)
            getSession().delete(p);
    }
    @Override
    public void updatePaquete(Paquete paquete) {
        getSession().update(paquete);
    }
    @Override
    public List<Paquete> findAllPaquetes() {
        return getSession().createQuery("from Paquete").list();
    }
    @Override
    public Paquete findById(Long idPaquete) {
        return (Paquete)getSession().get(Paquete.class,idPaquete);

    }
    @Override
    public Paquete findByNombre(String name) {
        return (Paquete) getSession().createQuery(
                "from Paquete where nombre = :nombre").setParameter("nombre",name).uniqueResult();
    }
}
