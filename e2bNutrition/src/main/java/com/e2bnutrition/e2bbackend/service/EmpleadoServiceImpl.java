package com.e2bnutrition.e2bbackend.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e2bnutrition.e2bbackend.dao.EmpleadoDao;
import com.e2bnutrition.e2bbackend.model.Empleado;

@Service("empleadoService")
@Transactional
public class EmpleadoServiceImpl implements EmpleadoService{
	
	@Autowired
	private EmpleadoDao _empleadoDao;

	@Override
	public void saveEmpleado(Empleado empleado) {
		// TODO Auto-generated method stub
		_empleadoDao.saveEmpleado(empleado);
		
	}

	@Override
	public void deleteEmpleadoById(Long idEmpleado) {
		// TODO Auto-generated method stub
		_empleadoDao.deleteEmpleadoById(idEmpleado);
		
	}

	@Override
	public void updateEmpleado(Empleado empleado) {
		// TODO Auto-generated method stub
		_empleadoDao.updateEmpleado(empleado);
		
	}

	@Override
	public List<Empleado> findAllEmpleados() {
		// TODO Auto-generated method stub
		return _empleadoDao.findAllEmpleados();
	}

	@Override
	public Empleado findById(Long idEmpleado) {
		// TODO Auto-generated method stub
		return _empleadoDao.findById(idEmpleado);
	}

	@Override
	public Empleado findByNombre(String nombre) {
		// TODO Auto-generated method stub
		return _empleadoDao.findByNombre(nombre);
	}

}
