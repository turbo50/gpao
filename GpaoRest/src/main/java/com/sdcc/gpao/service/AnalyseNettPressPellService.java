package com.sdcc.gpao.service;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sdcc.gpao.entity.AnalyseNettPressPell;
import com.sdcc.gpao.exception.NoDuplicationException;
import com.sdcc.gpao.exception.ResourceNotFoundException;
import com.sdcc.gpao.repository.IAnalyseNettPressPellRepository;

@Service
public class AnalyseNettPressPellService implements IServiceDeBase<AnalyseNettPressPell> {

	private IAnalyseNettPressPellRepository analyseNettPressPellRepository;
	
	@Autowired
	public AnalyseNettPressPellService(IAnalyseNettPressPellRepository analyseNettPressPellRepository) {
		super();
		this.analyseNettPressPellRepository = analyseNettPressPellRepository;
	}

	@Override
	public ResponseEntity<AnalyseNettPressPell> getElement(Object id_nettoyaged) throws ResourceNotFoundException {
		Optional<AnalyseNettPressPell> us = analyseNettPressPellRepository.findById(new Integer(id_nettoyaged.toString()));
		if(us.isPresent()) {
			return new ResponseEntity<AnalyseNettPressPell>(us.get(), HttpStatus.OK);
		}else {
			throw new ResourceNotFoundException("Analyse Nettoyage - pression - Pelletisation introuvable  : " + id_nettoyaged);
		}
	}
	

	@Override
	public ResponseEntity<Collection<AnalyseNettPressPell>> getListe() {
		return  new ResponseEntity<Collection<AnalyseNettPressPell>>(analyseNettPressPellRepository.findAll(), HttpStatus.FOUND);
	}

	@Override
	public ResponseEntity<AnalyseNettPressPell> sauvegarder(AnalyseNettPressPell t) throws NoDuplicationException {
		//On évite d'ajouter 2 fois les données pour un même quart
		Optional<AnalyseNettPressPell> us = analyseNettPressPellRepository.findByIdplanning(t.getIdplanning());
		if(us.isPresent()) {
			throw new NoDuplicationException("Les données ont déjà été saisies. Planning(ID, date, heure) : (" + t.getIdplanning().getIdplanning() + 
					            ", " + t.getIdplanning().getDateplanning() + ", " + t.getIdplanning().getIdhoraire() + ")");
		}else {
			return new ResponseEntity<AnalyseNettPressPell>(analyseNettPressPellRepository.save(t), HttpStatus.CREATED);
		}
	}

	@Override
	public ResponseEntity<AnalyseNettPressPell> modifier(AnalyseNettPressPell t) throws ResourceNotFoundException {
		Optional<AnalyseNettPressPell> us = analyseNettPressPellRepository.findById(t.getIdanalyse());
		if(us.isPresent()) {
			return new ResponseEntity<AnalyseNettPressPell>(analyseNettPressPellRepository.save(t), HttpStatus.OK);
		}else {
			throw new ResourceNotFoundException("Analyse Nettoyage - pression - Pelletisation introuvable : " + t.getIdanalyse());
		}
	}

	@Override
	public void supprimer(AnalyseNettPressPell t) throws ResourceNotFoundException {
		Optional<AnalyseNettPressPell> us = analyseNettPressPellRepository.findById(t.getIdanalyse());
		if(us.isPresent()) {
			analyseNettPressPellRepository.deleteById(t.getIdanalyse());
		}else {
			throw new ResourceNotFoundException("Analyse Nettoyage - pression - Pelletisation introuvable : " + t.getIdpersonnel());
		}
	}
	
	/**
	 * Cette fonction retourne les données d'analyses sur la production de l'Atelier Nettoyage-Decorticage pour une date données
	 * @param date
	 * @return
	 */
	public ResponseEntity<Collection<AnalyseNettPressPell>> getDonnneeAnalyse(int annee, int mois, int jour) {
		return new ResponseEntity<Collection<AnalyseNettPressPell>>(analyseNettPressPellRepository.findByDate(LocalDate.of(annee,  mois, jour)), HttpStatus.FOUND);
	}

}
