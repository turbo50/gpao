package com.sdcc.gpao.security;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class AppUserDetails implements UserDetails{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	 private Users user;
	 private IUsersRepository userRepository;
	
	
	 public AppUserDetails() {
	 }
	
	 public AppUserDetails(Users user, IUsersRepository userRepository) {
		 this.user = user;
		 this.userRepository = userRepository;
	 }	 
	 
	  // -------------------------interface
	  @Override
	  public Collection<? extends GrantedAuthority> getAuthorities() {
		  Collection<GrantedAuthority> authorities = new ArrayList<>();
		  for (Roles role : userRepository.getRoles(user.getIdUsers())) {
			  authorities.add(new SimpleGrantedAuthority(role.getName()));
		  }
		  return authorities;
	 }
	
	 @Override
	 public String getPassword() {
		 return user.getPassword();
	 }
	 
	  @Override
	  public String getUsername() {
		  return user.getLogin();
	  }
	
	  @Override
	  public boolean isAccountNonExpired() {
		  return true;
	  }
	
	  @Override
	  public boolean isAccountNonLocked() {
		 return true;
	  }
	
	 @Override
	 public boolean isCredentialsNonExpired() {
		 return true;
	 }
	
	 @Override
	 public boolean isEnabled() {
		 return true;
	 }

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public IUsersRepository getUserRepository() {
		return userRepository;
	}

	public void setUserRepository(IUsersRepository userRepository) {
		this.userRepository = userRepository;
	}
	 
		
}
