package com.loizenai.jwtauthentication.controller;

import com.loizenai.jwtauthentication.model.BonSort;
import com.loizenai.jwtauthentication.repository.Bon_SortRepository;
import com.loizenai.jwtauthentication.services.Bon_SortService;
import java.util.Date;
import java.math.BigDecimal;
import java.sql.Timestamp;
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
public class Bon_SortController{

    @Autowired
    private Bon_SortService service;

    @Autowired
    Bon_SortRepository repository;

    @GetMapping("/bonSorts")
    public ResponseEntity<List<BonSort>> getAllBonsorts() {
        List<BonSort> bonSorts = new ArrayList<>();
        try {
            service.getBonSorts().forEach(bonSorts::add);

            if (bonSorts.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(bonSorts, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/bonSorts/{NUM_BON}")
    public ResponseEntity<BonSort> getBonSortById(@PathVariable("NUM_BON") String numBon) {
        Optional<BonSort> bonSortData = repository.findById(numBon);

        if (bonSortData.isPresent()) {
            return new ResponseEntity<>(bonSortData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/bonSorts")
    public ResponseEntity<BonSort> postBonSort(@RequestBody BonSort bonSort) {
        try {
            Date date1 = new Date();
            Timestamp timestamp2 = new Timestamp(date1.getTime()+ (1*60*60*1000));
            bonSort.setDatBon(timestamp2);
            System.out.println(timestamp2);
            service.addBonSort(bonSort);
            return new ResponseEntity<>(bonSort, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @DeleteMapping("/bonSorts/{NUM_BON}")
    public ResponseEntity<HttpStatus> deleteBonsort(@PathVariable("NUM_BON") String numBon) {
        try {
            service.deleteBonSort(numBon);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
    @DeleteMapping("/bonSorts")
    public ResponseEntity<HttpStatus> deleteAllBonsorts() {
        try {
            repository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }


    //searsh with FK_keys******************

@GetMapping("/bonSorts/pasSortieDeStock")
public ResponseEntity<List<BonSort>> getBonSortEncoreEnStock() {
    try {
        List<BonSort> BonSortPasCharioter = service.getBonSortEncoreEnStock();  /** pour afficher les bon sortie pas encore sortie de stock */

        if (BonSortPasCharioter.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(BonSortPasCharioter, HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }
}

@GetMapping("/bonSorts/BS_BON_PREP/{numBonprep}")
public ResponseEntity<List<BonSort>> getAllBonSortDeMemeBonPreparation(@PathVariable String numBonprep) {
    try {
        List<BonSort> BonSortDeBonPrep= service.getAllBonSortDeMemeBonPreparation(numBonprep);  /** pour afficher les bon sortie de cette bon de preparation */

        if (BonSortDeBonPrep.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(BonSortDeBonPrep, HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }
}

@GetMapping("/bonSorts/BS_CENTRE/{centre}")
public ResponseEntity<List<BonSort>> getAllBonSortByCentre(@PathVariable String centre) {
    try {
        List<BonSort> BonSortByCentre= service.getAllBonSortByCentre(centre);  /** pour afficher les bon sortie de centre specifique */

        if (BonSortByCentre.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(BonSortByCentre, HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }
}

@GetMapping("/bonSorts/BS_USER_ID/{user_id}")
public ResponseEntity<List<BonSort>> getAllBonSortByUser(@PathVariable long user_id) {
    try {
        List<BonSort> BonSortByUser= service.getAllBonSortByUser(user_id);  /** pour afficher les bon sortie by user */

        if (BonSortByUser.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(BonSortByUser, HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }
}

    @GetMapping(value = "bonSorts/dateBetween/{startDate}to{endDate}")
    public ResponseEntity<List<BonSort>> getAllBonSortBydateBetween(@PathVariable String startDate,@PathVariable String endDate) {
        try {
            List<BonSort> BonSortByDateBetween = service.getAllBonSortBydateBetween(startDate,endDate);

            if (BonSortByDateBetween.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);    /** pour afficher les bon sortie entre 2 date */
            }
            return new ResponseEntity<>(BonSortByDateBetween, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }






    @GetMapping(value = "bonSorts/vehicule/{VEHICULE}")
    public ResponseEntity<List<BonSort>> findByVehicule(@PathVariable String vehicule) {
        try {
            List<BonSort> bonsorts = repository.findByVehicule(vehicule);

            if (bonsorts.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(bonsorts, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

//searsh with FK_keys******************

    @PutMapping("/bonSorts/{NUM_BON}")
    public ResponseEntity<BonSort> updateBonSort(@PathVariable("NUM_BON") String numBon, @RequestBody BonSort bonsort) {
        Optional<BonSort> bonSortData = repository.findById(numBon);
        
        if (bonSortData.isPresent()) {
            BonSort _bonSort = bonSortData.get();
            _bonSort.setDatBon(bonsort.getDatBon());
            _bonSort.setRaison(bonsort.getRaison());
            _bonSort.setBrutHt(bonsort.getBrutHt());
            _bonSort.setTauxRem(bonsort.getTauxRem());
            _bonSort.setMontRem(bonsort.getMontRem());
            _bonSort.setNetHt(bonsort.getNetHt());
            _bonSort.setMontTva(bonsort.getMontTva());
            _bonSort.setTotTtc(bonsort.getTotTtc());
            _bonSort.setXbase1(bonsort.getXbase1());
            _bonSort.setXbase2(bonsort.getXbase2());
            _bonSort.setXbase3(bonsort.getXbase3());
            _bonSort.setXbase4(bonsort.getXbase4());
            _bonSort.setXbase5(bonsort.getXbase5());
            _bonSort.setXtva1(bonsort.getXtva1());
            _bonSort.setXtva2(bonsort.getXtva2());
            _bonSort.setXtva3(bonsort.getXtva3());
            _bonSort.setXtva4(bonsort.getXtva4());
            _bonSort.setCentre(bonsort.getCentre());
            _bonSort.setObserv(bonsort.getObserv());
            _bonSort.setPoste(bonsort.getPoste());
            _bonSort.setVehicule(bonsort.getVehicule());
            
            //_bonSort.setBonprep_bonsort(bonsort.getBonprep_bonsort());
            //_bonSort.setChariot_bonsort(bonsort.getChariot_bonsort());
            _bonSort.setUser(bonsort.getUser());
            return new ResponseEntity<>(service.updateBonSort(_bonSort), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/bonSorts/Prix/{numBon}")
    public ResponseEntity<BonSort> updateBonSortPrix(@PathVariable("numBon") String numBon, @RequestBody BonSort bonSort) {
        Optional<BonSort> bonSortData = repository.findById(numBon);

        if (bonSortData.isPresent()) {
            BonSort _bonSort = bonSortData.get();
            System.out.println(bonSort.getBrutHt());
            System.out.println(_bonSort.getTotTtc());
            _bonSort.setBrutHt(bonSort.getBrutHt());
            _bonSort.setTotTtc(bonSort.getTotTtc());

            return new ResponseEntity<>(service.updateBonSort(_bonSort), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    } 
}