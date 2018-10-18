package com.e2bnutrition.e2bbackend.service;

import java.util.List;

import com.e2bnutrition.e2bbackend.model.Enfermedad;

public interface EnfermedadService {


	void saveEnfermedad(Enfermedad enfermedad);
	
	void deleteEnfermedadById(Long idEnfermedad);
	
	void updateEnfermedad(Enfermedad enfermedad);
		
	List<Enfermedad> findAllEnfermedades();
	
	Enfermedad findById(Long idEnfermedad);
	
	Enfermedad findByNombre(String nombre);
	
	//List<Enfermedad> findByIdPaquete(Long idPaquete);

}
