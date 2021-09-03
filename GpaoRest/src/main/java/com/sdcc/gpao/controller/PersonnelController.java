/**
 * 
 */
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

import com.sdcc.gpao.entity.Personnel;
import com.sdcc.gpao.exception.ResourceNotFoundException;
import com.sdcc.gpao.service.PersonnelService;

/**
 * @author Sodecoton
 *
 */

@RestController
@RequestMapping("/api/personnel/")
public class PersonnelController {
	@Autowired
	private PersonnelService PersonnelService;

	@GetMapping("/liste")
	public ResponseEntity<Collection<Personnel>> getListe(){
		return PersonnelService.getListe();
	}
	
	@GetMapping("/liste/{id}")
	public ResponseEntity<Personnel> getElement(@PathVariable(value = "id") int id) throws ResourceNotFoundException{
		return PersonnelService.getElement(id);
	}
	
	@PostMapping("/ajouter")
	public ResponseEntity<Personnel> ajouter(@RequestBody Personnel t){
		return PersonnelService.sauvegarder(t);
	}
	
	@PutMapping("/modifier")
	public ResponseEntity<Personnel> modifier(@RequestBody Personnel t) throws ResourceNotFoundException{
		return PersonnelService.modifier(t);
	}
	
	@DeleteMapping("/supprimer")
	public void supprimer(@RequestBody Personnel t) throws ResourceNotFoundException{
		PersonnelService.supprimer(t);
	}
}
