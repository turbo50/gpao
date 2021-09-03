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

import com.sdcc.gpao.entity.Quart;
import com.sdcc.gpao.exception.ResourceNotFoundException;
import com.sdcc.gpao.service.QuartService;

@RestController
@RequestMapping("/api/quart/")
public class QuartController {
	@Autowired
	private QuartService QuartService;

	@GetMapping("/liste")
	public ResponseEntity<Collection<Quart>> getListe(){
		return QuartService.getListe();
	}
	
	@GetMapping("/liste/{id}") 
	public ResponseEntity<Quart> geElement(@PathVariable(value = "id")int id) throws ResourceNotFoundException
	{
		return QuartService.getElement(id);
	}
	
	@PostMapping("/ajouter")
	public ResponseEntity<Quart> ajouter(@RequestBody Quart eg){
		return QuartService.sauvegarder(eg);
	}
	
	@PutMapping("/modifier")
	public ResponseEntity<Quart> modifier(@RequestBody Quart eg) throws ResourceNotFoundException{
		return QuartService.modifier(eg);
	}
	
	@DeleteMapping("/supprimer")
	public void supprimer(@RequestBody Quart eg) throws ResourceNotFoundException{
		QuartService.supprimer(eg);
	}
}
