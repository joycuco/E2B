package com.e2bnutrition.e2bbackend.service;

import java.util.List;

import com.e2bnutrition.e2bbackend.model.Consulta;

public interface ConsultaService {


	void saveConsulta(Consulta consulta);
	
	void deleteConsultaById(Long idConsulta);
	
	void updateConsulta(Consulta consulta);
		
	List<Consulta> findAllConsultas();
	
	Consulta findById(Long idConsulta);
	
	//List<Consulta> findByIdConsulta(Long idConsulta);

}
