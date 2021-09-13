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

import com.sdcc.gpao.entity.Usine;
import com.sdcc.gpao.exception.NoDuplicationException;
import com.sdcc.gpao.exception.ResourceNotFoundException;
import com.sdcc.gpao.service.UsineService;

@RestController
@RequestMapping("/api/usine/")
public class UsineController {
	@Autowired
	private UsineService UsineService;

	@GetMapping("/liste")
	public ResponseEntity<Collection<Usine>> getListe(){
		return UsineService.getListe();
	}
	
	@GetMapping("/liste/{id}") 
	public ResponseEntity<Usine> geElement(@PathVariable(value = "id")int id) throws ResourceNotFoundException
	{
		return UsineService.getElement(id);
	}
	
	@PostMapping("/ajouter")
	public ResponseEntity<Usine> ajouter(@RequestBody Usine eg) throws NoDuplicationException{
		return UsineService.sauvegarder(eg);
	}
	
	@PutMapping("/modifier")
	public ResponseEntity<Usine> modifier(@RequestBody Usine eg) throws ResourceNotFoundException{
		return UsineService.modifier(eg);
	}
	
	@DeleteMapping("/supprimer")
	public void supprimer(@RequestBody Usine eg) throws ResourceNotFoundException{
		UsineService.supprimer(eg);
	}
}
