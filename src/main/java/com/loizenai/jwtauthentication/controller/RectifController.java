package com.loizenai.jwtauthentication.controller;

import com.loizenai.jwtauthentication.model.Rectif;
import com.loizenai.jwtauthentication.repository.RectifRepository;
import com.loizenai.jwtauthentication.services.RectifService;

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
public class RectifController {

    @Autowired
    private RectifService service;

    @Autowired
    RectifRepository repository;

    @GetMapping("/rectifs")
    public ResponseEntity<List<Rectif>> getAllRectifs() {
        List<Rectif> rectifs = new ArrayList<>();
        try {
            service.getRectifs().forEach(rectifs::add);

            if (rectifs.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(rectifs, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/rectifs/{id}")
    public ResponseEntity<Rectif> getRectifById(@PathVariable("id") long id) {
        Optional<Rectif> rectifData = repository.findById(id);

        if (rectifData.isPresent()) {
            return new ResponseEntity<>(rectifData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/rectifs")
    public ResponseEntity<Rectif> postRectif(@RequestBody Rectif rectif) {
        try {
            service.addRectif(rectif);
            return new ResponseEntity<>(rectif, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @DeleteMapping("/rectifs/{id}")
    public ResponseEntity<HttpStatus> deleteRectif(@PathVariable("id") long id) {
        try {
            service.deleteRectif(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
    
    @DeleteMapping("/rectifs")
    public ResponseEntity<HttpStatus> deleteAllRectifs() {
        try {
            repository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    //searsh with FK_keys****************** 
/*
    @GetMapping(value = "rectifs/num_doc/{NUM_DOC}")
    public ResponseEntity<List<Rectif>> findByNumDoc(@PathVariable long numDoc) {
        try {
            List<Rectif> rectifs = repository.findByNumDoc(numDoc);
            if (rectifs.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(rectifs, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
*/


@GetMapping("/rectifs/Rectif_Achat/{numDoc}")
public ResponseEntity<List<Rectif>> getAllRectifByAchats(@PathVariable String numDoc) {
    try {
        List<Rectif> RectifByNumDoc= service.getAllRectifByAchats(numDoc);  /** pour afficher les rectif by Achats  */

        if (RectifByNumDoc.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(RectifByNumDoc, HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }
} 

@GetMapping("/rectifs/Rectif_Date/{startDate}to{endDate}")
public ResponseEntity<List<Rectif>> getAllRectifBydateBetween(@PathVariable String startDate,@PathVariable String endDate) {
    try {
        List<Rectif> RectifByDateBetween= service.getAllRectifBydateBetween(startDate,endDate);  /** pour afficher les rectif by date between  */

        if (RectifByDateBetween.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(RectifByDateBetween, HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }
} 

@GetMapping("/rectifs/Rectif_QutArt/{MinQ_art}to{MaxQ_art}")
public ResponseEntity<List<Rectif>> getAllRectifByQutArt(@PathVariable String MinQ_art,@PathVariable String MaxQ_art) {
    try {
        List<Rectif> RectifByQutBetween= service.getAllRectifByQutArt(MinQ_art,MaxQ_art);  /** pour afficher les rectif by Quantité between  */

        if (RectifByQutBetween.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(RectifByQutBetween, HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }
} 

@GetMapping("/rectifs/Rectif_PrixAch/{MinP_ach}to{MaxP_ach}")
public ResponseEntity<List<Rectif>> getAllRectifByPrixAch(@PathVariable String MinP_ach,@PathVariable String MaxP_ach) {
    try {
        List<Rectif> RectifByPrixAchBetween= service.getAllRectifByPrixAch(MinP_ach,MaxP_ach);  /** pour afficher les rectif by Prix achat between  */

        if (RectifByPrixAchBetween.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(RectifByPrixAchBetween, HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }
} 

@GetMapping("/rectifs/Rectif_TypMvt/{Ty_mvt}")
public ResponseEntity<List<Rectif>> getAllRectifByTyMvt(@PathVariable String Ty_mvt) {
    try {
        List<Rectif> RectifByTypMvt= service.getAllRectifByTyMvt(Ty_mvt);  /** pour afficher les rectif by Type mvt  */

        if (RectifByTypMvt.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(RectifByTypMvt, HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }
} 

@GetMapping("/rectifs/Rectif_NumRec/{numRec}")
public ResponseEntity<List<Rectif>> getAllRectifByNumRec(@PathVariable String numRec) {
    try {
        List<Rectif> RectifByNumRec= service.getAllRectifByNumRec(numRec);  /** pour afficher les rectif by numereau Rectif  */

        if (RectifByNumRec.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(RectifByNumRec, HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }
} 

@GetMapping("/rectifs/Rectif_Centre/{centre}")
public ResponseEntity<List<Rectif>> getAllRectifByCentre(@PathVariable String centre) {
    try {
        List<Rectif> RectifByCentre= service.getAllRectifByCentre(centre);  /** pour afficher les rectif by centre  */

        if (RectifByCentre.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(RectifByCentre, HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }
} 

@GetMapping("/rectifs/Rectif_DateRec/{startDateReclama}to{endDateReclama}")
public ResponseEntity<List<Rectif>> getAllRectifBydateReclamBetween(@PathVariable String startDateReclama,@PathVariable String endDateReclama) {
    try {
        List<Rectif> RectifByDateRecBetween= service.getAllRectifBydateReclamBetween(startDateReclama,endDateReclama);  /** pour afficher les rectif by Date Reclam between  */

        if (RectifByDateRecBetween.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(RectifByDateRecBetween, HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }
} 

@GetMapping("/rectifs/Rectif_DateRepon/{startDateRepon}to{endDateRepon}")
public ResponseEntity<List<Rectif>> getAllRectifBydateReponBetween(@PathVariable String startDateRepon,@PathVariable String endDateRepon) {
    try {
        List<Rectif> RectifByDateReponBetween= service.getAllRectifBydateReponBetween(startDateRepon,endDateRepon);  /** pour afficher les rectif by Date Repon between  */

        if (RectifByDateReponBetween.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(RectifByDateReponBetween, HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }
} 

@GetMapping("/rectifs/Rectif_DateCloture/{startDateClotur}to{endDateClotur}")
public ResponseEntity<List<Rectif>> getAllRectifBydateCloturBetween(@PathVariable String startDateClotur,@PathVariable String endDateClotur) {
    try {
        List<Rectif> RectifByDateClotureBetween= service.getAllRectifBydateCloturBetween(startDateClotur,endDateClotur);  /** pour afficher les rectif by Date Cloture between  */

        if (RectifByDateClotureBetween.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(RectifByDateClotureBetween, HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }
} 

    // end for the searsh of FK_Keys*******************
    
    @PutMapping("/rectifs/{id}")
    public ResponseEntity<Rectif> updateRectif(@PathVariable("id") long id, @RequestBody Rectif rectif) {
        Optional<Rectif> rectifData = repository.findById(id);
        if (rectifData.isPresent()) {
            Rectif _rectif = rectifData.get();
            _rectif.setDate(rectif.getDate());
            _rectif.setObserv(rectif.getObserv());
            _rectif.setTypMvt(rectif.getTypMvt());
            _rectif.setNumRec(rectif.getNumRec());
            _rectif.setDatReclam(rectif.getDatReclam());
            _rectif.setReclam(rectif.getReclam());
            _rectif.setCloture(rectif.getCloture());
            _rectif.setObsReclam(rectif.getObsReclam());
            _rectif.setDatRepon(rectif.getDatRepon());
            _rectif.setDatClotur(rectif.getDatClotur());

            return new ResponseEntity<>(service.updateRectif(_rectif), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}