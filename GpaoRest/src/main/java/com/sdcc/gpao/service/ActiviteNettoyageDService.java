package com.sdcc.gpao.service;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sdcc.gpao.entity.ActiviteNettoyageD;
import com.sdcc.gpao.entity.AnalyseNettPressPell;
import com.sdcc.gpao.exception.NoDuplicationException;
import com.sdcc.gpao.exception.ResourceNotFoundException;
import com.sdcc.gpao.repository.IActiviteNettoyageDRepository;

@Service
public class ActiviteNettoyageDService implements IServiceDeBase<ActiviteNettoyageD> {

	private IActiviteNettoyageDRepository activiteNettoyageDRepository;
	
	@Autowired
	public ActiviteNettoyageDService(IActiviteNettoyageDRepository activiteNettoyageDRepository) {
		super();
		this.activiteNettoyageDRepository = activiteNettoyageDRepository;
	}

	@Override
	public ResponseEntity<ActiviteNettoyageD> getElement(Object id_activite) throws ResourceNotFoundException {
		Optional<ActiviteNettoyageD> us = activiteNettoyageDRepository.findById(new Integer(id_activite.toString()));
		if(us.isPresent()) {
			return new ResponseEntity<ActiviteNettoyageD>(us.get(), HttpStatus.OK);
		}else {
			throw new ResourceNotFoundException("Analyse Nettoyage - pression - Pelletisation introuvable  : " + id_activite);
		}
	}
	

	@Override
	public ResponseEntity<Collection<ActiviteNettoyageD>> getListe() {
		return  new ResponseEntity<Collection<ActiviteNettoyageD>>(activiteNettoyageDRepository.findAll(), HttpStatus.FOUND);
	}

	@Override
	public ResponseEntity<ActiviteNettoyageD> sauvegarder(ActiviteNettoyageD t) throws NoDuplicationException {
		//On évite d'ajouter 2 fois les données pour un même quart
		Optional<ActiviteNettoyageD> us = activiteNettoyageDRepository.findByIdplanning(t.getIdplanning());
		if(us.isPresent()) {
			throw new NoDuplicationException("Les données ont déjà été saisies. Planning(ID, date, heure) : (" + t.getIdplanning().getIdplanning() + 
					            ", " + t.getIdplanning().getDateplanning() + ", " + t.getIdplanning().getIdhoraire() + ")");
		}else {
			return new ResponseEntity<ActiviteNettoyageD>(activiteNettoyageDRepository.save(t), HttpStatus.CREATED);
		}
	}

	@Override
	public ResponseEntity<ActiviteNettoyageD> modifier(ActiviteNettoyageD t) throws ResourceNotFoundException {
		Optional<ActiviteNettoyageD> us = activiteNettoyageDRepository.findById(t.getIdactivite());
		if(us.isPresent()) {
			return new ResponseEntity<ActiviteNettoyageD>(activiteNettoyageDRepository.save(t), HttpStatus.OK);
		}else {
			throw new ResourceNotFoundException("Analyse Nettoyage - pression - Pelletisation introuvable : " + t.getIdactivite());
		}
	}

	@Override
	public void supprimer(ActiviteNettoyageD t) throws ResourceNotFoundException {
		Optional<ActiviteNettoyageD> us = activiteNettoyageDRepository.findById(t.getIdactivite());
		if(us.isPresent()) {
			activiteNettoyageDRepository.deleteById(t.getIdactivite());
		}else {
			throw new ResourceNotFoundException("Analyse Nettoyage - pression - Pelletisation introuvable : " + t.getIdpersonnel());
		}
	}
	
	/**
	 * Cette fonction retourne les données d'analyses sur la production de l'Atelier Nettoyage-Decorticage pour une date données
	 * @param date
	 * @return
	 */
	public ResponseEntity<Collection<ActiviteNettoyageD>> getDonnneeActivite(int annee, int mois, int jour) {
		return new ResponseEntity<Collection<ActiviteNettoyageD>>(activiteNettoyageDRepository.findByDate(LocalDate.of(annee,  mois, jour)), HttpStatus.FOUND);
	}

}
