package com.sdcc.gpao.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AppUserDetailsService implements UserDetailsService {

	@Autowired
	private IUsersRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		// on cherche l'utilisateur via son login
		Optional<Users> user = userRepository.findByLogin(login);
		// trouvé ?
		if (!user.isPresent()) {
			throw new UsernameNotFoundException(String.format("login [%s] inexistant", login));
		}
		// on rend les détails de l'utilsateur
		return new AppUserDetails(user.get(), userRepository);
	}

}
