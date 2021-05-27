package com.loizenai.jwtauthentication.controller;

import com.loizenai.jwtauthentication.model.DetEmba;
import com.loizenai.jwtauthentication.repository.Det_EmbaRepository;
import com.loizenai.jwtauthentication.services.Det_EmbaService;

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
public class Det_EmbaController {

    @Autowired
    private Det_EmbaService service;

    @Autowired
    Det_EmbaRepository repository;

    @GetMapping("/detEmbas")
    public ResponseEntity<List<DetEmba>> getAllDetembas() {
        List<DetEmba> detEmbas = new ArrayList<>();
        try {
            service.getDetEmbas().forEach(detEmbas::add);
            
            if (detEmbas.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(detEmbas, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/detEmbas/{id}")
    public ResponseEntity<DetEmba> getDetEmbaById(@PathVariable("id") long id) {
        Optional<DetEmba> detEmbaData = repository.findById(id);
        if (detEmbaData.isPresent()) {
            return new ResponseEntity<>(detEmbaData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/detEmbas")
    public ResponseEntity<DetEmba> postDetemba(@RequestBody DetEmba detEmba) {
        try {
            service.addDetEmba(detEmba);
            return new ResponseEntity<>(detEmba, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @DeleteMapping("/detEmbas/{id}")
    public ResponseEntity<HttpStatus> deleteDetemba(@PathVariable("id") long id) {
        try {
            service.deleteDetEmba(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @DeleteMapping("/detEmbas")
    public ResponseEntity<HttpStatus> deleteAllDetEmbas() {
        try {
            repository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    //searsh with FK_keys******************
/*
    @GetMapping(value = "detEmbas/num_bon/{NUM_BON}")
    public ResponseEntity<List<DetEmba>> findByNumBon(@PathVariable String numBon) {
        try {
            List<DetEmba> detembas = repository.findByNumBon(numBon);

            if (detembas.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(detembas, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
*/



@GetMapping("/detEmbas/detEmbas_Nbon_prep/{Nbon_prep}")
public ResponseEntity<List<DetEmba>> getAllDetEmbaByBPrep(@PathVariable String Nbon_prep) {
    try {
        List<DetEmba> detembaByPrep= service.getAllDetEmbaByBPrep(Nbon_prep);  /** pour afficher les bon preparation by dembalage */

        if (detembaByPrep.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(detembaByPrep, HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }
}

@GetMapping("/detEmbas/detEmbas_Id_ArtLiv/{idArtliv}")
public ResponseEntity<List<DetEmba>> getAllDetEmbaByArtLiv(@PathVariable String idArtliv) {
    try {
        List<DetEmba> detembaByArticle= service.getAllDetEmbaByArtLiv(idArtliv);  /** pour afficher les ArtLiv by dembalage */

        if (detembaByArticle.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(detembaByArticle, HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }
}
// end for the searsh of FK_Keys*******************

    @PutMapping("/detEmbas/{id}")
    public ResponseEntity<DetEmba> updateDetEmba(@PathVariable("id") long id, @RequestBody DetEmba detemba) {
        Optional<DetEmba> detEmbaData = repository.findById(id);

        if (detEmbaData.isPresent()) {
            DetEmba _detEmba = detEmbaData.get();

            _detEmba.setNum(detemba.getNum());
            _detEmba.setQut(detemba.getQut());
            return new ResponseEntity<>(service.updateDetEmba(_detEmba), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
