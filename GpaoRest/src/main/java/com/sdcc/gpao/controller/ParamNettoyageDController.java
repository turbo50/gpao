package com.sdcc.gpao.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sdcc.gpao.entity.ParamNettoyageD;
import com.sdcc.gpao.exception.NoDuplicationException;
import com.sdcc.gpao.exception.ResourceNotFoundException;
import com.sdcc.gpao.service.ParamNettoyageDService;

@RestController
@RequestMapping("/api/paramnettoyaged/")
public class ParamNettoyageDController {

	@Autowired
	private ParamNettoyageDService paramNettoyageDService;
	
	@GetMapping("/liste")
	public ResponseEntity<Collection<ParamNettoyageD>> getListe(){
		return paramNettoyageDService.getListe();
	}
	
	@GetMapping("/liste/{id}")
	public ResponseEntity<ParamNettoyageD> getElement(@PathVariable(value = "id") int id) throws ResourceNotFoundException{
		return paramNettoyageDService.getElement(id);
	}
	
	@GetMapping("/production/{annee}/{mois}/{jour}")
	public ResponseEntity<Collection<ParamNettoyageD>> getParametres(@PathVariable(value = "annee") int annee, @PathVariable(value = "mois") int mois,
			@PathVariable(value = "jour") int jour) throws ResourceNotFoundException{
		return paramNettoyageDService.getDonnneeParametres(annee, mois, jour);
	}
	
	@PostMapping("/ajouter")
	public ResponseEntity<ParamNettoyageD> ajouter(@RequestBody ParamNettoyageD t) throws NoDuplicationException{
		return paramNettoyageDService.sauvegarder(t);
	}
	
	@PutMapping("/modifier")
	public ResponseEntity<ParamNettoyageD> modifier(@RequestBody ParamNettoyageD t) throws ResourceNotFoundException{
		return paramNettoyageDService.modifier(t);
	}
	
	@DeleteMapping("/supprimer")
	public void supprimer(@RequestBody ParamNettoyageD t) throws ResourceNotFoundException{
		paramNettoyageDService.supprimer(t);
	}
}
