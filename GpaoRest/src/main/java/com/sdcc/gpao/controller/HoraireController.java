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

import com.sdcc.gpao.entity.Horaire;
import com.sdcc.gpao.exception.NoDuplicationException;
import com.sdcc.gpao.exception.ResourceNotFoundException;
import com.sdcc.gpao.service.HoraireService;

@RestController
@RequestMapping("/api/horaire/")
public class HoraireController {
	@Autowired
	private HoraireService horaireService;

	@GetMapping("/liste")
	public ResponseEntity<Collection<Horaire>> getListe(){
		return horaireService.getListe();
	}
	
	@GetMapping("/liste/{id}")
	public ResponseEntity<Horaire> getElement(@PathVariable(value = "id") int id) throws ResourceNotFoundException{
		return horaireService.getElement(id);
	}
	
	@PostMapping("/ajouter")
	public ResponseEntity<Horaire> ajouter(@RequestBody Horaire t) throws NoDuplicationException{
		return horaireService.sauvegarder(t);
	}
	
	@PutMapping("/modifier")
	public ResponseEntity<Horaire> modifier(@RequestBody Horaire t) throws ResourceNotFoundException{
		return horaireService.modifier(t);
	}
	
	@DeleteMapping("/supprimer")
	public void supprimer(@RequestBody Horaire t) throws ResourceNotFoundException{
		horaireService.supprimer(t);
	}
}
