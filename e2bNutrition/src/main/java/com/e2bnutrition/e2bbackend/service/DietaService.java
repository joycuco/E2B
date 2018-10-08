package com.e2bnutrition.e2bbackend.service;

import java.util.List;

import com.e2bnutrition.e2bbackend.model.Dieta;

public interface DietaService {


	void saveDieta(Dieta dieta);
	
	void deleteDietaById(Long idDieta);
	
	void updateDieta(Dieta dieta);
		
	List<Dieta> findAllDietas();
	
	Dieta findById(Long idDieta);
	
	Dieta findByTipo(String tipo);
	
	//List<Dieta> findByIdPaquete(Long idPaquete);

}