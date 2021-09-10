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

import com.sdcc.gpao.entity.ActiviteNettoyageD;
import com.sdcc.gpao.exception.ResourceNotFoundException;
import com.sdcc.gpao.service.ActiviteNettoyageDService;

@RestController
@RequestMapping("/api/activitenettoyaged/")
public class ActiviteNettoyageDController {

	@Autowired
	private ActiviteNettoyageDService activiteNettoyageDService;
	
	@GetMapping("/liste")
	public ResponseEntity<Collection<ActiviteNettoyageD>> getListe(){
		return activiteNettoyageDService.getListe();
	}
	
	@GetMapping("/liste/{id}")
	public ResponseEntity<ActiviteNettoyageD> getElement(@PathVariable(value = "id") int id) throws ResourceNotFoundException{
		return activiteNettoyageDService.getElement(id);
	}
	
	@GetMapping("/production/{annee}/{mois}/{jour}")
	public ResponseEntity<Collection<ActiviteNettoyageD>> getActivite(@PathVariable(value = "annee") int annee, @PathVariable(value = "mois") int mois,
			@PathVariable(value = "jour") int jour) throws ResourceNotFoundException{
		return activiteNettoyageDService.getDonnneeActivite(annee, mois, jour);
	}
	
	@PostMapping("/ajouter")
	public ResponseEntity<ActiviteNettoyageD> ajouter(@RequestBody ActiviteNettoyageD t){
		return activiteNettoyageDService.sauvegarder(t);
	}
	
	@PutMapping("/modifier")
	public ResponseEntity<ActiviteNettoyageD> modifier(@RequestBody ActiviteNettoyageD t) throws ResourceNotFoundException{
		return activiteNettoyageDService.modifier(t);
	}
	
	@DeleteMapping("/supprimer")
	public void supprimer(@RequestBody ActiviteNettoyageD t) throws ResourceNotFoundException{
		activiteNettoyageDService.supprimer(t);
	}
	
}
