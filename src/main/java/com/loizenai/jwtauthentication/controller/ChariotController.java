package com.loizenai.jwtauthentication.controller;

import com.loizenai.jwtauthentication.model.BonPrep;
import com.loizenai.jwtauthentication.model.Chariot;
import com.loizenai.jwtauthentication.repository.ChariotRepository;
import com.loizenai.jwtauthentication.services.ChariotService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;




@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class ChariotController {

    @Autowired
    private ChariotService service;

    @Autowired
    ChariotRepository repository;

    @GetMapping("/chariots")
    public ResponseEntity<List<Chariot>> getAllChariots() {
        List<Chariot> chariots = new ArrayList<>();
        try {
            service.getChariots().forEach(chariots::add);

            if (chariots.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(chariots, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/chariots/{id}")
    public ResponseEntity<Chariot> getChariotById(@PathVariable("id") long id) {
        Optional<Chariot> chariotData = repository.findById(id);

        if (chariotData.isPresent()) {
            return new ResponseEntity<>(chariotData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/chariots")
    public ResponseEntity<Chariot> postChariot(@RequestBody Chariot chariot) {
        try {
            service.addChariot(chariot);
            return new ResponseEntity<>(chariot, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @DeleteMapping("/chariots/{id}")
    public ResponseEntity<HttpStatus> deleteChariot(@PathVariable("id") long id) {
        try {
            service.deleteChariot(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @DeleteMapping("/chariots")
    public ResponseEntity<HttpStatus> deleteAllChariots() {
        try {
            repository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }

    }

    //searsh with FK_keys******************
/*
    @GetMapping(value = "chariots/num_bon/{NUM_BON}")
    public ResponseEntity<List<Chariot>> findByNumBon(@PathVariable BonPrep numBon) {
        try {
            List<Chariot> chariots = repository.findByNumBon(numBon);

            if (chariots.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(chariots, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    */



@GetMapping("/chariots/chariot_article_ID/{IdArtPrep}")
public ResponseEntity<List<Chariot>> getAllChariotByArticle(@PathVariable String IdArtPrep) {
    try {
        List<Chariot> ChariotByarticle= service.getAllChariotByArticle(IdArtPrep);  /** pour afficher les chariot by Article  */

        if (ChariotByarticle.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(ChariotByarticle, HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }
}

    @GetMapping(value = "/chariots/dateBetween/{startDate}to{endDate}")
    public ResponseEntity<List<Chariot>> getAllChariotBydateBetween(@PathVariable String startDate,@PathVariable String endDate) {
        try {
            List<Chariot> ChariotByDateBetween = service.getAllChariotBydateBetween(startDate,endDate);

            if (ChariotByDateBetween.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);    /** pour afficher les chariot entre 2 date */
            }
            return new ResponseEntity<>(ChariotByDateBetween, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
    @GetMapping("/chariots/LastChariot")
    public ResponseEntity<Optional<Integer>> getLastIdChariot() {
        try {
            Optional<Integer> LastChariot = service.getLastIdChariot();  /** pour get Sum Quantité de Preparation*/

            if (LastChariot.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(LastChariot, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

/**select list add */
@GetMapping(value = "/bonPreps/allListChar")
public ResponseEntity<List<Chariot>> getChariotOfAddForBonPrep() {
    try {
        List<Chariot> ChariotAllList = service.getChariotOfAddForBonPrep();

        if (ChariotAllList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);   /** pour afficher les Chariot drop list for bon preparation */
        }
        return new ResponseEntity<>(ChariotAllList, HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }
}

/**select list add */

    

// end for the searsh of FK_Keys*******************

    @PutMapping("/chariots/{id}")
    public ResponseEntity<Chariot> updateChariot(@PathVariable("id") long id, @RequestBody Chariot chariot) {
        Optional<Chariot> chariotData = repository.findById(id);

        if (chariotData.isPresent()) {
            Chariot _chariot = chariotData.get();
            
            _chariot.setDatchariot(chariot.getDatchariot());
            _chariot.setEtat_char(chariot.getEtat_char());

            return new ResponseEntity<>(service.updateChariot(_chariot), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Transactional
    @GetMapping("/chariots/chariotChangeEtatEnAttent/{numChar}")
    public void ChangeChariotEtatEnAttent(@PathVariable("numChar") Long numChar) {
        service.ChangeChariotEtatEnAttent(numChar); 
    }



          /**  statistique  Pie Chariot*/ 

          @GetMapping("/chariots/SumCha1")
          public ResponseEntity<Optional<Integer>> getSumCha1() {
              try {
                  Optional<Integer> SumCha1 = service.getSumCha1();  /** pour get Sum Quantité de Livraison */
                  if (SumCha1.isEmpty()) {
                      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                  }
                  return new ResponseEntity<>(SumCha1, HttpStatus.OK);
              } catch (Exception e) {
                  return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
              }
          }
          @GetMapping("/chariots/SumCha2")
          public ResponseEntity<Optional<Integer>> getSumCha2() {
              try {
                  Optional<Integer> SumCha2 = service.getSumCha2();  /** pour get Sum Quantité de Livraison */
                  if (SumCha2.isEmpty()) {
                      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                  }
                  return new ResponseEntity<>(SumCha2, HttpStatus.OK);
              } catch (Exception e) {
                  return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
              }
          }
          @GetMapping("/chariots/SumCha3")
          public ResponseEntity<Optional<Integer>> getSumCha3() {
              try {
                  Optional<Integer> SumCha3 = service.getSumCha3();  /** pour get Sum Quantité de Livraison */
                  if (SumCha3.isEmpty()) {
                      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                  }
                  return new ResponseEntity<>(SumCha3, HttpStatus.OK);
              } catch (Exception e) {
                  return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
              }
          }
}
