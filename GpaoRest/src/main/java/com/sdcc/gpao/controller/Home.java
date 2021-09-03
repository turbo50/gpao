package com.sdcc.gpao.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Home {
	private static final Logger logger = LoggerFactory.getLogger(Home.class);
	@GetMapping("/")
	public ResponseEntity<String> defaultResource() {
			logger.info("Démarrage des services OK .....");
			return new ResponseEntity<String>("Réponse du serveur: "+HttpStatus.OK.name(), HttpStatus.OK);
		}
}