package com.loizenai.jwtauthentication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.loizenai.jwtauthentication.model.livreurs_primes;
import com.loizenai.jwtauthentication.repository.livreurs_primesRepository;
import com.loizenai.jwtauthentication.services.livreurs_primesService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class Livreurs_PrimesConroller {
   
    
    @Autowired
    private livreurs_primesService service;

    @Autowired
    livreurs_primesRepository repository;
    
    @GetMapping("/livreurs_primes")
    public ResponseEntity<List<livreurs_primes>> getAlllivreurs_primes() {
        List<livreurs_primes> Livreur_Prime = new ArrayList<>();
        try {
            service.getLivreurs_Primes().forEach(Livreur_Prime::add);

            if (Livreur_Prime.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(Livreur_Prime, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/livreurs_primes/{id_livreur_prime}")
    public ResponseEntity<livreurs_primes> getLivreur_PrimeById(@PathVariable("id_livreur_prime") long id_livreur_prime) {
        Optional<livreurs_primes> Livreur_PrimeData = repository.findById(id_livreur_prime);

        if (Livreur_PrimeData.isPresent()) {
            return new ResponseEntity<>(Livreur_PrimeData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/livreurs_primes")
    public ResponseEntity<livreurs_primes> postLivreurs_Primes(@RequestBody livreurs_primes livreurs_primes) {
        try {
            service.addLivreur_Prime(livreurs_primes);
            return new ResponseEntity<>(livreurs_primes, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @DeleteMapping("/livreurs_primes/{id_livreur_prime}")
    public ResponseEntity<HttpStatus> deleteLivreur_Prime(@PathVariable("id_livreur_prime") long id_livreur_prime) {
        try {
            service.deleteLivreur_Prime(id_livreur_prime);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

// end for the searsh of FK_Keys*******************


// end for the searsh of FK_Keys*******************

@PutMapping("/livreurs_primes/{id_livreur_prime}")
public ResponseEntity<livreurs_primes> updateLivreurs_Primes(@PathVariable("id_livreur_prime") long id_livreur_prime, @RequestBody livreurs_primes livreurs_primes) {
    Optional<livreurs_primes> Livreur_PrimeData = repository.findById(id_livreur_prime);

    if (Livreur_PrimeData.isPresent()) {
        livreurs_primes _Livreur_Prime = Livreur_PrimeData.get();

        _Livreur_Prime.setId_livreur(livreurs_primes.getId_livreur());
        _Livreur_Prime.setId_prime(livreurs_primes.getId_prime());

        return new ResponseEntity<>(service.updateLivreur_Prime(_Livreur_Prime), HttpStatus.OK);
    } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}     
}
