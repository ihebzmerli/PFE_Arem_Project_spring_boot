package com.loizenai.jwtauthentication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.transaction.annotation.Transactional;
import com.loizenai.jwtauthentication.model.ArtPrep;
import com.loizenai.jwtauthentication.model.Chariot;
import com.loizenai.jwtauthentication.repository.Art_PrepRepository;
import com.loizenai.jwtauthentication.services.Art_PrepService;
import com.loizenai.jwtauthentication.services.ChariotService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class Art_PrepController {
  
    @Autowired
    private Art_PrepService service;
    
    @Autowired
    private ChariotService chariotService;

    @Autowired
    Art_PrepRepository repository;

    @GetMapping("/artPreps")
    public ResponseEntity<List<ArtPrep>> getAllartpreps() {
        List<ArtPrep> artPreps = new ArrayList<>();
        try {
            service.getArtPreps().forEach(artPreps::add);

            if (artPreps.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(artPreps, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/artPreps/{id}")
    public ResponseEntity<ArtPrep> getArtPrepById(@PathVariable("id") long id) {
        Optional<ArtPrep> artPrepData = repository.findById(id);

        if (artPrepData.isPresent()) {
            return new ResponseEntity<>(artPrepData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/artPreps")
    public ResponseEntity<ArtPrep> postArtprep(@RequestBody ArtPrep artPrep) {
        try {
            service.addArtPrep(artPrep);
            return new ResponseEntity<>(artPrep, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @DeleteMapping("/artPreps/{id}")
    public ResponseEntity<HttpStatus> deleteArtprep(@PathVariable("id") long id) {
        try {
            service.deleteArtPrep(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @DeleteMapping("/artPreps")
    public ResponseEntity<HttpStatus> deleteAllArtpreps() {
        try {
            repository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }

    }
//searsh with FK_keys******************

    @GetMapping("/bonPreps/DetailsArtPrep/{num_bon_prep}")
    public ResponseEntity<List<ArtPrep>> getArtPrepForBonPrep(@PathVariable String num_bon_prep) {
        try {
            List<ArtPrep> ArtPrepDetail= service.getArtPrepForBonPrep(num_bon_prep);  /** pour afficher les detail de bon Prep*/

            if (ArtPrepDetail.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(ArtPrepDetail, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    } 


    @GetMapping("/chariots/DetailsChariot/{num_char}")
    public ResponseEntity<List<ArtPrep>> getArtPrepByChariot(@PathVariable String num_char) {
        try {
            List<ArtPrep> DetailsChariot= service.getArtPrepByChariot(num_char);  /** pour afficher les detail de bon Prep*/

            if (DetailsChariot.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(DetailsChariot, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    } 
// end for the searsh of FK_Keys*******************
    @Transactional
    @PutMapping("/artPreps/{id}")
    public ResponseEntity<ArtPrep> updateArtPrep(@PathVariable("id") long id, @RequestBody ArtPrep artprep) {
        Optional<ArtPrep> artPrepData = repository.findById(id);
        System.out.println("pfffffffff");
        if (artPrepData.isPresent()) {
            ArtPrep _artPrep = artPrepData.get();
            
            _artPrep.setQutLiv(artprep.getQutLiv());
                
            _artPrep.setRemise(artprep.getRemise());
            _artPrep.setPrixHt(artprep.getPrixHt());
            _artPrep.setTva(artprep.getTva());
            _artPrep.setTotHt(artprep.getTotHt());
            _artPrep.setCumulRet(artprep.getCumulRet());
            _artPrep.setCentre(artprep.getCentre());
            _artPrep.setArtprep_chariot(artprep.getArtprep_chariot());
            _artPrep.setPrepara(artprep.getPrepara());
            _artPrep.setPoitageChariot(artprep.getPoitageChariot());
            _artPrep.setTypArt(artprep.getTypArt());
            _artPrep.setQutPoint(artprep.getQutPoint());
            _artPrep.setPrep(artprep.getPrep());
            _artPrep.setNonTrouve(artprep.getNonTrouve());
            _artPrep.setRemExp(artprep.getRemExp());
            _artPrep.setEtage2(artprep.getEtage2());
            _artPrep.setQutValider(artprep.getQutValider());
            //_artPrep.setBonPrep(artprep.getBonPrep());
            if(artprep.getArtprep_chariot()!=null){
                chariotService.ChangeChariotEtatOccuper(artprep.getArtprep_chariot().getNumChar());
                System.out.println("te5dem"+artprep.getArtprep_chariot());
            }
                return new ResponseEntity<>(service.updateArtPrep(_artPrep), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }  

        @PutMapping("/artPreps/{numBon}And{COD_ART}")
        public ResponseEntity<ArtPrep> getArtPrepBP_CA(@PathVariable("numBon") String numBon,@PathVariable("COD_ART") String codArt, @RequestBody ArtPrep artPrep) {
            
            System.out.println("pfffffffffaaa");
            Optional<ArtPrep> artPrepData = repository.getArtPrepBP_CA(numBon,codArt);
    
            if (artPrepData.isPresent()) {
                ArtPrep _artPrep = artPrepData.get();
                
                _artPrep.setPrepara(artPrep.getPrepara());
                _artPrep.setArtprep_chariot(artPrep.getArtprep_chariot());
                _artPrep.setPoitageChariot(artPrep.getPoitageChariot());
                _artPrep.setQutPoint(artPrep.getQutPoint());
                
                    return new ResponseEntity<>(service.updateArtPrep(_artPrep), HttpStatus.OK);
                } else {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
            } 

            @GetMapping("/artPreps/SumQutPrepach/{num_bon_prep}")
            public ResponseEntity<Optional<Integer>> getSumQutByBPach(@PathVariable String num_bon_prep) {
                try {
                    Optional<Integer> SumQutPrep = service.getSumQutByBPach(num_bon_prep);  /** pour get Sum Quantité de Preparation*/
        
                    if (SumQutPrep.isEmpty()) {
                        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                    }
                    return new ResponseEntity<>(SumQutPrep, HttpStatus.OK);
                } catch (Exception e) {
                    return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
                }
            } 
            @GetMapping("/artPreps/SumQutPrepHt/{num_bon_prep}")
            public ResponseEntity<Optional<Integer>> getSumQutByBPht(@PathVariable String num_bon_prep) {
                try {
                    Optional<Integer> SumQutPrep = service.getSumQutByBPht(num_bon_prep);  /** pour get Sum Quantité de Preparation*/
        
                    if (SumQutPrep.isEmpty()) {
                        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                    }
                    return new ResponseEntity<>(SumQutPrep, HttpStatus.OK);
                } catch (Exception e) {
                    return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
                }
            }
            @GetMapping("/artPreps/SumQutPrepAREM/{num_bon_prep}")
            public ResponseEntity<Optional<Integer>> getSumQutByBPAREM(@PathVariable String num_bon_prep) {
                try {
                    Optional<Integer> SumQutPrep = service.getSumQutByBPAREM(num_bon_prep);  /** pour get Sum Quantité de Preparation*/
        
                    if (SumQutPrep.isEmpty()) {
                        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                    }
                    return new ResponseEntity<>(SumQutPrep, HttpStatus.OK);
                } catch (Exception e) {
                    return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
                }
            }






@Transactional
@GetMapping("/artPreps/ChronoChariotPointage/{num_char}")
public void ChronoChariotPointage(@PathVariable("num_char") Long num_char) {
    service.ChronoChariotPointage(num_char); 
}
@Transactional
@GetMapping("/artPreps/ChangeChrono/{num_char}")
public void ChangeChrono(@PathVariable("num_char") Long num_char) {
    service.ChangeChrono(num_char); 
}
}
