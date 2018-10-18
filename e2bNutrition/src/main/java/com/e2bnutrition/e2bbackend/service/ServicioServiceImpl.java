package com.e2bnutrition.e2bbackend.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e2bnutrition.e2bbackend.dao.ServicioDao;
import com.e2bnutrition.e2bbackend.model.Servicio;

@Service("servicioService")
@Transactional
public class ServicioServiceImpl implements ServicioService{
	
	@Autowired
	private ServicioDao _servicioDao;

	@Override
	public void saveServicio(Servicio servicio) {
		// TODO Auto-generated method stub
		_servicioDao.saveServicio(servicio);
		
	}

	@Override
	public void deleteServicioById(Long idServicio) {
		// TODO Auto-generated method stub
		_servicioDao.deleteServicioById(idServicio);
		
	}

	@Override
	public void updateServicio(Servicio servicio) {
		// TODO Auto-generated method stub
		_servicioDao.updateServicio(servicio);
		
	}

	@Override
	public List<Servicio> findAllServicios() {
		// TODO Auto-generated method stub
		return _servicioDao.findAllServicios();
	}

	@Override
	public Servicio findById(Long idServicio) {
		// TODO Auto-generated method stub
		return _servicioDao.findById(idServicio);
	}

	@Override
	public Servicio findByNombre(String nombre) {
		// TODO Auto-generated method stub
		return _servicioDao.findByNombre(nombre);
	}

}
