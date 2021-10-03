package com.loizenai.jwtauthentication.controller;

import com.loizenai.jwtauthentication.model.Prime;
import com.loizenai.jwtauthentication.repository.PrimeRepository;
import com.loizenai.jwtauthentication.services.PrimeService;

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
public class PrimeController {

    @Autowired
    private PrimeService service;

    @Autowired
    PrimeRepository repository;

    @GetMapping("/primes")
    public ResponseEntity<List<Prime>> getAllPrimes() {
        List<Prime> primes = new ArrayList<>();
        try {
            service.getPrimes().forEach(primes::add);

            if (primes.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(primes, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping(value = "/primes/dat_reclamDER_MVTBetween/{startDate}to{endDate}")
    public ResponseEntity<List<Prime>> getAllPrimeDER_MVTBydateBetween(@PathVariable String startDate,@PathVariable String endDate) {
        try {
            List<Prime> BonLivByDateBetween = service.getAllPrimeDER_MVTBydateBetween(startDate,endDate);
    
            if (BonLivByDateBetween.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);   /** pour afficher les bon livraison entre 2 date */
            }
            return new ResponseEntity<>(BonLivByDateBetween, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
    


    @GetMapping("/primes/{id}")
    public ResponseEntity<Prime> getPrimeById(@PathVariable("id") long id) {
        Optional<Prime> primeData = repository.findById(id);

        if (primeData.isPresent()) {
            return new ResponseEntity<>(primeData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/primes")
    public ResponseEntity<Prime> postPrime(@RequestBody Prime prime) {
        try {
            service.addPrime(prime);
            return new ResponseEntity<>(prime, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @DeleteMapping("/primes/{id}")
    public ResponseEntity<HttpStatus> deletePrime(@PathVariable("id") long id) {
        try {
            service.deleteLivreur(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @DeleteMapping("/primes")
    public ResponseEntity<HttpStatus> deleteAllPrimes() {
        try {
            repository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }


/**select list add */

@GetMapping("/primes/primes_livreurs")
public ResponseEntity<List<Long>> getLivs_PrimesOfAdd() {
    try {
        List<Long> primes = service.getLivs_PrimesOfAdd();

        if (primes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(primes, HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }
}

/**select list add */

//searsh with FK_keys******************

@GetMapping("/primes/Prime_Categorie/{cata}")
public ResponseEntity<List<Prime>> getAllPrimeByCategorie(@PathVariable String cata) {
    try {
        List<Prime> PrimeByTyCategorie= service.getAllPrimeByCategorie(cata);  /** pour afficher les prime by categorie  */

        if (PrimeByTyCategorie.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(PrimeByTyCategorie, HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }
}  

@GetMapping("/primes/Prime_Prime/{prime}")
public ResponseEntity<List<Prime>> getAllPrimeByPrime(@PathVariable String prime) {
    try {
        List<Prime> PrimeByTyPrime= service.getAllPrimeByPrime(prime);  /** pour afficher les prime by prime  */

        if (PrimeByTyPrime.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(PrimeByTyPrime, HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }
}  

@GetMapping("/primes/Prime_Bloc/{bloc}")
public ResponseEntity<List<Prime>> getAllPrimeByBloc(@PathVariable String bloc) {
    try {
        List<Prime> PrimeByTyBloc= service.getAllPrimeByBloc(bloc);  /** pour afficher les prime by bloc  */

        if (PrimeByTyBloc.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(PrimeByTyBloc, HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }
}  

@GetMapping("/primes/Prime_Der_Mvt/{d_mvt}")
public ResponseEntity<List<Prime>> getAllPrimeByDerMvt(@PathVariable String d_mvt) {
    try {
        List<Prime> PrimeByTyD_Mvt= service.getAllPrimeByDerMvt(d_mvt);  /** pour afficher les prime by Der_MVT  */

        if (PrimeByTyD_Mvt.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(PrimeByTyD_Mvt, HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }
}  

// end for the searsh of FK_Keys*******************

    @PutMapping("/primes/{id}")
    public ResponseEntity<Prime> updatePrime(@PathVariable("id") long id, @RequestBody Prime prime) {
        Optional<Prime> primeData = repository.findById(id);

        if (primeData.isPresent()) {
            Prime _prime = primeData.get();

            _prime.setRaison(prime.getRaison());
            _prime.setCategorie(prime.getCategorie());
            _prime.setObjMin(prime.getObjMin());
            _prime.setObjMax(prime.getObjMax());
            _prime.setCa(prime.getCa());
            _prime.setCaN1(prime.getCaN1());
            _prime.setDerMvt(prime.getDerMvt());
            _prime.setMort(prime.getMort());
            _prime.setArtSpec(prime.getArtSpec());
            _prime.setPrime(prime.getPrime());
            _prime.setBloc(prime.getBloc());
            _prime.setNbArt(prime.getNbArt());
            _prime.setMarge(prime.getMarge());

            //_prime.setLivreurs(prime.getLivreurs());

            return new ResponseEntity<>(service.updatePrime(_prime), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
