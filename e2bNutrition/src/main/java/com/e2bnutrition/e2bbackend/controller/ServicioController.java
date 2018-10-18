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

import com.e2bnutrition.e2bbackend.model.Servicio;
import com.e2bnutrition.e2bbackend.service.ServicioService;
import com.e2bnutrition.e2bbackend.utils.CustomMessageType;
import com.e2bnutrition.e2bbackend.utils.ValidateData;

@Controller
@RequestMapping("/v1")
public class ServicioController {
	
	@Autowired
	ServicioService _servicioService;
	
	//POST
	@RequestMapping(value = "/servicios", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<String> createServicio(@RequestBody Servicio servicio, UriComponentsBuilder uriComponentsBuilder){
		
		if (!ValidateData.isUsed(servicio.getNombre())) {

			return new ResponseEntity(new CustomMessageType("El nombre del servicio es requerido"), HttpStatus.CONFLICT);
			
		}
		
		if (_servicioService.findByNombre(servicio.getNombre())!=null) {
			
			return new ResponseEntity(new CustomMessageType("Ya existe el servicio "+servicio.getNombre()+" con el mismo nombre"), HttpStatus.CONFLICT);
		
		}
		_servicioService.saveServicio(servicio);
		
		Servicio servicioSaved = _servicioService.findByNombre(servicio.getNombre());
		

		HttpHeaders headers = new HttpHeaders();
		
		headers.setLocation(
				uriComponentsBuilder.path("/v1/servicios/{id}").
				buildAndExpand(servicioSaved.getIdServicio()).
				toUri());
		
		return new ResponseEntity<String>(headers,HttpStatus.OK);
	}
	
	//GET ALL	
	@RequestMapping(value = "/servicios", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Servicio>> getServicios(@RequestParam(value= "nombre", required = false) String nombre){
		
		List<Servicio> servicios = new ArrayList<>();
		
		//Si la URL tiene un nombre, buscamos ese servicio
		if (nombre==null) {
			
			servicios = _servicioService.findAllServicios();
			
			if (servicios.isEmpty()) {
				
				return new ResponseEntity(new CustomMessageType("No se encontraron servicios"), HttpStatus.NO_CONTENT);
								
			}
			
			return new ResponseEntity<List<Servicio>>(servicios,HttpStatus.OK);
		}
		//si no hay nombre en la url, devolvemos todos los servicios
		else {
			Servicio servicio = _servicioService.findByNombre(nombre);
			
			if (servicio== null) {
				
				return new ResponseEntity(new CustomMessageType("No se encontró el servicio "+ nombre), HttpStatus.NO_CONTENT);
								
			}
			
			servicios.add(servicio);
			return new ResponseEntity<List<Servicio>>(servicios,HttpStatus.OK);
			
		}			
	}
	
	// GET ON BY ID
	@RequestMapping(value = "/servicios/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<Servicio> getCourseById(@PathVariable("id") Long idServicio){
		
		if(!ValidateData.isUsed(idServicio)) {
			return new ResponseEntity(new CustomMessageType("idServicio is required"), HttpStatus.CONFLICT);
		}
		
		Servicio servicio = _servicioService.findById(idServicio);

		if (servicio==null) {
			return new ResponseEntity(new CustomMessageType("No se encontró el servicio "+ idServicio), HttpStatus.NO_CONTENT);
			
		}
		
		return new ResponseEntity<Servicio>(servicio,HttpStatus.OK);
	}
	
	//UPDATE
	@RequestMapping(value = "/servicios/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<Servicio> updateCourse(@PathVariable("id") Long idServicio, @RequestBody Servicio servicio){
		
		
		if(!ValidateData.isUsed(idServicio)) {
			return new ResponseEntity(new CustomMessageType("idServicio is required"), HttpStatus.CONFLICT);
		}
		
		Servicio currentServicio = _servicioService.findById(idServicio);

		if (currentServicio==null) {
			return new ResponseEntity(new CustomMessageType("No se encontró el servicio "+ idServicio), HttpStatus.NO_CONTENT);
			
		}
		
		currentServicio.setNombre(servicio.getNombre());
		currentServicio.setPrecio(servicio.getPrecio());
		
		_servicioService.updateServicio(currentServicio);
		
		return new ResponseEntity<Servicio>(currentServicio,HttpStatus.OK);
			
	}
	
	// DELETE
	@RequestMapping(value = "/servicios/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteServicioById(@PathVariable("id") Long idServicio){
		
		if(!ValidateData.isUsed(idServicio)) {
			return new ResponseEntity(new CustomMessageType("idServicio is required"), HttpStatus.CONFLICT);
		}
		
		Servicio servicio = _servicioService.findById(idServicio);

		if (servicio==null) {
			
			return new ResponseEntity(new CustomMessageType("No se encontró el servicio "+ idServicio), HttpStatus.NO_CONTENT);
		}
		
		_servicioService.deleteServicioById(idServicio);
		
		return new ResponseEntity<Servicio>(servicio,HttpStatus.OK);
	}
	
	
}
