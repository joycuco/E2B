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

import com.e2bnutrition.e2bbackend.model.Consultorio;
import com.e2bnutrition.e2bbackend.service.ConsultorioService;
import com.e2bnutrition.e2bbackend.utils.CustomMessageType;
import com.e2bnutrition.e2bbackend.utils.ValidateData;

@Controller
@RequestMapping("/v1")
public class ConsultorioController {
	
	@Autowired
	ConsultorioService _consultorioService;
	
	//POST
	@RequestMapping(value = "/consultorios", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<String> createConsultorio(@RequestBody Consultorio consultorio, UriComponentsBuilder uriComponentsBuilder){
		
		if (!ValidateData.isUsed(consultorio.getNombre())) {

			return new ResponseEntity(new CustomMessageType("El nombre del consultorio es requerido"), HttpStatus.CONFLICT);
			
		}
		
		if (_consultorioService.findByNombre(consultorio.getNombre())!=null) {
			
			return new ResponseEntity(new CustomMessageType("Ya existe el consultorio "+consultorio.getNombre()+" con el mismo nombre"), HttpStatus.CONFLICT);
		
		}
		_consultorioService.saveConsultorio(consultorio);
		
		Consultorio consultorioSaved = _consultorioService.findByNombre(consultorio.getNombre());
		

		HttpHeaders headers = new HttpHeaders();
		
		headers.setLocation(
				uriComponentsBuilder.path("/v1/consultorios/{id}").
				buildAndExpand(consultorioSaved.getIdConsultorio()).
				toUri());
		
		return new ResponseEntity<String>(headers,HttpStatus.OK);
	}
	
	//GET ALL	
	@RequestMapping(value = "/consultorios", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Consultorio>> getConsultorios(@RequestParam(value= "nombre", required = false) String nombre){
		
		List<Consultorio> consultorios = new ArrayList<>();
		
		//Si la URL tiene un nombre, buscamos ese consultorio
		if (nombre==null) {
			
			consultorios = _consultorioService.findAllConsultorios();
			
			if (consultorios.isEmpty()) {
				
				return new ResponseEntity(new CustomMessageType("No se encontraron consultorios"), HttpStatus.NO_CONTENT);
								
			}
			
			return new ResponseEntity<List<Consultorio>>(consultorios,HttpStatus.OK);
		}
		//si no hay nombre en la url, devolvemos todos los consultorios
		else {
			Consultorio consultorio = _consultorioService.findByNombre(nombre);
			
			if (consultorio== null) {
				
				return new ResponseEntity(new CustomMessageType("No se encontró el consultorio "+ nombre), HttpStatus.NO_CONTENT);
								
			}
			
			consultorios.add(consultorio);
			return new ResponseEntity<List<Consultorio>>(consultorios,HttpStatus.OK);
			
		}			
	}
	
	// GET ON BY ID
	@RequestMapping(value = "/consultorios/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<Consultorio> getCourseById(@PathVariable("id") Long idConsultorio){
		
		if(!ValidateData.isUsed(idConsultorio)) {
			return new ResponseEntity(new CustomMessageType("idConsultorio is required"), HttpStatus.CONFLICT);
		}
		
		Consultorio consultorio = _consultorioService.findById(idConsultorio);

		if (consultorio==null) {
			return new ResponseEntity(new CustomMessageType("No se encontró el consultorio "+ idConsultorio), HttpStatus.NO_CONTENT);
			
		}
		
		return new ResponseEntity<Consultorio>(consultorio,HttpStatus.OK);
	}
	
	//UPDATE
	@RequestMapping(value = "/consultorios/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<Consultorio> updateCourse(@PathVariable("id") Long idConsultorio, @RequestBody Consultorio consultorio){
		
		
		if(!ValidateData.isUsed(idConsultorio)) {
			return new ResponseEntity(new CustomMessageType("idConsultorio is required"), HttpStatus.CONFLICT);
		}
		
		Consultorio currentConsultorio = _consultorioService.findById(idConsultorio);

		if (currentConsultorio==null) {
			return new ResponseEntity(new CustomMessageType("No se encontró el consultorio "+ idConsultorio), HttpStatus.NO_CONTENT);
			
		}
		
		currentConsultorio.setNombre(consultorio.getNombre());
		currentConsultorio.setDireccion(consultorio.getNombre());
		currentConsultorio.setTelefono(consultorio.getTelefono());
		currentConsultorio.setFb(consultorio.getFb());
		currentConsultorio.setTw(consultorio.getTw());
		currentConsultorio.setFechaApertura(consultorio.getFechaApertura());
		currentConsultorio.setEstatus(consultorio.getEstatus());
		
		_consultorioService.updateConsultorio(currentConsultorio);
		
		return new ResponseEntity<Consultorio>(currentConsultorio,HttpStatus.OK);
			
	}
	
	// DELETE
	@RequestMapping(value = "/consultorios/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteConsultorioById(@PathVariable("id") Long idConsultorio){
		
		if(!ValidateData.isUsed(idConsultorio)) {
			return new ResponseEntity(new CustomMessageType("idConsultorio is required"), HttpStatus.CONFLICT);
		}
		
		Consultorio consultorio = _consultorioService.findById(idConsultorio);

		if (consultorio==null) {
			
			return new ResponseEntity(new CustomMessageType("No se encontró el consultorio "+ idConsultorio), HttpStatus.NO_CONTENT);
		}
		
		_consultorioService.deleteConsultorioById(idConsultorio);
		
		return new ResponseEntity<Consultorio>(consultorio,HttpStatus.OK);
	}
	
	
}
