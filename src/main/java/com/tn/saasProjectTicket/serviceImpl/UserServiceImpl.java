package com.tn.saasProjectTicket.serviceImpl;


import java.time.LocalDateTime;
import java.util.Date;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
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
import com.tn.saasProjectTicket.entity.PasswordChangeDTO;
import com.tn.saasProjectTicket.entity.PasswordResetToken;
import com.tn.saasProjectTicket.entity.Ressource;
import com.tn.saasProjectTicket.entity.Societe;
import com.tn.saasProjectTicket.entity.Superviseur;
import com.tn.saasProjectTicket.entity.TokenObject;
import com.tn.saasProjectTicket.entity.Utilisateur;
import com.tn.saasProjectTicket.entity.UtilisateurRegisterDTO;
import com.tn.saasProjectTicket.exception.RessourceNotFoundException;
import com.tn.saasProjectTicket.exception.domain.EmailAlreadyExistException;
import com.tn.saasProjectTicket.exception.domain.UserAlreadyExistException;
import com.tn.saasProjectTicket.jwt.JwtProvider;
import com.tn.saasProjectTicket.repository.AdminRepository;
import com.tn.saasProjectTicket.repository.ClientRepository;
import com.tn.saasProjectTicket.repository.EmployeRepository;
import com.tn.saasProjectTicket.repository.ManagerRepository;
import com.tn.saasProjectTicket.repository.RessourceRepository;
import com.tn.saasProjectTicket.repository.SocieteRepository;
import com.tn.saasProjectTicket.repository.SuperviseurRepository;
import com.tn.saasProjectTicket.repository.UserRepository;
import com.tn.saasProjectTicket.service.UserService;
import com.tn.saasProjectTicket.services.UserDetailsServiceImpl;
import com.tn.saasProjectTicket.services.UserPrinciple;

@Service
public class UserServiceImpl implements UserService {
	private Logger LOGGER = LoggerFactory.getLogger(getClass());
	private Map<String, PasswordResetToken> tokenStore = new ConcurrentHashMap<>();
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
	private EmployeRepository employeRepository;
	@Autowired
	private ManagerRepository managerRepository;
	@Autowired
	private RessourceRepository ressourceRepository;
	@Autowired
	private SocieteRepository societeRepository;
	@Autowired
	private MailTicketServiceImpl mailTicketServiceImpl;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserDetailsServiceImpl userDetailsService;

