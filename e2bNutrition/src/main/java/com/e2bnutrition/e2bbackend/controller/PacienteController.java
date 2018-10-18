package com.e2bnutrition.e2bbackend.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
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

import com.e2bnutrition.e2bbackend.model.Paciente;
import com.e2bnutrition.e2bbackend.service.PacienteService;
import com.e2bnutrition.e2bbackend.utils.CustomMessageType;
import com.e2bnutrition.e2bbackend.utils.ValidateData;

@Controller
@RequestMapping("/v1")
public class PacienteController {
	
	@Autowired
	PacienteService _pacienteService;
	
	//POST
	@RequestMapping(value = "/pacientes", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<String> createPaciente(@RequestBody Paciente paciente, UriComponentsBuilder uriComponentsBuilder){
		
		if (!ValidateData.isUsed(paciente.getNombre())) {

			return new ResponseEntity(new CustomMessageType("El nombre del paciente es requerido"), HttpStatus.CONFLICT);
			
		}
		
		if(!ValidateData.isUsed(paciente.getFechaIngreso().toString())){
			Timestamp stamp = new Timestamp(System.currentTimeMillis());
			Date date = new Date(stamp.getTime());
			
			paciente.setFechaIngreso(date);
		}
		
		if (_pacienteService.findByNombre(paciente.getNombre())!=null) {
			
			return new ResponseEntity(new CustomMessageType("Ya existe el paciente "+paciente.getNombre()+" con el mismo nombre"), HttpStatus.CONFLICT);
		
		}
		_pacienteService.savePaciente(paciente);
		
		Paciente pacienteSaved = _pacienteService.findByNombre(paciente.getNombre());
		

		HttpHeaders headers = new HttpHeaders();
		
		headers.setLocation(
				uriComponentsBuilder.path("/v1/pacientes/{id}").
				buildAndExpand(pacienteSaved.getIdPaciente()).
				toUri());
		
		return new ResponseEntity<String>(headers,HttpStatus.OK);
	}
	
	//GET ALL	
	@RequestMapping(value = "/pacientes", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Paciente>> getPacientes(@RequestParam(value= "nombre", required = false) String nombre){
		
		List<Paciente> pacientes = new ArrayList<>();
		
		//Si la URL tiene un nombre, buscamos ese paciente
		if (nombre==null) {
			
			pacientes = _pacienteService.findAllPacientes();
			
			if (pacientes.isEmpty()) {
				
				return new ResponseEntity(new CustomMessageType("No se encontraron pacientes"), HttpStatus.NO_CONTENT);
								
			}
			
			return new ResponseEntity<List<Paciente>>(pacientes,HttpStatus.OK);
		}
		//si no hay nombre en la url, devolvemos todos los pacientes
		else {
			Paciente paciente = _pacienteService.findByNombre(nombre);
			
			if (paciente== null) {
				
				return new ResponseEntity(new CustomMessageType("No se encontró el paciente "+ nombre), HttpStatus.NO_CONTENT);
								
			}
			
			pacientes.add(paciente);
			return new ResponseEntity<List<Paciente>>(pacientes,HttpStatus.OK);
			
		}			
	}
	
	// GET ON BY ID
	@RequestMapping(value = "/pacientes/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<Paciente> getCourseById(@PathVariable("id") Long idPaciente){
		
		if(!ValidateData.isUsed(idPaciente)) {
			return new ResponseEntity(new CustomMessageType("idPaciente is required"), HttpStatus.CONFLICT);
		}
		
		Paciente paciente = _pacienteService.findById(idPaciente);

		if (paciente==null) {
			return new ResponseEntity(new CustomMessageType("No se encontró el paciente "+ idPaciente), HttpStatus.NO_CONTENT);
			
		}
		
		return new ResponseEntity<Paciente>(paciente,HttpStatus.OK);
	}
	
	//UPDATE
	@RequestMapping(value = "/pacientes/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<Paciente> updateCourse(@PathVariable("id") Long idPaciente, @RequestBody Paciente paciente){
		
		
		if(!ValidateData.isUsed(idPaciente)) {
			return new ResponseEntity(new CustomMessageType("idPaciente is required"), HttpStatus.CONFLICT);
		}
		
		Paciente currentPaciente = _pacienteService.findById(idPaciente);

		if (currentPaciente==null) {
			return new ResponseEntity(new CustomMessageType("No se encontró el paciente "+ idPaciente), HttpStatus.NO_CONTENT);
			
		}
		
		currentPaciente.setNombre(paciente.getNombre());
		currentPaciente.setTelCasa(paciente.getTelCasa());
		currentPaciente.setTelCel(paciente.getTelCel());
		//currentPaciente.setFechaIngreso(paciente.getFechaIngreso());
		currentPaciente.setEnfermedades(paciente.getEnfermedades());
		currentPaciente.setCirugias(paciente.getCirugias());
		currentPaciente.setAlimentosNoGustan(paciente.getAlimentosNoGustan());
		currentPaciente.setAlergiaAlimentos(paciente.getAlergiaAlimentos());
		currentPaciente.setAlergiaMedicamentos(paciente.getAlergiaMedicamentos());
		
		_pacienteService.updatePaciente(currentPaciente);
		
		return new ResponseEntity<Paciente>(currentPaciente,HttpStatus.OK);
			
	}
	
	// DELETE
	@RequestMapping(value = "/pacientes/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deletePacienteById(@PathVariable("id") Long idPaciente){
		
		if(!ValidateData.isUsed(idPaciente)) {
			return new ResponseEntity(new CustomMessageType("idPaciente is required"), HttpStatus.CONFLICT);
		}
		
		Paciente paciente = _pacienteService.findById(idPaciente);

		if (paciente==null) {
			
			return new ResponseEntity(new CustomMessageType("No se encontró el paciente "+ idPaciente), HttpStatus.NO_CONTENT);
		}
		
		_pacienteService.deletePacienteById(idPaciente);
		
		return new ResponseEntity<Paciente>(paciente,HttpStatus.OK);
	}
	
	
}
