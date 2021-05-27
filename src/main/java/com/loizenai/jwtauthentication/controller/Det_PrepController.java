package com.loizenai.jwtauthentication.controller;

import com.loizenai.jwtauthentication.model.DetPrep;
import com.loizenai.jwtauthentication.repository.Det_PrepRepository;
import com.loizenai.jwtauthentication.services.Det_EmbaService;
import com.loizenai.jwtauthentication.services.Det_PrepService;

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
public class Det_PrepController {


    @Autowired
    private Det_PrepService service;

    @Autowired
    Det_PrepRepository repository;

    @GetMapping("/detPreps")
    public ResponseEntity<List<DetPrep>> getAllDetpreps() {
        List<DetPrep> detPreps = new ArrayList<>();
        try {
            service.getDetPreps().forEach(detPreps::add);

            if (detPreps.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(detPreps, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/detPreps/{id}")
    public ResponseEntity<DetPrep> getDetPrepById(@PathVariable("id") long id) {
        Optional<DetPrep> detPrepData = repository.findById(id);

        if (detPrepData.isPresent()) {
            return new ResponseEntity<>(detPrepData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/detPreps")
    public ResponseEntity<DetPrep> postDetprep(@RequestBody DetPrep detPrep) {
        try {
            service.addDetPrep(detPrep);
            return new ResponseEntity<>(detPrep, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @DeleteMapping("/detPreps/{id}")
    public ResponseEntity<HttpStatus> deleteDetprep(@PathVariable("id") long id) {
        try {
            service.deleteDetPrep(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @DeleteMapping("/detPreps")
    public ResponseEntity<HttpStatus> deleteAllDetPreps() {
        try {
            repository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

//searsh with FK_keys******************
/*
    @GetMapping(value = "detPreps/zone/{ZONE}")
    public ResponseEntity<List<DetPrep>> findByZone(@PathVariable String zone) {
        try {
            List<DetPrep> detpreps = repository.findByZone(zone);

            if (detpreps.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(detpreps, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
*/
@GetMapping("/detPreps/detPrep_Zone/{zone}")
public ResponseEntity<List<DetPrep>> getAllDetPrepByZone(@PathVariable String zone) {
    try {
        List<DetPrep> detPrepByZone= service.getAllDetPrepByZone(zone);  /** pour afficher les detail preparation by Zone */

        if (detPrepByZone.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(detPrepByZone, HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }
}

@GetMapping("/detPreps/detPrep_Preparateur/{preparateur}")
public ResponseEntity<List<DetPrep>> getAllDetPrepByPrepara(@PathVariable String preparateur) {
    try {
        List<DetPrep> detPrepByPrepara = service.getAllDetPrepByPrepara(preparateur);  /** pour afficher les detail preparation by Preparateur */

        if (detPrepByPrepara.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(detPrepByPrepara, HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }
}

@GetMapping("/detPreps/detPrep_idprepra/{idprepra}")
public ResponseEntity<List<DetPrep>> getAllDetPrepByBonPrep(@PathVariable String idprepra) {
    try {
        List<DetPrep> detPrepBybonPrep = service.getAllDetPrepByBonPrep(idprepra);  /** pour afficher les detail preparation by bon preparation */

        if (detPrepBybonPrep.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(detPrepBybonPrep, HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }
}


// end for the searsh of FK_Keys*******************

    @PutMapping("/detPreps/{id}")
    public ResponseEntity<DetPrep> updateDetPrep(@PathVariable("id") long id, @RequestBody DetPrep detprep) {
        Optional<DetPrep> detPrepData = repository.findById(id);

        if (detPrepData.isPresent()) {
            DetPrep _detPrep = detPrepData.get();

            _detPrep.setZone(detprep.getZone());
            _detPrep.setPrepara(detprep.getPrepara());


            return new ResponseEntity<>(service.updateDetPrep(_detPrep), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
