package com.e2bnutrition.e2bbackend.service;

import java.util.List;

import com.e2bnutrition.e2bbackend.model.Paquete;

public interface PaqueteService {


	void savePaquete(Paquete paquete);
	
	void deletePaqueteById(Long idPaquete);
	
	void updatePaquete(Paquete paquete);
		
	List<Paquete> findAllPaquetes();
	
	Paquete findById(Long idPaquete);
	
	Paquete findByNombre(String nombre);
	
	//List<Paquete> findByIdPaquete(Long idPaquete);

}
