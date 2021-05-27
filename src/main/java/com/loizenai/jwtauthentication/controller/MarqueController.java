package com.loizenai.jwtauthentication.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.loizenai.jwtauthentication.model.Marque;
import com.loizenai.jwtauthentication.repository.MarqueRepository;
import com.loizenai.jwtauthentication.services.MarqueService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class MarqueController {
    
    @Autowired
    private MarqueService service;

    @Autowired
    MarqueRepository repository;

    @GetMapping("/marques")
    public ResponseEntity<List<Marque>> getAllMarques() {
        List<Marque> marques = new ArrayList<>();
        try {
            service.getMarques().forEach(marques::add);

            if (marques.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(marques, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/marques/{id}")
    public ResponseEntity<Marque> getMarquesById(@PathVariable("id") Long id) {
        Optional<Marque> marqueData = repository.findById(id);

        if (marqueData.isPresent()) {
            return new ResponseEntity<>(marqueData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/marques")
    public ResponseEntity<Marque> postMarque(@RequestBody Marque marque) {
        try {
            service.addMarque(marque);
            return new ResponseEntity<>(marque, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @DeleteMapping("/marques/{id}")
    public ResponseEntity<HttpStatus> deleteMarque(@PathVariable("id") Long id) {
        try {
            service.deleteMarque(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

}
