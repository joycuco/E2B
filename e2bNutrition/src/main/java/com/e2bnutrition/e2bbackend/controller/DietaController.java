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

import com.e2bnutrition.e2bbackend.model.Dieta;
import com.e2bnutrition.e2bbackend.service.DietaService;
import com.e2bnutrition.e2bbackend.utils.CustomMessageType;
import com.e2bnutrition.e2bbackend.utils.ValidateData;

@Controller
@RequestMapping("/v1")
public class DietaController {
	
	@Autowired
	DietaService _dietaService;
	
	//POST
	@RequestMapping(value = "/dietas", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<String> createDieta(@RequestBody Dieta dieta, UriComponentsBuilder uriComponentsBuilder){
		
		if (!ValidateData.isUsed(dieta.getTipo())) {

			return new ResponseEntity(new CustomMessageType("El tipo del dieta es requerido"), HttpStatus.CONFLICT);
			
		}
		
		if (_dietaService.findByTipo(dieta.getTipo())!=null) {
			
			return new ResponseEntity(new CustomMessageType("Ya existe el dieta "+dieta.getTipo()+" con el mismo tipo"), HttpStatus.CONFLICT);
		
		}
		_dietaService.saveDieta(dieta);
		
		Dieta dietaSaved = _dietaService.findByTipo(dieta.getTipo());
		

		HttpHeaders headers = new HttpHeaders();
		
		headers.setLocation(
				uriComponentsBuilder.path("/v1/dietas/{id}").
				buildAndExpand(dietaSaved.getIdDieta()).
				toUri());
		
		return new ResponseEntity<String>(headers,HttpStatus.OK);
	}
	
	//GET ALL	
	@RequestMapping(value = "/dietas", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Dieta>> getDietas(@RequestParam(value= "tipo", required = false) String tipo){
		
		List<Dieta> dietas = new ArrayList<>();
		
		//Si la URL tiene un tipo, buscamos ese dieta
		if (tipo==null) {
			
			dietas = _dietaService.findAllDietas();
			
			if (dietas.isEmpty()) {
				
				return new ResponseEntity(new CustomMessageType("No se encontraron dietas"), HttpStatus.NO_CONTENT);
								
			}
			
			return new ResponseEntity<List<Dieta>>(dietas,HttpStatus.OK);
		}
		//si no hay tipo en la url, devolvemos todos los dietas
		else {
			Dieta dieta = _dietaService.findByTipo(tipo);
			
			if (dieta== null) {
				
				return new ResponseEntity(new CustomMessageType("No se encontró la dieta "+ tipo), HttpStatus.NO_CONTENT);
								
			}
			
			dietas.add(dieta);
			return new ResponseEntity<List<Dieta>>(dietas,HttpStatus.OK);
			
		}			
	}
	
	// GET ON BY ID
	@RequestMapping(value = "/dietas/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<Dieta> getCourseById(@PathVariable("id") Long idDieta){
		
		if(!ValidateData.isUsed(idDieta)) {
			return new ResponseEntity(new CustomMessageType("idDieta is required"), HttpStatus.CONFLICT);
		}
		
		Dieta dieta = _dietaService.findById(idDieta);

		if (dieta==null) {
			return new ResponseEntity(new CustomMessageType("No se encontró la dieta "+ idDieta), HttpStatus.NO_CONTENT);
			
		}
		
		return new ResponseEntity<Dieta>(dieta,HttpStatus.OK);
	}
	
	//UPDATE
	@RequestMapping(value = "/dietas/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<Dieta> updateCourse(@PathVariable("id") Long idDieta, @RequestBody Dieta dieta){
		
		
		if(!ValidateData.isUsed(idDieta)) {
			return new ResponseEntity(new CustomMessageType("idDieta is required"), HttpStatus.CONFLICT);
		}
		
		Dieta currentDieta = _dietaService.findById(idDieta);

		if (currentDieta==null) {
			return new ResponseEntity(new CustomMessageType("No se encontró la dieta "+ idDieta), HttpStatus.NO_CONTENT);
			
		}
		
		currentDieta.setTipo(dieta.getTipo());
		currentDieta.setHc(dieta.getHc());
		currentDieta.setKc(dieta.getKc());
		currentDieta.setLipidos(dieta.getLipidos());
		currentDieta.setProteinas(dieta.getProteinas());
		
		_dietaService.updateDieta(currentDieta);
		
		return new ResponseEntity<Dieta>(currentDieta,HttpStatus.OK);
			
	}
	
	// DELETE
	@RequestMapping(value = "/dietas/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteDietaById(@PathVariable("id") Long idDieta){
		
		if(!ValidateData.isUsed(idDieta)) {
			return new ResponseEntity(new CustomMessageType("idDieta es requerida"), HttpStatus.CONFLICT);
		}
		
		Dieta dieta = _dietaService.findById(idDieta);

		if (dieta==null) {
			
			return new ResponseEntity(new CustomMessageType("No se encontró el dieta "+ idDieta), HttpStatus.NO_CONTENT);
		}
		
		_dietaService.deleteDietaById(idDieta);
		
		return new ResponseEntity<Dieta>(dieta,HttpStatus.OK);
	}
	
	
}
