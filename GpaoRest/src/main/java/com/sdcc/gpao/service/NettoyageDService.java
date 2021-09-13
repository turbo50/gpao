package com.sdcc.gpao.service;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sdcc.gpao.entity.NettoyageD;
import com.sdcc.gpao.entity.ParamNettoyageD;
import com.sdcc.gpao.exception.NoDuplicationException;
import com.sdcc.gpao.exception.ResourceNotFoundException;
import com.sdcc.gpao.repository.INettoyageDRepository;

@Service
public class NettoyageDService implements IServiceDeBase<NettoyageD> {

	private INettoyageDRepository nettoyageDRepository;
	
	@Autowired
	public NettoyageDService(INettoyageDRepository nettoyageDRepository) {
		super();
		this.nettoyageDRepository = nettoyageDRepository;
	}

	@Override
	public ResponseEntity<NettoyageD> getElement(Object id_nettoyaged) throws ResourceNotFoundException {
		Optional<NettoyageD> us = nettoyageDRepository.findById(new Integer(id_nettoyaged.toString()));
		if(us.isPresent()) {
			return new ResponseEntity<NettoyageD>(us.get(), HttpStatus.OK);
		}else {
			throw new ResourceNotFoundException("NettoyageD introuvable  : " + id_nettoyaged);
		}
	}
	

	@Override
	public ResponseEntity<Collection<NettoyageD>> getListe() {
		return  new ResponseEntity<Collection<NettoyageD>>(nettoyageDRepository.findAll(), HttpStatus.FOUND);
	}

	@Override
	public ResponseEntity<NettoyageD> sauvegarder(NettoyageD t) throws NoDuplicationException{
		//On évite d'ajouter 2 fois les données pour un même quart
				Optional<NettoyageD> us = nettoyageDRepository.findByIdplanning(t.getIdplanning());
				if(us.isPresent()) {
					throw new NoDuplicationException("Les données ont déjà été saisies. Planning(ID, date, heure) : (" + t.getIdplanning().getIdplanning() + 
							            ", " + t.getIdplanning().getDateplanning() + ", " + t.getIdplanning().getIdhoraire() + ")");
				}else {
					return new ResponseEntity<NettoyageD>(nettoyageDRepository.save(t), HttpStatus.CREATED);
				}
	}

	@Override
	public ResponseEntity<NettoyageD> modifier(NettoyageD t) throws ResourceNotFoundException {
		Optional<NettoyageD> us = nettoyageDRepository.findById(t.getIdnettoyaged());
		if(us.isPresent()) {
			return new ResponseEntity<NettoyageD>(nettoyageDRepository.save(t), HttpStatus.OK);
		}else {
			throw new ResourceNotFoundException("NettoyageD introuvable : " + t.getIdnettoyaged());
		}
	}

	@Override
	public void supprimer(NettoyageD t) throws ResourceNotFoundException {
		Optional<NettoyageD> us = nettoyageDRepository.findById(t.getIdnettoyaged());
		if(us.isPresent()) {
			nettoyageDRepository.deleteById(t.getIdnettoyaged());
		}else {
			throw new ResourceNotFoundException("NettoyageD introuvable : " + t.getIdpersonnel());
		}
	}
	
	/**
	 * Cette fonction retourne les données sur la production de l'Atelier Nettoyage-Decorticage pour une date données
	 * @param date
	 * @return
	 */
	public ResponseEntity<Collection<NettoyageD>> getDonneesProduction(int annee, int mois, int jour) {
		return new ResponseEntity<Collection<NettoyageD>>(nettoyageDRepository.findByDate(LocalDate.of(annee,  mois, jour)), HttpStatus.FOUND);
	}

}
