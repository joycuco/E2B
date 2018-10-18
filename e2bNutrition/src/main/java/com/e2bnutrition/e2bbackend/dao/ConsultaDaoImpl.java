package com.e2bnutrition.e2bbackend.dao;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.e2bnutrition.e2bbackend.model.Consulta;
import com.e2bnutrition.e2bbackend.model.LaboratorioConsulta;

import java.util.List;

import javax.transaction.Transactional;

@Repository
@Transactional
public class ConsultaDaoImpl extends AbstractSession implements ConsultaDao{

    @Override
    public void saveConsulta(Consulta consulta) {
        getSession().persist(consulta);
    }
    @Override
    public void deleteConsultaById(Long idConsulta) {

        Consulta p = findById(idConsulta);
        if(p!=null)
            getSession().delete(p);
    }
    @Override
    public void updateConsulta(Consulta consulta) {
        getSession().update(consulta);
    }
    @Override
    public List<Consulta> findAllConsultas() {
        return getSession().createQuery("from Consulta").list();
    }
    @Override
    public Consulta findById(Long idConsulta) {
        return (Consulta)getSession().get(Consulta.class,idConsulta);

    }
	@Override
	public LaboratorioConsulta findLaboratorioByIdAndResultados(Long idLaboratorio, String resultados) {
		// TODO Auto-generated method stub
		return null;
	}
}
