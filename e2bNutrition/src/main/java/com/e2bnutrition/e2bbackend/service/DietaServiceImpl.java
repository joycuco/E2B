package com.e2bnutrition.e2bbackend.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e2bnutrition.e2bbackend.dao.DietaDao;
import com.e2bnutrition.e2bbackend.model.Dieta;

@Service("dietaService")
@Transactional
public class DietaServiceImpl implements DietaService{
	
	@Autowired
	private DietaDao _dietaDao;

	@Override
	public void saveDieta(Dieta dieta) {
		// TODO Auto-generated method stub
		_dietaDao.saveDieta(dieta);
		
	}

	@Override
	public void deleteDietaById(Long idDieta) {
		// TODO Auto-generated method stub
		_dietaDao.deleteDietaById(idDieta);
		
	}

	@Override
	public void updateDieta(Dieta dieta) {
		// TODO Auto-generated method stub
		_dietaDao.updateDieta(dieta);
		
	}

	@Override
	public List<Dieta> findAllDietas() {
		// TODO Auto-generated method stub
		return _dietaDao.findAllDietas();
	}

	@Override
	public Dieta findById(Long idDieta) {
		// TODO Auto-generated method stub
		return _dietaDao.findById(idDieta);
	}

	@Override
	public Dieta findByTipo(String tipo) {
		// TODO Auto-generated method stub
		return _dietaDao.findByTipo(tipo);
	}

}
