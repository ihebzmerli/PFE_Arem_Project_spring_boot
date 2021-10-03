package com.loizenai.jwtauthentication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.loizenai.jwtauthentication.model.Vehicule;
import com.loizenai.jwtauthentication.repository.VehiculeRepository;
import com.loizenai.jwtauthentication.services.VehiculeService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class VehiculeController {
  
    
    @Autowired
    private VehiculeService service;

    @Autowired
    VehiculeRepository repository;

    @GetMapping("/vehicules")
    public ResponseEntity<List<Vehicule>> getAllVehicules() {
        List<Vehicule> vehicules = new ArrayList<>();
        try {
            service.getVehicules().forEach(vehicules::add);

            if (vehicules.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(vehicules, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/vehicules/{matricule}")
    public ResponseEntity<Vehicule> getVehiculesById(@PathVariable("matricule") String matricule) {
        Optional<Vehicule> vehiculeData = repository.findById(matricule);

        if (vehiculeData.isPresent()) {
            return new ResponseEntity<>(vehiculeData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/vehicules")
    public ResponseEntity<Vehicule> postVehicule(@RequestBody Vehicule vehicule) {
        try {
            service.addVehicule(vehicule);
            return new ResponseEntity<>(vehicule, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }
    /**DATE FILTER  */

    @GetMapping(value = "/vehicules/DT_ACQBetween/{startDate}to{endDate}")
    public ResponseEntity<List<Vehicule>> getAllVehiculeDT_ACQBydateBetween(@PathVariable String startDate,@PathVariable String endDate) {
        try {
            List<Vehicule> BonLivByDateBetween = service.getAllVehiculeDT_ACQBydateBetween(startDate,endDate);
    
            if (BonLivByDateBetween.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);   /** pour afficher les bon livraison entre 2 date */
            }
            return new ResponseEntity<>(BonLivByDateBetween, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping(value = "/vehicules/t1mc2Between/{startDate}to{endDate}")
    public ResponseEntity<List<Vehicule>> getAllVehiculedt1mc2BydateBetween(@PathVariable String startDate,@PathVariable String endDate) {
        try {
            List<Vehicule> BonLivByDateBetween = service.getAllVehiculedt1mc2BydateBetween(startDate,endDate);
    
            if (BonLivByDateBetween.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);   /** pour afficher les bon livraison entre 2 date */
            }
            return new ResponseEntity<>(BonLivByDateBetween, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
    @GetMapping(value = "/vehicules/dt1mcBetween/{startDate}to{endDate}")
    public ResponseEntity<List<Vehicule>> getAllVehiculedt1mcBydateBetween(@PathVariable String startDate,@PathVariable String endDate) {
        try {
            List<Vehicule> BonLivByDateBetween = service.getAllVehiculedt1mcBydateBetween(startDate,endDate);
    
            if (BonLivByDateBetween.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);   /** pour afficher les bon livraison entre 2 date */
            }
            return new ResponseEntity<>(BonLivByDateBetween, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
    @GetMapping(value = "/vehicules/dtfassBetween/{startDate}to{endDate}")
    public ResponseEntity<List<Vehicule>> getAllVehiculedtfassBydateBetween(@PathVariable String startDate,@PathVariable String endDate) {
        try {
            List<Vehicule> BonLivByDateBetween = service.getAllVehiculedtfassBydateBetween(startDate,endDate);
    
            if (BonLivByDateBetween.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);   /** pour afficher les bon livraison entre 2 date */
            }
            return new ResponseEntity<>(BonLivByDateBetween, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
    @GetMapping(value = "/vehicules/dtfvisitBetween/{startDate}to{endDate}")
    public ResponseEntity<List<Vehicule>> getAllVehiculedtfvisitBydateBetween(@PathVariable String startDate,@PathVariable String endDate) {
        try {
            List<Vehicule> BonLivByDateBetween = service.getAllVehiculedtfvisitBydateBetween(startDate,endDate);
    
            if (BonLivByDateBetween.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);   /** pour afficher les bon livraison entre 2 date */
            }
            return new ResponseEntity<>(BonLivByDateBetween, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    /**end filter date */
    @DeleteMapping("/vehicules/{matricule}")
    public ResponseEntity<HttpStatus> deleteVehicule(@PathVariable("matricule") String matricule) {
        try {
            service.deleteVehicule(matricule);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @DeleteMapping("/vehicules")
    public ResponseEntity<HttpStatus> deleteAllVehicules() {
        try {
            repository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }

    }
//searsh with FK_keys******************

@GetMapping(value = "/vehicules/couleursV")
public ResponseEntity<List<String>> getCouleurVehicule() {
    try {
        List<String> CouleurV = service.getCouleurVehicule();

        if (CouleurV.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);     /** get couleur*/
        }
        return new ResponseEntity<>(CouleurV, HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }
}
// end for the searsh of FK_Keys*******************

    @PutMapping("/vehicules/{matricule}")
    public ResponseEntity<Vehicule> updateVehicule(@PathVariable("matricule") String matricule, @RequestBody Vehicule vehicule) {
        Optional<Vehicule> vehiculeData = repository.findById(matricule);

        if (vehiculeData.isPresent()) {
            Vehicule _vehicule = vehiculeData.get();
            
            _vehicule.setMatAgent(vehicule.getMatAgent());
            _vehicule.setMarque(vehicule.getMarque());
            _vehicule.setModel(vehicule.getModel());
            _vehicule.setCouleur(vehicule.getCouleur());
            _vehicule.setDt1Mc(vehicule.getDt1Mc());
            _vehicule.setDtAcq(vehicule.getDtAcq());
            _vehicule.setPattc(vehicule.getPattc());
            _vehicule.setEss(vehicule.getEss());
            _vehicule.setDtFAss(vehicule.getDtFAss());
            _vehicule.setDtFVisit(vehicule.getDtFVisit());
            _vehicule.setKmCour(vehicule.getKmCour());
            _vehicule.setDrKmVida(vehicule.getDrKmVida());
            _vehicule.setDrKmCh(vehicule.getDrKmCh());
            _vehicule.setObservation(vehicule.getObservation());
            _vehicule.setTonnage(vehicule.getTonnage());
            _vehicule.setDt1Mc2(vehicule.getDt1Mc2());

            return new ResponseEntity<>(service.updateVehicule(_vehicule), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }  

/**select list add */
    @GetMapping(value = "/expides/AllListVehicule")
    public ResponseEntity<List<Vehicule>> getVehiculeOfAdd() {
        try {
            List<Vehicule> VehiculeAllList = service.getVehiculeOfAdd();

            if (VehiculeAllList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);   /** pour afficher les vehicule drop list */
            }
            return new ResponseEntity<>(VehiculeAllList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
/**select list add */
}