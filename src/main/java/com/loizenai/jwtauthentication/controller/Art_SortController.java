package com.loizenai.jwtauthentication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.loizenai.jwtauthentication.model.ArtSort;
import com.loizenai.jwtauthentication.repository.Art_SortRepository;
import com.loizenai.jwtauthentication.services.Art_SortService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class Art_SortController {
    @Autowired
    private Art_SortService service;

    @Autowired
    Art_SortRepository repository;

    @GetMapping("/artSorts")
    public ResponseEntity<List<ArtSort>> getAllartsorts() {
        List<ArtSort> artSorts = new ArrayList<>();
        try {
            service.getArtSorts().forEach(artSorts::add);

            if (artSorts.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(artSorts, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/artSorts/{id}")
    public ResponseEntity<ArtSort> getArtSortById(@PathVariable("id") long id) {
        Optional<ArtSort> artSortData = repository.findById(id);

        if (artSortData.isPresent()) {
            return new ResponseEntity<>(artSortData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/bonSorts/artSorts")
    public ResponseEntity<ArtSort> postArtsort(@RequestBody ArtSort artSort) {
        try {
            service.addArtSort(artSort);
            return new ResponseEntity<>(artSort, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @DeleteMapping("/artSorts/{id}")
    public ResponseEntity<HttpStatus> deleteArtsort(@PathVariable("id") long id) {
        try {
            service.deleteArtSort(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @DeleteMapping("/artSorts")
    public ResponseEntity<HttpStatus> deleteAllArtsorts() {
        try {
            repository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }

    }
//searsh with FK_keys******************

@GetMapping("/bonSorts/DetailsArtSort/{num_bon_sort}")
public ResponseEntity<List<ArtSort>> getArtSortForBonSort(@PathVariable String num_bon_sort) {
    try {
        List<ArtSort> ArtSortDetail= service.getArtSortForBonSort(num_bon_sort);  /** pour afficher les detail de Bon Sort*/

        if (ArtSortDetail.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(ArtSortDetail, HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }
} 
// end for the searsh of FK_Keys*******************

    @PutMapping("/artSorts/{id}")
    public ResponseEntity<ArtSort> updateArtSort(@PathVariable("id") long id, @RequestBody ArtSort artsort) {
        Optional<ArtSort> artSortData = repository.findById(id);

        if (artSortData.isPresent()) {
            ArtSort _artSort = artSortData.get();
            
                _artSort.setQutSortie(artsort.getQutSortie());
                
                _artSort.setRemise(artsort.getRemise());
                _artSort.setPrixHt(artsort.getPrixHt());
                _artSort.setTva(artsort.getTva());
                _artSort.setTotHt(artsort.getTotHt());
                _artSort.setCumulRet(artsort.getCumulRet());
                _artSort.setCentre(artsort.getCentre());
                _artSort.setPreparateur(artsort.getPreparateur());
                _artSort.setChariot(artsort.getChariot());
                _artSort.setPoitageChariot(artsort.getPoitageChariot());
                return new ResponseEntity<>(service.updateArtSort(_artSort), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } 

        @PutMapping("/artSorts/{numBon}And{COD_ART}")
        public ResponseEntity<ArtSort> getArtSortBS_CA(@PathVariable("numBon") String numBon,@PathVariable("COD_ART") String codArt, @RequestBody ArtSort artsort) {
            Optional<ArtSort> artSortData = repository.getArtSortBS_CA(numBon,codArt);
    
            if (artSortData.isPresent()) {
                ArtSort _artSort = artSortData.get();
                
                    _artSort.setPreparateur(artsort.getPreparateur());
                    _artSort.setChariot(artsort.getChariot());
                    _artSort.setPoitageChariot(artsort.getPoitageChariot());
                    
                    return new ResponseEntity<>(service.updateArtSort(_artSort), HttpStatus.OK);
                } else {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
            } 









            @GetMapping("/artSorts/SumQutSortHt/{num_bon_sort}")
            public ResponseEntity<Optional<Integer>> getSumQutByBSht(@PathVariable String num_bon_sort) {
                try {
                    Optional<Integer> SumQutSort = service.getSumQutByBSht(num_bon_sort);  /** pour get Sum Quantité de Sort*/
        
                    if (SumQutSort.isEmpty()) {
                        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                    }
                    return new ResponseEntity<>(SumQutSort, HttpStatus.OK);
                } catch (Exception e) {
                    return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
                }
            }
            @GetMapping("/artSorts/SumQutSortAREM/{num_bon_sort}")
            public ResponseEntity<Optional<Integer>> getSumQutByBSAREM(@PathVariable String num_bon_sort) {
                try {
                    Optional<Integer> SumQutSort = service.getSumQutByBSAREM(num_bon_sort);  /** pour get Sum Quantité de Sort*/
        
                    if (SumQutSort.isEmpty()) {
                        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                    }
                    return new ResponseEntity<>(SumQutSort, HttpStatus.OK);
                } catch (Exception e) {
                    return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
                }
            }
}

