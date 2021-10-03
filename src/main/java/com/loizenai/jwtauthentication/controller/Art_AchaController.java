package com.loizenai.jwtauthentication.controller;

import java.util.ArrayList;
import java.util.List;

import com.loizenai.jwtauthentication.model.ArtAcha;
import com.loizenai.jwtauthentication.repository.Art_AchaRepository;
import com.loizenai.jwtauthentication.services.Art_AchaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class Art_AchaController {

    @Autowired
    Art_AchaService service;
    
    @Autowired
    Art_AchaRepository repository;


    @GetMapping("/artachas")
    public ResponseEntity<List<ArtAcha>> getAllArtAchats() {
        List<ArtAcha> artAchas = new ArrayList<>();
        try {
            service.getBonLivs().forEach(artAchas::add);

            if (artAchas.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(artAchas, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/artachas/{id}")
    public ResponseEntity<ArtAcha> getArtAchaById(@PathVariable("id") long id) {
        Optional<ArtAcha> artAchaData = repository.findById(id);

        if (artAchaData.isPresent()) {
            return new ResponseEntity<>(artAchaData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/achatss/DetailsArtAchaByAchats/{num_doc}")
    public ResponseEntity<List<ArtAcha>> getAllArtAchaByNumDocAchats(@PathVariable("num_doc") String num_doc) {
        try {
            List<ArtAcha> ArtAchaByDocAchats = service.getAllArtAchaByNumDocAchats(num_doc);

            if (ArtAchaByDocAchats.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);     /** pour afficher les numereau facutrure ilkoll */
            }
            return new ResponseEntity<>(ArtAchaByDocAchats, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    //searsh with FK_keys******************


@GetMapping("/achatss/DetailsArtAcha/{num_doc_achat}")
public ResponseEntity<List<ArtAcha>> getArtAchaForAchats(@PathVariable String num_doc_achat) {
    try {
        List<ArtAcha> ArtAchaDetail= service.getArtAchaForAchats(num_doc_achat);  /** pour afficher les detail de Achats*/

        if (ArtAchaDetail.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(ArtAchaDetail, HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }
} 


// end for the searsh of FK_Keys*******************



    @PutMapping("/artachas/QutNonTrouver/{id}")
    public ResponseEntity<ArtAcha> updateBonPrepPrix(@PathVariable("id") long id, @RequestBody ArtAcha artacha) {
        System.out.println("faaaaaaaa");
        Optional<ArtAcha> artAchaData = repository.findById(id);

        if (artAchaData.isPresent()) {
            ArtAcha _artacha = artAchaData.get();
            
            _artacha.setQutNonTrouver(artacha.getQutNonTrouver());
            
            return new ResponseEntity<>(service.updateArtAcha(_artacha), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }   
}