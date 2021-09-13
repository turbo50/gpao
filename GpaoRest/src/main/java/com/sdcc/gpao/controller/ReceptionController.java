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

import com.sdcc.gpao.entity.Reception;
import com.sdcc.gpao.exception.NoDuplicationException;
import com.sdcc.gpao.exception.ResourceNotFoundException;
import com.sdcc.gpao.service.ReceptionService;

@RestController
@RequestMapping("/api/reception/")
public class ReceptionController {

	@Autowired
	private ReceptionService receptionService;
	
	@GetMapping("/liste")
	public ResponseEntity<Collection<Reception>> getListe(){
		return receptionService.getListe();
	}
	
	@GetMapping("/liste/{id}") 
	public ResponseEntity<Reception> geElement(@PathVariable(value = "id")int id) throws ResourceNotFoundException
	{
		return receptionService.getElement(id);
	}
	
	@PostMapping("/ajouter")
	public ResponseEntity<Reception> ajouter(@RequestBody Reception eg) throws NoDuplicationException{
		return receptionService.sauvegarder(eg);
	}
	
	@PutMapping("/modifier")
	public ResponseEntity<Reception> modifier(@RequestBody Reception eg) throws ResourceNotFoundException{
		return receptionService.modifier(eg);
	}
	
	@DeleteMapping("/supprimer")
	public void supprimer(@RequestBody Reception eg) throws ResourceNotFoundException{
		receptionService.supprimer(eg);
	}
}
