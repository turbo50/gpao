package com.sdcc.gpao.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sdcc.gpao.entity.Quart;
import com.sdcc.gpao.exception.NoDuplicationException;
import com.sdcc.gpao.exception.ResourceNotFoundException;
import com.sdcc.gpao.repository.IQuartRepository;

@Service
public class QuartService implements IServiceDeBase<Quart> {

	private IQuartRepository quartRepository;
	
	@Autowired
	public QuartService(IQuartRepository quartRepository) {
		this.quartRepository = quartRepository;
	}
	
	@Override
	public ResponseEntity<Quart> getElement(Object id_quart) throws ResourceNotFoundException {
		Optional<Quart> us = quartRepository.findById(new Integer(id_quart.toString()));
		if(us.isPresent()) {
			return new ResponseEntity<Quart>(us.get(), HttpStatus.OK);
		}else {
			throw new ResourceNotFoundException("Quart introuvable  : " + id_quart);
		}
	}
	

	@Override
	public ResponseEntity<Collection<Quart>> getListe() {
		return  new ResponseEntity<Collection<Quart>>(quartRepository.findAll(), HttpStatus.FOUND);
	}

	@Override
	public ResponseEntity<Quart> sauvegarder(Quart t) throws NoDuplicationException{
		return new ResponseEntity<Quart>(quartRepository.save(t), HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<Quart> modifier(Quart t) throws ResourceNotFoundException {
		Optional<Quart> us = quartRepository.findById(t.getIdquart());
		if(us.isPresent()) {
			return new ResponseEntity<Quart>(quartRepository.save(t), HttpStatus.OK);
		}else {
			throw new ResourceNotFoundException("Quart introuvable : " + t.getIdquart());
		}
	}

	@Override
	public void supprimer(Quart t) throws ResourceNotFoundException {
		Optional<Quart> us = quartRepository.findById(t.getIdquart());
		if(us.isPresent()) {
			quartRepository.deleteById(t.getIdquart());
		}else {
			throw new ResourceNotFoundException("Quart introuvable : " + t.getIdquart());
		}
	}
	
	
	
}
