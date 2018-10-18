package com.e2bnutrition.e2bbackend.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponentsBuilder;

import com.e2bnutrition.e2bbackend.model.Consulta;
import com.e2bnutrition.e2bbackend.model.Laboratorio;
import com.e2bnutrition.e2bbackend.model.LaboratorioConsulta;
import com.e2bnutrition.e2bbackend.model.Receta;
import com.e2bnutrition.e2bbackend.service.ConsultaService;
import com.e2bnutrition.e2bbackend.service.LaboratorioService;
import com.e2bnutrition.e2bbackend.utils.CustomMessageType;
import com.e2bnutrition.e2bbackend.utils.ValidateData;

@Controller
@RequestMapping("/v1")
public class ConsultaController {
	
	@Autowired
	ConsultaService _consultaService;
	@Autowired
	LaboratorioService _laboratorioService;
	
	//POST
	@RequestMapping(value = "/consultas", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<Consulta> createConsulta(@RequestBody Consulta consulta){
	
		_consultaService.saveConsulta(consulta);
		return new ResponseEntity<Consulta>(consulta,HttpStatus.OK);
	}
	
	//GET ALL	
	@RequestMapping(value = "/consultas", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Consulta>> getConsultas(@RequestParam(value= "id_paciente", required = false) String nombre){
		
		List<Consulta> consultas = new ArrayList<>();
		
		//Si la URL NO tiene un nombre, buscamos ese consulta
		//if (nombre==null) {
			
			consultas = _consultaService.findAllConsultas();
			
			if (consultas.isEmpty()) {
				
				return new ResponseEntity(new CustomMessageType("No se encontraron consultas"), HttpStatus.NO_CONTENT);
								
			}
			
			return new ResponseEntity<List<Consulta>>(consultas,HttpStatus.OK);
		/*}
		//si hay nombre en la url, devolvemos por nombre
		else {
			Consulta consulta = _consultaService.findByNombre(nombre);
			
			if (consulta== null) {
				
				return new ResponseEntity(new CustomMessageType("No se encontró el consulta "+ nombre), HttpStatus.NO_CONTENT);
								
			}
			
			consultas.add(consulta);
			return new ResponseEntity<List<Consulta>>(consultas,HttpStatus.OK);
			
		}		*/	
	}
	
	// GET ON BY ID
	@RequestMapping(value = "/consultas/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<Consulta> getCourseById(@PathVariable("id") Long idConsulta){
		
		if(!ValidateData.isUsed(idConsulta)) {
			return new ResponseEntity(new CustomMessageType("idConsulta is required"), HttpStatus.CONFLICT);
		}
		
		Consulta consulta = _consultaService.findById(idConsulta);

		if (consulta==null) {
			return new ResponseEntity(new CustomMessageType("No se encontró el consulta "+ idConsulta), HttpStatus.NO_CONTENT);
			
		}
		
		return new ResponseEntity<Consulta>(consulta,HttpStatus.OK);
	}
	
	//UPDATE
	@RequestMapping(value = "/consultas/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<Consulta> updateCourse(@PathVariable("id") Long idConsulta, @RequestBody Consulta consulta){
		
		
		if(!ValidateData.isUsed(idConsulta)) {
			return new ResponseEntity(new CustomMessageType("idConsulta is required"), HttpStatus.CONFLICT);
		}
		
		Consulta currentConsulta = _consultaService.findById(idConsulta);

		if (currentConsulta==null) {
			return new ResponseEntity(new CustomMessageType("No se encontró el consulta "+ idConsulta), HttpStatus.NO_CONTENT);
			
		}
		
		currentConsulta.setCadera(consulta.getCadera());
		currentConsulta.setCintura(consulta.getCintura());
		currentConsulta.setComplexion(consulta.getComplexion());
		currentConsulta.setEstatura(consulta.getEstatura());
		currentConsulta.setImc(consulta.getImc());
		currentConsulta.setMasaMagra(consulta.getMasaMagra());
		currentConsulta.setMunieca(consulta.getMunieca());
		currentConsulta.setPeso(consulta.getPeso());
		currentConsulta.setPesoIdeal(consulta.getPesoIdeal());
		currentConsulta.setpGrasa(consulta.getpGrasa());
		
		_consultaService.updateConsulta(currentConsulta);
		
		return new ResponseEntity<Consulta>(currentConsulta,HttpStatus.OK);
			
	}
	
	// DELETE
	@RequestMapping(value = "/consultas/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteConsultaById(@PathVariable("id") Long idConsulta){
		
		if(!ValidateData.isUsed(idConsulta)) {
			return new ResponseEntity(new CustomMessageType("idConsulta is required"), HttpStatus.CONFLICT);
		}
		
		Consulta consulta = _consultaService.findById(idConsulta);

		if (consulta==null) {
			
			return new ResponseEntity(new CustomMessageType("No se encontró el consulta "+ idConsulta), HttpStatus.NO_CONTENT);
		}
		
		_consultaService.deleteConsultaById(idConsulta);
		
		return new ResponseEntity<Consulta>(consulta,HttpStatus.OK);
	}
	
	
	//POST el más perro!
	
		@RequestMapping(value="consultas/laboratorios",  method = RequestMethod.PATCH, headers ="Accept=application/json")
		public ResponseEntity<?> assignEjemplosLaboratorios(@RequestBody Consulta consulta, UriComponentsBuilder uriComponentsBuilder){
			
			//return new ResponseEntity<Consulta>(consulta, HttpStatus.OK);
			
			
			if (consulta.getIdConsulta()==null) {
				
				return new ResponseEntity(new CustomMessageType("We need at least id_Consulta, id_laboratorio and resultados"), HttpStatus.NO_CONTENT);
				
			}
			
			
			Consulta consultaSaved= _consultaService.findById(consulta.getIdConsulta());
			
			if (consultaSaved==null) {				
				return new ResponseEntity(new CustomMessageType("We need at least id_Consulta, id_laboratorio and resultados"), HttpStatus.NO_CONTENT);	
			}
			
			if (consulta.getLaboratoriosConsulta().size()==0) {
				return new ResponseEntity(new CustomMessageType("We need at least id_Consulta, id_laboratorio and resultados"), HttpStatus.NO_CONTENT);	
				
			}
			else {
				
				Iterator<LaboratorioConsulta> i = consulta.getLaboratoriosConsulta().iterator();
				
				while(i.hasNext()) {
					
					LaboratorioConsulta laboratorioConsulta = i.next();

					if ((laboratorioConsulta.getLaboratorio().getIdLaboratorio()==null)||(laboratorioConsulta.getResultados()==null)) {
						
						return new ResponseEntity(new CustomMessageType("We need at least id_consulta, id_laboratorio and tipo_alimento"), HttpStatus.NO_CONTENT);	
						
					}else {
						
						
						Laboratorio lab = _laboratorioService.findById(laboratorioConsulta.getLaboratorio().getIdLaboratorio());
						
						
						if (lab==null) {
							
							return new ResponseEntity(new CustomMessageType("Id Lab not found"), HttpStatus.NO_CONTENT);	
							
						}

						laboratorioConsulta.setLaboratorio(lab);
		
						laboratorioConsulta.setConsulta(consultaSaved);
						
						consultaSaved.getLaboratoriosConsulta().add(laboratorioConsulta);


						//return new ResponseEntity<LaboratorioConsulta>(laboratorioConsulta, HttpStatus.OK);
				
						
							LinkedList<LaboratorioConsulta> laboratoriosConsulta = new LinkedList<>();
							
							laboratoriosConsulta.addAll(consultaSaved.getLaboratoriosConsulta());
							
							
							for(int j = 0;j<laboratoriosConsulta.size();j++) {
								LaboratorioConsulta laboratorioConsulta2 = laboratoriosConsulta.get(j);

								//return new ResponseEntity<LaboratorioConsulta>(laboratorioConsulta, HttpStatus.OK);
						
								
								if (laboratorioConsulta.getConsulta().getIdConsulta() == laboratorioConsulta2.getConsulta().getIdConsulta()
										&& laboratorioConsulta.getLaboratorio().getIdLaboratorio() == laboratorioConsulta2.getLaboratorio().getIdLaboratorio()) {
									
									laboratorioConsulta.setResultados(laboratorioConsulta.getResultados());
									laboratoriosConsulta.set(j, laboratorioConsulta2);									
								}
								
								else {
									laboratoriosConsulta.set(j, laboratorioConsulta2);
								}
							}
							
							//laboratoriosConsulta.set(0, laboratorioConsulta);
							
							consultaSaved.getLaboratoriosConsulta().clear();
							consultaSaved.getLaboratoriosConsulta().addAll(laboratoriosConsulta);

							
						}
					}
			}
			
			_consultaService.updateConsulta(consultaSaved);
			return new ResponseEntity<Consulta>(consultaSaved, HttpStatus.OK);
		}
		
	
		
	
}
