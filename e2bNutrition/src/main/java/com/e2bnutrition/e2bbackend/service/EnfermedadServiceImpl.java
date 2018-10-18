package com.e2bnutrition.e2bbackend.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e2bnutrition.e2bbackend.dao.EnfermedadDao;
import com.e2bnutrition.e2bbackend.model.Enfermedad;

@Service("enfermedadService")
@Transactional
public class EnfermedadServiceImpl implements EnfermedadService{
	
	@Autowired
	private EnfermedadDao _enfermedadDao;

	@Override
	public void saveEnfermedad(Enfermedad enfermedad) {
		// TODO Auto-generated method stub
		_enfermedadDao.saveEnfermedad(enfermedad);
		
	}

	@Override
	public void deleteEnfermedadById(Long idEnfermedad) {
		// TODO Auto-generated method stub
		_enfermedadDao.deleteEnfermedadById(idEnfermedad);
		
	}

	@Override
	public void updateEnfermedad(Enfermedad enfermedad) {
		// TODO Auto-generated method stub
		_enfermedadDao.updateEnfermedad(enfermedad);
		
	}

	@Override
	public List<Enfermedad> findAllEnfermedades() {
		// TODO Auto-generated method stub
		return _enfermedadDao.findAllEnfermedades();
	}

	@Override
	public Enfermedad findById(Long idEnfermedad) {
		// TODO Auto-generated method stub
		return _enfermedadDao.findById(idEnfermedad);
	}

	@Override
	public Enfermedad findByNombre(String nombre) {
		// TODO Auto-generated method stub
		return _enfermedadDao.findByNombre(nombre);
	}

}
