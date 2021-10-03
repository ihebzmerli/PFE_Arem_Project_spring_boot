package com.loizenai.jwtauthentication.controller;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import javax.servlet.ServletContext;
import com.loizenai.jwtauthentication.model.RoleName;
import org.springframework.transaction.annotation.Transactional;
import com.loizenai.jwtauthentication.model.Role;
import com.loizenai.jwtauthentication.model.User;
import com.loizenai.jwtauthentication.repository.UserRepository;
import com.loizenai.jwtauthentication.services.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loizenai.jwtauthentication.repository.RoleRepository;
import java.io.File;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.commons.io.FilenameUtils;
import org.springframework.boot.json.JsonParseException;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class UserController {
    
    @Autowired
    private UserService service;

    @Autowired
    UserRepository userRepository;
	@Autowired
	PasswordEncoder encoder;

	@Autowired
	RoleRepository roleRepository;

    @Autowired
    ServletContext context;
    
    @GetMapping("/utilisateurs")
    public ResponseEntity<List<User>> getAllUtilisateurs() {
      List<User> users = new ArrayList<>();
      try {
        service.getUsers().forEach(users::add);
        
        if (users.isEmpty()) {
          return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(users, HttpStatus.OK);
      } catch (Exception e) {
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
      }
    }

    @GetMapping("/utilisateurs/{id}")
    public ResponseEntity<User> getUtilisateurById(@PathVariable("id") long id) {
      Optional<User> userData = userRepository.findById(id);
   
      if (userData.isPresent()) {
        return new ResponseEntity<>(userData.get(), HttpStatus.OK);
      } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
    }


    @PostMapping(value = "/utilisateurs")
    public ResponseEntity<User> postUtilisateur(@RequestBody User user) {
      try {
        service.addUser(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
      } catch (Exception e) {
        return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
      }
    }


    /**DATE FILTER  */

    @GetMapping(value = "/utilisateurs/datffacBetween/{startDate}to{endDate}")
    public ResponseEntity<List<User>> getAllUserdatffacBydateBetween(@PathVariable String startDate,@PathVariable String endDate) {
        try {
            List<User> BonLivByDateBetween = service.getAllUserdatffacBydateBetween(startDate,endDate);
    
            if (BonLivByDateBetween.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);   /** pour afficher les bon livraison entre 2 date */
            }
            return new ResponseEntity<>(BonLivByDateBetween, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping(value = "/utilisateurs/date_contratBetween/{startDate}to{endDate}")
    public ResponseEntity<List<User>> getAllUserdate_contratBydateBetween(@PathVariable String startDate,@PathVariable String endDate) {
        try {
            List<User> BonLivByDateBetween = service.getAllUserdate_contratBydateBetween(startDate,endDate);
    
            if (BonLivByDateBetween.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);   /** pour afficher les bon livraison entre 2 date */
            }
            return new ResponseEntity<>(BonLivByDateBetween, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping(value = "/utilisateurs/date_de_naissanceBetween/{startDate}to{endDate}")
    public ResponseEntity<List<User>> getAllUserdate_de_naissanceBydateBetween(@PathVariable String startDate,@PathVariable String endDate) {
        try {
            List<User> BonLivByDateBetween = service.getAllUserdate_de_naissanceBydateBetween(startDate,endDate);
    
            if (BonLivByDateBetween.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);   /** pour afficher les bon livraison entre 2 date */
            }
            return new ResponseEntity<>(BonLivByDateBetween, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping(value = "/utilisateurs/date_debut_congeBetween/{startDate}to{endDate}")
    public ResponseEntity<List<User>> getAllUserdate_debut_congeBydateBetween(@PathVariable String startDate,@PathVariable String endDate) {
        try {
            List<User> BonLivByDateBetween = service.getAllUserdate_debut_congeBydateBetween(startDate,endDate);
    
            if (BonLivByDateBetween.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);   /** pour afficher les bon livraison entre 2 date */
            }
            return new ResponseEntity<>(BonLivByDateBetween, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping(value = "/utilisateurs/date_fin_congeBetween/{startDate}to{endDate}")
    public ResponseEntity<List<User>> getAllUserdate_fin_congeBydateBetween(@PathVariable String startDate,@PathVariable String endDate) {
        try {
            List<User> BonLivByDateBetween = service.getAllUserdate_fin_congeBydateBetween(startDate,endDate);
    
            if (BonLivByDateBetween.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);   /** pour afficher les bon livraison entre 2 date */
            }
            return new ResponseEntity<>(BonLivByDateBetween, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping(value = "/utilisateurs/date_recBetween/{startDate}to{endDate}")
    public ResponseEntity<List<User>> getAllUserdate_recBydateBetween(@PathVariable String startDate,@PathVariable String endDate) {
        try {
            List<User> BonLivByDateBetween = service.getAllUserdate_recBydateBetween(startDate,endDate);
    
            if (BonLivByDateBetween.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);   /** pour afficher les bon livraison entre 2 date */
            }
            return new ResponseEntity<>(BonLivByDateBetween, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping(value = "/utilisateurs/der_mvtBetween/{startDate}to{endDate}")
    public ResponseEntity<List<User>> getAllUserder_mvtBydateBetween(@PathVariable String startDate,@PathVariable String endDate) {
        try {
            List<User> BonLivByDateBetween = service.getAllUserder_mvtBydateBetween(startDate,endDate);
    
            if (BonLivByDateBetween.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);   /** pour afficher les bon livraison entre 2 date */
            }
            return new ResponseEntity<>(BonLivByDateBetween, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
        /*****************post User upload image */

@PostMapping(value = "/utilisateursTest")
public ResponseEntity<User> postUtilisateurTest(@RequestParam("file") MultipartFile file,@RequestParam("user") String user)
throws JsonParseException , JsonMappingException , Exception
{
    System.out.println("OK............");
    User use =  new ObjectMapper().readValue(user,User.class);

    boolean isExist = new File(context.getRealPath("/imgUsers/Images/")+use.getCodUser()+"/").exists();
    if(!isExist){
        new File (context.getRealPath("/imgUsers/Images/")+use.getCodUser()+"/").mkdir();
        System.out.println("mk dir............");
    }
    Integer i=0;
    String filename = file.getOriginalFilename();
    String newFileName = FilenameUtils.getBaseName(String.valueOf(use.getCodUser())+'_'+i)+"."+FilenameUtils.getExtension(filename);
    File serverFile = new File (context.getRealPath("/imgUsers/Images/"+use.getCodUser()+"/"+File.separator+newFileName));
    try {
        System.out.println("Image"); 
        org.apache.commons.io.FileUtils.writeByteArrayToFile(serverFile,file.getBytes());
    }catch(Exception e){
        e.printStackTrace();
    }
    use.setFileName(newFileName);
    use.setConnected(0);
    use.setAuthorisation(User.Authorisation.Allow);
    use.setShowPassword(use.getPassword());
    use.setPassword(encoder.encode(use.getPassword()));

    Set<Role> roles = new HashSet<>(); 
    if(use.getRoles() != null) {
        Set<String> strRoles = new HashSet<String>(Arrays.asList(use.getRoles().toString()));

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
    
    use.setRoles(roles);
    try {
        service.addUser(use);
        return new ResponseEntity<>(use, HttpStatus.CREATED);
    } catch (Exception e) {
        return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
    }
}

@GetMapping(path="/Imgusers/{id}")
public byte[] getPhoto(@PathVariable("id") Long id) throws Exception {
    User User = userRepository.findById(id).get();
    System.out.println("OK............"+User.getCodUser()+"/"+User.getFileName());
    return Files.readAllBytes(Paths.get(context.getRealPath("/imgUsers/Images/")+User.getCodUser()+"/"+User.getFileName()));

}
/*****************post article upload image */


    @DeleteMapping("/utilisateurs/{id}")
    public ResponseEntity<HttpStatus> deleteUtilisateur(@PathVariable("id") long id) {
      try {
        
        User use =  userRepository.findById(id).get();
        System.out.println("OK............"+use);
        File folder = new File(context.getRealPath("/imgUsers/Images/")+use.getCodUser()+"/");
        boolean isExist = new File(context.getRealPath("/imgUsers/Images/")+use.getCodUser()+"/").exists();
        boolean isDirectory= new File(context.getRealPath("/imgUsers/Images/")+use.getCodUser()+"/").isDirectory();
        System.out.println("after............"+isExist+"and"+isDirectory);
        if(isExist && isDirectory){
            for (File f : folder.listFiles()) {
				if(f.delete()){
					System.out.println("'"+f.getName()+"' deleted successfully");
				}else{
					System.out.println("Fail to delete '"+f.getName()+"'");
				}
			}
            if(folder.delete()){
				System.out.println("Folder deleted successfully");
                service.deleteUser(id);
			}else{
				System.out.println("Fail to delete folder");
			}
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
      }
    }


    @PutMapping("/utilisateurs/{id}")
    public ResponseEntity<User> updateCustomer(@PathVariable("id") long id, @RequestBody User user) {
      Optional<User> userData = userRepository.findById(id);
   
      if (userData.isPresent()) {
        User _user = userData.get();

        /**update file name from code user */
        if(_user.getCodUser() != user.getCodUser()){
            File folder = new File(context.getRealPath("/imgUsers/Images/")+_user.getCodUser());
            boolean isExist = new File(context.getRealPath("/imgUsers/Images/")+_user.getCodUser()+"/").exists();
            boolean isDirectory= new File(context.getRealPath("/imgUsers/Images/")+_user.getCodUser()+"/").isDirectory();
            System.out.println("after............"+isExist+"and"+isDirectory);
            if(isExist && isDirectory){
                if(folder.renameTo(new File(context.getRealPath("/imgUsers/Images/")+user.getCodUser()))){
                    System.out.println("Folder renamed successfully");
                }else{
                    System.out.println("Fail to rename folder");
                }
                Integer i=0;
                
                for (File f : new File(context.getRealPath("/imgUsers/Images/")+user.getCodUser()+'/').listFiles()) {
                    String mimeType= f.getName().substring(f.getName().indexOf('.'), f.getName().length());
                    System.out.println("see me"+mimeType);
                    if(f.renameTo(new File(context.getRealPath("/imgUsers/Images/")+user.getCodUser()+'/'+user.getCodUser()+'_'+i+mimeType))){
                        _user.setFileName(user.getCodUser()+" "+i+mimeType);
                        System.out.println("'"+f.getName()+"' renamed successfully");
                    }else{
                        System.out.println("Fail to rename file '"+f.getName()+"'");
                    }
                    i = i+1;
                }
            }
        }
        /**update file name from code user */

        _user.setUsername(user.getUsername());
        _user.setPassword(encoder.encode(user.getPassword()));
        _user.setShowPassword(user.getShowPassword());
        _user.setLastname(user.getLastname());
        _user.setFirstname(user.getFirstname());
        _user.setEmail(user.getEmail());
        _user.setDateDeNaissance(user.getDateDeNaissance());
        _user.setCin(user.getCin());
        _user.setTelephone(user.getTelephone());
        _user.setAddress(user.getAddress());
        _user.setCps(user.getCps());
        _user.setPseudo(user.getPseudo());
        _user.setDateRec(user.getDateRec());
        _user.setTypeContrat(user.getTypeContrat());
        _user.setDateContrat(user.getDateContrat());
        _user.setRoles(user.getRoles());
        _user.setFamille(user.getFamille());
        _user.setSalaire(user.getSalaire());
        _user.setBank1(user.getBank1());
        _user.setAgence1(user.getAgence1());
        _user.setPrimeDeRendement(user.getPrimeDeRendement());
        _user.setHeuresDeTravail(user.getHeuresDeTravail());
        _user.setVenteParHeure(user.getVenteParHeure());
        _user.setObjectifParJour(user.getObjectifParJour());
        _user.setObjectifParMois(user.getObjectifParMois());
        _user.setDateDebutConge(user.getDateDebutConge());
        _user.setDateFinConge(user.getDateFinConge());
        _user.setTypeConge(user.getTypeConge());
        _user.setPrimeGlobal(user.getPrimeGlobal());
        _user.setPrimeParClient(user.getPrimeParClient());
        _user.setPrimeStock(user.getPrimeStock());
        _user.setPostV(user.getPostV());
        _user.setCodUser(user.getCodUser());
        _user.setRaison(user.getRaison());
        _user.setRc(user.getRc());
        _user.setRespon1(user.getRespon1());
        _user.setFonction1(user.getFonction1());
        _user.setFaxs(user.getFaxs());
        _user.setAdrSiege(user.getAdrSiege());
        _user.setRuel(user.getRuel());
        _user.setNumRuel(user.getNumRuel());
        _user.setCpl(user.getCpl());
        _user.setVillel(user.getVillel());
        _user.setRegionl(user.getRegionl());
        _user.setTell(user.getTell());
        _user.setFaxl(user.getFaxl());
        _user.setAdrLiv(user.getAdrLiv());
        _user.setRegion(user.getRegion());
        _user.setModReg(user.getModReg());
        _user.setDomBan(user.getDomBan());
        _user.setEcheance(user.getEcheance());
        _user.setCrMax(user.getCrMax());
        _user.setDerMvt(user.getDerMvt());
        _user.setCredit(user.getCredit());
        _user.setPreVen(user.getPreVen());
        _user.setCumulAch(user.getCumulAch());
        _user.setChifAff1(user.getChifAff1());
        _user.setChifAff2(user.getChifAff2());
        _user.setChifAff3(user.getChifAff3());
        _user.setTauxRem(user.getTauxRem());
        _user.setTauxCom(user.getTauxCom());
        _user.setReste(user.getReste());
        _user.setTauxRes(user.getTauxRes());
        _user.setValRes(user.getValRes());
        _user.setPatron(user.getPatron());
        _user.setRang(user.getRang());
        _user.setImpaye(user.getImpaye());
        _user.setChqImpaye(user.getChqImpaye());
        _user.setEfPort(user.getEfPort());
        _user.setEfBanque(user.getEfBanque());
        _user.setEfNrecu(user.getEfNrecu());
        _user.setAvCom(user.getAvCom());
        _user.setCaution(user.getCaution());
        _user.setBenefice(user.getBenefice());
        _user.setTauxBene(user.getTauxBene());
        _user.setRecFff(user.getRecFff());
        _user.setTva(user.getTva());
        _user.setCle(user.getCle());
        _user.setSoldDep(user.getSoldDep());
        _user.setInteret(user.getInteret());
        _user.setRegChq(user.getRegChq());
        _user.setRegEff(user.getRegEff());
        _user.setRegEsp(user.getRegEsp());
        _user.setFacInst(user.getFacInst());
        _user.setAvoir(user.getAvoir());
        _user.setEffInst(user.getEffInst());
        _user.setSoldeBq(user.getSoldeBq());
        _user.setCreance(user.getCreance());
        _user.setEffEnc(user.getEffEnc());
        _user.setEffEsc(user.getEffEsc());
        _user.setComission(user.getComission());
        _user.setBloc(user.getBloc());
        _user.setCodeTva(user.getCodeTva());
        _user.setRemOrg(user.getRemOrg());
        _user.setAvance(user.getAvance());
        _user.setChqPf(user.getChqPf());
        _user.setRetenue(user.getRetenue());
        _user.setRegVir(user.getRegVir());
        _user.setAvN1(user.getAvN1());
        _user.setClasse(user.getClasse());
        _user.setRistourne(user.getRistourne());
        _user.setCaPrev(user.getCaPrev());
        _user.setSoldeCpf(user.getSoldeCpf());
        _user.setSoldeImp(user.getSoldeImp());
        _user.setSoldeEpf(user.getSoldeEpf());
        _user.setDatFFac(user.getDatFFac());
        _user.setDatGFac(user.getDatGFac());
        _user.setCaMens(user.getCaMens());
        _user.setCrImax(user.getCrImax());
        _user.setFcreN1(user.getFcreN1());
        _user.setFcreN2(user.getFcreN2());
        _user.setFreglN1(user.getFreglN1());
        _user.setFreglN2(user.getFreglN2());
        _user.setFescN2(user.getFescN2());
        _user.setFbkN1(user.getFbkN1());
        _user.setFbkN2(user.getFbkN2());
        _user.setFefpN1(user.getFefpN1());
        _user.setFefpN2(user.getFefpN2());
        _user.setFchpN1(user.getFchpN1());
        _user.setFchpN2(user.getFchpN2());
        _user.setFefnrN1(user.getFefnrN1());
        _user.setFefnrN2(user.getFefnrN2());
        _user.setIcreN1(user.getIcreN1());
        _user.setIcreN2(user.getIcreN2());
        _user.setIreglN1(user.getIreglN1());
        _user.setIreglN2(user.getIreglN2());
        _user.setIescN1(user.getIescN1());
        _user.setIescN2(user.getIescN2());
        _user.setIbkN1(user.getIbkN1());
        _user.setIbkN2(user.getIbkN2());
        _user.setIefpN1(user.getIefpN1());
        _user.setIefpN2(user.getIefpN2());
        _user.setIchpN1(user.getIchpN1());
        _user.setIchpN2(user.getIchpN2());
        _user.setIefnrN1(user.getIefnrN1());
        _user.setIefnrN2(user.getIefnrN2());
        _user.setDatOuvr(user.getDatOuvr());
        _user.setCommand(user.getCommand());
        _user.setRemExp(user.getRemExp());
        _user.setChefMag(user.getChefMag());
        _user.setJourVisit(user.getJourVisit());
        _user.setInstance(user.getInstance());
        _user.setComptant(user.getComptant());
        _user.setBl(user.getBl());
        _user.setNatLiv(user.getNatLiv());
        _user.setMois1(user.getMois1());
        _user.setMois2(user.getMois2());
        _user.setMois3(user.getMois3());
        _user.setMois4(user.getMois4());
        _user.setMois5(user.getMois5());
        _user.setMois6(user.getMois6());
        _user.setMois7(user.getMois7());
        _user.setMois8(user.getMois8());
        _user.setMois9(user.getMois9());
        _user.setMois10(user.getMois10());
        _user.setMois11(user.getMois11());
        _user.setMois12(user.getMois12());
        _user.setDatDerLi(user.getDatDerLi());
        _user.setMargePour(user.getMargePour());
        _user.setMargeVal(user.getMargeVal());
        _user.setCredblEnc(user.getCredblEnc());
        _user.setCredinstec(user.getCredinstec());
        _user.setObservatio(user.getObservatio());
        _user.setObserv(user.getObserv());
        _user.setGouv1(user.getGouv1());
        _user.setGouv2(user.getGouv2());
        _user.setCriRef(user.getCriRef());
        _user.setRemFam(user.getRemFam());
        _user.setReglement(user.getReglement());
        _user.setDelai(user.getDelai());
        _user.setNbTranche(user.getNbTranche());
        _user.setCodSteq(user.getCodSteq());
        _user.setReference(user.getReference());
        _user.setSansRet(user.getSansRet());
        _user.setCliGroup(user.getCliGroup());
        _user.setTauxMarge(user.getTauxMarge());
        _user.setAuthorisation(user.getAuthorisation());
        _user.setRoles(user.getRoles());
        _user.setConnected(user.getConnected());

        return new ResponseEntity<>(service.updateUser(_user), HttpStatus.OK);
      } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
    }


    /*****************post article upload image */
    @PutMapping("/utilisateurs/Update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") long id, @RequestParam("file") MultipartFile file,@RequestParam("user") String user)
    throws JsonParseException , JsonMappingException , Exception {
        Optional<User> userData = userRepository.findById(id);

        if (userData.isPresent()) {
            User _user = userData.get();

            System.out.println("OK............");
            User marqu =  new ObjectMapper().readValue(user,User.class);
            boolean isExist = new File(context.getRealPath("/imgUsers/Images/")+marqu.getCodUser()+"/").exists();
            if(!isExist){

                File folder =new File (context.getRealPath("/imgUsers/Images/")+_user.getCodUser()+"/");

                if(folder.listFiles()!=null){
                    for (File f : folder.listFiles()) {
                        if(f.delete()){
                            System.out.println("'"+f.getName()+"' deleted successfully");
                        }else{
                            System.out.println("Fail to delete '"+f.getName()+"'");
                        }
                    }
                }
                if(folder.delete()){
                    System.out.println("Folder deleted successfully");
                }else{
                    System.out.println("Fail to delete folder");
                }
                new File (context.getRealPath("/imgUsers/Images/")+marqu.getCodUser()+"/").mkdir();
                System.out.println("mk dir............");
            }else{        

                File folder = new File(context.getRealPath("/imgUsers/Images/")+marqu.getCodUser()+"/");
                boolean isExist2 = new File(context.getRealPath("/imgUsers/Images/")+marqu.getCodUser()+"/").exists();
                boolean isDirectory= new File(context.getRealPath("/imgUsers/Images/")+marqu.getCodUser()+"/").isDirectory();
                if(isExist2 && isDirectory){
                    for (File f : folder.listFiles()) {
                        if(f.delete()){
                            System.out.println("'"+f.getName()+"' deleted successfully");
                        }else{
                            System.out.println("Fail to delete '"+f.getName()+"'");
                        }
                    }
                }else{
                    System.out.println("something wrong with the folder");
                }
            }

            String filename = file.getOriginalFilename();
            String newFileName = FilenameUtils.getBaseName(filename)+"."+FilenameUtils.getExtension(filename);
            File serverFile = new File (context.getRealPath("/imgUsers/Images/"+marqu.getCodUser()+"/"+File.separator+newFileName));
            try {
                System.out.println("Image"); 
                org.apache.commons.io.FileUtils.writeByteArrayToFile(serverFile,file.getBytes());
            }catch(Exception e){
                e.printStackTrace();
            }
            Integer i =0;
            String mimeType= newFileName.substring(newFileName.indexOf('.'), newFileName.length());
            boolean hasRename = serverFile.renameTo(new File(context.getRealPath("/imgUsers/Images/"+marqu.getCodUser()+"/"+marqu.getCodUser()+'_'+i+mimeType)));
            if (hasRename) {
                System.out.println("File rename successful");
            } else {
                System.out.println("File reanme failed");
            }



            _user.setUsername(marqu.getUsername());
            _user.setPassword(encoder.encode(marqu.getPassword()));
            _user.setShowPassword(marqu.getShowPassword());
            _user.setLastname(marqu.getLastname());
            _user.setFirstname(marqu.getFirstname());
            _user.setEmail(marqu.getEmail());
            _user.setDateDeNaissance(marqu.getDateDeNaissance());
            _user.setCin(marqu.getCin());
            _user.setTelephone(marqu.getTelephone());
            _user.setAddress(marqu.getAddress());
            _user.setCps(marqu.getCps());
            _user.setPseudo(marqu.getPseudo());
            _user.setDateRec(marqu.getDateRec());
            _user.setTypeContrat(marqu.getTypeContrat());
            _user.setDateContrat(marqu.getDateContrat());
            _user.setRoles(marqu.getRoles());
            _user.setFamille(marqu.getFamille());
            _user.setSalaire(marqu.getSalaire());
            _user.setBank1(marqu.getBank1());
            _user.setAgence1(marqu.getAgence1());
            _user.setPrimeDeRendement(marqu.getPrimeDeRendement());
            _user.setHeuresDeTravail(marqu.getHeuresDeTravail());
            _user.setVenteParHeure(marqu.getVenteParHeure());
            _user.setObjectifParJour(marqu.getObjectifParJour());
            _user.setObjectifParMois(marqu.getObjectifParMois());
            _user.setDateDebutConge(marqu.getDateDebutConge());
            _user.setDateFinConge(marqu.getDateFinConge());
            _user.setTypeConge(marqu.getTypeConge());
            _user.setPrimeGlobal(marqu.getPrimeGlobal());
            _user.setPrimeParClient(marqu.getPrimeParClient());
            _user.setPrimeStock(marqu.getPrimeStock());
            _user.setPostV(marqu.getPostV());
            _user.setCodUser(marqu.getCodUser());
            _user.setRaison(marqu.getRaison());
            _user.setRc(marqu.getRc());
            _user.setRespon1(marqu.getRespon1());
            _user.setFonction1(marqu.getFonction1());
            _user.setFaxs(marqu.getFaxs());
            _user.setAdrSiege(marqu.getAdrSiege());
            _user.setRuel(marqu.getRuel());
            _user.setNumRuel(marqu.getNumRuel());
            _user.setCpl(marqu.getCpl());
            _user.setVillel(marqu.getVillel());
            _user.setRegionl(marqu.getRegionl());
            _user.setTell(marqu.getTell());
            _user.setFaxl(marqu.getFaxl());
            _user.setAdrLiv(marqu.getAdrLiv());
            _user.setRegion(marqu.getRegion());
            _user.setModReg(marqu.getModReg());
            _user.setDomBan(marqu.getDomBan());
            _user.setEcheance(marqu.getEcheance());
            _user.setCrMax(marqu.getCrMax());
            _user.setDerMvt(marqu.getDerMvt());
            _user.setCredit(marqu.getCredit());
            _user.setPreVen(marqu.getPreVen());
            _user.setCumulAch(marqu.getCumulAch());
            _user.setChifAff1(marqu.getChifAff1());
            _user.setChifAff2(marqu.getChifAff2());
            _user.setChifAff3(marqu.getChifAff3());
            _user.setTauxRem(marqu.getTauxRem());
            _user.setTauxCom(marqu.getTauxCom());
            _user.setReste(marqu.getReste());
            _user.setTauxRes(marqu.getTauxRes());
            _user.setValRes(marqu.getValRes());
            _user.setPatron(marqu.getPatron());
            _user.setRang(marqu.getRang());
            _user.setImpaye(marqu.getImpaye());
            _user.setChqImpaye(marqu.getChqImpaye());
            _user.setEfPort(marqu.getEfPort());
            _user.setEfBanque(marqu.getEfBanque());
            _user.setEfNrecu(marqu.getEfNrecu());
            _user.setAvCom(marqu.getAvCom());
            _user.setCaution(marqu.getCaution());
            _user.setBenefice(marqu.getBenefice());
            _user.setTauxBene(marqu.getTauxBene());
            _user.setRecFff(marqu.getRecFff());
            _user.setTva(marqu.getTva());
            _user.setCle(marqu.getCle());
            _user.setSoldDep(marqu.getSoldDep());
            _user.setInteret(marqu.getInteret());
            _user.setRegChq(marqu.getRegChq());
            _user.setRegEff(marqu.getRegEff());
            _user.setRegEsp(marqu.getRegEsp());
            _user.setFacInst(marqu.getFacInst());
            _user.setAvoir(marqu.getAvoir());
            _user.setEffInst(marqu.getEffInst());
            _user.setSoldeBq(marqu.getSoldeBq());
            _user.setCreance(marqu.getCreance());
            _user.setEffEnc(marqu.getEffEnc());
            _user.setEffEsc(marqu.getEffEsc());
            _user.setComission(marqu.getComission());
            _user.setBloc(marqu.getBloc());
            _user.setCodeTva(marqu.getCodeTva());
            _user.setRemOrg(marqu.getRemOrg());
            _user.setAvance(marqu.getAvance());
            _user.setChqPf(marqu.getChqPf());
            _user.setRetenue(marqu.getRetenue());
            _user.setRegVir(marqu.getRegVir());
            _user.setAvN1(marqu.getAvN1());
            _user.setClasse(marqu.getClasse());
            _user.setRistourne(marqu.getRistourne());
            _user.setCaPrev(marqu.getCaPrev());
            _user.setSoldeCpf(marqu.getSoldeCpf());
            _user.setSoldeImp(marqu.getSoldeImp());
            _user.setSoldeEpf(marqu.getSoldeEpf());
            _user.setDatFFac(marqu.getDatFFac());
            _user.setDatGFac(marqu.getDatGFac());
            _user.setCaMens(marqu.getCaMens());
            _user.setCrImax(marqu.getCrImax());
            _user.setFcreN1(marqu.getFcreN1());
            _user.setFcreN2(marqu.getFcreN2());
            _user.setFreglN1(marqu.getFreglN1());
            _user.setFreglN2(marqu.getFreglN2());
            _user.setFescN2(marqu.getFescN2());
            _user.setFbkN1(marqu.getFbkN1());
            _user.setFbkN2(marqu.getFbkN2());
            _user.setFefpN1(marqu.getFefpN1());
            _user.setFefpN2(marqu.getFefpN2());
            _user.setFchpN1(marqu.getFchpN1());
            _user.setFchpN2(marqu.getFchpN2());
            _user.setFefnrN1(marqu.getFefnrN1());
            _user.setFefnrN2(marqu.getFefnrN2());
            _user.setIcreN1(marqu.getIcreN1());
            _user.setIcreN2(marqu.getIcreN2());
            _user.setIreglN1(marqu.getIreglN1());
            _user.setIreglN2(marqu.getIreglN2());
            _user.setIescN1(marqu.getIescN1());
            _user.setIescN2(marqu.getIescN2());
            _user.setIbkN1(marqu.getIbkN1());
            _user.setIbkN2(marqu.getIbkN2());
            _user.setIefpN1(marqu.getIefpN1());
            _user.setIefpN2(marqu.getIefpN2());
            _user.setIchpN1(marqu.getIchpN1());
            _user.setIchpN2(marqu.getIchpN2());
            _user.setIefnrN1(marqu.getIefnrN1());
            _user.setIefnrN2(marqu.getIefnrN2());
            _user.setDatOuvr(marqu.getDatOuvr());
            _user.setCommand(marqu.getCommand());
            _user.setRemExp(marqu.getRemExp());
            _user.setChefMag(marqu.getChefMag());
            _user.setJourVisit(marqu.getJourVisit());
            _user.setInstance(marqu.getInstance());
            _user.setComptant(marqu.getComptant());
            _user.setBl(marqu.getBl());
            _user.setNatLiv(marqu.getNatLiv());
            _user.setMois1(marqu.getMois1());
            _user.setMois2(marqu.getMois2());
            _user.setMois3(marqu.getMois3());
            _user.setMois4(marqu.getMois4());
            _user.setMois5(marqu.getMois5());
            _user.setMois6(marqu.getMois6());
            _user.setMois7(marqu.getMois7());
            _user.setMois8(marqu.getMois8());
            _user.setMois9(marqu.getMois9());
            _user.setMois10(marqu.getMois10());
            _user.setMois11(marqu.getMois11());
            _user.setMois12(marqu.getMois12());
            _user.setDatDerLi(marqu.getDatDerLi());
            _user.setMargePour(marqu.getMargePour());
            _user.setMargeVal(marqu.getMargeVal());
            _user.setCredblEnc(marqu.getCredblEnc());
            _user.setCredinstec(marqu.getCredinstec());
            _user.setObservatio(marqu.getObservatio());
            _user.setObserv(marqu.getObserv());
            _user.setGouv1(marqu.getGouv1());
            _user.setGouv2(marqu.getGouv2());
            _user.setCriRef(marqu.getCriRef());
            _user.setRemFam(marqu.getRemFam());
            _user.setReglement(marqu.getReglement());
            _user.setDelai(marqu.getDelai());
            _user.setNbTranche(marqu.getNbTranche());
            _user.setCodSteq(marqu.getCodSteq());
            _user.setReference(marqu.getReference());
            _user.setSansRet(marqu.getSansRet());
            _user.setCliGroup(marqu.getCliGroup());
            _user.setTauxMarge(marqu.getTauxMarge());
            _user.setAuthorisation(marqu.getAuthorisation());
            _user.setRoles(marqu.getRoles());
            _user.setConnected(marqu.getConnected());

            System.out.println("shoooo"+marqu.getCodUser()+"pfff"+mimeType);
            _user.setFileName(marqu.getCodUser()+'_'+i+mimeType);
            //userRepository.ChangeFileName(marqu.getCodUser()+'_'+i+mimeType,id);
            service.updateUser(_user);
            System.out.println(_user); 
            return new ResponseEntity<>(_user, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
        
    }

    /*****************post article upload image */


    @PutMapping("/utilisateurs/connected/{id}")
    public ResponseEntity<User> updateConnectedUser(@PathVariable("id") long id, @RequestBody User user) {
      Optional<User> userData = userRepository.findById(id);
   
      if (userData.isPresent()) {
        User _user = userData.get();
        _user.setConnected(user.getConnected());

        return new ResponseEntity<>(service.updateUser(_user), HttpStatus.OK);
      } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
    }
/**update the roles */
@Transactional
@GetMapping("/utilisateurs/RoleToUSER/{id}")
public void ChangeRoleToUSER(@PathVariable("id") Long id) {
    service.ChangeRoleToUSER(id); 
}
@Transactional
@GetMapping("/utilisateurs/RoleToADMIN/{id}")
public void ChangeRoleToADMIN(@PathVariable("id") Long id) {
    service.ChangeRoleToADMIN(id); 
}
@Transactional
@GetMapping("/utilisateurs/RoleToACHETEUR/{id}")
public void ChangeRoleToACHETEUR(@PathVariable("id") Long id) {
    service.ChangeRoleToACHETEUR(id); 
}
@Transactional
@GetMapping("/utilisateurs/RoleToTRANSITAIRE/{id}")
public void ChangeRoleToTRANSITAIRE(@PathVariable("id") Long id) {
    service.ChangeRoleToTRANSITAIRE(id); 
}
@Transactional
@GetMapping("/utilisateurs/RoleToCLIENT/{id}")
public void ChangeRoleToCLIENT(@PathVariable("id") Long id) {
    service.ChangeRoleToCLIENT(id); 
}
@Transactional
@GetMapping("/utilisateurs/RoleToVENDEUR/{id}")
public void ChangeRoleToVENDEUR(@PathVariable("id") Long id) {
    service.ChangeRoleToVENDEUR(id); 
}
@Transactional
@GetMapping("/utilisateurs/RoleToDECIDEUR_BP/{id}")
public void ChangeRoleToDECIDEUR_BP(@PathVariable("id") Long id) {
    service.ChangeRoleToDECIDEUR_BP(id); 
}
@Transactional
@GetMapping("/utilisateurs/RoleToAGENT_CAB/{id}")
public void ChangeRoleToAGENT_CAB(@PathVariable("id") Long id) {
    service.ChangeRoleToAGENT_CAB(id); 
}
@Transactional
@GetMapping("/utilisateurs/RoleToPREPARATEUR_BR/{id}")
public void ChangeRoleToPREPARATEUR_BR(@PathVariable("id") Long id) {
    service.ChangeRoleToPREPARATEUR_BR(id); 
}
@Transactional
@GetMapping("/utilisateurs/RoleToRESPONSABLE_DISPATCHING_BP/{id}")
public void ChangeRoleToRESPONSABLE_DISPATCHING_BP(@PathVariable("id") Long id) {
    service.ChangeRoleToRESPONSABLE_DISPATCHING_BP(id); 
}
@Transactional
@GetMapping("/utilisateurs/RoleToPREPARATEUR/{id}")
public void ChangeRoleToPREPARATEUR(@PathVariable("id") Long id) {
    service.ChangeRoleToPREPARATEUR(id); 
}
@Transactional
@GetMapping("/utilisateurs/RoleToVALIDATEUR_DE_CHARIOT/{id}")
public void ChangeRoleToVALIDATEUR_DE_CHARIOT(@PathVariable("id") Long id) {
    service.ChangeRoleToVALIDATEUR_DE_CHARIOT(id); 
}
@Transactional
@GetMapping("/utilisateurs/RoleToRESPONSABLE_POINTAGE/{id}")
public void ChangeRoleToRESPONSABLE_POINTAGE(@PathVariable("id") Long id) {
    service.ChangeRoleToRESPONSABLE_POINTAGE(id); 
}
@Transactional
@GetMapping("/utilisateurs/RoleToEMBALLEUR/{id}")
public void ChangeRoleToEMBALLEUR(@PathVariable("id") Long id) {
    service.ChangeRoleToEMBALLEUR(id); 
}
@Transactional
@GetMapping("/utilisateurs/RoleToEXPEDITEUR/{id}")
public void ChangeRoleToEXPEDITEUR(@PathVariable("id") Long id) {
    service.ChangeRoleToEXPEDITEUR(id); 
}
@Transactional
@GetMapping("/utilisateurs/RoleToAGENT_SAISIE_REG/{id}")
public void ChangeRoleToAGENT_SAISIE_REG(@PathVariable("id") Long id) {
    service.ChangeRoleToAGENT_SAISIE_REG(id); 
}
@Transactional
@GetMapping("/utilisateurs/RoleToCAISSIER/{id}")
public void ChangeRoleToCAISSIER(@PathVariable("id") Long id) {
    service.ChangeRoleToCAISSIER(id); 
}
@Transactional
@GetMapping("/utilisateurs/RoleToRESPONSABLE_SERVICE_FRS_ETRANGER/{id}")
public void ChangeRoleToRESPONSABLE_SERVICE_FRS_ETRANGER(@PathVariable("id") Long id) {
    service.ChangeRoleToRESPONSABLE_SERVICE_FRS_ETRANGER(id); 
}
@Transactional
@GetMapping("/utilisateurs/RoleToRESPONSABLE_SERVICE_FRS_LOCAL/{id}")
public void ChangeRoleToRESPONSABLE_SERVICE_FRS_LOCAL(@PathVariable("id") Long id) {
    service.ChangeRoleToRESPONSABLE_SERVICE_FRS_LOCAL(id); 
}
@Transactional
@GetMapping("/utilisateurs/RoleToLIVREUR/{id}")
public void ChangeRoleToLIVREUR(@PathVariable("id") Long id) {
    service.ChangeRoleToLIVREUR(id); 
}



    @GetMapping(value = "/utilisateurs/Roles")
    public ResponseEntity<List<Role>> getAllRoles() {
        try {
            List<Role> RoleUsers = service.getAllRoles();

            if (RoleUsers.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);   /** pour afficher les Achats drop list */
            }
            return new ResponseEntity<>(RoleUsers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }



    @GetMapping(value = "/utilisateurs/username/{username}")
    public ResponseEntity<Integer> getUserByUsername(@PathVariable String username) {
        try {
            Integer Iduser = service.getUserByUsername(username);

            if (Iduser==null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);     /** pour afficher les stock d article */
            }
            return new ResponseEntity<>(Iduser, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }


    
      /**  statistique  Pie Utilisateur */ 

      @GetMapping("/utilisateurs/SumROLE_USER")
      public ResponseEntity<Optional<Integer>> getSumROLE_USER() {
          try {
              Optional<Integer> SumROLE_USER = service.getSumROLE_USER();  /** pour get Sum des role de utilisateur */
              if (SumROLE_USER.isEmpty()) {
                  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
              }
              return new ResponseEntity<>(SumROLE_USER, HttpStatus.OK);
          } catch (Exception e) {
              return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
          }
      }
      @GetMapping("/utilisateurs/SumROLE_ADMIN")
      public ResponseEntity<Optional<Integer>> getSumROLE_ADMIN() {
          try {
              Optional<Integer> SumROLE_ADMIN = service.getSumROLE_ADMIN();  /** pour get Sum des role de utilisateur */
              if (SumROLE_ADMIN.isEmpty()) {
                  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
              }
              return new ResponseEntity<>(SumROLE_ADMIN, HttpStatus.OK);
          } catch (Exception e) {
              return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
          }
      }
      @GetMapping("/utilisateurs/SumROLE_ACHETEUR")
      public ResponseEntity<Optional<Integer>> getSumROLE_ACHETEUR() {
          try {
              Optional<Integer> SumROLE_ACHETEUR = service.getSumROLE_ACHETEUR();  /** pour get Sum des role de utilisateur */
              if (SumROLE_ACHETEUR.isEmpty()) {
                  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
              }
              return new ResponseEntity<>(SumROLE_ACHETEUR, HttpStatus.OK);
          } catch (Exception e) {
              return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
          }
      }
      @GetMapping("/utilisateurs/SumROLE_TRANSITAIRE")
      public ResponseEntity<Optional<Integer>> getSumROLE_TRANSITAIRE() {
          try {
              Optional<Integer> SumROLE_TRANSITAIRE = service.getSumROLE_TRANSITAIRE();  /** pour get Sum des role de utilisateur */
              if (SumROLE_TRANSITAIRE.isEmpty()) {
                  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
              }
              return new ResponseEntity<>(SumROLE_TRANSITAIRE, HttpStatus.OK);
          } catch (Exception e) {
              return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
          }
      }
      @GetMapping("/utilisateurs/SumROLE_CLIENT")
      public ResponseEntity<Optional<Integer>> getSumROLE_CLIENT() {
          try {
              Optional<Integer> SumROLE_CLIENT = service.getSumROLE_CLIENT();  /** pour get Sum des role de utilisateur */
              if (SumROLE_CLIENT.isEmpty()) {
                  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
              }
              return new ResponseEntity<>(SumROLE_CLIENT, HttpStatus.OK);
          } catch (Exception e) {
              return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
          }
      }
      @GetMapping("/utilisateurs/SumROLE_VENDEUR")
      public ResponseEntity<Optional<Integer>> getSumROLE_VENDEUR() {
          try {
              Optional<Integer> SumROLE_VENDEUR = service.getSumROLE_VENDEUR();  /** pour get Sum des role de utilisateur */
              if (SumROLE_VENDEUR.isEmpty()) {
                  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
              }
              return new ResponseEntity<>(SumROLE_VENDEUR, HttpStatus.OK);
          } catch (Exception e) {
              return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
          }
      }
      @GetMapping("/utilisateurs/SumROLE_DECIDEUR_BP")
      public ResponseEntity<Optional<Integer>> getSumROLE_DECIDEUR_BP() {
          try {
              Optional<Integer> SumROLE_DECIDEUR_BP = service.getSumROLE_DECIDEUR_BP();  /** pour get Sum des role de utilisateur */
              if (SumROLE_DECIDEUR_BP.isEmpty()) {
                  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
              }
              return new ResponseEntity<>(SumROLE_DECIDEUR_BP, HttpStatus.OK);
          } catch (Exception e) {
              return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
          }
      }
      @GetMapping("/utilisateurs/SumROLE_AGENT_CAB")
      public ResponseEntity<Optional<Integer>> getSumROLE_AGENT_CAB() {
          try {
              Optional<Integer> SumROLE_AGENT_CAB = service.getSumROLE_AGENT_CAB();  /** pour get Sum des role de utilisateur */
              if (SumROLE_AGENT_CAB.isEmpty()) {
                  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
              }
              return new ResponseEntity<>(SumROLE_AGENT_CAB, HttpStatus.OK);
          } catch (Exception e) {
              return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
          }
      }
      @GetMapping("/utilisateurs/SumROLE_PREPARATEUR_BR")
      public ResponseEntity<Optional<Integer>> getSumROLE_PREPARATEUR_BR() {
          try {
              Optional<Integer> SumROLE_PREPARATEUR_BR = service.getSumROLE_PREPARATEUR_BR();  /** pour get Sum des role de utilisateur */
              if (SumROLE_PREPARATEUR_BR.isEmpty()) {
                  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
              }
              return new ResponseEntity<>(SumROLE_PREPARATEUR_BR, HttpStatus.OK);
          } catch (Exception e) {
              return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
          }
      }
      @GetMapping("/utilisateurs/SumROLE_RESPONSABLE_DISPATCHING_BP")
      public ResponseEntity<Optional<Integer>> getSumROLE_RESPONSABLE_DISPATCHING_BP() {
          try {
              Optional<Integer> SumROLE_RESPONSABLE_DISPATCHING_BP = service.getSumROLE_RESPONSABLE_DISPATCHING_BP();  /** pour get Sum des role de utilisateur */
              if (SumROLE_RESPONSABLE_DISPATCHING_BP.isEmpty()) {
                  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
              }
              return new ResponseEntity<>(SumROLE_RESPONSABLE_DISPATCHING_BP, HttpStatus.OK);
          } catch (Exception e) {
              return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
          }
      }
      @GetMapping("/utilisateurs/SumROLE_PREPARATEUR")
      public ResponseEntity<Optional<Integer>> getSumROLE_PREPARATEUR() {
          try {
              Optional<Integer> SumROLE_PREPARATEUR = service.getSumROLE_PREPARATEUR();  /** pour get Sum des role de utilisateur */
              if (SumROLE_PREPARATEUR.isEmpty()) {
                  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
              }
              return new ResponseEntity<>(SumROLE_PREPARATEUR, HttpStatus.OK);
          } catch (Exception e) {
              return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
          }
      }
      @GetMapping("/utilisateurs/SumROLE_VALIDATEUR_DE_CHARIOT")
      public ResponseEntity<Optional<Integer>> getSumROLE_VALIDATEUR_DE_CHARIOT() {
          try {
              Optional<Integer> SumROLE_VALIDATEUR_DE_CHARIOT = service.getSumROLE_VALIDATEUR_DE_CHARIOT();  /** pour get Sum des role de utilisateur */
              if (SumROLE_VALIDATEUR_DE_CHARIOT.isEmpty()) {
                  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
              }
              return new ResponseEntity<>(SumROLE_VALIDATEUR_DE_CHARIOT, HttpStatus.OK);
          } catch (Exception e) {
              return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
          }
      }
      @GetMapping("/utilisateurs/SumROLE_RESPONSABLE_POINTAGE")
      public ResponseEntity<Optional<Integer>> getSumROLE_RESPONSABLE_POINTAGE() {
          try {
              Optional<Integer> SumROLE_RESPONSABLE_POINTAGE = service.getSumROLE_RESPONSABLE_POINTAGE();  /** pour get Sum des role de utilisateur */
              if (SumROLE_RESPONSABLE_POINTAGE.isEmpty()) {
                  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
              }
              return new ResponseEntity<>(SumROLE_RESPONSABLE_POINTAGE, HttpStatus.OK);
          } catch (Exception e) {
              return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
          }
      }
      @GetMapping("/utilisateurs/SumROLE_EMBALLEUR")
      public ResponseEntity<Optional<Integer>> getSumROLE_EMBALLEUR() {
          try {
              Optional<Integer> SumROLE_EMBALLEUR = service.getSumROLE_EMBALLEUR();  /** pour get Sum des role de utilisateur */
              if (SumROLE_EMBALLEUR.isEmpty()) {
                  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
              }
              return new ResponseEntity<>(SumROLE_EMBALLEUR, HttpStatus.OK);
          } catch (Exception e) {
              return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
          }
      }
      @GetMapping("/utilisateurs/SumROLE_EXPEDITEUR")
      public ResponseEntity<Optional<Integer>> getSumROLE_EXPEDITEUR() {
          try {
              Optional<Integer> SumROLE_EXPEDITEUR = service.getSumROLE_EXPEDITEUR();  /** pour get Sum des role de utilisateur */
              if (SumROLE_EXPEDITEUR.isEmpty()) {
                  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
              }
              return new ResponseEntity<>(SumROLE_EXPEDITEUR, HttpStatus.OK);
          } catch (Exception e) {
              return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
          }
      }
      @GetMapping("/utilisateurs/SumROLE_AGENT_SAISIE_REG")
      public ResponseEntity<Optional<Integer>> getSumROLE_AGENT_SAISIE_REG() {
          try {
              Optional<Integer> SumROLE_AGENT_SAISIE_REG = service.getSumROLE_AGENT_SAISIE_REG();  /** pour get Sum des role de utilisateur */
              if (SumROLE_AGENT_SAISIE_REG.isEmpty()) {
                  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
              }
              return new ResponseEntity<>(SumROLE_AGENT_SAISIE_REG, HttpStatus.OK);
          } catch (Exception e) {
              return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
          }
      }
      @GetMapping("/utilisateurs/SumROLE_CAISSIER")
      public ResponseEntity<Optional<Integer>> getSumROLE_CAISSIER() {
          try {
              Optional<Integer> SumROLE_CAISSIER = service.getSumROLE_CAISSIER();  /** pour get Sum des role de utilisateur */
              if (SumROLE_CAISSIER.isEmpty()) {
                  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
              }
              return new ResponseEntity<>(SumROLE_CAISSIER, HttpStatus.OK);
          } catch (Exception e) {
              return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
          }
      }
      @GetMapping("/utilisateurs/SumROLE_RESPONSABLE_SERVICE_FRS_ETRANGER")
      public ResponseEntity<Optional<Integer>> getSumROLE_RESPONSABLE_SERVICE_FRS_ETRANGER() {
          try {
              Optional<Integer> SumROLE_RESPONSABLE_SERVICE_FRS_ETRANGER = service.getSumROLE_RESPONSABLE_SERVICE_FRS_ETRANGER();  /** pour get Sum des role de utilisateur */
              if (SumROLE_RESPONSABLE_SERVICE_FRS_ETRANGER.isEmpty()) {
                  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
              }
              return new ResponseEntity<>(SumROLE_RESPONSABLE_SERVICE_FRS_ETRANGER, HttpStatus.OK);
          } catch (Exception e) {
              return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
          }
      }
      @GetMapping("/utilisateurs/SumROLE_RESPONSABLE_SERVICE_FRS_LOCAL")
      public ResponseEntity<Optional<Integer>> getSumROLE_RESPONSABLE_SERVICE_FRS_LOCAL() {
          try {
              Optional<Integer> SumROLE_RESPONSABLE_SERVICE_FRS_LOCAL = service.getSumROLE_RESPONSABLE_SERVICE_FRS_LOCAL();  /** pour get Sum des role de utilisateur */
              if (SumROLE_RESPONSABLE_SERVICE_FRS_LOCAL.isEmpty()) {
                  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
              }
              return new ResponseEntity<>(SumROLE_RESPONSABLE_SERVICE_FRS_LOCAL, HttpStatus.OK);
          } catch (Exception e) {
              return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
          }
      }
      @GetMapping("/utilisateurs/SumROLE_LIVREUR")
      public ResponseEntity<Optional<Integer>> getSumROLE_LIVREUR() {
          try {
              Optional<Integer> SumROLE_LIVREUR = service.getSumROLE_LIVREUR();  /** pour get Sum des role de utilisateur */
              if (SumROLE_LIVREUR.isEmpty()) {
                  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
              }
              return new ResponseEntity<>(SumROLE_LIVREUR, HttpStatus.OK);
          } catch (Exception e) {
              return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
          }
      }  
      
      

      /***end here */


      @GetMapping("/utilisateurs/LastUtilisateur")
      public ResponseEntity<Optional<Long>> getLastIdUser() {
          try {
              Optional<Long> LastChariot = service.getLastIdUser();  /** pour get getLastIdUser*/
  
              if (LastChariot.isEmpty()) {
                  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
              }
              return new ResponseEntity<>(LastChariot, HttpStatus.OK);
          } catch (Exception e) {
              return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
          }
      }
}
