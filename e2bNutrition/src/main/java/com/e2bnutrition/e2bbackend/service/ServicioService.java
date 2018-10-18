package com.e2bnutrition.e2bbackend.service;

import java.util.List;

import com.e2bnutrition.e2bbackend.model.Servicio;

public interface ServicioService {


	void saveServicio(Servicio servicio);
	
	void deleteServicioById(Long idServicio);
	
	void updateServicio(Servicio servicio);
		
	List<Servicio> findAllServicios();
	
	Servicio findById(Long idServicio);
	
	Servicio findByNombre(String nombre);
	
	//List<Servicio> findByIdPaquete(Long idPaquete);

}
