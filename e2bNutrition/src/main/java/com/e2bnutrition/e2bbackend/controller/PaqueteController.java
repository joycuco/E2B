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

import com.e2bnutrition.e2bbackend.model.Paquete;
import com.e2bnutrition.e2bbackend.service.PaqueteService;
import com.e2bnutrition.e2bbackend.utils.CustomMessageType;
import com.e2bnutrition.e2bbackend.utils.ValidateData;

@Controller
@RequestMapping("/v1")
public class PaqueteController {
	
	@Autowired
	PaqueteService _paqueteService;
	
	//POST
	@RequestMapping(value = "/paquetes", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<String> createPaquete(@RequestBody Paquete paquete, UriComponentsBuilder uriComponentsBuilder){
		
		if (!ValidateData.isUsed(paquete.getNombre())) {

			return new ResponseEntity(new CustomMessageType("El nombre del paquete es requerido"), HttpStatus.CONFLICT);
			
		}
		
		if (_paqueteService.findByNombre(paquete.getNombre())!=null) {
			
			return new ResponseEntity(new CustomMessageType("Ya existe el paquete "+paquete.getNombre()+" con el mismo nombre"), HttpStatus.CONFLICT);
		
		}
		_paqueteService.savePaquete(paquete);
		
		Paquete paqueteSaved = _paqueteService.findByNombre(paquete.getNombre());
		

		HttpHeaders headers = new HttpHeaders();
		
		headers.setLocation(
				uriComponentsBuilder.path("/v1/paquetes/{id}").
				buildAndExpand(paqueteSaved.getIdPaquete()).
				toUri());
		
		return new ResponseEntity<String>(headers,HttpStatus.OK);
	}
	
	//GET ALL	
	@RequestMapping(value = "/paquetes", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Paquete>> getPaquetes(@RequestParam(value= "nombre", required = false) String nombre){
		
		List<Paquete> paquetes = new ArrayList<>();
		
		//Si la URL tiene un nombre, buscamos ese paquete
		if (nombre==null) {
			
			paquetes = _paqueteService.findAllPaquetes();
			
			if (paquetes.isEmpty()) {
				
				return new ResponseEntity(new CustomMessageType("No se encontraron paquetes"), HttpStatus.NO_CONTENT);
								
			}
			
			return new ResponseEntity<List<Paquete>>(paquetes,HttpStatus.OK);
		}
		//si no hay nombre en la url, devolvemos todos los paquetes
		else {
			Paquete paquete = _paqueteService.findByNombre(nombre);
			
			if (paquete== null) {
				
				return new ResponseEntity(new CustomMessageType("No se encontró el paquete "+ nombre), HttpStatus.NO_CONTENT);
								
			}
			
			paquetes.add(paquete);
			return new ResponseEntity<List<Paquete>>(paquetes,HttpStatus.OK);
			
		}			
	}
	
	// GET ON BY ID
	@RequestMapping(value = "/paquetes/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<Paquete> getCourseById(@PathVariable("id") Long idPaquete){
		
		if(!ValidateData.isUsed(idPaquete)) {
			return new ResponseEntity(new CustomMessageType("idPaquete is required"), HttpStatus.CONFLICT);
		}
		
		Paquete paquete = _paqueteService.findById(idPaquete);

		if (paquete==null) {
			return new ResponseEntity(new CustomMessageType("No se encontró el paquete "+ idPaquete), HttpStatus.NO_CONTENT);
			
		}
		
		return new ResponseEntity<Paquete>(paquete,HttpStatus.OK);
	}
	
	//UPDATE
	@RequestMapping(value = "/paquetes/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<Paquete> updateCourse(@PathVariable("id") Long idPaquete, @RequestBody Paquete paquete){
		
		
		if(!ValidateData.isUsed(idPaquete)) {
			return new ResponseEntity(new CustomMessageType("idPaquete is required"), HttpStatus.CONFLICT);
		}
		
		Paquete currentPaquete = _paqueteService.findById(idPaquete);

		if (currentPaquete==null) {
			return new ResponseEntity(new CustomMessageType("No se encontró el paquete "+ idPaquete), HttpStatus.NO_CONTENT);
			
		}
		
		currentPaquete.setNombre(paquete.getNombre());
		currentPaquete.setPrecio(paquete.getPrecio());
		
		_paqueteService.updatePaquete(currentPaquete);
		
		return new ResponseEntity<Paquete>(currentPaquete,HttpStatus.OK);
			
	}
	
	// DELETE
	@RequestMapping(value = "/paquetes/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deletePaqueteById(@PathVariable("id") Long idPaquete){
		
		if(!ValidateData.isUsed(idPaquete)) {
			return new ResponseEntity(new CustomMessageType("idPaquete is required"), HttpStatus.CONFLICT);
		}
		
		Paquete paquete = _paqueteService.findById(idPaquete);

		if (paquete==null) {
			
			return new ResponseEntity(new CustomMessageType("No se encontró el paquete "+ idPaquete), HttpStatus.NO_CONTENT);
		}
		
		_paqueteService.deletePaqueteById(idPaquete);
		
		return new ResponseEntity<Paquete>(paquete,HttpStatus.OK);
	}
	
	
}
