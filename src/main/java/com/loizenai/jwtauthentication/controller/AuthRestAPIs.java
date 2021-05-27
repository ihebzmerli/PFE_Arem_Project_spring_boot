package com.loizenai.jwtauthentication.controller;

import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loizenai.jwtauthentication.message.request.LoginForm;
import com.loizenai.jwtauthentication.message.request.SignUpForm;
import com.loizenai.jwtauthentication.message.response.JwtResponse;
import com.loizenai.jwtauthentication.message.response.ResponseMessage;
import com.loizenai.jwtauthentication.model.Role;
import com.loizenai.jwtauthentication.model.RoleName;
import com.loizenai.jwtauthentication.model.User;
import com.loizenai.jwtauthentication.repository.RoleRepository;
import com.loizenai.jwtauthentication.repository.UserRepository;
import com.loizenai.jwtauthentication.security.jwt.JwtProvider;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthRestAPIs {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtProvider jwtProvider;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		String jwt = jwtProvider.generateJwtToken(authentication);
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();

		return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getUsername(), userDetails.getAuthorities()));
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpForm signUpRequest) throws InterruptedException{
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return new ResponseEntity<>(new ResponseMessage("Fail -> Username is already taken!"),
					HttpStatus.BAD_REQUEST);
		}

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return new ResponseEntity<>(new ResponseMessage("Fail -> Email is already in use!"),
					HttpStatus.BAD_REQUEST);
		}

		// Creating user's account
		User user = new User(signUpRequest.getFirstname(), signUpRequest.getLastname(), 
								signUpRequest.getUsername(), signUpRequest.getEmail(),
				encoder.encode(signUpRequest.getPassword()));

		Set<Role> roles = new HashSet<>(); 
		if(signUpRequest.getRole() != null) {
			Set<String> strRoles = signUpRequest.getRole();

			strRoles.forEach(role -> {
				switch (role) {
				case "admin":
					Role adminRole = roleRepository.findByName(RoleName.ROLE_ADMIN)
							.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
					roles.add(adminRole);

				break;
				case "acheteur":
					Role acheteurRole = roleRepository.findByName(RoleName.ROLE_ACHETEUR)
							.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
					roles.add(acheteurRole);

					break;
				case "transitaire":
					Role transitaireRole = roleRepository.findByName(RoleName.ROLE_TRANSITAIRE)
							.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
					roles.add(transitaireRole);

				break;
				case "client":
					Role clientRole = roleRepository.findByName(RoleName.ROLE_CLIENT)
							.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
					roles.add(clientRole);

				break;
				case "vendeur":
					Role vendeurRole = roleRepository.findByName(RoleName.ROLE_VENDEUR)
							.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
					roles.add(vendeurRole);

				break;	
				case "decideur_bp":
					Role decideur_bpRole = roleRepository.findByName(RoleName.ROLE_DECIDEUR_BP)
							.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
					roles.add(decideur_bpRole);

				break;
				case "agent_cab":
					Role agent_cabRole = roleRepository.findByName(RoleName.ROLE_AGENT_CAB)
							.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
					roles.add(agent_cabRole);

				break;	
				case "preparateur_br":
					Role preparateur_brRole = roleRepository.findByName(RoleName.ROLE_PREPARATEUR_BR)
							.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
					roles.add(preparateur_brRole);

				break;
				case "responsable_dispatching_bp":
					Role responsable_dispatching_bpRole = roleRepository.findByName(RoleName.ROLE_RESPONSABLE_DISPATCHING_BP)
							.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
					roles.add(responsable_dispatching_bpRole);

				break;	
				case "preparateur":
					Role preparateurRole = roleRepository.findByName(RoleName.ROLE_PREPARATEUR)
							.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
					roles.add(preparateurRole);

				break;
				case "validateur_de_chariot":
					Role validateur_de_chariotRole = roleRepository.findByName(RoleName.ROLE_VALIDATEUR_DE_CHARIOT)
							.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
					roles.add(validateur_de_chariotRole);

				break;	
				case "responsable_pointage":
					Role responsable_pointageRole = roleRepository.findByName(RoleName.ROLE_RESPONSABLE_POINTAGE)
							.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
					roles.add(responsable_pointageRole);

				break;
				case "emballeur":
					Role emballeurRole = roleRepository.findByName(RoleName.ROLE_EMBALLEUR)
							.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
					roles.add(emballeurRole);

				break;
				case "expediteur":
					Role expediteurRole = roleRepository.findByName(RoleName.ROLE_EXPEDITEUR)
							.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
					roles.add(expediteurRole);

				break;
				case "agent_saisie_reg":
					Role agent_saisie_regRole = roleRepository.findByName(RoleName.ROLE_AGENT_SAISIE_REG)
							.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
					roles.add(agent_saisie_regRole);

				break;						
				case "caissier":
					Role caissierRole = roleRepository.findByName(RoleName.ROLE_CAISSIER)
							.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
					roles.add(caissierRole);

				break;
				case "responsable_service_frs_etranger":
					Role responsable_service_frs_etrangerRole = roleRepository.findByName(RoleName.ROLE_RESPONSABLE_SERVICE_FRS_ETRANGER)
							.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
					roles.add(responsable_service_frs_etrangerRole);

				break;
				case "responsable_service_frs_local":
					Role responsable_service_frs_localRole = roleRepository.findByName(RoleName.ROLE_RESPONSABLE_SERVICE_FRS_LOCAL)
							.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
					roles.add(responsable_service_frs_localRole);

				break;
				default:
					Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
							.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
					roles.add(userRole);
				}
			});
		} else {
			// default mode : User register 
			Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
			roles.add(userRole);			
		}
		
		user.setRoles(roles);
		user.setCodUser(RandomTest1());
		userRepository.save(user);

		return new ResponseEntity<>(new ResponseMessage("User "+ signUpRequest.getFirstname() + " is registered successfully!"), HttpStatus.OK);
	}





	        // Simple test which prints random number between min and max number (Number Range Example)
			public long RandomTest1() throws InterruptedException {
				while (true) {
					int min = 1000000;
					int max = 9999999;
		 
					// random() returns a double value with a positive sign, greater than or equal to 0.0 and less than 1.0.
					// Returned values are chosen pseudorandomly with (approximately) uniform distribution from that range.
					long randomNumber = (min + (long) (Math.random() * ((max - min))));
					System.out.println("Crunchify Thread 1 random result: " + randomNumber);
				return randomNumber ;
				}
			}
}