package com.sdcc.gpao.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sdcc.gpao.entity.Chauffeur;
import com.sdcc.gpao.exception.ResourceNotFoundException;
import com.sdcc.gpao.repository.IChauffeurRepository;

@Service
public class ChauffeurService implements IServiceDeBase<Chauffeur> {
	private IChauffeurRepository chauffeurRepository;
	
	@Autowired
	public ChauffeurService(IChauffeurRepository chauffeurRepository) {
		this.chauffeurRepository = chauffeurRepository;
	}
	
	@Override
	public ResponseEntity<Chauffeur> getElement(Object id_chauffeur) throws ResourceNotFoundException {
		Optional<Chauffeur> us = chauffeurRepository.findById(new Integer(id_chauffeur.toString()));
		if(us.isPresent()) {
			return new ResponseEntity<Chauffeur>(us.get(), HttpStatus.OK);
		}else {
			throw new ResourceNotFoundException("Chauffeur introuvable  : " + id_chauffeur);
		}
	}
	

	@Override
	public ResponseEntity<Collection<Chauffeur>> getListe() {
		return  new ResponseEntity<Collection<Chauffeur>>(chauffeurRepository.findAll(), HttpStatus.FOUND);
	}

	@Override
	public ResponseEntity<Chauffeur> sauvegarder(Chauffeur t) {
		return new ResponseEntity<Chauffeur>(chauffeurRepository.save(t), HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<Chauffeur> modifier(Chauffeur t) throws ResourceNotFoundException {
		Optional<Chauffeur> us = chauffeurRepository.findById(t.getIdchauffeur());
		if(us.isPresent()) {
			return new ResponseEntity<Chauffeur>(chauffeurRepository.save(t), HttpStatus.OK);
		}else {
			throw new ResourceNotFoundException("Chauffeur introuvable : " + t.getIdchauffeur());
		}
	}

	@Override
	public void supprimer(Chauffeur t) throws ResourceNotFoundException {
		Optional<Chauffeur> us = chauffeurRepository.findById(t.getIdchauffeur());
		if(us.isPresent()) {
			chauffeurRepository.deleteById(t.getIdchauffeur());
		}else {
			throw new ResourceNotFoundException("Chauffeur introuvable : " + t.getIdchauffeur());
		}
	}
}
