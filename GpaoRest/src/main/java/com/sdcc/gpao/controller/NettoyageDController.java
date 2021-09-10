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

import com.sdcc.gpao.entity.NettoyageD;
import com.sdcc.gpao.exception.ResourceNotFoundException;
import com.sdcc.gpao.service.NettoyageDService;

@RestController
@RequestMapping("/api/nettoyaged/")
public class NettoyageDController {

	@Autowired
	private NettoyageDService nettoyageDService;
	
	@GetMapping("/liste")
	public ResponseEntity<Collection<NettoyageD>> getListe(){
		return nettoyageDService.getListe();
	}
	
	@GetMapping("/liste/{id}")
	public ResponseEntity<NettoyageD> getElement(@PathVariable(value = "id") int id) throws ResourceNotFoundException{
		return nettoyageDService.getElement(id);
	}
	
	@GetMapping("/production/{annee}/{mois}/{jour}")
	public ResponseEntity<Collection<NettoyageD>> getProduction(@PathVariable(value = "annee") int annee, @PathVariable(value = "mois") int mois,
			@PathVariable(value = "jour") int jour) throws ResourceNotFoundException{
		return nettoyageDService.getDonneesProduction(annee, mois, jour);
	}
	
	@PostMapping("/ajouter")
	public ResponseEntity<NettoyageD> ajouter(@RequestBody NettoyageD t){
		return nettoyageDService.sauvegarder(t);
	}
	
	@PutMapping("/modifier")
	public ResponseEntity<NettoyageD> modifier(@RequestBody NettoyageD t) throws ResourceNotFoundException{
		return nettoyageDService.modifier(t);
	}
	
	@DeleteMapping("/supprimer")
	public void supprimer(@RequestBody NettoyageD t) throws ResourceNotFoundException{
		nettoyageDService.supprimer(t);
	}
}
