package com.loizenai.jwtauthentication.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.loizenai.jwtauthentication.model.Role;
import com.loizenai.jwtauthentication.model.User;
import com.loizenai.jwtauthentication.repository.UserRepository;
import com.loizenai.jwtauthentication.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class UserController {
    
    @Autowired
    private UserService service;

    @Autowired
    UserRepository userRepository;


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
   
    @DeleteMapping("/utilisateurs/{id}")
    public ResponseEntity<HttpStatus> deleteUtilisateur(@PathVariable("id") long id) {
      try {
        service.deleteUser(id);
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
        _user.setUsername(user.getUsername());
        _user.setPassword(user.getPassword());
        _user.setLastname(user.getLastname());
        _user.setFirstname(user.getFirstname());
        _user.setEmail(user.getEmail());
        _user.setDateDeNaissance(user.getDateDeNaissance());
        _user.setCin(user.getCin());
        _user.setAddress(user.getAddress());
        _user.setCps(user.getCps());
        _user.setPseudo(user.getPseudo());
        _user.setDateRec(user.getDateRec());
        _user.setTypeContrat(user.getTypeContrat());
        _user.setDateContrat(user.getDateContrat());
        _user.setRoles(user.getRoles());
        _user.setFamille(user.getFamille());
        _user.setSalaire(user.getSalaire());
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
        return new ResponseEntity<>(service.updateUser(_user), HttpStatus.OK);
      } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
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
}
