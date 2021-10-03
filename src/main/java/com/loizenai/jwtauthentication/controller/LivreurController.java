package com.loizenai.jwtauthentication.controller;

import com.loizenai.jwtauthentication.model.Livreur;
import com.loizenai.jwtauthentication.repository.LivreurRepository;
import com.loizenai.jwtauthentication.services.LivreurService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class LivreurController {

    @Autowired
    private LivreurService service;

    @Autowired
    LivreurRepository repository;

    @GetMapping("/livreurs")
    public ResponseEntity<List<Livreur>> getAllLivreurs() {
        List<Livreur> livreurs = new ArrayList<>();
        try {
            service.getLivreurs().forEach(livreurs::add);

            if (livreurs.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(livreurs, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/livreurs/{id}")
    public ResponseEntity<Livreur> getLivreurById(@PathVariable("id") long id) {
        Optional<Livreur> livreurData = repository.findById(id);
        if (livreurData.isPresent()) {
            return new ResponseEntity<>(livreurData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/livreurs")
    public ResponseEntity<Livreur> postLivreur(@RequestBody Livreur livreur) {
        try {
            service.addLivreur(livreur);
            return new ResponseEntity<>(livreur, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @DeleteMapping("/livreurs/{id}")
    public ResponseEntity<HttpStatus> deleteLivreur(@PathVariable("id") long id) {
        try {
            service.deleteLivreur(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @DeleteMapping("/livreurs")
    public ResponseEntity<HttpStatus> deleteAllLivreurs() {
        try {
            repository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

/**select list add */

    @GetMapping("/expides/AllListLivreur")
    public ResponseEntity<List<Livreur>> getLivreurOfAdd() {
        try {
            List<Livreur> livreurs = service.getLivreurOfAdd();

            if (livreurs.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(livreurs, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }


@GetMapping(value = "/livreurs/dat_reclamdateBetween/{startDate}to{endDate}")
public ResponseEntity<List<Livreur>> getAllEtatLivdat_reclamBydateBetween(@PathVariable String startDate,@PathVariable String endDate) {
    try {
        List<Livreur> BonLivByDateBetween = service.getAllEtatLivdat_reclamBydateBetween(startDate,endDate);

        if (BonLivByDateBetween.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);   /** pour afficher les bon livraison entre 2 date */
        }
        return new ResponseEntity<>(BonLivByDateBetween, HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }
}

@GetMapping(value = "/livreurs/dat_repondateBetween/{startDate}to{endDate}")
public ResponseEntity<List<Livreur>> getAllEtatLivdat_reponBydateBetween(@PathVariable String startDate,@PathVariable String endDate) {
    try {
        List<Livreur> BonLivByDateBetween = service.getAllEtatLivdat_reponBydateBetween(startDate,endDate);

        if (BonLivByDateBetween.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);   /** pour afficher les bon livraison entre 2 date */
        }
        return new ResponseEntity<>(BonLivByDateBetween, HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }
}

@GetMapping(value = "/livreurs/datedateBetween/{startDate}to{endDate}")
public ResponseEntity<List<Livreur>> getAllEtatLivdateBydateBetween(@PathVariable String startDate,@PathVariable String endDate) {
    try {
        List<Livreur> BonLivByDateBetween = service.getAllEtatLivdateBydateBetween(startDate,endDate);

        if (BonLivByDateBetween.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);   /** pour afficher les bon livraison entre 2 date */
        }
        return new ResponseEntity<>(BonLivByDateBetween, HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }
}
/**select list add */


    //searsh with FK_keys******************

    @GetMapping("/livreurs/livreur_Nom/{nom}")
    public ResponseEntity<List<Livreur>> getAllLivreurByNom(@PathVariable String nom) {
        try {
            List<Livreur> LivreurByTyNom= service.getAllLivreurByNom(nom);  /** pour afficher les livreur by type nom */
    
            if (LivreurByTyNom.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(LivreurByTyNom, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping("/livreurs/livreur_Centre/{centre}")
    public ResponseEntity<List<Livreur>> getAllLivreurByCentre(@PathVariable String centre) {
        try {
            List<Livreur> LivreurByTyCentre= service.getAllLivreurByCentre(centre);  /** pour afficher les livreur by type centre */
    
            if (LivreurByTyCentre.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(LivreurByTyCentre, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping("/livreurs/livreur_Qutart/{qutart}")
    public ResponseEntity<List<Livreur>> getAllLivreurByQutArt(@PathVariable String qutart) {
        try {
            List<Livreur> LivreurByTyQutart= service.getAllLivreurByQutArt(qutart);  /** pour afficher les livreur by type qutart */
    
            if (LivreurByTyQutart.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(LivreurByTyQutart, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping("/livreurs/livreur_Expide/{expide}")
    public ResponseEntity<List<Livreur>> getAllLivreurByExpide(@PathVariable String expide) {
        try {
            List<Livreur> LivreurByTyExpide= service.getAllLivreurByExpide(expide);  /** pour afficher les livreur by type expide  */
    
            if (LivreurByTyExpide.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(LivreurByTyExpide, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    // end for the searsh of FK_Keys*******************
    
    @PutMapping("/livreurs/{id}")
    public ResponseEntity<Livreur> updateLivreur(@PathVariable("id") long id, @RequestBody Livreur livreur) {
        Optional<Livreur> livreurData = repository.findById(id);

        if (livreurData.isPresent()) {
            Livreur _livreur = livreurData.get();
            _livreur.setNom(livreur.getNom());
            _livreur.setNumrec(livreur.getNumrec());
            _livreur.setCentre(livreur.getCentre());
            _livreur.setDatreclam(livreur.getDatreclam());
            _livreur.setDatrepon(livreur.getDatrepon());
            _livreur.setDate(livreur.getDate());
            _livreur.setObsreclam(livreur.getObsreclam());
            _livreur.setObserv(livreur.getObserv());
            _livreur.setPrixach(livreur.getPrixach());
            _livreur.setQutart(livreur.getQutart());
            _livreur.setReclam(livreur.getReclam());
            _livreur.setTypmvt(livreur.getTypmvt());
            _livreur.setNature(livreur.getNature());
            _livreur.setObjectif(livreur.getObjectif());
            _livreur.setPrime(livreur.getPrime());
            //_livreur.setExpide(livreur.getExpide());


            return new ResponseEntity<>(service.updateLivreur(_livreur), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



















             /**  statistique  Pie Chariot*/ 

             @GetMapping("/livreurs/SumL1")
             public ResponseEntity<Optional<Integer>> getSumL1() {
                 try {
                     Optional<Integer> SumL1 = service.getSumL1();  /** pour get Sum Quantité de Livraison */
                     if (SumL1.isEmpty()) {
                         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                     }
                     return new ResponseEntity<>(SumL1, HttpStatus.OK);
                 } catch (Exception e) {
                     return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
                 }
             }
             @GetMapping("/livreurs/SumL2")
             public ResponseEntity<Optional<Integer>> getSumL2() {
                 try {
                     Optional<Integer> SumL2 = service.getSumL2();  /** pour get Sum Quantité de Livraison */
                     if (SumL2.isEmpty()) {
                         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                     }
                     return new ResponseEntity<>(SumL2, HttpStatus.OK);
                 } catch (Exception e) {
                     return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
                 }
             }
             @GetMapping("/livreurs/SumL3")
             public ResponseEntity<Optional<Integer>> getSumL3() {
                 try {
                     Optional<Integer> SumL3 = service.getSumL3();  /** pour get Sum Quantité de Livraison */
                     if (SumL3.isEmpty()) {
                         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                     }
                     return new ResponseEntity<>(SumL3, HttpStatus.OK);
                 } catch (Exception e) {
                     return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
                 }
             }
}
