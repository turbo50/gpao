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

import com.sdcc.gpao.entity.DecoupageHoraire;
import com.sdcc.gpao.exception.ResourceNotFoundException;
import com.sdcc.gpao.service.DecoupageHoraireService;

@RestController
@RequestMapping("/api/decoupagehoraire/")
public class DecoupageHoraireController {
	@Autowired
	private DecoupageHoraireService decoupageHoraireService;

	@GetMapping("/liste")
	public ResponseEntity<Collection<DecoupageHoraire>> getListe(){
		return decoupageHoraireService.getListe();
	}
	
	@GetMapping("/liste/{id}")
	public ResponseEntity<DecoupageHoraire> getElement(@PathVariable(value = "id") int id) throws ResourceNotFoundException{
		return decoupageHoraireService.getElement(id);
	}
	
	@PostMapping("/ajouter")
	public ResponseEntity<DecoupageHoraire> ajouter(@RequestBody DecoupageHoraire t){
		return decoupageHoraireService.sauvegarder(t);
	}
	
	@PutMapping("/modifier")
	public ResponseEntity<DecoupageHoraire> modifier(@RequestBody DecoupageHoraire t) throws ResourceNotFoundException{
		return decoupageHoraireService.modifier(t);
	}
	
	@DeleteMapping("/supprimer")
	public void supprimer(@RequestBody DecoupageHoraire t) throws ResourceNotFoundException{
		decoupageHoraireService.supprimer(t);
	}
	
	@GetMapping("/get_decoupages/{debut}/{fin}")
	public ResponseEntity<Collection<DecoupageHoraire>> getListe(@PathVariable(value = "debut") int debut, @PathVariable(value = "fin") int fin){
		return decoupageHoraireService.getDecoupageParInterval(debut, fin);
	}
}
