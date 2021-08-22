package com.loizenai.jwtauthentication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.loizenai.jwtauthentication.model.Achats;
import com.loizenai.jwtauthentication.repository.AchatsRepository;
import com.loizenai.jwtauthentication.services.AchatsService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class AchatsController {
      
    
    @Autowired
    private AchatsService service;

    @Autowired
    AchatsRepository repository;

    @GetMapping("/achatss")
    public ResponseEntity<List<Achats>> getAllAchatss() {
        List<Achats> achats = new ArrayList<>();
        try {
            service.getAchatss().forEach(achats::add);

            if (achats.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(achats, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/achatss/{numDocAchat}")
    public ResponseEntity<Achats> getAchatsById(@PathVariable("numDocAchat") long numDocAchat) {
        Optional<Achats> achatsData = repository.findById(numDocAchat);

        if (achatsData.isPresent()) {
            return new ResponseEntity<>(achatsData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**select list add */
    @GetMapping(value = "/bonPreps/AllListAchats")
    public ResponseEntity<List<Achats>> getAchatsOfAddPrep() {
        try {
            List<Achats> AchatsAllList = service.getAchatsOfAddPrep();

            if (AchatsAllList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);   /** pour afficher les Achats drop list */
            }
            return new ResponseEntity<>(AchatsAllList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    /*  
    @PutMapping(value = "/achatss/Valider/{numDocAchat}")
    public ResponseEntity<Achats> ChangeAchatToValidate(@PathVariable("numDocAchat") long numDocAchat) {
        Optional<Achats> achatsData = repository.findById(numDocAchat);

        if (achatsData.isPresent()) {
            Achats _achats = achatsData.get();
            
            _achats.setValidation(Achats.VALIDATION.valider);
            
            return new ResponseEntity<>(service.updateAchats(_achats), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/achatss/NotValider/{numDocAchat}")
    public ResponseEntity<Achats> ChangeAchatToNotValidate(@PathVariable("numDocAchat") long numDocAchat) {
        Optional<Achats> achatsData = repository.findById(numDocAchat);

        if (achatsData.isPresent()) {
            Achats _achats = achatsData.get();
            _achats.setValidation(Achats.VALIDATION.non_valider);
            
            return new ResponseEntity<>(service.updateAchats(_achats), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    } 
*/
@Transactional
@GetMapping("/achatss/NotValider/{numDocAchat}")
public void ChangeAchatToNotValidate(@PathVariable("numDocAchat") Long numDocAchat) {
    service.ChangeAchatToNotValidate(numDocAchat); 
}
@Transactional
@GetMapping("/achatss/Valider/{numDocAchat}")
public void ChangeAchatToValidate(@PathVariable("numDocAchat") Long numDocAchat) {
    service.ChangeAchatToValidate(numDocAchat); 
}
/**select list add */

/**select list add */
@GetMapping(value = "/achatss/dateBetween/{startDate}to{endDate}")
public ResponseEntity<List<Achats>> getAllAchatsBydateBetween(@PathVariable String startDate,@PathVariable String endDate) {
    try {
        List<Achats> AchatsByDateBetween= service.getAllAchatsBydateBetween(startDate,endDate);

        if (AchatsByDateBetween.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);     /** pour afficher les bon preparation entre 2 date */
        }
        return new ResponseEntity<>(AchatsByDateBetween, HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }
}




      /**  statistique  Pie Affaire */ 

      @GetMapping("/achatss/SumP1")
      public ResponseEntity<Optional<Integer>> getSumP1() {
          try {
            Optional<Integer> SumP1 = service.getSumP1();  /** pour get Sum Quantité de Livraison */
              if (SumP1.isEmpty()) {
                  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
              }
              return new ResponseEntity<>(SumP1, HttpStatus.OK);
          } catch (Exception e) {
              return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
          }
      }
      @GetMapping("/achatss/SumP2")
      public ResponseEntity<Optional<Integer>> getSumP2() {
          try {
            Optional<Integer> SumP2 = service.getSumP2();  /** pour get Sum Quantité de Livraison */
              if (SumP2.isEmpty()) {
                  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
              }
              return new ResponseEntity<>(SumP2, HttpStatus.OK);
          } catch (Exception e) {
              return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
          }
      }
      @GetMapping("/achatss/SumV1")
      public ResponseEntity<Optional<Integer>> getSumV1() {
          try {
            Optional<Integer> SumV1 = service.getSumV1();  /** pour get Sum Quantité de Livraison */
              if (SumV1.isEmpty()) {
                  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
              }
              return new ResponseEntity<>(SumV1, HttpStatus.OK);
          } catch (Exception e) {
              return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
          }
      }
      @GetMapping("/achatss/SumV2")
      public ResponseEntity<Optional<Integer>> getSumV2() {
          try {
            Optional<Integer> SumV2 = service.getSumV2();  /** pour get Sum Quantité de Livraison */
              if (SumV2.isEmpty()) {
                  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
              }
              return new ResponseEntity<>(SumV2, HttpStatus.OK);
          } catch (Exception e) {
              return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
          }
      }

      



                  /**  statistique  Bar achats */ 

            @GetMapping("/achatss/SumBar1")
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
            @GetMapping("/achatss/SumBar2")
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
            @GetMapping("/achatss/SumBar3")
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
            @GetMapping("/achatss/SumBar4")
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
            @GetMapping("/achatss/SumBar5")
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
            @GetMapping("/achatss/SumBar6")
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
            @GetMapping("/achatss/SumBar7")
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
}
