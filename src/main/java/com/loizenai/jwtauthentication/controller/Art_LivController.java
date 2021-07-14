package com.loizenai.jwtauthentication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.loizenai.jwtauthentication.model.ArtLiv;
import com.loizenai.jwtauthentication.repository.Art_LivRepository;
import com.loizenai.jwtauthentication.services.Art_LivService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class Art_LivController {
  
    
    @Autowired
    private Art_LivService service;

    @Autowired
    Art_LivRepository repository;

    @GetMapping("/artLivs")
    public ResponseEntity<List<ArtLiv>> getAllartlivs() {
        List<ArtLiv> artLivs = new ArrayList<>();
        try {
            service.getArtLivs().forEach(artLivs::add);

            if (artLivs.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(artLivs, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/artLivs/{id}")
    public ResponseEntity<ArtLiv> getArtLivById(@PathVariable("id") long id) {
        Optional<ArtLiv> artLivData = repository.findById(id);

        if (artLivData.isPresent()) {
            return new ResponseEntity<>(artLivData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/artLivs")
    public ResponseEntity<ArtLiv> postArtliv(@RequestBody ArtLiv artLiv) {
        try {
            service.addArtLiv(artLiv);
            return new ResponseEntity<>(artLiv, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @DeleteMapping("/artLivs/{id}")
    public ResponseEntity<HttpStatus> deleteArtliv(@PathVariable("id") long id) {
        try {
            service.deleteArtLiv(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @DeleteMapping("/artLivs")
    public ResponseEntity<HttpStatus> deleteAllArtlivs() {
        try {
            repository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }

    }
//searsh with FK_keys******************


@GetMapping("/bonLivs/DetailsArtLiv/{num_bon_liv}")
public ResponseEntity<List<ArtLiv>> getArtLivForBonLiv(@PathVariable String num_bon_liv) {
    try {
        List<ArtLiv> ArtLivDetail= service.getArtLivForBonLiv(num_bon_liv);  /** pour afficher les detail de bon Liv*/

        if (ArtLivDetail.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(ArtLivDetail, HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }
} 


// end for the searsh of FK_Keys*******************

    @PutMapping("/artLivs/{id}")
    public ResponseEntity<ArtLiv> updateArtLiv(@PathVariable("id") long id, @RequestBody ArtLiv artliv) {
        Optional<ArtLiv> artLivData = repository.findById(id);

        if (artLivData.isPresent()) {
            ArtLiv _artLiv = artLivData.get();

            _artLiv.setQutLiv(artliv.getQutLiv());
            _artLiv.setRemise(artliv.getRemise());
            _artLiv.setPrixHt(artliv.getPrixHt());
            _artLiv.setTva(artliv.getTva());
            _artLiv.setTotHt(artliv.getTotHt());
            _artLiv.setMarge(artliv.getMarge());
            _artLiv.setTypArt(artliv.getTypArt());
            _artLiv.setCumulRet(artliv.getCumulRet());
            _artLiv.setPrixAch(artliv.getPrixAch());
            _artLiv.setRemExp(artliv.getRemExp());
            _artLiv.setPoste(artliv.getPoste());
            _artLiv.setCentre(artliv.getCentre());
           // _artLiv.setBonLiv(artliv.getBonLiv());
           // _artLiv.setArtliv_articls(artliv.getArtliv_articls());

            return new ResponseEntity<>(service.updateArtLiv(_artLiv), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    } 
    
    @GetMapping("/artLivs/SumQutByBLach/{num_bon_liv}")
    public ResponseEntity<Optional<Integer>> getSumQutByBLach(@PathVariable String num_bon_liv) {
        try {
            Optional<Integer> SumQutLivAch = service.getSumQutByBLach(num_bon_liv);  /** pour get Sum Quantité de Preparation*/

            if (SumQutLivAch.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(SumQutLivAch, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
    @GetMapping("/artLivs/SumQutLivHt/{num_bon_liv}")
    public ResponseEntity<Optional<Integer>> getSumQutByBLht(@PathVariable String num_bon_liv) {
        try {
            Optional<Integer> SumQutLivHt = service.getSumQutByBLht(num_bon_liv);  /** pour get Sum Quantité de Livraison */

            if (SumQutLivHt.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(SumQutLivHt, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
    @GetMapping("/artLivs/SumQutByBLAREM/{num_bon_liv}")
    public ResponseEntity<Optional<Integer>> getSumQutByBLAREM(@PathVariable String num_bon_liv) {
        try {
            Optional<Integer> SumQutLivArem = service.getSumQutByBLAREM(num_bon_liv);  /** pour get Sum Quantité de AremPrix*/

            if (SumQutLivArem.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(SumQutLivArem, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
}
