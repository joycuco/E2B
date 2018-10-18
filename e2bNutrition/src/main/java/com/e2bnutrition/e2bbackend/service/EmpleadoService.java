package com.e2bnutrition.e2bbackend.service;

import java.util.List;

import com.e2bnutrition.e2bbackend.model.Empleado;

public interface EmpleadoService {


	void saveEmpleado(Empleado empleado);
	
	void deleteEmpleadoById(Long idEmpleado);
	
	void updateEmpleado(Empleado empleado);
		
	List<Empleado> findAllEmpleados();
	
	Empleado findById(Long idEmpleado);
	
	Empleado findByNombre(String nombre);
	
	//List<Empleado> findByIdPaquete(Long idPaquete);

}

