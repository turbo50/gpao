package com.sdcc.gpao.service;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sdcc.gpao.entity.ParamNettoyageD;
import com.sdcc.gpao.exception.NoDuplicationException;
import com.sdcc.gpao.exception.ResourceNotFoundException;
import com.sdcc.gpao.repository.IParamNettoyageDRepository;

@Service
public class ParamNettoyageDService implements IServiceDeBase<ParamNettoyageD> {
	private IParamNettoyageDRepository paramNettoyageDRepository;
	
	@Autowired
	public ParamNettoyageDService(IParamNettoyageDRepository paramNettoyageDRepository) {
		super();
		this.paramNettoyageDRepository = paramNettoyageDRepository;
	}

	@Override
	public ResponseEntity<ParamNettoyageD> getElement(Object id_param) throws ResourceNotFoundException {
		Optional<ParamNettoyageD> us = paramNettoyageDRepository.findById(new Integer(id_param.toString()));
		if(us.isPresent()) {
			return new ResponseEntity<ParamNettoyageD>(us.get(), HttpStatus.OK);
		}else {
			throw new ResourceNotFoundException("Paramètre Nettoyage introuvable  : " + id_param);
		}
	}
	

	@Override
	public ResponseEntity<Collection<ParamNettoyageD>> getListe() {
		return  new ResponseEntity<Collection<ParamNettoyageD>>(paramNettoyageDRepository.findAll(), HttpStatus.FOUND);
	}

	@Override
	public ResponseEntity<ParamNettoyageD> sauvegarder(ParamNettoyageD t) throws NoDuplicationException {
		//On évite d'ajouter 2 fois les données pour un même quart
		Optional<ParamNettoyageD> us = paramNettoyageDRepository.findByIdplanning(t.getIdplanning());
		if(us.isPresent()) {
			throw new NoDuplicationException("Les données ont déjà été saisies. Planning(ID, date, heure) : (" + t.getIdplanning().getIdplanning() + 
					            ", " + t.getIdplanning().getDateplanning() + ", " + t.getIdplanning().getIdhoraire() + ")");
		}else {
			return new ResponseEntity<ParamNettoyageD>(paramNettoyageDRepository.save(t), HttpStatus.CREATED);
		}
	}

	@Override
	public ResponseEntity<ParamNettoyageD> modifier(ParamNettoyageD t) throws ResourceNotFoundException {
		Optional<ParamNettoyageD> us = paramNettoyageDRepository.findById(t.getIdparamnettoyaged());
		if(us.isPresent()) {
			return new ResponseEntity<ParamNettoyageD>(paramNettoyageDRepository.save(t), HttpStatus.OK);
		}else {
			throw new ResourceNotFoundException("Paramètre Nettoyage introuvable : " + t.getIdparamnettoyaged());
		}
	}

	@Override
	public void supprimer(ParamNettoyageD t) throws ResourceNotFoundException {
		Optional<ParamNettoyageD> us = paramNettoyageDRepository.findById(t.getIdparamnettoyaged());
		if(us.isPresent()) {
			paramNettoyageDRepository.deleteById(t.getIdparamnettoyaged());
		}else {
			throw new ResourceNotFoundException("Paramètre Nettoyage introuvable : " + t.getIdpersonnel());
		}
	}
	
	/**
	 * Cette fonction retourne les données d'analyses sur la production de l'Atelier Nettoyage-Decorticage pour une date données
	 * @param date
	 * @return
	 */
	public ResponseEntity<Collection<ParamNettoyageD>> getDonnneeParametres(int annee, int mois, int jour) {
		return new ResponseEntity<Collection<ParamNettoyageD>>(paramNettoyageDRepository.findByDate(LocalDate.of(annee,  mois, jour)), HttpStatus.FOUND);
	}

}
