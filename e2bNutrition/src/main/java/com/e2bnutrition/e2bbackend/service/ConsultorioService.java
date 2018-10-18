package com.e2bnutrition.e2bbackend.service;

import java.util.List;

import com.e2bnutrition.e2bbackend.model.Consultorio;

public interface ConsultorioService {


	void saveConsultorio(Consultorio consultorio);
	
	void deleteConsultorioById(Long idConsultorio);
	
	void updateConsultorio(Consultorio consultorio);
		
	List<Consultorio> findAllConsultorios();
	
	Consultorio findById(Long idConsultorio);
	
	Consultorio findByNombre(String nombre);
	
	//List<Consultorio> findByIdConsultorio(Long idConsultorio);

}
