package com.loizenai.jwtauthentication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.loizenai.jwtauthentication.model.ArtTerm;
import com.loizenai.jwtauthentication.repository.Art_TermRepository;
import com.loizenai.jwtauthentication.services.Art_TermService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class Art_TermController {
    
    
    @Autowired
    private Art_TermService service;

    @Autowired
    Art_TermRepository repository;

    @GetMapping("/artTerms")
    public ResponseEntity<List<ArtTerm>> getAllArtTerms() {
        List<ArtTerm> artTerms = new ArrayList<>();
        try {
            service.getArtTerms().forEach(artTerms::add);
            if (artTerms.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(artTerms, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/artTerms/{numBonFac}")
    public ResponseEntity<ArtTerm> getArtTermById(@PathVariable("numBonFac") String id) {
        Optional<ArtTerm> artTermData = repository.findById(id);

        if (artTermData.isPresent()) {
            return new ResponseEntity<>(artTermData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/artTerms")
    public ResponseEntity<ArtTerm> postArtTerm(@RequestBody ArtTerm artTerm) {
        try {
            service.addArtTerm(artTerm);
            return new ResponseEntity<>(artTerm, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @DeleteMapping("/artTerms/{numBonFac}")
    public ResponseEntity<HttpStatus> deleteArtTerm(@PathVariable("numBonFac") String id) {
        try {
            service.deleteArtTerm(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @DeleteMapping("/artTerms")
    public ResponseEntity<HttpStatus> deleteAllArtTerms() {
        try {
            repository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    //searsh with FK_keys******************

    @GetMapping("/bonLivs/DetailsArtTerm/{num_bon_liv}")
    public ResponseEntity<List<ArtTerm>> getArtTermForBonLiv(@PathVariable String num_bon_liv) {
    try {
        List<ArtTerm> ArtTermDetail= service.getArtTermForBonLiv(num_bon_liv);  /** pour afficher les detail de bon Liv*/

        if (ArtTermDetail.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(ArtTermDetail, HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }
} 

    // end for the searsh of FK_Keys*******************
    @PutMapping("/artTerms/{numBonFac}")
    public ResponseEntity<ArtTerm> updateArtTerm(@PathVariable("numBonFac") String id, @RequestBody ArtTerm artTerm) {
        Optional<ArtTerm> etatLivData = repository.findById(id);

        if (etatLivData.isPresent()) {
            ArtTerm _artTerm = etatLivData.get();

            _artTerm.setNumBonFac(artTerm.getNumBonFac());


            _artTerm.setDate(artTerm.getDate());

            return new ResponseEntity<>(service.updateArtTerm(_artTerm), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
