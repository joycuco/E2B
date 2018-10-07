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

import com.e2bnutrition.e2bbackend.model.Receta;
import com.e2bnutrition.e2bbackend.service.RecetaService;
import com.e2bnutrition.e2bbackend.utils.CustomMessageType;
import com.e2bnutrition.e2bbackend.utils.ValidateData;

@Controller
@RequestMapping("/v1")
public class RecetaController {
	
	@Autowired
	RecetaService _recetaService;
	
	//POST
	@RequestMapping(value = "/recetas", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<String> createReceta(@RequestBody Receta receta, UriComponentsBuilder uriComponentsBuilder){
		
		if (!ValidateData.isUsed(receta.getNombre())) {

			return new ResponseEntity(new CustomMessageType("El nombre del receta es requerido"), HttpStatus.CONFLICT);
			
		}
		
		if (_recetaService.findByNombre(receta.getNombre())!=null) {
			
			return new ResponseEntity(new CustomMessageType("Ya existe el receta "+receta.getNombre()+" con el mismo nombre"), HttpStatus.CONFLICT);
		
		}
		_recetaService.saveReceta(receta);
		
		Receta recetaSaved = _recetaService.findByNombre(receta.getNombre());
		

		HttpHeaders headers = new HttpHeaders();
		
		headers.setLocation(
				uriComponentsBuilder.path("/v1/recetas/{id}").
				buildAndExpand(recetaSaved.getIdReceta()).
				toUri());
		
		return new ResponseEntity<String>(headers,HttpStatus.OK);
	}
	
	//GET ALL	
	@RequestMapping(value = "/recetas", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Receta>> getRecetas(@RequestParam(value= "nombre", required = false) String nombre){
		
		List<Receta> recetas = new ArrayList<>();
		
		//Si la URL tiene un nombre, buscamos ese receta
		if (nombre==null) {
			
			recetas = _recetaService.findAllRecetas();
			
			if (recetas.isEmpty()) {
				
				return new ResponseEntity(new CustomMessageType("No se encontraron recetas"), HttpStatus.NO_CONTENT);
								
			}
			
			return new ResponseEntity<List<Receta>>(recetas,HttpStatus.OK);
		}
		//si no hay nombre en la url, devolvemos todos los recetas
		else {
			Receta receta = _recetaService.findByNombre(nombre);
			
			if (receta== null) {
				
				return new ResponseEntity(new CustomMessageType("No se encontró el receta "+ nombre), HttpStatus.NO_CONTENT);
								
			}
			
			recetas.add(receta);
			return new ResponseEntity<List<Receta>>(recetas,HttpStatus.OK);
			
		}			
	}
	
	// GET ON BY ID
	@RequestMapping(value = "/recetas/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<Receta> getCourseById(@PathVariable("id") Long idReceta){
		
		if(!ValidateData.isUsed(idReceta)) {
			return new ResponseEntity(new CustomMessageType("idReceta is required"), HttpStatus.CONFLICT);
		}
		
		Receta receta = _recetaService.findById(idReceta);

		if (receta==null) {
			return new ResponseEntity(new CustomMessageType("No se encontró la receta "+ idReceta), HttpStatus.NO_CONTENT);
			
		}
		
		return new ResponseEntity<Receta>(receta,HttpStatus.OK);
	}
	
	//UPDATE
	@RequestMapping(value = "/recetas/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<Receta> updateCourse(@PathVariable("id") Long idReceta, @RequestBody Receta receta){
		
		
		if(!ValidateData.isUsed(idReceta)) {
			return new ResponseEntity(new CustomMessageType("idReceta is required"), HttpStatus.CONFLICT);
		}
		
		Receta currentReceta = _recetaService.findById(idReceta);

		if (currentReceta==null) {
			return new ResponseEntity(new CustomMessageType("No se encontró la receta "+ idReceta), HttpStatus.NO_CONTENT);
			
		}
		
		currentReceta.setNombre(receta.getNombre());
		currentReceta.setIngredientes(receta.getIngredientes());
		currentReceta.setInfoNutrimental(receta.getInfoNutrimental());
		currentReceta.setVerduras(receta.getVerduras());
		currentReceta.setCernes(receta.getCernes());
		currentReceta.setAceites(receta.getAceites());
		currentReceta.setSemillas(receta.getSemillas());
		
		_recetaService.updateReceta(currentReceta);
		
		return new ResponseEntity<Receta>(currentReceta,HttpStatus.OK);
			
	}
	
	// DELETE
	@RequestMapping(value = "/recetas/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteRecetaById(@PathVariable("id") Long idReceta){
		
		if(!ValidateData.isUsed(idReceta)) {
			return new ResponseEntity(new CustomMessageType("idReceta es requerida"), HttpStatus.CONFLICT);
		}
		
		Receta receta = _recetaService.findById(idReceta);

		if (receta==null) {
			
			return new ResponseEntity(new CustomMessageType("No se encontró el receta "+ idReceta), HttpStatus.NO_CONTENT);
		}
		
		_recetaService.deleteRecetaById(idReceta);
		
		return new ResponseEntity<Receta>(receta,HttpStatus.OK);
	}
	
	
}
