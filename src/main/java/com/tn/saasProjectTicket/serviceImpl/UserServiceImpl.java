package com.tn.saasProjectTicket.serviceImpl;


import java.util.Date;
import java.util.Random;
import java.util.stream.Collectors;

import javax.naming.AuthenticationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
import com.tn.saasProjectTicket.services.UserPrinciple;

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
			System.out.println("++++++++++++++++++++++++++++++++++++++++++ "+encoder.encode(utilisateur.getPassword()));
			Admin admin = new Admin();
			admin.setEmail(utilisateur.getEmail());
			admin.setUsername(utilisateur.getUsername());
			admin.setPassword(encoder.encode(utilisateur.getPassword()));
			admin.setRole(utilisateur.getRole());
			admin.setBirthDate(utilisateur.getBirthDate());
			admin.setFirstName(utilisateur.getFirstName());
			admin.setLastName(utilisateur.getLastName());
			admin.setCreationDate(new Date());
			admin.setUpdateDate(new Date());
			admin.setIsActif(true);
			mailTicketServiceImpl.sendMAil(
					utilisateur.getEmail(), "Creation account", "title for test", "message for test");
			adminRepository.save(admin);
			break;
		case "CLIENT":
			Client client = new Client();
			client.setEmail(utilisateur.getEmail());
			client.setUsername(utilisateur.getUsername());
			String generatedPassword = generateSecurePassword();
			
			client.setPassword(encoder.encode(generatedPassword));
			client.setRole(utilisateur.getRole());
			client.setBirthDate(utilisateur.getBirthDate());
			client.setFirstName(utilisateur.getFirstName());
			client.setLastName(utilisateur.getLastName());
			client.setCreationDate(new Date());
			client.setUpdateDate(new Date());
			client.setIsActif(true);
			
			//envoi de l'email
			String emailContent = "Votre identifiant est : " + utilisateur.getUsername() + 
                    "<br>Votre mot de passe est : " + generatedPassword;
			 mailTicketServiceImpl.sendMAil(
					 utilisateur.getEmail(), "Création de compte", "Bienvenue chez Nous", emailContent);
			clientRepository.save(client);
			break;
		/*case "SUPERVISEUR":
			Superviseur superviseur = new Superviseur();
			superviseur.setEmail(utilisateur.getEmail());
			superviseur.setUsername(utilisateur.getUsername());
			superviseur.setPassword(encoder.encode(utilisateur.getPassword()));
			superviseur.setRole(utilisateur.getRole());
			superviseur.setBirthDate(utilisateur.getBirthDate());
			superviseur.setFirstName(utilisateur.getFirstName());
			superviseur.setLastName(utilisateur.getLastName());
			superviseur.setCreationDate(new Date());
			superviseur.setUpdateDate(new Date());
			superviseur.setIsActif(true);
			mailTicketServiceImpl.sendMAil(
					utilisateur.getEmail(), "Creation account", "title for test", "message for test");
			superviseurRepository.save(superviseur); */
		case "MANAGER":
			Manager manager = new Manager();
			manager.setEmail(utilisateur.getEmail());
			manager.setUsername(utilisateur.getUsername());
			manager.setPassword(encoder.encode(utilisateur.getPassword()));
			manager.setRole(utilisateur.getRole());
			manager.setBirthDate(utilisateur.getBirthDate());
			manager.setFirstName(utilisateur.getFirstName());
			manager.setLastName(utilisateur.getLastName());
			manager.setCreationDate(new Date());
			manager.setUpdateDate(new Date());
			manager.setIsActif(true);
			mailTicketServiceImpl.sendMAil(
					utilisateur.getEmail(), "Creation account", "title for test", "message for test");
			managerRepository.save(manager);
			break;
		case "RESSOURCE":
			Ressource ressource = new Ressource();
			ressource.setEmail(utilisateur.getEmail());
			ressource.setUsername(utilisateur.getUsername());
			ressource.setPassword(encoder.encode(utilisateur.getPassword()));
			ressource.setRole(utilisateur.getRole());
			ressource.setBirthDate(utilisateur.getBirthDate());
			ressource.setFirstName(utilisateur.getFirstName());
			ressource.setLastName(utilisateur.getLastName());
			ressource.setCreationDate(new Date());
			ressource.setUpdateDate(new Date());
			ressource.setIsActif(true);
			mailTicketServiceImpl.sendMAil(
					utilisateur.getEmail(), "Creation account", "title for test", "message for test");
			ressourceRepository.save(ressource);
			break;
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
	public ResponseEntity<AuthResponse> authenticateUser(UserPrinciple userPrinciple) {
		try {
			
		Authentication authentication = authenticationManager.authenticate(
		    new UsernamePasswordAuthenticationToken(userPrinciple.getUsername(), userPrinciple.getPassword())
		);
		SecurityContextHolder.getContext().setAuthentication(authentication);

		UserDetails userDetails = userDetailsService.loadUserByUsername(userPrinciple.getUsername());
		Utilisateur utilisateur = userRepository.findByUsername(userPrinciple.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("Utilisateur non trouvé"));
		if(!utilisateur.isActif()) {
			return ResponseEntity.ok(new AuthResponse(HttpStatus.FORBIDDEN.value(), "Utilisateur non connecté"));
		}
		TokenObject tokenObject = new TokenObject();
		tokenObject.setUsername(userDetails.getUsername());
		tokenObject.setUserId(utilisateur.getUserId());
     
		String role = userDetails.getAuthorities().isEmpty() ? null :
		              userDetails.getAuthorities().iterator().next().getAuthority();
		tokenObject.setRole(role);

		String token = jwtProvider.generateJwtToken(tokenObject);

		return ResponseEntity.ok(new AuthResponse(HttpStatus.OK.value(), token));
	} catch (BadCredentialsException e) {
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
				.body(new AuthResponse(HttpStatus.UNAUTHORIZED.value(), "Nom d'utilisateur ou mot de passe incorrect"));
	} catch (Exception e) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(new AuthResponse(HttpStatus.UNAUTHORIZED.value(), "Erreur d'authentification "+e.getMessage()));
     }
	}
	
	public String generateSecurePassword() {
	    int length = 10; // Longueur du mot de passe
	    String symbol = "&#@/%=+";
	    String capLetter = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	    String smallLetter = "abcdefghijklmnopqrstuvwxyz";
	    String numbers = "0123456789";

	    String finalString = capLetter + smallLetter + numbers + symbol;

	    Random random = new Random();
	    char[] password = new char[length];

	    for (int i = 0; i < length; i++) {
	        password[i] = finalString.charAt(random.nextInt(finalString.length()));
	    }
	    return new String(password);
	}
	
	
	
	
	

}
