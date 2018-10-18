package com.e2bnutrition.e2bbackend.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e2bnutrition.e2bbackend.dao.ConsultaDao;
import com.e2bnutrition.e2bbackend.model.Consulta;

@Service("consultaService")
@Transactional
public class ConsultaServiceImpl implements ConsultaService{
	
	@Autowired
	private ConsultaDao _consultaDao;

	@Override
	public void saveConsulta(Consulta consulta) {
		// TODO Auto-generated method stub
		_consultaDao.saveConsulta(consulta);
		
	}

	@Override
	public void deleteConsultaById(Long idConsulta) {
		// TODO Auto-generated method stub
		_consultaDao.deleteConsultaById(idConsulta);
		
	}

	@Override
	public void updateConsulta(Consulta consulta) {
		// TODO Auto-generated method stub
		_consultaDao.updateConsulta(consulta);
		
	}

	@Override
	public List<Consulta> findAllConsultas() {
		// TODO Auto-generated method stub
		return _consultaDao.findAllConsultas();
	}

	@Override
	public Consulta findById(Long idConsulta) {
		// TODO Auto-generated method stub
		return _consultaDao.findById(idConsulta);
	}

}
