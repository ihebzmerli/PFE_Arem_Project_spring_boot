package com.loizenai.jwtauthentication.controller;

import java.util.ArrayList;
import java.util.List;

import com.loizenai.jwtauthentication.model.Fournis;
import com.loizenai.jwtauthentication.repository.FournisRepository;
import com.loizenai.jwtauthentication.services.FournisService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class FournisController {
    
    @Autowired
    private FournisService service;

    @Autowired
    FournisRepository repository;

    @GetMapping("/fournis")
    public ResponseEntity<List<Fournis>> getFourniss() {
        List<Fournis> fournis = new ArrayList<>();
        try {
            service.getFourniss().forEach(fournis::add);

            if (fournis.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(fournis, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/fournis/{COD_FRS}")
    public ResponseEntity<Fournis> getFournisByCodFrs(@PathVariable("COD_FRS") long codFrs) {
        Optional<Fournis> fournisData = repository.findById(codFrs);

        if (fournisData.isPresent()) {
            return new ResponseEntity<>(fournisData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
/**select list add */

    @GetMapping("/bonSorts/cod_frs")
    public ResponseEntity<List<Long>> getFournisOfAdd() {
        try {
            List<Long> fourniss = service.getFournisOfAdd();

            if (fourniss.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(fourniss, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

/**select list add */

//searsh with FK_keys******************

}
