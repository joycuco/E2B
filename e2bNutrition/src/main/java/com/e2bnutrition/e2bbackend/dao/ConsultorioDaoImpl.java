package com.e2bnutrition.e2bbackend.dao;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.e2bnutrition.e2bbackend.model.Consultorio;

import java.util.List;

import javax.transaction.Transactional;

@Repository
@Transactional
public class ConsultorioDaoImpl extends AbstractSession implements ConsultorioDao{

    @Override
    public void saveConsultorio(Consultorio consultorio) {
        getSession().persist(consultorio);
    }
    @Override
    public void deleteConsultorioById(Long idConsultorio) {

        Consultorio p = findById(idConsultorio);
        if(p!=null)
            getSession().delete(p);
    }
    @Override
    public void updateConsultorio(Consultorio consultorio) {
        getSession().update(consultorio);
    }
    @Override
    public List<Consultorio> findAllConsultorios() {
        return getSession().createQuery("from Consultorio").list();
    }
    @Override
    public Consultorio findById(Long idConsultorio) {
        return (Consultorio)getSession().get(Consultorio.class,idConsultorio);

    }
    @Override
    public Consultorio findByNombre(String name) {
        return (Consultorio) getSession().createQuery(
                "from Consultorio where nombre = :nombre").setParameter("nombre",name).uniqueResult();
    }
}
