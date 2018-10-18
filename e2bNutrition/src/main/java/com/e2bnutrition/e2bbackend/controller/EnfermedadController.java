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

import com.e2bnutrition.e2bbackend.model.Enfermedad;
import com.e2bnutrition.e2bbackend.service.EnfermedadService;
import com.e2bnutrition.e2bbackend.utils.CustomMessageType;
import com.e2bnutrition.e2bbackend.utils.ValidateData;

@Controller
@RequestMapping("/v1")
public class EnfermedadController {
	
	@Autowired
	EnfermedadService _enfermedadService;
	
	//POST
	@RequestMapping(value = "/enfermedades", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<String> createEnfermedad(@RequestBody Enfermedad enfermedad, UriComponentsBuilder uriComponentsBuilder){
		
		if (!ValidateData.isUsed(enfermedad.getNombre())) {

			return new ResponseEntity(new CustomMessageType("El nombre del enfermedad es requerido"), HttpStatus.CONFLICT);
			
		}
		
		if (_enfermedadService.findByNombre(enfermedad.getNombre())!=null) {
			
			return new ResponseEntity(new CustomMessageType("Ya existe el enfermedad "+enfermedad.getNombre()+" con el mismo nombre"), HttpStatus.CONFLICT);
		
		}
		_enfermedadService.saveEnfermedad(enfermedad);
		
		Enfermedad enfermedadSaved = _enfermedadService.findByNombre(enfermedad.getNombre());
		

		HttpHeaders headers = new HttpHeaders();
		
		headers.setLocation(
				uriComponentsBuilder.path("/v1/enfermedades/{id}").
				buildAndExpand(enfermedadSaved.getIdEnfermedad()).
				toUri());
		
		return new ResponseEntity<String>(headers,HttpStatus.OK);
	}
	
	//GET ALL	
	@RequestMapping(value = "/enfermedades", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Enfermedad>> getEnfermedades(@RequestParam(value= "nombre", required = false) String nombre){
		
		List<Enfermedad> enfermedades = new ArrayList<>();
		
		//Si la URL tiene un nombre, buscamos ese enfermedad
		if (nombre==null) {
			
			enfermedades = _enfermedadService.findAllEnfermedades();
			
			if (enfermedades.isEmpty()) {
				
				return new ResponseEntity(new CustomMessageType("No se encontraron enfermedades"), HttpStatus.NO_CONTENT);
								
			}
			
			return new ResponseEntity<List<Enfermedad>>(enfermedades,HttpStatus.OK);
		}
		//si no hay nombre en la url, devolvemos todos los enfermedades
		else {
			Enfermedad enfermedad = _enfermedadService.findByNombre(nombre);
			
			if (enfermedad== null) {
				
				return new ResponseEntity(new CustomMessageType("No se encontró el enfermedad "+ nombre), HttpStatus.NO_CONTENT);
								
			}
			
			enfermedades.add(enfermedad);
			return new ResponseEntity<List<Enfermedad>>(enfermedades,HttpStatus.OK);
			
		}			
	}
	
	// GET ON BY ID
	@RequestMapping(value = "/enfermedades/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<Enfermedad> getCourseById(@PathVariable("id") Long idEnfermedad){
		
		if(!ValidateData.isUsed(idEnfermedad)) {
			return new ResponseEntity(new CustomMessageType("idEnfermedad is required"), HttpStatus.CONFLICT);
		}
		
		Enfermedad enfermedad = _enfermedadService.findById(idEnfermedad);

		if (enfermedad==null) {
			return new ResponseEntity(new CustomMessageType("No se encontró el enfermedad "+ idEnfermedad), HttpStatus.NO_CONTENT);
			
		}
		
		return new ResponseEntity<Enfermedad>(enfermedad,HttpStatus.OK);
	}
	
	//UPDATE
	@RequestMapping(value = "/enfermedades/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<Enfermedad> updateCourse(@PathVariable("id") Long idEnfermedad, @RequestBody Enfermedad enfermedad){
		
		
		if(!ValidateData.isUsed(idEnfermedad)) {
			return new ResponseEntity(new CustomMessageType("idEnfermedad is required"), HttpStatus.CONFLICT);
		}
		
		Enfermedad currentEnfermedad = _enfermedadService.findById(idEnfermedad);

		if (currentEnfermedad==null) {
			return new ResponseEntity(new CustomMessageType("No se encontró el enfermedad "+ idEnfermedad), HttpStatus.NO_CONTENT);
			
		}
		
		currentEnfermedad.setNombre(enfermedad.getNombre());
		
		_enfermedadService.updateEnfermedad(currentEnfermedad);
		
		return new ResponseEntity<Enfermedad>(currentEnfermedad,HttpStatus.OK);
			
	}
	
	// DELETE
	@RequestMapping(value = "/enfermedades/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteEnfermedadById(@PathVariable("id") Long idEnfermedad){
		
		if(!ValidateData.isUsed(idEnfermedad)) {
			return new ResponseEntity(new CustomMessageType("idEnfermedad is required"), HttpStatus.CONFLICT);
		}
		
		Enfermedad enfermedad = _enfermedadService.findById(idEnfermedad);

		if (enfermedad==null) {
			
			return new ResponseEntity(new CustomMessageType("No se encontró el enfermedad "+ idEnfermedad), HttpStatus.NO_CONTENT);
		}
		
		_enfermedadService.deleteEnfermedadById(idEnfermedad);
		
		return new ResponseEntity<Enfermedad>(enfermedad,HttpStatus.OK);
	}
	
	
}
