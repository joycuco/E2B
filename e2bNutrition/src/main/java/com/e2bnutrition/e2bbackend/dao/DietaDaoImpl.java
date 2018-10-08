package com.e2bnutrition.e2bbackend.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.e2bnutrition.e2bbackend.model.Dieta;

import java.util.List;

import javax.transaction.Transactional;

@Repository
@Transactional
public class DietaDaoImpl extends AbstractSession implements DietaDao{

    @Override
    public void saveDieta(Dieta dieta) {
        getSession().persist(dieta);
    }
    @Override
    public void deleteDietaById(Long idDieta) {

        Dieta p = findById(idDieta);
        if(p!=null)
            getSession().delete(p);
    }
    @Override
    public void updateDieta(Dieta dieta) {
        getSession().update(dieta);
    }
    @Override
    public List<Dieta> findAllDietas() {
        return getSession().createQuery("from Dieta").list();
    }
    @Override
    public Dieta findById(Long idDieta) {
        return (Dieta)getSession().get(Dieta.class,idDieta);

    }
    @Override
    public Dieta findByTipo(String tipo) {
        return (Dieta) getSession().createQuery(
                "from Dieta where tipo = :tipo").setParameter("tipo",tipo).uniqueResult();
    }
}
