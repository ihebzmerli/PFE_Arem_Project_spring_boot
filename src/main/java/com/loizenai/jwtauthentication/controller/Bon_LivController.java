package com.loizenai.jwtauthentication.controller;

import com.loizenai.jwtauthentication.model.BonLiv;
import com.loizenai.jwtauthentication.model.EtatLiv;
import com.loizenai.jwtauthentication.model.Xcommand;
import com.loizenai.jwtauthentication.repository.Bon_LivRepository;
import com.loizenai.jwtauthentication.services.Bon_LivService;
import com.loizenai.jwtauthentication.services.Etat_LivService;

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
public class Bon_LivController {

    @Autowired
    private Bon_LivService service;

    @Autowired
    private Etat_LivService serviceEtat;

    @Autowired
    Bon_LivRepository repository;

    @GetMapping("/bonLivs")
    public ResponseEntity<List<BonLiv>> getAllBonlivs() {
        List<BonLiv> bonLivs = new ArrayList<>();
        try {
            service.getBonLivs().forEach(bonLivs::add);

            if (bonLivs.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(bonLivs, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/bonLivs/{NUM_BON}")
    public ResponseEntity<BonLiv> getBonLivById(@PathVariable("NUM_BON") String numBon) {
        Optional<BonLiv> bonLivData = repository.findById(numBon);

        if (bonLivData.isPresent()) {
            return new ResponseEntity<>(bonLivData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/bonLivs")
    public ResponseEntity<BonLiv> addBonLiv(@RequestBody BonLiv bonliv) {
        try {
            if(!bonliv.getNomprenomCli().isEmpty() && !bonliv.getAdresseCli().isEmpty()){
                String NewNomprenomCli = bonliv.getNomprenomCli();
                String last_concat = NewNomprenomCli.concat(" : ").concat(Long.toString(RandomTest1()));
                bonliv.setNomprenomCli(last_concat);
            }else if (bonliv.getNomprenomCli().isEmpty() && bonliv.getAdresseCli().isEmpty()){
                bonliv.setNomprenomCli("");
                bonliv.setAdresseCli("");
            }
            


            service.addBonLiv(bonliv);
            EtatLiv etatLiv = new EtatLiv();

            if(!bonliv.getAdresseCli().isEmpty() && bonliv.getTrans_action().toString() == "envoyer"){
                    etatLiv.setRegion(bonliv.getAdresseCli());
                    

                    etatLiv.setDate(bonliv.getDatBon());
                    etatLiv.setConfirmation(EtatLiv.CONFIRMATION.n_est_pas_recu);
                    etatLiv.setBonLiv(bonliv);
                     
                    serviceEtat.addEtatLiv(etatLiv);
            }

            if(bonliv.getAdresseCli().isEmpty() && bonliv.getTrans_action().toString() == "envoyer" ){
                etatLiv.setRegion(bonliv.getFournis().getAdresse());

                etatLiv.setDate(bonliv.getDatBon());
                etatLiv.setConfirmation(EtatLiv.CONFIRMATION.n_est_pas_recu);
                etatLiv.setBonLiv(bonliv);
                 
                serviceEtat.addEtatLiv(etatLiv);
            }
            if(!bonliv.getAdresseCli().isEmpty() && bonliv.getTrans_action().toString() == "recu"){
                etatLiv.setRegion(bonliv.getFournis().getAdresse());

                etatLiv.setDate(bonliv.getDatBon());
                etatLiv.setConfirmation(EtatLiv.CONFIRMATION.recu_non_verifier);
                etatLiv.setBonLiv(bonliv);
                 
                serviceEtat.addEtatLiv(etatLiv);
            }
            if(bonliv.getAdresseCli().isEmpty() && bonliv.getTrans_action().toString() == "recu"){
                etatLiv.setRegion(bonliv.getFournis().getAdresse());

                etatLiv.setDate(bonliv.getDatBon());
                etatLiv.setConfirmation(EtatLiv.CONFIRMATION.recu_non_verifier);
                etatLiv.setBonLiv(bonliv);
                 
                serviceEtat.addEtatLiv(etatLiv);
            }

            return new ResponseEntity<>(bonliv, HttpStatus.CREATED);            
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }
/*    
    @PostMapping(value = "/bonLivs")
    public BonLiv postBonLiv(@RequestBody BonLiv bonliv) {
/*        try {
              
              String value1num = bonliv.getNumBon();
//              String idFormFinal = Long.toString(value1num);
              Date value2date = bonliv.getDatBon();
              DateFormat value2dateform = new SimpleDateFormat("yyyy-MM-dd");
              String dateToString = value2dateform.format(value2date);
              String dateToStringForma = Bon_LivService.removeCharacterV1(dateToString, '-');
              String BlFormaFinal = "BL".concat(value1num).concat(dateToStringForma);
              bonliv.setNumBon(BlFormaFinal);
              
            return service.addBonLiv(bonliv);
    }
*/

    @DeleteMapping("/bonLivs/{NUM_BON}")
    public ResponseEntity<HttpStatus> deleteBonLiv(@PathVariable("NUM_BON") String numBon) {
        try {
            service.deleteBonLiv(numBon);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @DeleteMapping("/bonLivs")
    public ResponseEntity<HttpStatus> deleteAllBonlivs() {
        try {
            repository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }

    }
    

//searsh with FK_keys******************

@GetMapping(value = "/bonLivs/dateBetween/{startDate}to{endDate}")
public ResponseEntity<List<BonLiv>> getAllBonLivBydateBetween(@PathVariable String startDate,@PathVariable String endDate) {
    try {
        List<BonLiv> BonLivByDateBetween = service.getAllBonLivBydateBetween(startDate,endDate);

        if (BonLivByDateBetween.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);   /** pour afficher les bon livraison entre 2 date */
        }
        return new ResponseEntity<>(BonLivByDateBetween, HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }
}
@GetMapping(value = "/bonLivs/ByClient/{codcli}")
public ResponseEntity<List<BonLiv>> getAllBonLivByClient(@PathVariable String codcli) {
    try {
        List<BonLiv> BonLivByClient = service.getAllBonLivByClient(codcli);

        if (BonLivByClient.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);     /** pour afficher les bon livraison par code client */
        }
        return new ResponseEntity<>(BonLivByClient, HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }
}

@GetMapping(value = "/bonLivs/ByBonLi/{numBonL}")
public ResponseEntity<List<BonLiv>> getAllBonLivByBonLi(@PathVariable String numBonL) {
    try {
        List<BonLiv> BonLivByBonLi = service.getAllBonLivByBonLi(numBonL);

        if (BonLivByBonLi.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);     /** pour afficher les bon livraison par numbonLiv saisi mouch kémél*/
        }
        return new ResponseEntity<>(BonLivByBonLi, HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }
}

@GetMapping(value = "/bonLivs/NumFac/{numFac}")
public ResponseEntity<List<BonLiv>> getAllBonLivByNumFac(@PathVariable String numFac) {
    try {
        List<BonLiv> BonLivByNumFac = service.getAllBonLivByNumFac(numFac);

        if (BonLivByNumFac.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);     /** pour afficher les bon livraison par numfacture saisi mouch kémél*/
        }
        return new ResponseEntity<>(BonLivByNumFac, HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }
}

@GetMapping(value = "/bonLivs/Transaction/{Trans_action}")
public ResponseEntity<List<BonLiv>> getAllBonLivByTrasaction(@PathVariable String Trans_action) {
    try {
        List<BonLiv> BonLivByTrasaction = service.getAllBonLivByTrasaction(Trans_action);

        if (BonLivByTrasaction.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);     /** pour afficher les bon livraison par Trasaction saisi mouch kémél*/
        }
        return new ResponseEntity<>(BonLivByTrasaction, HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }
}


@GetMapping(value = "/bonLivs/expide/{id_expide}")
public ResponseEntity<List<BonLiv>> getAllBonLivByExpidetion(@PathVariable String id_expide) {
    try {
        List<BonLiv> BonLivByExpide= service.getAllBonLivByExpidetion(id_expide);

        if (BonLivByExpide.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);     /** pour afficher les bon livraison par expidetion saisi mouch kémél*/
        }
        return new ResponseEntity<>(BonLivByExpide, HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }
}

@GetMapping(value = "/bonLivs/Centre/{centre}")
public ResponseEntity<List<BonLiv>> getAllBonLivByCentre(@PathVariable String centre) {
    try {
        List<BonLiv> BonLivByCentre= service.getAllBonLivByCentre(centre);

        if (BonLivByCentre.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);     /** pour afficher les bon livraison par centre saisi mouch kémél*/
        }
        return new ResponseEntity<>(BonLivByCentre, HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }
}

@GetMapping(value = "/bonLivs/Pointage/{pointage}")
public ResponseEntity<List<BonLiv>> getAllBonLivByPointage(@PathVariable String pointage) {
    try {
        List<BonLiv> BonLivByPointage= service.getAllBonLivByPointage(pointage);

        if (BonLivByPointage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);     /** pour afficher les bon livraison par pointage saisi mouch kémél*/
        }
        return new ResponseEntity<>(BonLivByPointage, HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }
}

@GetMapping(value = "/bonLivs/Command/{command}")
public ResponseEntity<List<BonLiv>> getAllBonLivByCommand(@PathVariable String command) {
    try {
        List<BonLiv> BonLivByCommand= service.getAllBonLivByCommand(command);

        if (BonLivByCommand.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);     /** pour afficher les bon livraison par command saisi mouch kémél*/
        }
        return new ResponseEntity<>(BonLivByCommand, HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }
}




    @GetMapping(value = "/bonLivs/num_com/{NUM_COM}")
    public ResponseEntity<List<BonLiv>> findByNumCom(@PathVariable Xcommand numCom) {
        try {
            List<BonLiv> bonlivs = repository.findByNumCom(numCom);

            if (bonlivs.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(bonlivs, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping(value = "/bonLivs/num_fac/{NUM_FAC}")
    public ResponseEntity<List<BonLiv>> findByNumFac(@PathVariable long numFac) {
        try {
            List<BonLiv> bonlivs = repository.findByNumFac(numFac);

            if (bonlivs.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(bonlivs, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

// end for the searsh of FK_Keys*******************

    @PutMapping("/bonLivs/{NUM_BON}")
    public ResponseEntity<BonLiv> updateBonLiv(@PathVariable("NUM_BON") String numBon, @RequestBody BonLiv bonliv) throws InterruptedException {
        Optional<BonLiv> bonLivData = repository.findById(numBon);

        if(!bonliv.getNomprenomCli().isEmpty()){
            String NewNomprenomCli = bonliv.getNomprenomCli();
            String last_concat = NewNomprenomCli.concat(" : ").concat(Long.toString(RandomTest1()));
            bonliv.setNomprenomCli(last_concat);
        }else{
            bonliv.setNomprenomCli("");
            bonliv.setAdresseCli("");
        }
        
        if (bonLivData.isPresent()) {
            BonLiv _bonLiv = bonLivData.get();
            
                _bonLiv.setNumBon(bonliv.getNumBon());
                _bonLiv.setDatBon(bonliv.getDatBon());
                _bonLiv.setTrans_action(bonliv.getTrans_action());
                _bonLiv.setCronoTime(bonliv.getCronoTime());
                _bonLiv.setNumBonFrs(bonliv.getNumBonFrs());
                _bonLiv.setNomprenomCli(bonliv.getNomprenomCli());
                _bonLiv.setAdresseCli(bonliv.getAdresseCli());
                _bonLiv.setRaison(bonliv.getRaison());
                _bonLiv.setBrutHt(bonliv.getBrutHt());
                _bonLiv.setTauxRem(bonliv.getTauxRem());
                _bonLiv.setMontRem(bonliv.getMontRem());
                _bonLiv.setNetHt(bonliv.getNetHt());
                _bonLiv.setMontTva(bonliv.getMontTva());
                _bonLiv.setTotTtc(bonliv.getTotTtc());
                _bonLiv.setNumFac(bonliv.getNumFac());
                _bonLiv.setXbase0(bonliv.getXbase0());
                _bonLiv.setXbase6(bonliv.getXbase6());
                _bonLiv.setXbase10(bonliv.getXbase10());
                _bonLiv.setXbase17(bonliv.getXbase17());
                _bonLiv.setXbase29(bonliv.getXbase29());
                _bonLiv.setXbase7(bonliv.getXbase7());
                _bonLiv.setXbase12(bonliv.getXbase12());
                _bonLiv.setXbase21(bonliv.getXbase21());
                _bonLiv.setXbase36(bonliv.getXbase36());
                _bonLiv.setXtva6(bonliv.getXtva6());
                _bonLiv.setXtva10(bonliv.getXtva10());
                _bonLiv.setXtva17(bonliv.getXtva17());
                _bonLiv.setXtva29(bonliv.getXtva29());
                _bonLiv.setXtva7(bonliv.getXtva7());
                _bonLiv.setXtva12(bonliv.getXtva12());
                _bonLiv.setXtva21(bonliv.getXtva21());
                _bonLiv.setXtva36(bonliv.getXtva36());
                _bonLiv.setPlusV(bonliv.getPlusV());
                _bonLiv.setTauxRes(bonliv.getTauxRes());
                _bonLiv.setMontTrs(bonliv.getMontTrs());
                _bonLiv.setLiv(bonliv.getLiv());
                _bonLiv.setCommand(bonliv.getCommand());
                _bonLiv.setPointage(bonliv.getPointage());
                _bonLiv.setMontIrpp(bonliv.getMontIrpp());
                _bonLiv.setPoste(bonliv.getPoste());
                _bonLiv.setCentre(bonliv.getCentre());
                _bonLiv.setXbase19(bonliv.getXbase19());
                _bonLiv.setXtva19(bonliv.getXtva19());
                _bonLiv.setXbase13(bonliv.getXbase13());
                _bonLiv.setXtva13(bonliv.getXtva13());
                _bonLiv.setXbase7A(bonliv.getXbase7A());
                _bonLiv.setXtva7A(bonliv.getXtva7A());
                _bonLiv.setCodeTva(bonliv.getCodeTva());
                
                //_bonLiv.setExpide(bonliv.getExpide());
                _bonLiv.setUser(bonliv.getUser());
                
                
                return new ResponseEntity<>(service.updateBonLiv(_bonLiv), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }




/**select list add */
        @GetMapping(value = "/expides/AllListBonliv")
        public ResponseEntity<List<BonLiv>> getBonLivOfAdd() {
            try {
                List<BonLiv> BonLivAllList = service.getBonLivOfAdd();

                if (BonLivAllList.isEmpty()) {
                    return new ResponseEntity<>(HttpStatus.NO_CONTENT);   /** pour afficher les bon livraison drop list */
                }
                return new ResponseEntity<>(BonLivAllList, HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
            }
        }

        @PutMapping("/bonLivs/Prix/{NUM_BON}")
        public ResponseEntity<BonLiv> updateBonLivPrix(@PathVariable("NUM_BON") String numBon, @RequestBody BonLiv bonLiv) {
            Optional<BonLiv> bonLivData = repository.findById(numBon);
    
            if (bonLivData.isPresent()) {
                BonLiv _bonLiv = bonLivData.get();
                
                _bonLiv.setBrutHt(bonLiv.getBrutHt());
                _bonLiv.setNetHt(bonLiv.getNetHt());
                _bonLiv.setTotTtc(bonLiv.getTotTtc());
                
                return new ResponseEntity<>(service.updateBonLiv(_bonLiv), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }    
        /**select list add */
    
    /**select list add */
    
        // Simple test which prints random number between min and max number (Number Range Example)
        public long RandomTest1() throws InterruptedException {
            while (true) {
                int min = 1000000;
                int max = 9999999;
     
                // random() returns a double value with a positive sign, greater than or equal to 0.0 and less than 1.0.
                // Returned values are chosen pseudorandomly with (approximately) uniform distribution from that range.
                long randomNumber = (min + (long) (Math.random() * ((max - min))));
                System.out.println("Crunchify Thread 1 random result: " + randomNumber);
            return randomNumber ;
            }
        }















      /**  statistique  Pie Bon liv */ 

        @GetMapping("/bonLivs/SumR")
        public ResponseEntity<Optional<Integer>> getSumR() {
            try {
                Optional<Integer> SumR = service.getSumR();  /** pour get Sum Quantité de Livraison */
                if (SumR.isEmpty()) {
                    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                }
                return new ResponseEntity<>(SumR, HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
            }
        }
        @GetMapping("/bonLivs/SumE")
        public ResponseEntity<Optional<Integer>> getSumE() {
            try {
                Optional<Integer> SumE = service.getSumE();  /** pour get Sum Quantité de Livraison */
                if (SumE.isEmpty()) {
                    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                }
                return new ResponseEntity<>(SumE, HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
            }
        }

      /**  statistique  Bar Bon liv */ 

      @GetMapping("/bonLivs/SumBar1")
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
      @GetMapping("/bonLivs/SumBar2")
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
      @GetMapping("/bonLivs/SumBar3")
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
      @GetMapping("/bonLivs/SumBar4")
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
      @GetMapping("/bonLivs/SumBar5")
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
      @GetMapping("/bonLivs/SumBar6")
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
      @GetMapping("/bonLivs/SumBar7")
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





      /**  statistique  Bar D3 Affaire */ 

      @GetMapping("/bonLivs/MinChrono")
      public ResponseEntity<Optional<String>> getMinChrono() {
          try {
            Optional<String> MinChrono = service.getMinChrono(); 
              if (MinChrono.isEmpty()) {
                  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
              }
              return new ResponseEntity<>(MinChrono, HttpStatus.OK);
          } catch (Exception e) {
              return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
          }
      }

      @GetMapping("/bonLivs/MaxChrono")
      public ResponseEntity<Optional<String>> getMaxChrono() {
          try {
            Optional<String> MaxChrono = service.getMaxChrono(); 
              if (MaxChrono.isEmpty()) {
                  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
              }
              return new ResponseEntity<>(MaxChrono, HttpStatus.OK);
          } catch (Exception e) {
              return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
          }
      }


      @GetMapping("/bonLivs/SumAvgF1")
      public ResponseEntity<List<Long>> getSumAvgF1() {
          try {
            List<Long> SumAvgF1 = service.getSumAvgF1();  /** pour get Sum Quantité de Livraison */
              if (SumAvgF1.isEmpty()) {
                  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
              }
              return new ResponseEntity<>(SumAvgF1, HttpStatus.OK);
          } catch (Exception e) {
              return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
          }
      }
      @GetMapping("/bonLivs/SumAvgF2")
      public ResponseEntity<List<Float>> getSumAvgF2() {
          try {
            List<Float> SumAvgF2 = service.getSumAvgF2();  /** pour get Sum Quantité de Livraison */
              if (SumAvgF2.isEmpty()) {
                  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
              }
              return new ResponseEntity<>(SumAvgF2, HttpStatus.OK);
          } catch (Exception e) {
              return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
          }
      }
      @GetMapping("/bonLivs/SumAvgC1")
      public ResponseEntity<List<String>> getSumAvgC1() {
          try {
            List<String> SumAvgC1 = service.getSumAvgC1();  /** pour get Sum Quantité de Livraison */
              if (SumAvgC1.isEmpty()) {
                  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
              }
              return new ResponseEntity<>(SumAvgC1, HttpStatus.OK);
          } catch (Exception e) {
              return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
          }
      }
      @GetMapping("/bonLivs/SumAvgC2")
      public ResponseEntity<List<Float>> getSumAvgC2() {
          try {
            List<Float> SumAvgC2 = service.getSumAvgC2();  /** pour get Sum Quantité de Livraison */
              if (SumAvgC2.isEmpty()) {
                  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
              }
              return new ResponseEntity<>(SumAvgC2, HttpStatus.OK);
          } catch (Exception e) {
              return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
          }
      }      
}