	@Autowired
	private JwtProvider jwtProvider;
	
	
	@Override
	public UtilisateurRegisterDTO registerUser(UtilisateurRegisterDTO utilisateur) {
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
			admin.setActif(true);
			admin.setPhoto(utilisateur.getPhoto());
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
			client.setActif(true);
			client.setPhoto(utilisateur.getPhoto());
			if (utilisateur.getSociete() != null) {
			    Societe societe = societeRepository.findById(utilisateur.getSociete().getIdSociete()).orElseThrow(/* exception */);
			    client.setSociete(societe);
			}
			
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
			String generatedMPassword = generateSecurePassword();
			manager.setPassword(encoder.encode(generatedMPassword));
			manager.setRole(utilisateur.getRole());
			manager.setBirthDate(utilisateur.getBirthDate());
			manager.setFirstName(utilisateur.getFirstName());
			manager.setLastName(utilisateur.getLastName());
			manager.setCreationDate(new Date());
			manager.setUpdateDate(new Date());
			manager.setActif(true);
			manager.setPhoto(utilisateur.getPhoto());
			manager.setSociete(utilisateur.getSociete());
			//envoi de l'email
			String emailMContent = "Votre identifiant est : " + utilisateur.getUsername() + 
                    "<br>Votre mot de passe est : " + generatedMPassword;
			 mailTicketServiceImpl.sendMAil(
					 utilisateur.getEmail(), "Création de compte", "Bienvenue chez Nous", emailMContent);
			managerRepository.save(manager);
			break;
		case "RESSOURCE":
			Ressource ressource = new Ressource();
			ressource.setEmail(utilisateur.getEmail());
			ressource.setUsername(utilisateur.getUsername());
			String generatedRPassword = generateSecurePassword();
			ressource.setPassword(encoder.encode(generatedRPassword));
			ressource.setRole(utilisateur.getRole());
			ressource.setBirthDate(utilisateur.getBirthDate());
			ressource.setFirstName(utilisateur.getFirstName());
			ressource.setLastName(utilisateur.getLastName());
			ressource.setCreationDate(new Date());
			ressource.setUpdateDate(new Date());
			ressource.setActif(true);
			ressource.setPhoto(utilisateur.getPhoto());
			ressource.setSociete(utilisateur.getSociete());
			//envoi de l'email
			String emailRContent = "Votre identifiant est : " + utilisateur.getUsername() + 
                    "<br>Votre mot de passe est : " + generatedRPassword;
			 mailTicketServiceImpl.sendMAil(
					 utilisateur.getEmail(), "Création de compte", "Bienvenue chez Nous", emailRContent);
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
		if(utilisateur.getRole().equals("CLIENT"))
			tokenObject.setIdEntreprise(clientRepository.findById(utilisateur.getUserId()).get().getSociete().getIdSociete());
		if(utilisateur.getRole().equals("SUPERVISEUR"))
			tokenObject.setIdEntreprise(superviseurRepository.findById(utilisateur.getUserId()).get().getSociete().getIdSociete());
		if(utilisateur.getRole().equals("MANAGER"))
			tokenObject.setIdEntreprise(managerRepository.findById(utilisateur.getUserId()).get().getSociete().getIdSociete());
		if(utilisateur.getRole().equals("RESSOURCE"))
			tokenObject.setIdEntreprise(ressourceRepository.findById(utilisateur.getUserId()).get().getSociete().getIdSociete());
     
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
	
	@Override
	public void createResetToken(String email) {
		String token = UUID.randomUUID().toString();
        LocalDateTime expiryDate = LocalDateTime.now().plusHours(24);
        tokenStore.put(token, new PasswordResetToken(token, email, expiryDate));

        sendResetTokenEmail(email, token);
	}
	
	private void sendResetTokenEmail(String email, String token) {
		String resetLink = "http://localhost:4200/password-change?token=" + token;
		mailTicketServiceImpl.sendMAil(email, "Réinitialisation de votre mot de passe",
				"\"Pour réinitialiser votre mot de passe, veuillez cliquer sur le lien suivant : ", resetLink);
	}

	@Override
	public void resetPassword(String token, String newPassword) {
		if (!tokenStore.containsKey(token)) {
			throw new IllegalArgumentException("Token invalide ou expiré");
		}
		
		PasswordResetToken resetToken = tokenStore.get(token);
		if(resetToken.getExpiryDate().isBefore(LocalDateTime.now())) {
			throw new IllegalArgumentException("Token expiré");
		}
		
		Utilisateur utilisateur = this.userRepository.findByEmail(resetToken.getUserEmail()).orElseThrow(
				() -> new UsernameNotFoundException("Utilisateur non trouvé")
				);
		utilisateur.setPassword(encoder.encode(newPassword));
		userRepository.save(utilisateur);
		tokenStore.remove(token);
		
	}
	
	@Override
	public boolean changeUserPassword(Integer userId, PasswordChangeDTO passwordChangeDTO) {
		Utilisateur utilisateur = userRepository.findById(userId).orElseThrow(
				() -> new RessourceNotFoundException("Id", "userId", userId)
				);
		String currentPassword = passwordChangeDTO.getCurrentPassword();
		String newPassword = passwordChangeDTO.getNewPassword();
		
		if(!encoder.matches(currentPassword, utilisateur.getPassword())) {
			throw new BadCredentialsException("Le mot de passe actuel est incorrect!!!");
		}
		
		utilisateur.setPassword(encoder.encode(newPassword));
		userRepository.save(utilisateur);
		return true;
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
	
	@Override
	public String getUserRoleById(Integer userId) {
		Utilisateur user = this.userRepository.findById(userId).get();
		String role = user.getRole();
		return role;
	}
	
	
	
	
	

}
