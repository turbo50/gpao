package com.sdcc.gpao.security;


import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;


import com.sdcc.gpao.exception.NoDuplicationException;
import com.sdcc.gpao.exception.ResourceNotFoundException;
import com.sdcc.gpao.service.IServiceDeBase;

@Service
public class UsersService implements IServiceDeBase<Users> {
	
	private IUsersRepository userRepository;
	
	private IUsersRolesRepository userRoleRepository;
	
	@Autowired
	public UsersService(IUsersRepository userRepository, IUsersRolesRepository userRoleRepository) {
		super();
		this.userRepository = userRepository;
		this.userRoleRepository = userRoleRepository;
	}
	
	@Override
	public ResponseEntity<Collection<Users>> getListe() {
		return new ResponseEntity<Collection<Users>>(userRepository.findAll(), HttpStatus.FOUND);
	}

	@Override
	public ResponseEntity<Users> getElement(Object code) throws ResourceNotFoundException {
		Users user = userRepository.findById(Long.parseLong(code.toString())).orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + code));
	    return new ResponseEntity<Users>(user, HttpStatus.FOUND);
	}

	@Override
	public ResponseEntity<Users> sauvegarder(Users user) throws NoDuplicationException {
		  String crypt = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
	      Optional<Users> userSave = userRepository.findByLogin(user.getLogin());
	      Users u;
	      if(userSave.isPresent()) {
	    	  throw new NoDuplicationException("L'utilisateur existe déjà");
	      }else {
	    	  user.setPassword(crypt);
	    	  //On récupère le ou les rôles donnés à l'utilisateur et on les lui attribue
	    	  //Sachant que les rôles doivent déjà avoir été crée dans la base de données
	    	  Collection<UsersRoles> liste_roles = user.getUsersRolesCollection();
	    	  //On efface les roles pour enregistrer l'utilisateur d'abord et faire suivre le reste après
	    	  user.setUsersRolesCollection(null);
	    	  u =  userRepository.save(user);
	    	  for(UsersRoles r : liste_roles) {
	    		//On établit le lien entre l'utilisateur et son rôle
		          userRoleRepository.save(new UsersRoles(u, r.getIdRoles()));
	    	  }
	          return new ResponseEntity<Users>(u, HttpStatus.CREATED);
	      }
	}

	@Override
	public ResponseEntity<Users> modifier(Users t) throws ResourceNotFoundException {
		String crypt = BCrypt.hashpw(t.getPassword(), BCrypt.gensalt());
	    t.setPassword(crypt);	    
	    Optional<Users> us = userRepository.findById(t.getIdUsers());
		if(us.isPresent()) {
			return new ResponseEntity<Users>(userRepository.save(t), HttpStatus.OK);
		}else {
			throw new ResourceNotFoundException("utilisateur introuvable : " + t.getIdUsers());
		}
	}

	@Override
	public void supprimer(Users t) throws ResourceNotFoundException {
		Optional<Users> us = userRepository.findById(t.getIdUsers());
		if(us.isPresent()) {
			userRepository.deleteById(t.getIdUsers());
		}else {
			throw new ResourceNotFoundException("Utilisateur introuvable : " + t.getIdUsers());
		}		
	}

}
