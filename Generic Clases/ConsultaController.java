package com.e2bnutrition.e2bbackend.controller;

import java.util.ArrayList;
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
import com.e2bnutrition.e2bbackend.service.ConsultaService;
import com.e2bnutrition.e2bbackend.utils.CustomMessageType;
import com.e2bnutrition.e2bbackend.utils.ValidateData;

@Controller
@RequestMapping("/v1")
public class ConsultaController {
	
	@Autowired
	ConsultaService _consultaService;
	
	//POST
	@RequestMapping(value = "/consultas", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<String> createConsulta(@RequestBody Consulta consulta, UriComponentsBuilder uriComponentsBuilder){
		
		if (!ValidateData.isUsed(consulta.getNombre())) {

			return new ResponseEntity(new CustomMessageType("El nombre del consulta es requerido"), HttpStatus.CONFLICT);
			
		}
		
		if (_consultaService.findByNombre(consulta.getNombre())!=null) {
			
			return new ResponseEntity(new CustomMessageType("Ya existe el consulta "+consulta.getNombre()+" con el mismo nombre"), HttpStatus.CONFLICT);
		
		}
		_consultaService.saveConsulta(consulta);
		
		Consulta consultaSaved = _consultaService.findByNombre(consulta.getNombre());
		

		HttpHeaders headers = new HttpHeaders();
		
		headers.setLocation(
				uriComponentsBuilder.path("/v1/consultas/{id}").
				buildAndExpand(consultaSaved.getIdConsulta()).
				toUri());
		
		return new ResponseEntity<String>(headers,HttpStatus.OK);
	}
	
	//GET ALL	
	@RequestMapping(value = "/consultas", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Consulta>> getConsultas(@RequestParam(value= "nombre", required = false) String nombre){
		
		List<Consulta> consultas = new ArrayList<>();
		
		//Si la URL tiene un nombre, buscamos ese consulta
		if (nombre==null) {
			
			consultas = _consultaService.findAllConsultas();
			
			if (consultas.isEmpty()) {
				
				return new ResponseEntity(new CustomMessageType("No se encontraron consultas"), HttpStatus.NO_CONTENT);
								
			}
			
			return new ResponseEntity<List<Consulta>>(consultas,HttpStatus.OK);
		}
		//si no hay nombre en la url, devolvemos todos los consultas
		else {
			Consulta consulta = _consultaService.findByNombre(nombre);
			
			if (consulta== null) {
				
				return new ResponseEntity(new CustomMessageType("No se encontró el consulta "+ nombre), HttpStatus.NO_CONTENT);
								
			}
			
			consultas.add(consulta);
			return new ResponseEntity<List<Consulta>>(consultas,HttpStatus.OK);
			
		}			
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
		
		currentConsulta.setNombre(consulta.getNombre());
		currentConsulta.setPrecio(consulta.getPrecio());
		currentConsulta.setStock(consulta.getStock());
		currentConsulta.setTamanio(consulta.getTamanio());
		
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
	
	
}
