package com.tn.saasProjectTicket.services;

 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tn.saasProjectTicket.entity.Utilisateur;
import com.tn.saasProjectTicket.repository.UserRepository;






@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

		Utilisateur user = userRepository.findByUsername(login).orElseThrow(
				() -> new UsernameNotFoundException("User Not Found with -> login : " + login));

		return UserPrinciple.build(user);
	}
}