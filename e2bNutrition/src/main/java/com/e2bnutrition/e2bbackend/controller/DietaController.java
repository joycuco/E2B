package com.e2bnutrition.e2bbackend.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
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
import com.e2bnutrition.e2bbackend.model.EjemploAlimento;
import com.e2bnutrition.e2bbackend.model.Receta;
import com.e2bnutrition.e2bbackend.service.DietaService;
import com.e2bnutrition.e2bbackend.service.RecetaService;
import com.e2bnutrition.e2bbackend.utils.CustomMessageType;
import com.e2bnutrition.e2bbackend.utils.ValidateData;

@Controller
@RequestMapping("/v1")
public class DietaController {
	
	@Autowired
	DietaService _dietaService;
	
	@Autowired 
	RecetaService _recetaService;
	
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
	
	
	
	
	//POST el más perro!
	
	@RequestMapping(value="dietas/recetas",  method = RequestMethod.PATCH, headers ="Accept=application/json")
	public ResponseEntity<?> assignEjemplosRecetas(@RequestBody Dieta dieta, UriComponentsBuilder uriComponentsBuilder){
		
		//return new ResponseEntity<Dieta>(dieta, HttpStatus.OK);
		
		
		if (dieta.getIdDieta()==null) {
			
			return new ResponseEntity(new CustomMessageType("We need at least id_Dieta, id_receta and tipo alimento"), HttpStatus.NO_CONTENT);
			
		}
		
		
		Dieta dietaSaved= _dietaService.findById(dieta.getIdDieta());
		
		if (dietaSaved==null) {				
			return new ResponseEntity(new CustomMessageType("We need at least id_Dieta, id_receta and tipo alimento"), HttpStatus.NO_CONTENT);	
		}
		
		if (dieta.getEjemplosAlimentos().size()==0) {
			return new ResponseEntity(new CustomMessageType("We need at least id_Dieta, id_receta and tipo alimento"), HttpStatus.NO_CONTENT);	
			
		}
		else {
			
			Iterator<EjemploAlimento> i = dieta.getEjemplosAlimentos().iterator();
			while(i.hasNext()) {
				
				EjemploAlimento ejemploAlimento = i.next();

				if ((ejemploAlimento.getReceta().getIdReceta()==null)||(ejemploAlimento.getTipo()==null)) {
					
					return new ResponseEntity(new CustomMessageType("We need at least id_dieta, id_receta and tipo_alimento"), HttpStatus.NO_CONTENT);	
					
				}else {
					EjemploAlimento eaAux = _recetaService.findRecetaByIdAndTipo(
																					ejemploAlimento.getReceta().getIdReceta(), 
																					ejemploAlimento.getTipo());

					
					if(eaAux!=null) {
						
						return new ResponseEntity(new CustomMessageType("The idReceta "+
																		ejemploAlimento.getReceta().getIdReceta()+
																		" with Tipo_alimento "+
																		ejemploAlimento.getTipo()+"already exists"), 
																		HttpStatus.NO_CONTENT);	
						
					}
					
					Receta receta = _recetaService.findById(ejemploAlimento.getReceta().getIdReceta());
				
					if (receta==null) {
						
						return new ResponseEntity(new CustomMessageType("Id Receta not found"), HttpStatus.NO_CONTENT);	
						
					}
					ejemploAlimento.setReceta(receta);
					ejemploAlimento.setDieta(dietaSaved);
					
					if (eaAux==null) {
						dietaSaved.getEjemplosAlimentos().add(ejemploAlimento);							
					}
					//hasta aquí me quedé 11-10-2018
					else {
						LinkedList<EjemploAlimento> ejemplosAlimentos = new LinkedList<>();
						ejemplosAlimentos.addAll(dietaSaved.getEjemplosAlimentos());
						
						for(int j = 0;j<ejemplosAlimentos.size();j++) {
							EjemploAlimento ejemploAlimento2 = ejemplosAlimentos.get(j);
							
							if (ejemploAlimento.getDieta().getIdDieta() == ejemploAlimento2.getDieta().getIdDieta()
									&& ejemploAlimento.getReceta().getIdReceta() == ejemploAlimento2.getReceta().getIdReceta()) {
								
								ejemploAlimento2.setTipo(ejemploAlimento.getTipo());
								ejemplosAlimentos.set(j, ejemploAlimento2);									
							}
							
							else {
								ejemplosAlimentos.set(j, ejemploAlimento2);
							}
						}
						
						dietaSaved.getEjemplosAlimentos().clear();
						dietaSaved.getEjemplosAlimentos().addAll(ejemplosAlimentos);
						
					}
				}
				
			}
			
		}
		
		_dietaService.updateDieta(dietaSaved);
		return new ResponseEntity<Dieta>(dietaSaved, HttpStatus.OK);
	}
	
	
	
	
	
	
	
}
