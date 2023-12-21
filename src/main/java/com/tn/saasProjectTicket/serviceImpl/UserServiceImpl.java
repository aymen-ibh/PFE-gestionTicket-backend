package com.tn.saasProjectTicket.serviceImpl;


import java.util.stream.Collectors;

import javax.naming.AuthenticationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.tn.saasProjectTicket.entity.Admin;
import com.tn.saasProjectTicket.entity.AuthResponse;
import com.tn.saasProjectTicket.entity.Client;
import com.tn.saasProjectTicket.entity.Manager;
import com.tn.saasProjectTicket.entity.Ressource;
import com.tn.saasProjectTicket.entity.Superviseur;
import com.tn.saasProjectTicket.entity.TokenObject;
import com.tn.saasProjectTicket.entity.Utilisateur;
import com.tn.saasProjectTicket.exception.domain.EmailAlreadyExistException;
import com.tn.saasProjectTicket.exception.domain.UserAlreadyExistException;
import com.tn.saasProjectTicket.jwt.JwtProvider;
import com.tn.saasProjectTicket.repository.AdminRepository;
import com.tn.saasProjectTicket.repository.ClientRepository;
import com.tn.saasProjectTicket.repository.ManagerRepository;
import com.tn.saasProjectTicket.repository.RessourceRepository;
import com.tn.saasProjectTicket.repository.SuperviseurRepository;
import com.tn.saasProjectTicket.repository.UserRepository;
import com.tn.saasProjectTicket.service.UserService;
import com.tn.saasProjectTicket.services.UserDetailsServiceImpl;

@Service
public class UserServiceImpl implements UserService {
	private Logger LOGGER = LoggerFactory.getLogger(getClass());
	@Autowired
	private UserRepository userRepository;

	@Autowired
	PasswordEncoder encoder;
	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private SuperviseurRepository superviseurRepository;
	@Autowired
	private ManagerRepository managerRepository;
	@Autowired
	private RessourceRepository ressourceRepository;
	@Autowired
	private MailTicketServiceImpl mailTicketServiceImpl;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserDetailsServiceImpl userDetailsService;

	@Autowired
	private JwtProvider jwtProvider;
	
	
	@Override
	public Utilisateur registerUser(Utilisateur utilisateur) {
		if (userRepository.findByUsername(utilisateur.getUsername()).isPresent()) {
            throw new UserAlreadyExistException("Nom d'utilisateur déjà pris");
        }
        if (userRepository.findByEmail(utilisateur.getEmail()).isPresent()) {
            throw new EmailAlreadyExistException("Email déjà utilisé");
        }
        switch (utilisateur.getRole()) {
		case "ADMIN":
			Admin admin = new Admin();
			admin.setEmail(utilisateur.getEmail());
			admin.setUsername(utilisateur.getUsername());
			admin.setPassword(encoder.encode(utilisateur.getPassword()));
			mailTicketServiceImpl.sendMAil(
					utilisateur.getEmail(), "Creation account", "title for test", "message for test");
			adminRepository.save(admin);
			break;
		case "CLIENT":
			Client client = new Client();
			client.setEmail(utilisateur.getEmail());
			client.setUsername(utilisateur.getUsername());
			client.setPassword(encoder.encode(utilisateur.getPassword()));
			mailTicketServiceImpl.sendMAil(
					utilisateur.getEmail(), "Creation account", "title for test", "message for test");
			clientRepository.save(client);
			break;
		case "SUPERVISEUR":
			Superviseur superviseur = new Superviseur();
			superviseur.setEmail(utilisateur.getEmail());
			superviseur.setUsername(utilisateur.getUsername());
			superviseur.setPassword(encoder.encode(utilisateur.getPassword()));
			mailTicketServiceImpl.sendMAil(
					utilisateur.getEmail(), "Creation account", "title for test", "message for test");
			superviseurRepository.save(superviseur);
		case "MANAGER":
			Manager manager = new Manager();
			manager.setEmail(utilisateur.getEmail());
			manager.setUsername(utilisateur.getUsername());
			manager.setPassword(encoder.encode(utilisateur.getPassword()));
			mailTicketServiceImpl.sendMAil(
					utilisateur.getEmail(), "Creation account", "title for test", "message for test");
			managerRepository.save(manager);
		case "RESSOURCE":
			Ressource ressource = new Ressource();
			ressource.setEmail(utilisateur.getEmail());
			ressource.setUsername(utilisateur.getUsername());
			ressource.setPassword(encoder.encode(utilisateur.getPassword()));
			mailTicketServiceImpl.sendMAil(
					utilisateur.getEmail(), "Creation account", "title for test", "message for test");
			ressourceRepository.save(ressource);
		default:
			throw new IllegalArgumentException("Rôle non reconnu : " + utilisateur.getRole());
		}
		/*user.setUserId(Integer.parseInt(generateUserId()));
		user.setPassword(encodePassword(password));
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setUsername(username);
		user.setEmail(email);
		user.setBirthDate(birthDate);
		user.setCreationDate(new Date());*/
		//userRepository.save(user);
		return utilisateur;
	}


	@Override
	public ResponseEntity<AuthResponse> authenticateUser(String username, String password) throws
	       AuthenticationException {
		
		Authentication authentication = authenticationManager.authenticate(
		    new UsernamePasswordAuthenticationToken(username, password)
		);
		SecurityContextHolder.getContext().setAuthentication(authentication);

		UserDetails userDetails = userDetailsService.loadUserByUsername(username);
		TokenObject tokenObject = new TokenObject();
		tokenObject.setUsername(userDetails.getUsername());

     
		String role = userDetails.getAuthorities().isEmpty() ? null :
		              userDetails.getAuthorities().iterator().next().getAuthority();
		tokenObject.setRole(role);

		String token = jwtProvider.generateJwtToken(tokenObject);

		return ResponseEntity.ok(new AuthResponse(HttpStatus.OK.value(), token));
	}
	
	
	
	
	
	

}
