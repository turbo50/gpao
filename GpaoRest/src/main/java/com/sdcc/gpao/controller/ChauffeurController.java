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

import com.sdcc.gpao.entity.Chauffeur;
import com.sdcc.gpao.exception.NoDuplicationException;
import com.sdcc.gpao.exception.ResourceNotFoundException;
import com.sdcc.gpao.service.ChauffeurService;

@RestController
@RequestMapping("/api/chauffeur/")
public class ChauffeurController {

	@Autowired
	private ChauffeurService chauffeurService;
	
	@GetMapping("/liste")
	public ResponseEntity<Collection<Chauffeur>> getListe(){
		return chauffeurService.getListe();
	}
	
	@GetMapping("/liste/{id}") 
	public ResponseEntity<Chauffeur> geElement(@PathVariable(value = "id")int id) throws ResourceNotFoundException
	{
		return chauffeurService.getElement(id);
	}
	
	@PostMapping("/ajouter")
	public ResponseEntity<Chauffeur> ajouter(@RequestBody Chauffeur eg) throws NoDuplicationException{
		return chauffeurService.sauvegarder(eg);
	}
	
	@PutMapping("/modifier")
	public ResponseEntity<Chauffeur> modifier(@RequestBody Chauffeur eg) throws ResourceNotFoundException{
		return chauffeurService.modifier(eg);
	}
	
	@DeleteMapping("/supprimer")
	public void supprimer(@RequestBody Chauffeur eg) throws ResourceNotFoundException{
		chauffeurService.supprimer(eg);
	}
}
