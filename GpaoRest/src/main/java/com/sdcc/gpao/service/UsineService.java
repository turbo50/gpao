package com.sdcc.gpao.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sdcc.gpao.entity.Usine;
import com.sdcc.gpao.exception.NoDuplicationException;
import com.sdcc.gpao.exception.ResourceNotFoundException;
import com.sdcc.gpao.repository.IUsineRepository;

@Service
public class UsineService implements IServiceDeBase<Usine> {

	private IUsineRepository usineRepository;
	
	@Autowired
	public UsineService(IUsineRepository usineRepository) {
		this.usineRepository = usineRepository;
	}
	
	@Override
	public ResponseEntity<Collection<Usine>> getListe() {
		return new ResponseEntity<Collection<Usine>>(usineRepository.findAll(), HttpStatus.OK);
	}
	
	@Override
	public ResponseEntity<Usine> getElement(Object id_usine) throws ResourceNotFoundException {
		Optional<Usine> us = usineRepository.findById(new Integer(id_usine.toString()));
		if(us.isPresent()) {
			return new ResponseEntity<Usine>(us.get(), HttpStatus.OK);
		}else {
			throw new ResourceNotFoundException("Usine introuvable - ID Usine : " + id_usine);
		}
	}

	

	@Override
	public ResponseEntity<Usine> sauvegarder(Usine t) throws NoDuplicationException {
		return new ResponseEntity<Usine>(usineRepository.save(t), HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<Usine> modifier(Usine t) throws ResourceNotFoundException {
		Optional<Usine> us = usineRepository.findById(t.getIdusine());
		if(us.isPresent()) {
			return new ResponseEntity<Usine>(usineRepository.save(t), HttpStatus.OK);
		}else {
			throw new ResourceNotFoundException("Usine introuvable : " + t.getIdusine());
		}
	}

	@Override
	public void supprimer(Usine t) throws ResourceNotFoundException {
		Optional<Usine> us = usineRepository.findById(t.getIdusine());
		if(us.isPresent()) {
			usineRepository.deleteById(t.getIdusine());
		}else {
			throw new ResourceNotFoundException("Usine introuvable : " + t.getIdusine());
		}
		
	}

}
