package com.sdcc.gpao.service;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sdcc.gpao.entity.Horaire;
import com.sdcc.gpao.entity.ParamPlanning;
import com.sdcc.gpao.entity.Quart;
import com.sdcc.gpao.exception.ResourceNotFoundException;
import com.sdcc.gpao.repository.IParamPlanningRepository;

@Service
public class ParamPlanningService implements IServiceDeBase<ParamPlanning> {

	private IParamPlanningRepository paramPlanningRepository;
	@Autowired
	private HoraireService horaireService;
	
	@Autowired
	public ParamPlanningService(IParamPlanningRepository paramPlanningRepository/*, HoraireService horaireService*/) {
		super();
		this.paramPlanningRepository = paramPlanningRepository;
		//this.horaireService = horaireService;
	}
	
	@Override
	public ResponseEntity<Collection<ParamPlanning>> getListe() {
		return new ResponseEntity<Collection<ParamPlanning>>(paramPlanningRepository.findAll(), HttpStatus.FOUND);
	}

	@Override
	public ResponseEntity<ParamPlanning> getElement(Object code) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ParamPlanning> sauvegarder(ParamPlanning t) {
		return new ResponseEntity<ParamPlanning>(paramPlanningRepository.save(t), HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<ParamPlanning> modifier(ParamPlanning t) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void supprimer(ParamPlanning t) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		
	}
	
	public ResponseEntity<Collection<ParamPlanning>> getParamCourant() {
		return new ResponseEntity<Collection<ParamPlanning>>(paramPlanningRepository.getParamActuel(), HttpStatus.FOUND);
	}
	
	/**
	 * Fonction qui retourne une collection sur l'emploi du temps a une date donnée
	 * @param date : date du jour où on demande l'emploi du temps
	 * @param inclu_repos : true si on ajoute aussi le quart au repos et false sinon
	 * @return renvoie une Map de type <Quart , Horaire> un quart et l'horaire affecté.
	 * @throws Exception
	 */
	public Map<Quart, Horaire> getQuartEnService(int jour, int mois, int annee, boolean inclu_repos) throws Exception{
		Map<Quart, Horaire> liste_quart = new HashMap<>();
		Horaire h; LocalDate date = LocalDate.of(annee, mois, jour);
		ArrayList<ParamPlanning> all_recent_param = (ArrayList<ParamPlanning>) paramPlanningRepository.getParamEnDateDu(date);
		for(ParamPlanning p : all_recent_param) {
			h = horaireService.getHoraireActuelle(p.getParamPlanningPK().getDatebase(), date, p.getHoraire(), 2).getBody();
			if(inclu_repos || !h.getHeuredebut().equals(LocalTime.of(0, 0))){
				liste_quart.put(p.getIdquart(), h);
			}
		}
		return liste_quart;
	}
}
