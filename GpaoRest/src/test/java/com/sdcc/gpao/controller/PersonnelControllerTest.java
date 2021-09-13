package com.sdcc.gpao.controller;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.http.MediaType;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sdcc.gpao.entity.Personnel;
import com.sdcc.gpao.exception.NoDuplicationException;
import com.sdcc.gpao.exception.ResourceNotFoundException;
import com.sdcc.gpao.service.PersonnelService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PersonnelControllerTest {
	@MockBean
	private PersonnelService personnelService;
	@Autowired
	private MockMvc mockMvc;
	private ObjectMapper objectMapper;
	
	private Personnel personnel, personnel2;
	private ArrayList<Personnel> liste_personnel;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Before
	public void Setup() throws ResourceNotFoundException, NoDuplicationException {
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
		//On fabrique le mapper
		objectMapper = new ObjectMapper();
		//On indique le comportement des méthodes de la couche service qui seront appelées
		when(personnelService.getListe()).thenReturn(ResponseEntity.ok(liste_personnel));
		when(personnelService.sauvegarder(any(Personnel.class))).thenReturn(ResponseEntity.ok(personnel));
		when(personnelService.modifier(any(Personnel.class))).thenReturn(ResponseEntity.ok(personnel), new ResponseEntity(null, HttpStatus.NOT_FOUND));
		doNothing().when(personnelService).supprimer(any(Personnel.class));		
	}
	
	@Test
	public void modifierPersonnelTest() throws Exception {
		String jsonContent = objectMapper.writeValueAsString(personnel);
		MvcResult result = mockMvc.perform(put("/api/personnel/modifier").content(jsonContent).
				contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();
		
		assertEquals("Message", HttpStatus.OK.value(), result.getResponse().getStatus());
		assertNotNull(result);
		Personnel p = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<Personnel>() {});
		
		assertNotNull(p);
		assertEquals("Meme ID", p.getIdpersonnel(), personnel.getIdpersonnel());
		assertEquals("Meme nom", p.getNom(), personnel.getNom());
		
		//Deuxième appel pour lever l'exception
		result = mockMvc.perform(put("/api/personnel/modifier").content(jsonContent).
				contentType(MediaType.APPLICATION_JSON)).andExpect(status().isNotFound()).andReturn();
		assertEquals("Message", HttpStatus.NOT_FOUND.value(), result.getResponse().getStatus());
	}
	
	@Test
	public void ajouterPersonnelTest() throws Exception {
		String jsonContent = objectMapper.writeValueAsString(personnel);
		MvcResult result = mockMvc.perform(post("/api/personnel/ajouter").content(jsonContent).
				contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();
		
		assertEquals("Message", HttpStatus.OK.value(), result.getResponse().getStatus());
		assertNotNull(result);
		Personnel p = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<Personnel>() {});
		
		assertNotNull(p);
		assertEquals("Meme ID", p.getIdpersonnel(), personnel.getIdpersonnel());
		assertEquals("Meme nom", p.getNom(), personnel.getNom());	
		
	}
	
	@Test
	public void supprimerPersonnelTest() throws Exception {
		String jsonContent = objectMapper.writeValueAsString(personnel);
		MvcResult result = mockMvc.perform(delete("/api/personnel/supprimer").content(jsonContent).
				contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();		
		assertEquals("Message", HttpStatus.OK.value(), result.getResponse().getStatus());
		assertNotNull(result);		
		
	}
	
	@Test
	public void getListePersonnelTest() throws Exception {
		MvcResult result = mockMvc.perform(get("/api/personnel/liste").
				contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();		
		assertEquals("Message", HttpStatus.OK.value(), result.getResponse().getStatus());
		assertNotNull(result);
		ArrayList<Personnel> p_liste = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<ArrayList<Personnel>>() {});
		assertThat(liste_personnel.size(), is(p_liste.size()));
		
	}

}
