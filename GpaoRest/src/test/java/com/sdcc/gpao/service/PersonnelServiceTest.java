package com.sdcc.gpao.service;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.sdcc.gpao.entity.Personnel;
import com.sdcc.gpao.exception.ResourceNotFoundException;
import com.sdcc.gpao.repository.IPersonnelRepository;



import static org.mockito.ArgumentMatchers.any;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertThat;

@SpringBootTest
public class PersonnelServiceTest {

	private PersonnelService personnelService;
	private IPersonnelRepository personnelRepository;
	private Personnel personnel, personnel2;
	private ArrayList<Personnel> liste_personnel;
	
	@Before
	public void Setup() {
		personnel = new Personnel();
		personnel.setIdpersonnel(1);
		personnel.setMatricule("Mat001");
		personnel.setNom("Bob");
		personnel.setFonction("Laborantin");
		//Personnel 2
		personnel2 = new Personnel();
		personnel2.setIdpersonnel(2);
		personnel2.setMatricule("Mat002");
		personnel2.setNom("Alice");
		personnel2.setFonction("Machiniste");
		//Liste du personnel
		liste_personnel = new ArrayList<>();
		liste_personnel.add(personnel); liste_personnel.add(personnel2);
		//On fabrique le mock du repository
		personnelRepository = mock(IPersonnelRepository.class);
		//On cree le service avec le mock du repository
		personnelService = new PersonnelService(personnelRepository);
		
	}
	
	@Test
	public void test_liste() {
		when(personnelRepository.findAll()).thenReturn(liste_personnel);
		ResponseEntity<Collection<Personnel>> response_e = personnelService.getListe();
		//We start checking
		assertThat(liste_personnel, is(response_e.getBody()));
		verify(personnelRepository).findAll();
	}
	
	@Test
	public void test_modifier() throws ResourceNotFoundException  {
		when(personnelRepository.findById(any(Integer.class))).thenReturn(Optional.ofNullable(personnel2));
		when(personnelRepository.save(personnel2)).thenReturn(personnel2);
		ResponseEntity<Personnel> personnel = personnelService.modifier(personnel2);
		verify(personnelRepository).findById(any(Integer.class));
		assertThat(personnel.getBody(), is(personnel2));
	}
	
}
