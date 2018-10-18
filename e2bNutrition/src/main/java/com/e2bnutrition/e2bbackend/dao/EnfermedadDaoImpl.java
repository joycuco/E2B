package com.e2bnutrition.e2bbackend.dao;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.e2bnutrition.e2bbackend.model.Enfermedad;

import java.util.List;

import javax.transaction.Transactional;

@Repository
@Transactional
public class EnfermedadDaoImpl extends AbstractSession implements EnfermedadDao{

    @Override
    public void saveEnfermedad(Enfermedad enfermedad) {
        getSession().persist(enfermedad);
    }
    @Override
    public void deleteEnfermedadById(Long idEnfermedad) {

        Enfermedad p = findById(idEnfermedad);
        if(p!=null)
            getSession().delete(p);
    }
    @Override
    public void updateEnfermedad(Enfermedad enfermedad) {
        getSession().update(enfermedad);
    }
    @Override
    public List<Enfermedad> findAllEnfermedades() {
        return getSession().createQuery("from Enfermedad").list();
    }
    @Override
    public Enfermedad findById(Long idEnfermedad) {
        return (Enfermedad)getSession().get(Enfermedad.class,idEnfermedad);

    }
    @Override
    public Enfermedad findByNombre(String name) {
        return (Enfermedad) getSession().createQuery(
                "from Enfermedad where nombre = :nombre").setParameter("nombre",name).uniqueResult();
    }
}
