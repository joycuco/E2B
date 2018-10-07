package com.e2bnutrition.e2bbackend.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e2bnutrition.e2bbackend.dao.RecetaDao;
import com.e2bnutrition.e2bbackend.model.Receta;

@Service("recetaService")
@Transactional
public class RecetaServiceImpl implements RecetaService{
	
	@Autowired
	private RecetaDao _recetaDao;

	@Override
	public void saveReceta(Receta receta) {
		// TODO Auto-generated method stub
		_recetaDao.saveReceta(receta);
		
	}

	@Override
	public void deleteRecetaById(Long idReceta) {
		// TODO Auto-generated method stub
		_recetaDao.deleteRecetaById(idReceta);
		
	}

	@Override
	public void updateReceta(Receta receta) {
		// TODO Auto-generated method stub
		_recetaDao.updateReceta(receta);
		
	}

	@Override
	public List<Receta> findAllRecetas() {
		// TODO Auto-generated method stub
		return _recetaDao.findAllRecetas();
	}

	@Override
	public Receta findById(Long idReceta) {
		// TODO Auto-generated method stub
		return _recetaDao.findById(idReceta);
	}

	@Override
	public Receta findByNombre(String nombre) {
		// TODO Auto-generated method stub
		return _recetaDao.findByNombre(nombre);
	}

}
