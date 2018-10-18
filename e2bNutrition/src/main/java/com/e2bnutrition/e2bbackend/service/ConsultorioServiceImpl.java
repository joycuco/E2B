package com.e2bnutrition.e2bbackend.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e2bnutrition.e2bbackend.dao.ConsultorioDao;
import com.e2bnutrition.e2bbackend.model.Consultorio;

@Service("consultorioService")
@Transactional
public class ConsultorioServiceImpl implements ConsultorioService{
	
	@Autowired
	private ConsultorioDao _consultorioDao;

	@Override
	public void saveConsultorio(Consultorio consultorio) {
		// TODO Auto-generated method stub
		_consultorioDao.saveConsultorio(consultorio);
		
	}

	@Override
	public void deleteConsultorioById(Long idConsultorio) {
		// TODO Auto-generated method stub
		_consultorioDao.deleteConsultorioById(idConsultorio);
		
	}

	@Override
	public void updateConsultorio(Consultorio consultorio) {
		// TODO Auto-generated method stub
		_consultorioDao.updateConsultorio(consultorio);
		
	}

	@Override
	public List<Consultorio> findAllConsultorios() {
		// TODO Auto-generated method stub
		return _consultorioDao.findAllConsultorios();
	}

	@Override
	public Consultorio findById(Long idConsultorio) {
		// TODO Auto-generated method stub
		return _consultorioDao.findById(idConsultorio);
	}

	@Override
	public Consultorio findByNombre(String nombre) {
		// TODO Auto-generated method stub
		return _consultorioDao.findByNombre(nombre);
	}

}
