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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/activitenettoyaged/")
@Api(value = "REST controlleur pour les activités de l'atelier nettoyage décorticage")
public class ActiviteNettoyageDController {

	@Autowired
	private ActiviteNettoyageDService activiteNettoyageDService;
	
	@ApiOperation(value = "Liste toutes les données sur la saisie des activités de l'atelier nettoyage décorticage", response = Collection.class)
	@ApiResponses(value = {@ApiResponse(code = 302, message = "La liste des activités est retournée, ou une liste vide")})
	@GetMapping("/liste")
	public ResponseEntity<Collection<ActiviteNettoyageD>> getListe(){
		return activiteNettoyageDService.getListe();
	}
	
	@ApiOperation(value = "L'objet ayant pour ID parmi les données sur les activités de l'atelier nettoyage décorticage", response = ActiviteNettoyageD.class)
	@ApiResponses(value = {@ApiResponse(code = 302, message = "Les données de l'activités ont été retournées"),
			@ApiResponse(code = 404, message = "L'activité ayant l'ID demandé n'existe pas")})
	@GetMapping("/liste/{id}")
	public ResponseEntity<ActiviteNettoyageD> getElement(@PathVariable(value = "id") int id) throws ResourceNotFoundException{
		return activiteNettoyageDService.getElement(id);
	}
	
	@GetMapping("/production/{annee}/{mois}/{jour}")
	@ApiOperation(value = "Retourne les données sur les activités de l'atelier nettoyage décorticage pour une date précise", response = Collection.class)
	@ApiResponses(value = {@ApiResponse(code = 302, message = "Les données de l'activités ont été retournées"),
			@ApiResponse(code = 404, message = "Les données de l'activités demandé n'existent pas")})
	public ResponseEntity<Collection<ActiviteNettoyageD>> getActivite(@PathVariable(value = "annee") int annee, @PathVariable(value = "mois") int mois,
			@PathVariable(value = "jour") int jour) throws ResourceNotFoundException{
		return activiteNettoyageDService.getDonnneeActivite(annee, mois, jour);
	}
	
	@PostMapping("/ajouter")
	@ApiOperation(value = "Ajoute une occurence des activités de l'atelier nettoyage décorticage", response = ActiviteNettoyageD.class)
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Les données de l'activités ont été ajouté avec succès")})
	public ResponseEntity<ActiviteNettoyageD> ajouter(@RequestBody ActiviteNettoyageD t){
		return activiteNettoyageDService.sauvegarder(t);
	}
	
	@PutMapping("/modifier")
	@ApiOperation(value = "Modifie une occurence des activités de l'atelier nettoyage décorticage", response = ActiviteNettoyageD.class)
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Les données de l'activités ont été modifié avec succès"),
			@ApiResponse(code = 404, message = "L'activité ayant l'ID demandé n'existe pas")})
	public ResponseEntity<ActiviteNettoyageD> modifier(@RequestBody ActiviteNettoyageD t) throws ResourceNotFoundException{
		return activiteNettoyageDService.modifier(t);
	}
	
	@DeleteMapping("/supprimer")
	@ApiOperation(value = "Supprime une occurence des activités de l'atelier nettoyage décorticage", response = ActiviteNettoyageD.class)
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Les données de l'activités ont été supprimé avec succès"),
			@ApiResponse(code = 404, message = "L'activité ayant l'ID demandé n'existe pas")})
	public void supprimer(@RequestBody ActiviteNettoyageD t) throws ResourceNotFoundException{
		activiteNettoyageDService.supprimer(t);
	}
	
}
