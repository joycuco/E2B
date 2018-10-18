package com.e2bnutrition.e2bbackend.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e2bnutrition.e2bbackend.dao.LaboratorioDao;
import com.e2bnutrition.e2bbackend.model.Laboratorio;

@Service("laboratorioService")
@Transactional
public class LaboratorioServiceImpl implements LaboratorioService{
	
	@Autowired
	private LaboratorioDao _laboratorioDao;

	@Override
	public void saveLaboratorio(Laboratorio laboratorio) {
		// TODO Auto-generated method stub
		_laboratorioDao.saveLaboratorio(laboratorio);
		
	}

	@Override
	public void deleteLaboratorioById(Long idLaboratorio) {
		// TODO Auto-generated method stub
		_laboratorioDao.deleteLaboratorioById(idLaboratorio);
		
	}

	@Override
	public void updateLaboratorio(Laboratorio laboratorio) {
		// TODO Auto-generated method stub
		_laboratorioDao.updateLaboratorio(laboratorio);
		
	}

	@Override
	public List<Laboratorio> findAllLaboratorios() {
		// TODO Auto-generated method stub
		return _laboratorioDao.findAllLaboratorios();
	}

	@Override
	public Laboratorio findById(Long idLaboratorio) {
		// TODO Auto-generated method stub
		return _laboratorioDao.findById(idLaboratorio);
	}

	@Override
	public Laboratorio findByNombre(String nombre) {
		// TODO Auto-generated method stub
		return _laboratorioDao.findByNombre(nombre);
	}

}
