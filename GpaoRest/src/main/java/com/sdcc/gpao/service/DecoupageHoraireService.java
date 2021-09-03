package com.sdcc.gpao.service;


import java.time.LocalTime;
import java.util.Collection;
//import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sdcc.gpao.entity.DecoupageHoraire;
import com.sdcc.gpao.exception.ResourceNotFoundException;
import com.sdcc.gpao.repository.IDecoupageHoraireRepository;


@Service
public class DecoupageHoraireService implements IServiceDeBase<DecoupageHoraire> {

	private IDecoupageHoraireRepository decoupageHoraireRepository;
	
	
	@Autowired
	public DecoupageHoraireService(IDecoupageHoraireRepository decoupageHoraireRepository) {
		super();
		this.decoupageHoraireRepository = decoupageHoraireRepository;
	}

	@Override
	public ResponseEntity<DecoupageHoraire> getElement(Object id_personnel) throws ResourceNotFoundException {
		Optional<DecoupageHoraire> us = decoupageHoraireRepository.findById(new Integer(id_personnel.toString()));
		if(us.isPresent()) {
			return new ResponseEntity<DecoupageHoraire>(us.get(), HttpStatus.OK);
		}else {
			throw new ResourceNotFoundException("Decoupage Horaire introuvable  : " + id_personnel);
		}
	}
	

	@Override
	public ResponseEntity<Collection<DecoupageHoraire>> getListe() {
		return  new ResponseEntity<Collection<DecoupageHoraire>>(decoupageHoraireRepository.findAll(), HttpStatus.FOUND);
	}

	@Override
	public ResponseEntity<DecoupageHoraire> sauvegarder(DecoupageHoraire t) {
		return new ResponseEntity<DecoupageHoraire>(decoupageHoraireRepository.save(t), HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<DecoupageHoraire> modifier(DecoupageHoraire t) throws ResourceNotFoundException {
		Optional<DecoupageHoraire> us = decoupageHoraireRepository.findById(t.getIddecoupage());
		if(us.isPresent()) {
			return new ResponseEntity<DecoupageHoraire>(decoupageHoraireRepository.save(t), HttpStatus.OK);
		}else {
			throw new ResourceNotFoundException("Decoupage Horaire introuvable : " + t.getIddecoupage());
		}
	}

	@Override
	public void supprimer(DecoupageHoraire t) throws ResourceNotFoundException {
		Optional<DecoupageHoraire> us = decoupageHoraireRepository.findById(t.getIddecoupage());
		if(us.isPresent()) {
			decoupageHoraireRepository.deleteById(t.getIddecoupage());
		}else {
			throw new ResourceNotFoundException("Decoupage Horaire introuvable : " + t.getIddecoupage());
		}
	}
	
	/**
	 * Cette méthode prend en paramètre deux valeurs correspondantes à un interval de temps
	 * @param time_deb
	 * @param time_fin
	 * @return Les heures appartenant à cet intervalle fournit en paramètre
	 */
	public ResponseEntity<Collection<DecoupageHoraire>> getDecoupageParInterval(int time_deb, int time_fin) {
		return  new ResponseEntity<Collection<DecoupageHoraire>>(decoupageHoraireRepository.
				findDecoupageByHeure(LocalTime.of(time_deb, 0).plusHours(1), LocalTime.of(time_fin, 0).minusHours(1)), HttpStatus.FOUND);
	}
	

}
