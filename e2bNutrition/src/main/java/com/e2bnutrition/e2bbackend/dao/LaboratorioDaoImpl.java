package com.e2bnutrition.e2bbackend.dao;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.e2bnutrition.e2bbackend.model.Laboratorio;

import java.util.List;

import javax.transaction.Transactional;

@Repository
@Transactional
public class LaboratorioDaoImpl extends AbstractSession implements LaboratorioDao{

    @Override
    public void saveLaboratorio(Laboratorio laboratorio) {
        getSession().persist(laboratorio);
    }
    @Override
    public void deleteLaboratorioById(Long idLaboratorio) {

        Laboratorio p = findById(idLaboratorio);
        if(p!=null)
            getSession().delete(p);
    }
    @Override
    public void updateLaboratorio(Laboratorio laboratorio) {
        getSession().update(laboratorio);
    }
    @Override
    public List<Laboratorio> findAllLaboratorios() {
        return getSession().createQuery("from Laboratorio").list();
    }
    @Override
    public Laboratorio findById(Long idLaboratorio) {
        return (Laboratorio)getSession().get(Laboratorio.class,idLaboratorio);

    }
    @Override
    public Laboratorio findByNombre(String name) {
        return (Laboratorio) getSession().createQuery(
                "from Laboratorio where nombre = :nombre").setParameter("nombre",name).uniqueResult();
    }
}
