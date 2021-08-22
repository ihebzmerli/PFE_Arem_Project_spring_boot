package com.loizenai.jwtauthentication.controller;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.sql.Timestamp;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
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
import com.loizenai.jwtauthentication.message.request.RequestPasswordForm;
import com.loizenai.jwtauthentication.message.request.SignUpForm;
import com.loizenai.jwtauthentication.message.request.SignUpForm.TypeConge;
import com.loizenai.jwtauthentication.message.request.SignUpForm.TypeContrat;
import com.loizenai.jwtauthentication.message.response.JwtResponse;
import com.loizenai.jwtauthentication.message.response.ResponseMessage;
import com.loizenai.jwtauthentication.model.Role;
import com.loizenai.jwtauthentication.model.RoleName;
import com.loizenai.jwtauthentication.model.User;
import com.loizenai.jwtauthentication.repository.RoleRepository;
import com.loizenai.jwtauthentication.repository.UserRepository;
import com.loizenai.jwtauthentication.security.jwt.JwtProvider;
import com.loizenai.jwtauthentication.security.MailConfig;
import com.loizenai.jwtauthentication.services.UserService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthRestAPIs {
 
	@Autowired
    private UserService service;
	
    @Autowired
    public MailConfig emailSender;
	
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

		if(userRepository.getUserNameForAuthorisation(loginRequest.getUsername()).getAuthorisation()==User.Authorisation.Allow){
			SecurityContextHolder.getContext().setAuthentication(authentication);

			String jwt = jwtProvider.generateJwtToken(authentication);
			UserDetails userDetails = (UserDetails) authentication.getPrincipal();

			return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getUsername(), userDetails.getAuthorities()));
		}else{
			return new ResponseEntity<>(new ResponseMessage("Fail -> Pour des raisons de protection des service et de sécurité, vous étes bloqués, pour prendre l\'authorisation vous pouvez demande au centre informatique de centre AREM GROUP!\n\n "+"ExampleMail@gamil.com"),
			HttpStatus.BAD_REQUEST);
		}
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
				case "livreur":
				Role livreur = roleRepository.findByName(RoleName.ROLE_LIVREUR)
						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
				roles.add(livreur);

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
		/**test */
		user.setShowPassword(signUpRequest.getPassword());
		user.setDateDeNaissance(signUpRequest.getDateDeNaissance());
		user.setCin(signUpRequest.getCin());
		user.setAddress(signUpRequest.getAddress());
		user.setCps(signUpRequest.getCps());
		user.setTelephone(signUpRequest.getTelephone());
		user.setPseudo(signUpRequest.getPseudo());
		user.setDateRec(signUpRequest.getDateRec());
		if(signUpRequest.getTypeContrat().toString().equals("CDI")){
			user.setTypeContrat(User.TypeContrat.CDI);
		}else if(signUpRequest.getTypeContrat().toString().equals("CDD")){
			user.setTypeContrat(User.TypeContrat.CDD);
		}else if(signUpRequest.getTypeContrat().toString().equals("CTT")){
			user.setTypeContrat(User.TypeContrat.CTT);
		}else if(signUpRequest.getTypeContrat().toString().equals("C_en_Alternance")){
			user.setTypeContrat(User.TypeContrat.C_en_Alternance);
		}else{
			user.setTypeContrat(User.TypeContrat.indefini);
		}
		
		user.setDateContrat(signUpRequest.getDateContrat());
		user.setFamille(signUpRequest.getFamille());
		user.setSalaire(signUpRequest.getSalaire());
		user.setPrimeDeRendement(signUpRequest.getPrimeDeRendement());
		user.setHeuresDeTravail(signUpRequest.getHeuresDeTravail());
		user.setVenteParHeure(signUpRequest.getVenteParHeure());
		user.setObjectifParJour(signUpRequest.getObjectifParJour());
		user.setObjectifParMois(signUpRequest.getObjectifParMois());
		user.setDateDebutConge(signUpRequest.getDateDebutConge());
		user.setDateFinConge(signUpRequest.getDateFinConge());

		if(signUpRequest.getTypeConge().toString().equals("maternite")){
			user.setTypeConge(User.TypeConge.maternite);
		}else if(signUpRequest.getTypeConge().toString().equals("maladie")){
			user.setTypeConge(User.TypeConge.maladie);
		}else if(signUpRequest.getTypeConge().toString().equals("reduire")){
			user.setTypeConge(User.TypeConge.reduire);
		}else if(signUpRequest.getTypeConge().toString().equals("sans_solde")){
			user.setTypeConge(User.TypeConge.sans_solde);
		}else if(signUpRequest.getTypeConge().toString().equals("deces")){
			user.setTypeConge(User.TypeConge.deces);
		}else if(signUpRequest.getTypeConge().toString().equals("annuel")){
			user.setTypeConge(User.TypeConge.annuel);
		}else{
			user.setTypeConge(User.TypeConge.indefini);
		}
		user.setPrimeDev(signUpRequest.getPrimeDev());
		user.setPrimeGlobal(signUpRequest.getPrimeGlobal());
		user.setPrimeParClient(signUpRequest.getPrimeParClient());
		user.setPrimeStock(signUpRequest.getPrimeStock());
		user.setPostV(signUpRequest.getPostV());
		user.setCodUser(signUpRequest.getCodUser());
		user.setRaison(signUpRequest.getRaison());
		user.setRc(signUpRequest.getRc());
		user.setRespon1(signUpRequest.getRespon1());
		user.setFonction1(signUpRequest.getFonction1());
		user.setFaxs(signUpRequest.getFaxs());
		user.setAdrSiege(signUpRequest.getAdrSiege());
		user.setRuel(signUpRequest.getRuel());
		user.setNumRuel(signUpRequest.getNumRuel());
		user.setCpl(signUpRequest.getCpl());
		user.setVillel(signUpRequest.getVillel());
		user.setRegionl(signUpRequest.getRegionl());
		user.setTell(signUpRequest.getTell());
		user.setFaxl(signUpRequest.getFaxl());
		user.setAdrLiv(signUpRequest.getAdrLiv());
		user.setRegion(signUpRequest.getRegion());
		user.setTaxe(signUpRequest.getTaxe());
		user.setCcb1(signUpRequest.getCcb1());
		user.setBank1(signUpRequest.getBank1());
		user.setAgence1(signUpRequest.getAgence1());
		user.setGaranties(signUpRequest.getGaranties());
		user.setCodGrp(signUpRequest.getCodGrp());
		user.setModReg(signUpRequest.getModReg());
		user.setDomBan(signUpRequest.getDomBan());
		user.setEcheance(signUpRequest.getEcheance());
		user.setCrMax(signUpRequest.getCrMax());
		user.setDerMvt(signUpRequest.getDerMvt());
		user.setCredit(signUpRequest.getCredit());
		user.setPreVen(signUpRequest.getPreVen());
		user.setCumulAch(signUpRequest.getCumulAch());
		user.setChifAff1(signUpRequest.getChifAff1());
		user.setChifAff2(signUpRequest.getChifAff2());
		user.setChifAff3(signUpRequest.getChifAff3());
		user.setTauxRem(signUpRequest.getTauxRem());
		user.setTauxCom(signUpRequest.getTauxCom());
		user.setReste(signUpRequest.getReste());
		user.setTauxRes(signUpRequest.getTauxRes());
		user.setValRes(signUpRequest.getValRes());
		user.setPatron(signUpRequest.getPatron());
		user.setRang(signUpRequest.getRang());
		user.setImpaye(signUpRequest.getImpaye());
		user.setChqImpaye(signUpRequest.getChqImpaye());
		user.setEfPort(signUpRequest.getEfPort());
		user.setEfBanque(signUpRequest.getEfBanque());
		user.setEfNrecu(signUpRequest.getEfNrecu());
		user.setAvCom(signUpRequest.getAvCom());
		user.setCaution(signUpRequest.getCaution());
		user.setBenefice(signUpRequest.getBenefice());
		user.setTauxBene(signUpRequest.getTauxBene());
		user.setRecFff(signUpRequest.getRecFff());
		user.setTva(signUpRequest.getTva());
		user.setCle(signUpRequest.getCle());
		user.setSoldDep(signUpRequest.getSoldDep());
		user.setInteret(signUpRequest.getInteret());
		user.setRegChq(signUpRequest.getRegChq());
		user.setRegEff(signUpRequest.getRegEff());
		user.setRegEsp(signUpRequest.getRegEsp());
		user.setFacInst(signUpRequest.getFacInst());
		user.setAvoir(signUpRequest.getAvoir());
		user.setEffInst(signUpRequest.getEffInst());
		user.setSoldeBq(signUpRequest.getSoldeBq());
		user.setCreance(signUpRequest.getCreance());
		user.setEffEnc(signUpRequest.getEffEnc());
		user.setEffEsc(signUpRequest.getEffEsc());
		user.setComission(signUpRequest.getComission());
		user.setBloc(signUpRequest.getBloc());
		user.setCodeTva(signUpRequest.getCodeTva());
		user.setRemOrg(signUpRequest.getRemOrg());
		user.setAvance(signUpRequest.getAvance());
		user.setChqPf(signUpRequest.getChqPf());
		user.setRetenue(signUpRequest.getRetenue());
		user.setRegVir(signUpRequest.getRegVir());
		user.setAvN1(signUpRequest.getAvN1());
		user.setClasse(signUpRequest.getClasse());
		user.setRistourne(signUpRequest.getRistourne());
		user.setCaPrev(signUpRequest.getCaPrev());
		user.setSoldeCpf(signUpRequest.getSoldeCpf());
		user.setSoldeImp(signUpRequest.getSoldeImp());
		user.setSoldeEpf(signUpRequest.getSoldeEpf());
		user.setDatFFac(signUpRequest.getDatFFac());
		user.setDatGFac(signUpRequest.getDatGFac());
		user.setCaMens(signUpRequest.getCaMens());
		user.setCrImax(signUpRequest.getCrImax());
		user.setZone(signUpRequest.getZone());
		user.setFcreN1(signUpRequest.getFcreN1());
		user.setFcreN2(signUpRequest.getFcreN2());
		user.setFreglN1(signUpRequest.getFreglN1());
		user.setFreglN2(signUpRequest.getFreglN2());
		user.setFescN1(signUpRequest.getFescN1());
		user.setFescN2(signUpRequest.getFescN2());
		user.setFbkN1(signUpRequest.getFbkN1());
		user.setFbkN2(signUpRequest.getFbkN2());
		user.setFefpN1(signUpRequest.getFefpN1());
		user.setFefpN2(signUpRequest.getFefpN2());
		user.setFchpN1(signUpRequest.getFchpN1());
		user.setFchpN2(signUpRequest.getFchpN2());
		user.setFefnrN1(signUpRequest.getFefnrN1());
		user.setFefnrN2(signUpRequest.getFefnrN2());
		user.setIcreN1(signUpRequest.getIcreN1());
		user.setIcreN2(signUpRequest.getIcreN2());
		user.setIreglN1(signUpRequest.getIreglN1());
		user.setIreglN2(signUpRequest.getIreglN2());
		user.setIescN1(signUpRequest.getIescN1());
		user.setIescN2(signUpRequest.getIescN2());
		user.setIbkN1(signUpRequest.getIbkN1());
		user.setIbkN2(signUpRequest.getIbkN2());
		user.setIefpN1(signUpRequest.getIefpN1());
		user.setIefpN2(signUpRequest.getIefpN2());
		user.setIchpN1(signUpRequest.getIchpN1());
		user.setIchpN2(signUpRequest.getIchpN2());
		user.setIefnrN1(signUpRequest.getIefnrN1());
		user.setIefnrN2(signUpRequest.getIefnrN2());
		user.setDatOuvr(signUpRequest.getDatOuvr());
		user.setCommand(signUpRequest.getCommand());
		user.setRemExp(signUpRequest.getRemExp());
		user.setChefMag(signUpRequest.getChefMag());
		user.setJourVisit(signUpRequest.getJourVisit());
		user.setInstance(signUpRequest.getInstance());
		user.setComptant(signUpRequest.getComptant());
		user.setBl(signUpRequest.getBl());
		user.setNatLiv(signUpRequest.getNatLiv());
		user.setMois1(signUpRequest.getMois1());
		user.setMois2(signUpRequest.getMois2());
		user.setMois3(signUpRequest.getMois3());
		user.setMois4(signUpRequest.getMois4());
		user.setMois5(signUpRequest.getMois5());
		user.setMois6(signUpRequest.getMois6());
		user.setMois7(signUpRequest.getMois7());
		user.setMois8(signUpRequest.getMois8());
		user.setMois9(signUpRequest.getMois9());
		user.setMois10(signUpRequest.getMois10());
		user.setMois11(signUpRequest.getMois11());
		user.setMois12(signUpRequest.getMois12());
		user.setMois1(signUpRequest.getMois1());
		user.setDatDerLi(signUpRequest.getDatDerLi());
		user.setMargePour(signUpRequest.getMargePour());
		user.setMargeVal(signUpRequest.getMargeVal());
		user.setCredblEnc(signUpRequest.getCredblEnc());
		user.setCredinstec(signUpRequest.getCredinstec());
		user.setObservatio(signUpRequest.getObservatio());
		user.setObserv(signUpRequest.getObserv());
		user.setGouv1(signUpRequest.getGouv1());
		user.setGouv2(signUpRequest.getGouv2());
		user.setNatcaution(signUpRequest.getNatcaution());
		user.setCheque(signUpRequest.getCheque());
		user.setEspece(signUpRequest.getEspece());
		user.setTraite(signUpRequest.getTraite());
		user.setCrRef(signUpRequest.getCrRef());
		user.setSoldTerm(signUpRequest.getSoldTerm());
		user.setChqImp(signUpRequest.getChqImp());
		user.setCriRef(signUpRequest.getCriRef());
		user.setRemFam(signUpRequest.getRemFam());
		user.setReglement(signUpRequest.getReglement());
		user.setDelai(signUpRequest.getDelai());
		user.setNbTranche(signUpRequest.getNbTranche());
		user.setCodSteq(signUpRequest.getCodSteq());
		user.setReference(signUpRequest.getReference());
		user.setSansRet(signUpRequest.getSansRet());
		user.setCliGroup(signUpRequest.getCliGroup());
		user.setTauxMarge(signUpRequest.getTauxMarge());
		user.setAuthorisation(User.Authorisation.Allow);
		user.setDateLastForgot(null);
		/**test end */
		userRepository.save(user);

		return new ResponseEntity<>(new ResponseMessage("User "+ signUpRequest.getFirstname() + " is registered successfully!"), HttpStatus.OK);
	}


	@ResponseBody
	@PostMapping("/requestpassword")
	public ResponseEntity<?> requestpasswordUser(@Valid @RequestBody RequestPasswordForm requestpasswordRequest) throws InterruptedException{

		if (userRepository.existsByEmail(requestpasswordRequest.getEmail())) {
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			timestamp=new Timestamp(timestamp.getTime()+ (1000 * 60 * 60 * 1));
			System.out.println("let me see1: " +TimeUnit.MILLISECONDS.toMinutes(timestamp.getTime()));
			if(userRepository.getRequestPassword(requestpasswordRequest.getEmail()).getDateLastForgot()!=null){
				System.out.println("let me see2: " +userRepository.getRequestPassword(requestpasswordRequest.getEmail()).getDateLastForgot().getTime());
			}
			System.out.println("let me see3: " + userRepository.getRequestPassword(requestpasswordRequest.getEmail()).getAuthorisation()+"la resultat"+User.Authorisation.Allow);
			
			if(userRepository.getRequestPassword(requestpasswordRequest.getEmail()).getAuthorisation()==User.Authorisation.Allow){
				if(userRepository.getRequestPassword(requestpasswordRequest.getEmail()).getDateLastForgot()==null || TimeUnit.MILLISECONDS.toMinutes(timestamp.getTime())-TimeUnit.MILLISECONDS.toMinutes(userRepository.getRequestPassword(requestpasswordRequest.getEmail()).getDateLastForgot().getTime()) > 10){
						// Create a Simple MailMessage.
						Optional<User> userData = userRepository.findById(userRepository.getRequestPassword(requestpasswordRequest.getEmail()).getId());
						if (userData.isPresent()) {
							User _user = userData.get();
							_user.setDateLastForgot(timestamp);
							service.updateUser(_user);
							SimpleMailMessage message = new SimpleMailMessage();
			
							message.setTo(requestpasswordRequest.getEmail());
							
		
							message.setSubject("Mot de passe oublié");
							message.setText("nous vous avons envoyé cet e-mail en réponse à votre demande d'obtention de votre mot de passe sur le serveur d\'AREAM GROUP.\n"+
							"Votre mot de passe est:\n\n"+userRepository.getRequestPassword(requestpasswordRequest.getEmail()).getShowPassword()+".\n\n"+
							"Nous vous recommandons de garder votre mot de passe en sécurité et de ne le partager avec personne."+" si vous pensez que votre mot de passe a été compromis, vous pouvez le changer en vous rendant sur votre profil sur le serveur d\'AREM GROUP et essayer de le changer à partir de là.\n"+
							"Si vous avez besoin d\'aide, ou si vous avez d\'autres questions, n\'hésitez pas à envoyer un mail au centre Informatique de l\'association ExampleMail@gamil.com, ou à les appeler \n au numéro 216-53853155 .\n\n"+"Pas besoin de répondre à ce mail");
					
							// Send Message!
							this.emailSender.getJavaMailSender().send(message);
							return new ResponseEntity<>(new ResponseMessage("password sended to the adresse "+ requestpasswordRequest.getEmail() + " was successful!"), HttpStatus.OK);	

						} else {
							return new ResponseEntity<>(HttpStatus.CHECKPOINT);
						}
		
					}else{
						return new ResponseEntity<>(new ResponseMessage("Fail -> Pour des raisons de protection des service et de sécurité, vous étes bloqués, vous pouvez réessayer après 10 minutes!"),
						HttpStatus.TOO_MANY_REQUESTS);
					}
				}else{
					return new ResponseEntity<>(new ResponseMessage("Fail -> Pour des raisons de protection des service et de sécurité, vous étes bloqués, pour prendre l\'authorisation vous pouvez demande au centre informatique de centre AREM GROUP!\n\n "+"ExampleMail@gamil.com"),
					HttpStatus.BAD_REQUEST);
				}
		}else{
			return new ResponseEntity<>(new ResponseMessage("Fail -> Email wrong!"),
			HttpStatus.NOT_FOUND);
		}
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