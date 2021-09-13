package com.sdcc.gpao.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sdcc.gpao.entity.Horaire;
import com.sdcc.gpao.exception.NoDuplicationException;
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
	public ResponseEntity<Horaire> sauvegarder(Horaire t) throws NoDuplicationException{
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
	
	//Autres fonction metier
	
	/**
	 * Cette fonction retourne une horaire suivant h à partir de l'ordre de passage parametré dans la table Horaire.Ordre
	 * @param h horaire donné
	 * @param liste_horaire liste des horaires dans l'ordre de passage
	 * @return Horaire suivant
	 */
	public Horaire horaireSuivant(Horaire h, ArrayList<Horaire> liste_horaire) {
		Horaire ho = h; int index = -1;		
		for(Horaire horaire: liste_horaire) {
			if(horaire.getIdhoraire() == h.getIdhoraire()) {
				index = liste_horaire.lastIndexOf(horaire);
			}
		}
		//On a trouvé ce qu'on cherche
		if(index != -1) {
			if(liste_horaire.size() > 1 && index == liste_horaire.size() - 1) {
				//On est à la fin de la liste. Le suivant est le premier dans la liste
				ho = liste_horaire.get(0);
			}
			else {
				ho = liste_horaire.get(index + 1);
			}
			return ho;
		}
		return null;
	}
	
	/**
	 * Cette fonction est utilisée pour déterminer l'heure à laquelle un quart est affecté
	 * @param dateBase : La date de référence dans la table paramPlanning
	 * @param dateCourante : La date courante à laquelle on s'interroge
	 * @param horaireBase : L'heure de référence qui a été fixé dans la table paramPlanning. Par exemple 07:00-15:00. 
	 * C'est sur cette base qu'on va déduire l'horaire actuelle auquel est affecté le quart en question
	 * @param cycle : Le nombre de jour après lequel on effectue le décalage
	 * @return
	 * @throws Exception
	 */
	public ResponseEntity<Horaire> getHoraireActuelle(LocalDate dateBase, LocalDate dateCourante, Horaire horaireBase, int cycle) throws Exception {
		if(dateCourante.isAfter(dateBase)) {
			Horaire ho = horaireBase; int j = 0;
			ArrayList<Horaire> liste  = (ArrayList<Horaire>) horaireRepository.findAll(Sort.by(Sort.Direction.ASC, "ordre"));
			long nb_days = ChronoUnit.DAYS.between(dateCourante, dateBase);
			for(long i = 0; i < nb_days; i++) {
				j++;
				if(j > cycle) {
					ho = horaireSuivant(ho, liste);
					j = 0;
				}
			}
			return new  ResponseEntity<Horaire>(ho, HttpStatus.FOUND);
		}else {
			throw new Exception("Erreur avec la plage de date");
		}
	}
}
