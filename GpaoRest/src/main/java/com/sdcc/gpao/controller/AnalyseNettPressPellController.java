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

import com.sdcc.gpao.entity.AnalyseNettPressPell;
import com.sdcc.gpao.exception.ResourceNotFoundException;
import com.sdcc.gpao.service.AnalyseNettPressPellService;

@RestController
@RequestMapping("/api/analysenettoyaged/")
public class AnalyseNettPressPellController {

	@Autowired
	private AnalyseNettPressPellService analyseNettPressPellService;
	
	@GetMapping("/liste")
	public ResponseEntity<Collection<AnalyseNettPressPell>> getListe(){
		return analyseNettPressPellService.getListe();
	}
	
	@GetMapping("/liste/{id}")
	public ResponseEntity<AnalyseNettPressPell> getElement(@PathVariable(value = "id") int id) throws ResourceNotFoundException{
		return analyseNettPressPellService.getElement(id);
	}
	
	@GetMapping("/production/{annee}/{mois}/{jour}")
	public ResponseEntity<Collection<AnalyseNettPressPell>> getAnalyse(@PathVariable(value = "annee") int annee, @PathVariable(value = "mois") int mois,
			@PathVariable(value = "jour") int jour) throws ResourceNotFoundException{
		return analyseNettPressPellService.getDonnneeAnalyse(annee, mois, jour);
	}
	
	@PostMapping("/ajouter")
	public ResponseEntity<AnalyseNettPressPell> ajouter(@RequestBody AnalyseNettPressPell t){
		return analyseNettPressPellService.sauvegarder(t);
	}
	
	@PutMapping("/modifier")
	public ResponseEntity<AnalyseNettPressPell> modifier(@RequestBody AnalyseNettPressPell t) throws ResourceNotFoundException{
		return analyseNettPressPellService.modifier(t);
	}
	
	@DeleteMapping("/supprimer")
	public void supprimer(@RequestBody AnalyseNettPressPell t) throws ResourceNotFoundException{
		analyseNettPressPellService.supprimer(t);
	}
}
