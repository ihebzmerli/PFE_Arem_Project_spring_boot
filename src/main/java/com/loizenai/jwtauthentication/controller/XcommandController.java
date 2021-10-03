package com.loizenai.jwtauthentication.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.loizenai.jwtauthentication.model.Xcommand;
import com.loizenai.jwtauthentication.repository.XcommandRepository;
import com.loizenai.jwtauthentication.services.XcommandService;

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

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class XcommandController {
    

        
    @Autowired
    private XcommandService service;

    @Autowired
    XcommandRepository repository;


    @GetMapping("/Xcommands")
    public ResponseEntity<List<Xcommand>> getAllXcommands() {
        List<Xcommand> xcommands = new ArrayList<>();
        try {
            service.getXcommands().forEach(xcommands::add);

            if (xcommands.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(xcommands, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/Xcommands/{NUM_COM}")
    public ResponseEntity<Xcommand> getBonprepById(@PathVariable("NUM_COM") long numCom) {
        Optional<Xcommand> bonPrepData = repository.findById(numCom);

        if (bonPrepData.isPresent()) {
            return new ResponseEntity<>(bonPrepData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



@GetMapping(value = "/Xcommands/BlNull")
public ResponseEntity<List<Xcommand>> getXcommandBlNull() {
    try {
        List<Xcommand> CouleurV = service.getXcommandBlNull();

        if (CouleurV.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);     
        }
        return new ResponseEntity<>(CouleurV, HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }
}
    

@PutMapping("/Xcommands/{NUM_COM}")
public ResponseEntity<Xcommand> updateXcommands(@PathVariable("NUM_COM") long numCom, @RequestBody Xcommand xcommand) throws InterruptedException {
    Optional<Xcommand> xcommandData = repository.findById(numCom);
        if (xcommandData.isPresent()) {
            Xcommand _xcommand = xcommandData.get();
            
                _xcommand.setTraite("YES");
                
                
                return new ResponseEntity<>(service.updateXcommand(_xcommand), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
    }
}
