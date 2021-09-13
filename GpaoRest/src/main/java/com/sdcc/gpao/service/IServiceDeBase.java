package com.sdcc.gpao.service;

import java.util.Collection;

import org.springframework.http.ResponseEntity;

import com.sdcc.gpao.exception.NoDuplicationException;
import com.sdcc.gpao.exception.ResourceNotFoundException;

public interface IServiceDeBase<T> {
	public ResponseEntity<Collection<T>> getListe();
	public ResponseEntity<T> getElement(Object code) throws ResourceNotFoundException;
	public ResponseEntity<T> sauvegarder(T t)throws NoDuplicationException;
	public ResponseEntity<T> modifier(T t) throws ResourceNotFoundException;
	public void supprimer(T t) throws ResourceNotFoundException;
}
