package com.sdcc.gpao.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.sdcc.gpao.entity.Reception;
import com.sdcc.gpao.exception.ResourceNotFoundException;
import com.sdcc.gpao.repository.IReceptionRepository;

@Service
public class ReceptionService implements IServiceDeBase<Reception> {
	private IReceptionRepository receptionRepository;
	
	@Autowired
	public ReceptionService(IReceptionRepository receptionRepository) {
		this.receptionRepository = receptionRepository;
	}
	
	@Override
	public ResponseEntity<Reception> getElement(Object id_service) throws ResourceNotFoundException {
		Optional<Reception> us = receptionRepository.findById(new Integer(id_service.toString()));
		if(us.isPresent()) {
			return new ResponseEntity<Reception>(us.get(), HttpStatus.OK);
		}else {
			throw new ResourceNotFoundException("Reception introuvable  : " + id_service);
		}
	}
	

	@Override
	public ResponseEntity<Collection<Reception>> getListe() {
		return  new ResponseEntity<Collection<Reception>>(receptionRepository.findAll(), HttpStatus.FOUND);
	}

	@Override
	public ResponseEntity<Reception> sauvegarder(Reception t) {
		return new ResponseEntity<Reception>(receptionRepository.save(t), HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<Reception> modifier(Reception t) throws ResourceNotFoundException {
		Optional<Reception> us = receptionRepository.findById(t.getIdreception());
		if(us.isPresent()) {
			return new ResponseEntity<Reception>(receptionRepository.save(t), HttpStatus.OK);
		}else {
			throw new ResourceNotFoundException("Reception introuvable : " + t.getIdreception());
		}
	}

	@Override
	public void supprimer(Reception t) throws ResourceNotFoundException {
		Optional<Reception> us = receptionRepository.findById(t.getIdreception());
		if(us.isPresent()) {
			receptionRepository.deleteById(t.getIdreception());
		}else {
			throw new ResourceNotFoundException("Reception introuvable : " + t.getIdreception());
		}
	}
}
