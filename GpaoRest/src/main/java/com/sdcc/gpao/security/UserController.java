package com.sdcc.gpao.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sdcc.gpao.exception.NoDuplicationException;
import com.sdcc.gpao.exception.ResourceNotFoundException;

import java.util.Collection;

/**
 * The type User controller.
 *
 * @author ladac
 */
@RestController
@RequestMapping("/api/users/")
public class UserController {

  @Autowired
  private UsersService usersService;;

  /**
   * Get all users list.
   *
   * @return the list
   */
  @GetMapping("/liste")
  public ResponseEntity<Collection<Users>> getAllUsers() {
    return usersService.getListe();
  }

 
  @GetMapping("/liste/{id}")
  public ResponseEntity<Users> getElement(@PathVariable(value = "id") int userId) throws ResourceNotFoundException {
    return usersService.getElement(userId);
  }

  /**
   * Create user user.
   *
   * @param user the user
   * @return the user
   */
  @PostMapping("/ajouter")
  public ResponseEntity<Users> createUser(@RequestBody Users user) throws NoDuplicationException {  
      return usersService.sauvegarder(user);
  }

  /**
   * Update user response entity.
   *
   * @param userId the user id
   * @param userDetails the user details
   * @return the response entity
   * @throws ResourceNotFoundException the resource not found exception
   */
  @PutMapping("/modifier}")
  public ResponseEntity<Users> modifier(@RequestBody Users user) throws ResourceNotFoundException {
	  return usersService.modifier(user);
  }

  /**
   * Delete user map.
   *
   * @param userId the user id
   * @return the map
   * @throws Exception the exception
   */
  @DeleteMapping("/supprimer")
  public void supprimer(@RequestBody Users user) throws ResourceNotFoundException {
	  usersService.supprimer(user);
  }
}
