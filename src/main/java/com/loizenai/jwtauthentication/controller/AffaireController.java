package com.loizenai.jwtauthentication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.loizenai.jwtauthentication.model.Affaire;
import com.loizenai.jwtauthentication.repository.AffaireRepository;
import com.loizenai.jwtauthentication.services.AffaireService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class AffaireController {
      
    
    @Autowired
    private AffaireService service;

    @Autowired
    AffaireRepository repository;

    @GetMapping("/affaires")
    public ResponseEntity<List<Affaire>> getAllAffaires() {
        List<Affaire> affaires = new ArrayList<>();
        try {
            service.getAffaires().forEach(affaires::add);

            if (affaires.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(affaires, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/affaires/{numAff}")
    public ResponseEntity<Affaire> getAffairesById(@PathVariable("numAff") long numAff) {
        Optional<Affaire> affaireData = repository.findById(numAff);

        if (affaireData.isPresent()) {
            return new ResponseEntity<>(affaireData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**select list add */
    @GetMapping(value = "/bonSorts/AllListAffaires")
    public ResponseEntity<List<Affaire>> getAffairesOfAddPrep() {
        try {
            List<Affaire> AffaireAllList = service.getAffairesOfAddPrep();

            if (AffaireAllList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);   /** pour afficher les Affaire drop list */
            }
            return new ResponseEntity<>(AffaireAllList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
/**select list add */
@GetMapping(value = "/affaires/DAT_AFFdateBetween/{startDate}to{endDate}")
public ResponseEntity<List<Affaire>> getAllAffaireDAT_AFFBydateBetween(@PathVariable String startDate,@PathVariable String endDate) {
    try {
        List<Affaire> AffaireByDateBetween= service.getAllAffaireDAT_AFFBydateBetween(startDate,endDate);

        if (AffaireByDateBetween.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);     /** pour afficher les bon preparation entre 2 date */
        }
        return new ResponseEntity<>(AffaireByDateBetween, HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }
}

@GetMapping(value = "/affaires/DAT_PROFdateBetween/{startDate}to{endDate}")
public ResponseEntity<List<Affaire>> getAllAffaireDAT_PROFBydateBetween(@PathVariable String startDate,@PathVariable String endDate) {
    try {
        List<Affaire> AffaireByDateBetween= service.getAllAffaireDAT_PROFBydateBetween(startDate,endDate);

        if (AffaireByDateBetween.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);     /** pour afficher les bon preparation entre 2 date */
        }
        return new ResponseEntity<>(AffaireByDateBetween, HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }
}
@GetMapping(value = "/affaires/DAT_CONFdateBetween/{startDate}to{endDate}")
public ResponseEntity<List<Affaire>> getAllAffaireDAT_CONFBydateBetween(@PathVariable String startDate,@PathVariable String endDate) {
    try {
        List<Affaire> AffaireByDateBetween= service.getAllAffaireDAT_CONFBydateBetween(startDate,endDate);

        if (AffaireByDateBetween.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);     /** pour afficher les bon preparation entre 2 date */
        }
        return new ResponseEntity<>(AffaireByDateBetween, HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }
}
@GetMapping(value = "/affaires/DAT_TRANSFdateBetween/{startDate}to{endDate}")
public ResponseEntity<List<Affaire>> getAllAffaireDAT_TRANSFBydateBetween(@PathVariable String startDate,@PathVariable String endDate) {
    try {
        List<Affaire> AffaireByDateBetween= service.getAllAffaireDAT_TRANSFBydateBetween(startDate,endDate);

        if (AffaireByDateBetween.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);     /** pour afficher les bon preparation entre 2 date */
        }
        return new ResponseEntity<>(AffaireByDateBetween, HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }
}
@GetMapping(value = "/affaires/DAT_ANALdateBetween/{startDate}to{endDate}")
public ResponseEntity<List<Affaire>> getAllAffaireDAT_ANALBydateBetween(@PathVariable String startDate,@PathVariable String endDate) {
    try {
        List<Affaire> AffaireByDateBetween= service.getAllAffaireDAT_ANALBydateBetween(startDate,endDate);

        if (AffaireByDateBetween.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);     /** pour afficher les bon preparation entre 2 date */
        }
        return new ResponseEntity<>(AffaireByDateBetween, HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }
}
@GetMapping(value = "/affaires/DAT_FACdateBetween/{startDate}to{endDate}")
public ResponseEntity<List<Affaire>> getAllAffaireDAT_FACBydateBetween(@PathVariable String startDate,@PathVariable String endDate) {
    try {
        List<Affaire> AffaireByDateBetween= service.getAllAffaireDAT_FACBydateBetween(startDate,endDate);

        if (AffaireByDateBetween.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);     /** pour afficher les bon preparation entre 2 date */
        }
        return new ResponseEntity<>(AffaireByDateBetween, HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }
}


            /**  statistique  Bar affaires */ 

            @GetMapping("/affaires/SumBar1")
            public ResponseEntity<Optional<Float>> getSumBar1() {
                try {
                    Optional<Float> SumBar1 = service.getSumBar1();  /** pour get Sum Quantité de Livraison */
                    if (SumBar1.isEmpty()) {
                        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                    }
                    return new ResponseEntity<>(SumBar1, HttpStatus.OK);
                } catch (Exception e) {
                    return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
                }
            }
            @GetMapping("/affaires/SumBar2")
            public ResponseEntity<Optional<Float>> getSumBar2() {
                try {
                    Optional<Float> SumBar2 = service.getSumBar2();  /** pour get Sum Quantité de Livraison */
                    if (SumBar2.isEmpty()) {
                        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                    }
                    return new ResponseEntity<>(SumBar2, HttpStatus.OK);
                } catch (Exception e) {
                    return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
                }
            }
            @GetMapping("/affaires/SumBar3")
            public ResponseEntity<Optional<Float>> getSumBar3() {
                try {
                    Optional<Float> SumBar3 = service.getSumBar3();  /** pour get Sum Quantité de Livraison */
                    if (SumBar3.isEmpty()) {
                        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                    }
                    return new ResponseEntity<>(SumBar3, HttpStatus.OK);
                } catch (Exception e) {
                    return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
                }
            }
            @GetMapping("/affaires/SumBar4")
            public ResponseEntity<Optional<Float>> getSumBar4() {
                try {
                    Optional<Float> SumBar4 = service.getSumBar4();  /** pour get Sum Quantité de Livraison */
                    if (SumBar4.isEmpty()) {
                        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                    }
                    return new ResponseEntity<>(SumBar4, HttpStatus.OK);
                } catch (Exception e) {
                    return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
                }
            }
            @GetMapping("/affaires/SumBar5")
            public ResponseEntity<Optional<Float>> getSumBar5() {
                try {
                    Optional<Float> SumBar5 = service.getSumBar5();  /** pour get Sum Quantité de Livraison */
                    if (SumBar5.isEmpty()) {
                        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                    }
                    return new ResponseEntity<>(SumBar5, HttpStatus.OK);
                } catch (Exception e) {
                    return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
                }
            }
            @GetMapping("/affaires/SumBar6")
            public ResponseEntity<Optional<Float>> getSumBar6() {
                try {
                    Optional<Float> SumBar6 = service.getSumBar6();  /** pour get Sum Quantité de Livraison */
                    if (SumBar6.isEmpty()) {
                        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                    }
                    return new ResponseEntity<>(SumBar6, HttpStatus.OK);
                } catch (Exception e) {
                    return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
                }
            }
            @GetMapping("/affaires/SumBar7")
            public ResponseEntity<Optional<Float>> getSumBar7() {
                try {
                    Optional<Float> SumBar7 = service.getSumBar7();  /** pour get Sum Quantité de Livraison */
                    if (SumBar7.isEmpty()) {
                        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                    }
                    return new ResponseEntity<>(SumBar7, HttpStatus.OK);
                } catch (Exception e) {
                    return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
                }
            }
      /**  statistique  Pie Affaire */ 

      @GetMapping("/affaires/SumAvg1")
      public ResponseEntity<List<Long>> getSumAvg1() {
          try {
            List<Long> SumAvg1 = service.getSumAvg1();  /** pour get Sum Quantité de Livraison */
              if (SumAvg1.isEmpty()) {
                  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
              }
              return new ResponseEntity<>(SumAvg1, HttpStatus.OK);
          } catch (Exception e) {
              return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
          }
      }
      @GetMapping("/affaires/SumAvg2")
      public ResponseEntity<List<Float>> getSumAvg2() {
          try {
            List<Float> SumAvg2 = service.getSumAvg2();  /** pour get Sum Quantité de Livraison */
              if (SumAvg2.isEmpty()) {
                  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
              }
              return new ResponseEntity<>(SumAvg2, HttpStatus.OK);
          } catch (Exception e) {
              return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
          }
      }


      


}
