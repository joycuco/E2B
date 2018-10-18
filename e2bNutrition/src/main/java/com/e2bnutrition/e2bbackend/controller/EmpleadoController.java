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

import com.e2bnutrition.e2bbackend.model.Empleado;
import com.e2bnutrition.e2bbackend.service.EmpleadoService;
import com.e2bnutrition.e2bbackend.utils.CustomMessageType;
import com.e2bnutrition.e2bbackend.utils.ValidateData;

@Controller
@RequestMapping("/v1")
public class EmpleadoController {
	
	@Autowired
	EmpleadoService _empleadoService;
	
	//POST
	@RequestMapping(value = "/empleados", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<String> createEmpleado(@RequestBody Empleado empleado, UriComponentsBuilder uriComponentsBuilder){
		
		if (!ValidateData.isUsed(empleado.getNombre())) {

			return new ResponseEntity(new CustomMessageType("El nombre del empleado es requerido"), HttpStatus.CONFLICT);
			
		}
		
		if (_empleadoService.findByNombre(empleado.getNombre())!=null) {
			
			return new ResponseEntity(new CustomMessageType("Ya existe el empleado "+empleado.getNombre()+" con el mismo nombre"), HttpStatus.CONFLICT);
		
		}
		_empleadoService.saveEmpleado(empleado);
		
		Empleado empleadoSaved = _empleadoService.findByNombre(empleado.getNombre());
		

		HttpHeaders headers = new HttpHeaders();
		
		headers.setLocation(
				uriComponentsBuilder.path("/v1/empleados/{id}").
				buildAndExpand(empleadoSaved.getIdEmpleado()).
				toUri());
		
		return new ResponseEntity<String>(headers,HttpStatus.OK);
	}
	
	//GET ALL	
	@RequestMapping(value = "/empleados", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Empleado>> getEmpleados(@RequestParam(value= "nombre", required = false) String nombre){
		
		List<Empleado> empleados = new ArrayList<>();
		
		//Si la URL tiene un nombre, buscamos ese empleado
		if (nombre==null) {
			
			empleados = _empleadoService.findAllEmpleados();
			
			if (empleados.isEmpty()) {
				
				return new ResponseEntity(new CustomMessageType("No se encontraron empleados"), HttpStatus.NO_CONTENT);
								
			}
			
			return new ResponseEntity<List<Empleado>>(empleados,HttpStatus.OK);
		}
		//si no hay nombre en la url, devolvemos todos los empleados
		else {
			Empleado empleado = _empleadoService.findByNombre(nombre);
			
			if (empleado== null) {
				
				return new ResponseEntity(new CustomMessageType("No se encontró el empleado "+ nombre), HttpStatus.NO_CONTENT);
								
			}
			
			empleados.add(empleado);
			return new ResponseEntity<List<Empleado>>(empleados,HttpStatus.OK);
			
		}			
	}
	
	// GET ON BY ID
	@RequestMapping(value = "/empleados/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<Empleado> getCourseById(@PathVariable("id") Long idEmpleado){
		
		if(!ValidateData.isUsed(idEmpleado)) {
			return new ResponseEntity(new CustomMessageType("idEmpleado is required"), HttpStatus.CONFLICT);
		}
		
		Empleado empleado = _empleadoService.findById(idEmpleado);

		if (empleado==null) {
			return new ResponseEntity(new CustomMessageType("No se encontró el empleado "+ idEmpleado), HttpStatus.NO_CONTENT);
			
		}
		
		return new ResponseEntity<Empleado>(empleado,HttpStatus.OK);
	}
	
	//UPDATE
	@RequestMapping(value = "/empleados/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<Empleado> updateCourse(@PathVariable("id") Long idEmpleado, @RequestBody Empleado empleado){
		
		
		if(!ValidateData.isUsed(idEmpleado)) {
			return new ResponseEntity(new CustomMessageType("idEmpleado is required"), HttpStatus.CONFLICT);
		}
		
		Empleado currentEmpleado = _empleadoService.findById(idEmpleado);

		if (currentEmpleado==null) {
			return new ResponseEntity(new CustomMessageType("No se encontró el empleado "+ idEmpleado), HttpStatus.NO_CONTENT);
			
		}
		
		currentEmpleado.setNombre(empleado.getNombre());
		currentEmpleado.setCorreo(empleado.getCorreo());
		currentEmpleado.setDireccion(empleado.getDireccion());
		currentEmpleado.setEstatus(empleado.getEstatus());
		currentEmpleado.setPuesto(empleado.getPuesto());
		currentEmpleado.setTelCasa(empleado.getTelCasa());
		currentEmpleado.setTelCel(empleado.getTelCel());
		
		
		_empleadoService.updateEmpleado(currentEmpleado);
		
		return new ResponseEntity<Empleado>(currentEmpleado,HttpStatus.OK);
			
	}
	
	// DELETE
	@RequestMapping(value = "/empleados/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteEmpleadoById(@PathVariable("id") Long idEmpleado){
		
		if(!ValidateData.isUsed(idEmpleado)) {
			return new ResponseEntity(new CustomMessageType("idEmpleado is required"), HttpStatus.CONFLICT);
		}
		
		Empleado empleado = _empleadoService.findById(idEmpleado);

		if (empleado==null) {
			
			return new ResponseEntity(new CustomMessageType("No se encontró el empleado "+ idEmpleado), HttpStatus.NO_CONTENT);
		}
		
		_empleadoService.deleteEmpleadoById(idEmpleado);
		
		return new ResponseEntity<Empleado>(empleado,HttpStatus.OK);
	}
	
	
}
