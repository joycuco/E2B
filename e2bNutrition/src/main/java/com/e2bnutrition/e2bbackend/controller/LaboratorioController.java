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

import com.e2bnutrition.e2bbackend.model.Laboratorio;
import com.e2bnutrition.e2bbackend.service.LaboratorioService;
import com.e2bnutrition.e2bbackend.utils.CustomMessageType;
import com.e2bnutrition.e2bbackend.utils.ValidateData;

@Controller
@RequestMapping("/v1")
public class LaboratorioController {
	
	@Autowired
	LaboratorioService _laboratorioService;
	
	//POST
	@RequestMapping(value = "/laboratorios", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<String> createLaboratorio(@RequestBody Laboratorio laboratorio, UriComponentsBuilder uriComponentsBuilder){
		
		if (!ValidateData.isUsed(laboratorio.getNombre())) {

			return new ResponseEntity(new CustomMessageType("El nombre del laboratorio es requerido"), HttpStatus.CONFLICT);
			
		}
		
		if (_laboratorioService.findByNombre(laboratorio.getNombre())!=null) {
			
			return new ResponseEntity(new CustomMessageType("Ya existe el laboratorio "+laboratorio.getNombre()+" con el mismo nombre"), HttpStatus.CONFLICT);
		
		}
		_laboratorioService.saveLaboratorio(laboratorio);
		
		Laboratorio laboratorioSaved = _laboratorioService.findByNombre(laboratorio.getNombre());
		

		HttpHeaders headers = new HttpHeaders();
		
		headers.setLocation(
				uriComponentsBuilder.path("/v1/laboratorios/{id}").
				buildAndExpand(laboratorioSaved.getIdLaboratorio()).
				toUri());
		
		return new ResponseEntity<String>(headers,HttpStatus.OK);
	}
	
	//GET ALL	
	@RequestMapping(value = "/laboratorios", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Laboratorio>> getLaboratorios(@RequestParam(value= "nombre", required = false) String nombre){
		
		List<Laboratorio> laboratorios = new ArrayList<>();
		
		//Si la URL tiene un nombre, buscamos ese laboratorio
		if (nombre==null) {
			
			laboratorios = _laboratorioService.findAllLaboratorios();
			
			if (laboratorios.isEmpty()) {
				
				return new ResponseEntity(new CustomMessageType("No se encontraron laboratorios"), HttpStatus.NO_CONTENT);
								
			}
			
			return new ResponseEntity<List<Laboratorio>>(laboratorios,HttpStatus.OK);
		}
		//si no hay nombre en la url, devolvemos todos los laboratorios
		else {
			Laboratorio laboratorio = _laboratorioService.findByNombre(nombre);
			
			if (laboratorio== null) {
				
				return new ResponseEntity(new CustomMessageType("No se encontró el laboratorio "+ nombre), HttpStatus.NO_CONTENT);
								
			}
			
			laboratorios.add(laboratorio);
			return new ResponseEntity<List<Laboratorio>>(laboratorios,HttpStatus.OK);
			
		}			
	}
	
	// GET ON BY ID
	@RequestMapping(value = "/laboratorios/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<Laboratorio> getCourseById(@PathVariable("id") Long idLaboratorio){
		
		if(!ValidateData.isUsed(idLaboratorio)) {
			return new ResponseEntity(new CustomMessageType("idLaboratorio is required"), HttpStatus.CONFLICT);
		}
		
		Laboratorio laboratorio = _laboratorioService.findById(idLaboratorio);

		if (laboratorio==null) {
			return new ResponseEntity(new CustomMessageType("No se encontró el laboratorio "+ idLaboratorio), HttpStatus.NO_CONTENT);
			
		}
		
		return new ResponseEntity<Laboratorio>(laboratorio,HttpStatus.OK);
	}
	
	//UPDATE
	@RequestMapping(value = "/laboratorios/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<Laboratorio> updateCourse(@PathVariable("id") Long idLaboratorio, @RequestBody Laboratorio laboratorio){
		
		
		if(!ValidateData.isUsed(idLaboratorio)) {
			return new ResponseEntity(new CustomMessageType("idLaboratorio is required"), HttpStatus.CONFLICT);
		}
		
		Laboratorio currentLaboratorio = _laboratorioService.findById(idLaboratorio);

		if (currentLaboratorio==null) {
			return new ResponseEntity(new CustomMessageType("No se encontró el laboratorio "+ idLaboratorio), HttpStatus.NO_CONTENT);
			
		}
		
		currentLaboratorio.setNombre(laboratorio.getNombre());
		currentLaboratorio.setDetalle(laboratorio.getDetalle());
		
		_laboratorioService.updateLaboratorio(currentLaboratorio);
		
		return new ResponseEntity<Laboratorio>(currentLaboratorio,HttpStatus.OK);
			
	}
	
	// DELETE
	@RequestMapping(value = "/laboratorios/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteLaboratorioById(@PathVariable("id") Long idLaboratorio){
		
		if(!ValidateData.isUsed(idLaboratorio)) {
			return new ResponseEntity(new CustomMessageType("idLaboratorio is required"), HttpStatus.CONFLICT);
		}
		
		Laboratorio laboratorio = _laboratorioService.findById(idLaboratorio);

		if (laboratorio==null) {
			
			return new ResponseEntity(new CustomMessageType("No se encontró el laboratorio "+ idLaboratorio), HttpStatus.NO_CONTENT);
		}
		
		_laboratorioService.deleteLaboratorioById(idLaboratorio);
		
		return new ResponseEntity<Laboratorio>(laboratorio,HttpStatus.OK);
	}
	
	
}
