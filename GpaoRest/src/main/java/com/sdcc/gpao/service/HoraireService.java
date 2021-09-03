package com.sdcc.gpao.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sdcc.gpao.entity.Horaire;
import com.sdcc.gpao.exception.ResourceNotFoundException;
import com.sdcc.gpao.repository.IHoraireRepository;

@Service
public class HoraireService implements IServiceDeBase<Horaire> {

	private IHoraireRepository horaireRepository;
	@Autowired
	public HoraireService(IHoraireRepository horaireRepository) {
		super();
		this.horaireRepository = horaireRepository;
	}

	@Override
	public ResponseEntity<Horaire> getElement(Object id_personnel) throws ResourceNotFoundException {
		Optional<Horaire> us = horaireRepository.findById(new Integer(id_personnel.toString()));
		if(us.isPresent()) {
			return new ResponseEntity<Horaire>(us.get(), HttpStatus.OK);
		}else {
			throw new ResourceNotFoundException("Horaire introuvable  : " + id_personnel);
		}
	}
	

	@Override
	public ResponseEntity<Collection<Horaire>> getListe() {
		return  new ResponseEntity<Collection<Horaire>>(horaireRepository.findAll(), HttpStatus.FOUND);
	}

	@Override
	public ResponseEntity<Horaire> sauvegarder(Horaire t) {
		return new ResponseEntity<Horaire>(horaireRepository.save(t), HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<Horaire> modifier(Horaire t) throws ResourceNotFoundException {
		Optional<Horaire> us = horaireRepository.findById(t.getIdhoraire());
		if(us.isPresent()) {
			return new ResponseEntity<Horaire>(horaireRepository.save(t), HttpStatus.OK);
		}else {
			throw new ResourceNotFoundException("Horaire introuvable : " + t.getIdhoraire());
		}
	}

	@Override
	public void supprimer(Horaire t) throws ResourceNotFoundException {
		Optional<Horaire> us = horaireRepository.findById(t.getIdhoraire());
		if(us.isPresent()) {
			horaireRepository.deleteById(t.getIdhoraire());
		}else {
			throw new ResourceNotFoundException("Horaire introuvable : " + t.getIdhoraire());
		}
	}
	
	
	
}
