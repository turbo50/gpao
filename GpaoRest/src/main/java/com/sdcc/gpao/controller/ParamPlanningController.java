package com.sdcc.gpao.controller;


import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sdcc.gpao.entity.Horaire;
import com.sdcc.gpao.entity.ParamPlanning;
import com.sdcc.gpao.entity.Quart;
import com.sdcc.gpao.exception.NoDuplicationException;
import com.sdcc.gpao.service.ParamPlanningService;

@RestController
@RequestMapping("/api/paramplanning/")
public class ParamPlanningController {
	
	@Autowired
	private ParamPlanningService paramPlanningService;

	@GetMapping("/liste")
	public ResponseEntity<Collection<ParamPlanning>> getListe(){
		return paramPlanningService.getListe();
	}
	
	@GetMapping("/actuel")
	public ResponseEntity<Collection<ParamPlanning>> getActuel(){
		return paramPlanningService.getParamCourant();
	}
	
	@GetMapping("/emploidutemps/{jour}/{mois}/{annee}")
	public Map<Quart, Horaire> getEmploiDuTemps(@PathVariable(value = "jour") int jour, @PathVariable(value = "mois") int mois,
			@PathVariable(value = "annee") int annee) throws Exception{
		return paramPlanningService.getQuartEnService(jour, mois, annee, false);
	}
	
	@PostMapping("/ajouter")
	public ResponseEntity<ParamPlanning> ajouter(@RequestBody ParamPlanning p) throws NoDuplicationException{
		return paramPlanningService.sauvegarder(p);
	}
}
