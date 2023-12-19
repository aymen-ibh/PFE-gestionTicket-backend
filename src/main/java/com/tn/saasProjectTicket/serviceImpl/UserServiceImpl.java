package com.tn.saasProjectTicket.serviceImpl;

import java.util.Date;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.tn.saasProjectTicket.entity.Utilisateur;
import com.tn.saasProjectTicket.exception.domain.EmailAlreadyExistException;
import com.tn.saasProjectTicket.exception.domain.UserAlreadyExistException;
import com.tn.saasProjectTicket.repository.UserRepository;
import com.tn.saasProjectTicket.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	private UserRepository userRepository;
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}
	
	@Override
	public Utilisateur registerUser(String firstName, String lastName, String username,String password, String email,
			Date birthDate) {
		Utilisateur user = new Utilisateur();
		if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new UserAlreadyExistException("Nom d'utilisateur déjà pris");
        }
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new EmailAlreadyExistException("Email déjà utilisé");
        }
		user.setUserId(Integer.parseInt(generateUserId()));
		user.setPassword(encodePassword(password));
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setUsername(username);
		user.setEmail(email);
		user.setBirthDate(birthDate);
		user.setCreationDate(new Date());
		userRepository.save(user);
		return user;
	}

	private String encodePassword(String password) {
		return passwordEncoder.encode(password);
	}

	private String generateUserId() {
		return RandomStringUtils.randomNumeric(10);
	}

}
