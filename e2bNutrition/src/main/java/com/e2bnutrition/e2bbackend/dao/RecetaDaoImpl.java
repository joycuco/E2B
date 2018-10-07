package com.e2bnutrition.e2bbackend.dao;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.e2bnutrition.e2bbackend.model.Receta;

import java.util.List;

import javax.transaction.Transactional;

@Repository
@Transactional
public class RecetaDaoImpl extends AbstractSession implements RecetaDao{

    @Override
    public void saveReceta(Receta receta) {
        getSession().persist(receta);
    }
    @Override
    public void deleteRecetaById(Long idReceta) {

        Receta p = findById(idReceta);
        if(p!=null)
            getSession().delete(p);
    }
    @Override
    public void updateReceta(Receta receta) {
        getSession().update(receta);
    }
    @Override
    public List<Receta> findAllRecetas() {
        return getSession().createQuery("from Receta").list();
    }
    @Override
    public Receta findById(Long idReceta) {
        return (Receta)getSession().get(Receta.class,idReceta);

    }
    @Override
    public Receta findByNombre(String name) {
        return (Receta) getSession().createQuery(
                "from Receta where nombre = :nombre").setParameter("nombre",name).uniqueResult();
    }
}
