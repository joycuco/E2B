package com.e2bnutrition.e2bbackend.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e2bnutrition.e2bbackend.dao.PaqueteDao;
import com.e2bnutrition.e2bbackend.model.Paquete;

@Service("paqueteService")
@Transactional
public class PaqueteServiceImpl implements PaqueteService{
	
	@Autowired
	private PaqueteDao _paqueteDao;

	@Override
	public void savePaquete(Paquete paquete) {
		// TODO Auto-generated method stub
		_paqueteDao.savePaquete(paquete);
		
	}

	@Override
	public void deletePaqueteById(Long idPaquete) {
		// TODO Auto-generated method stub
		_paqueteDao.deletePaqueteById(idPaquete);
		
	}

	@Override
	public void updatePaquete(Paquete paquete) {
		// TODO Auto-generated method stub
		_paqueteDao.updatePaquete(paquete);
		
	}

	@Override
	public List<Paquete> findAllPaquetes() {
		// TODO Auto-generated method stub
		return _paqueteDao.findAllPaquetes();
	}

	@Override
	public Paquete findById(Long idPaquete) {
		// TODO Auto-generated method stub
		return _paqueteDao.findById(idPaquete);
	}

	@Override
	public Paquete findByNombre(String nombre) {
		// TODO Auto-generated method stub
		return _paqueteDao.findByNombre(nombre);
	}

}
