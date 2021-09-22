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
import com.sdcc.gpao.exception.NoDuplicationException;
import com.sdcc.gpao.exception.ResourceNotFoundException;
import com.sdcc.gpao.service.AnalyseNettPressPellService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/analysenettoyaged/")
@Api(value = "REST controlleur pour les analyses labo des ateliers nettoyage décorticage, Pression et Pelletisation")
public class AnalyseNettPressPellController {

	@Autowired
	private AnalyseNettPressPellService analyseNettPressPellService;
	
	@ApiOperation(value = "Liste toutes les analyses labo des ateliers nettoyage décorticage, Pression et Pelletisation", response = Collection.class)
	@ApiResponses(value = {@ApiResponse(code = 302, message = "La liste des analyses est retournée, ou une liste vide")})
	@GetMapping("/liste")
	public ResponseEntity<Collection<AnalyseNettPressPell>> getListe(){
		return analyseNettPressPellService.getListe();
	}
	
	@ApiOperation(value = "Analyses labo des ateliers nettoyage décorticage, Pression et Pelletisation avec l'ID donné", response = AnalyseNettPressPell.class)
	@ApiResponses(value = {@ApiResponse(code = 302, message = "Les données d'analyses ont été retournées"),
			@ApiResponse(code = 404, message = "Les données d'analyses ayant l'ID donné n'existent pas")})
	@GetMapping("/liste/{id}")
	public ResponseEntity<AnalyseNettPressPell> getElement(@PathVariable(value = "id") int id) throws ResourceNotFoundException{
		return analyseNettPressPellService.getElement(id);
	}
	
	@ApiOperation(value = "Analyses labo des ateliers nettoyage décorticage, Pression et Pelletisation à la date demandée", response = Collection.class)
	@ApiResponses(value = {@ApiResponse(code = 302, message = "Les données d'analyses ont été retournées"),
			@ApiResponse(code = 404, message = "Les données d'analyses à cette date donnée n'existent pas")})
	@GetMapping("/production/{annee}/{mois}/{jour}")
	public ResponseEntity<Collection<AnalyseNettPressPell>> getAnalyse(@PathVariable(value = "annee") int annee, @PathVariable(value = "mois") int mois,
			@PathVariable(value = "jour") int jour) throws ResourceNotFoundException{
		return analyseNettPressPellService.getDonnneeAnalyse(annee, mois, jour);
	}
	
	@ApiOperation(value = "Ajout des données d'analyses labo des ateliers nettoyage décorticage, Pression et Pelletisation", response = AnalyseNettPressPell.class)
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Les données d'analyses ont été ajoutées"),
			@ApiResponse(code = 302, message = "Les données d'analyses ont déjà été saisies pour cette période")})
	@PostMapping("/ajouter")
	public ResponseEntity<AnalyseNettPressPell> ajouter(@RequestBody AnalyseNettPressPell t) throws NoDuplicationException{
		return analyseNettPressPellService.sauvegarder(t);
	}
	
	@PutMapping("/modifier")
	@ApiOperation(value = "Modifie une occurence d'analyses de l'atelier nettoyage décorticage, Pression et Pelletisation", response = AnalyseNettPressPell.class)
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Les données d'analyses ont été modifiées avec succès"),
			@ApiResponse(code = 404, message = "Les analyses ayant l'ID demandé n'existent pas")})
	public ResponseEntity<AnalyseNettPressPell> modifier(@RequestBody AnalyseNettPressPell t) throws ResourceNotFoundException{
		return analyseNettPressPellService.modifier(t);
	}
	
	@DeleteMapping("/supprimer")
	@ApiOperation(value = "Supprime une occurence d'analyses de l'atelier nettoyage décorticage, Pression et Pelletisation")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Les données d'analyses ont été supprimées avec succès"),
			@ApiResponse(code = 404, message = "Les analyses ayant l'ID demandé n'existent pas")})
	public void supprimer(@RequestBody AnalyseNettPressPell t) throws ResourceNotFoundException{
		analyseNettPressPellService.supprimer(t);
	}
}
