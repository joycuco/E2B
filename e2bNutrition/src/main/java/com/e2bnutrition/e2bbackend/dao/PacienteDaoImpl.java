package com.e2bnutrition.e2bbackend.dao;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.e2bnutrition.e2bbackend.model.Paciente;

import java.util.List;

import javax.transaction.Transactional;

@Repository
@Transactional
public class PacienteDaoImpl extends AbstractSession implements PacienteDao{

    @Override
    public void savePaciente(Paciente paciente) {
        getSession().persist(paciente);
    }
    @Override
    public void deletePacienteById(Long idPaciente) {

        Paciente p = findById(idPaciente);
        if(p!=null)
            getSession().delete(p);
    }
    @Override
    public void updatePaciente(Paciente paciente) {
        getSession().update(paciente);
    }
    @Override
    public List<Paciente> findAllPacientes() {
        return getSession().createQuery("from Paciente").list();
    }
    @Override
    public Paciente findById(Long idPaciente) {
        return (Paciente)getSession().get(Paciente.class,idPaciente);

    }
    @Override
    public Paciente findByNombre(String name) {
        return (Paciente) getSession().createQuery(
                "from Paciente where nombre = :nombre").setParameter("nombre",name).uniqueResult();
    }
}
