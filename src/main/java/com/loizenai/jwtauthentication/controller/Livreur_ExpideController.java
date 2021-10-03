package com.loizenai.jwtauthentication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.loizenai.jwtauthentication.model.Livreur_Expide;
import com.loizenai.jwtauthentication.repository.Livreur_ExpideRepository;
import com.loizenai.jwtauthentication.services.Livreur_ExpideService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class Livreur_ExpideController {
   
    
    @Autowired
    private Livreur_ExpideService service;

    @Autowired
    Livreur_ExpideRepository repository;
    
    @GetMapping("/Livreur_Expides")
    public ResponseEntity<List<Livreur_Expide>> getAllLivreurs_Expides() {
        List<Livreur_Expide> Livreur_Expides = new ArrayList<>();
        try {
            service.getLivreur_Expide().forEach(Livreur_Expides::add);

            if (Livreur_Expides.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(Livreur_Expides, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/Livreur_Expides/{id_livreur_expide}")
    public ResponseEntity<Livreur_Expide> getLivreur_ExpideById(@PathVariable("id_livreur_expide") long id_livreur_expide) {
        Optional<Livreur_Expide> Livreur_ExpideData = repository.findById(id_livreur_expide);

        if (Livreur_ExpideData.isPresent()) {
            return new ResponseEntity<>(Livreur_ExpideData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/Livreur_Expides")
    public ResponseEntity<Livreur_Expide> postLivreurs_Expides(@RequestBody Livreur_Expide livreur_expide) {
        try {
            service.addLivreur_Expide(livreur_expide);
            return new ResponseEntity<>(livreur_expide, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @DeleteMapping("/Livreur_Expides/{id_livreur_expide}")
    public ResponseEntity<HttpStatus> deleteLivreurs_Expides(@PathVariable("id_livreur_expide") long id_livreur_expide) {
        try {
            service.deleteLivreur_Expide(id_livreur_expide);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping(value = "/Livreur_Expides/DeleteAllExpideID/{id_expide}")
    public ResponseEntity<HttpStatus> deleteAllByExpidition(@PathVariable Long id_expide) {
    try {
        service.deleteAllByExpidition(id_expide);

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
}
// end for the searsh of FK_Keys*******************

@GetMapping("/expides/LivreurBonliv/{id_expide}")
public ResponseEntity<List<Livreur_Expide>> getAllLivreursAndBonliv(@PathVariable Long id_expide) {
    try {
        List<Livreur_Expide> LivreurBonliv= service.getAllLivreursAndBonliv(id_expide);  /** pour afficher les bonLiv livreur */

        if (LivreurBonliv.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(LivreurBonliv, HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }
} 


// end for the searsh of FK_Keys*******************

@PutMapping("/Livreur_Expides/{id_expide}")
public ResponseEntity<Livreur_Expide> getAllLivreursAndBonliv2(@PathVariable("id_expide") String id_expide, @RequestBody Livreur_Expide livreur_expide) {
    Optional<Livreur_Expide> Livreur_ExpideData = service.getAllLivreursAndBonliv2(id_expide);

    if (Livreur_ExpideData.isPresent()) {
        Livreur_Expide _Livreur_Expide = Livreur_ExpideData.get();

        _Livreur_Expide.setId_expide(livreur_expide.getId_expide());
        _Livreur_Expide.setId_livreur(livreur_expide.getId_livreur());
        _Livreur_Expide.setBonLiv(livreur_expide.getBonLiv());
        _Livreur_Expide.setMatricule(livreur_expide.getMatricule());

        return new ResponseEntity<>(service.updateLivreur_Expide(_Livreur_Expide), HttpStatus.OK);
    } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}  
}
