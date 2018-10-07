package com.e2bnutrition.e2bbackend.service;

import java.util.List;

import com.e2bnutrition.e2bbackend.model.Receta;

public interface RecetaService {


	void saveReceta(Receta receta);
	
	void deleteRecetaById(Long idReceta);
	
	void updateReceta(Receta receta);
		
	List<Receta> findAllRecetas();
	
	Receta findById(Long idReceta);
	
	Receta findByNombre(String nombre);
	
	//List<Receta> findByIdPaquete(Long idPaquete);

}