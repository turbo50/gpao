package com.sdcc.gpao.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sdcc.gpao.entity.Personnel;
import com.sdcc.gpao.exception.NoDuplicationException;
import com.sdcc.gpao.exception.ResourceNotFoundException;
import com.sdcc.gpao.repository.IPersonnelRepository;

@Service
public class PersonnelService implements IServiceDeBase<Personnel> {

	private IPersonnelRepository personnelRepository;
	
	
	@Autowired
	public PersonnelService(IPersonnelRepository personnelRepository) {
		super();
		this.personnelRepository = personnelRepository;
	}

	@Override
	public ResponseEntity<Personnel> getElement(Object id_personnel) throws ResourceNotFoundException {
		Optional<Personnel> us = personnelRepository.findById(new Integer(id_personnel.toString()));
		if(us.isPresent()) {
			return new ResponseEntity<Personnel>(us.get(), HttpStatus.OK);
		}else {
			throw new ResourceNotFoundException("Personnel introuvable  : " + id_personnel);
		}
	}
	

	@Override
	public ResponseEntity<Collection<Personnel>> getListe() {
		return  new ResponseEntity<Collection<Personnel>>(personnelRepository.findAll(), HttpStatus.FOUND);
	}

	@Override
	public ResponseEntity<Personnel> sauvegarder(Personnel t) throws NoDuplicationException{
		return new ResponseEntity<Personnel>(personnelRepository.save(t), HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<Personnel> modifier(Personnel t) throws ResourceNotFoundException {
		Optional<Personnel> us = personnelRepository.findById(t.getIdpersonnel());
		if(us.isPresent()) {
			return new ResponseEntity<Personnel>(personnelRepository.save(t), HttpStatus.OK);
		}else {
			throw new ResourceNotFoundException("Personnel introuvable : " + t.getIdpersonnel());
		}
	}

	@Override
	public void supprimer(Personnel t) throws ResourceNotFoundException {
		Optional<Personnel> us = personnelRepository.findById(t.getIdpersonnel());
		if(us.isPresent()) {
			personnelRepository.deleteById(t.getIdpersonnel());
		}else {
			throw new ResourceNotFoundException("Personnel introuvable : " + t.getIdpersonnel());
		}
	}
	
	
	
}
