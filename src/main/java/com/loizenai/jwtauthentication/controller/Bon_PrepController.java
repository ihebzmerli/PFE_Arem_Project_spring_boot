package com.loizenai.jwtauthentication.controller;

import com.loizenai.jwtauthentication.model.BonPrep;
import com.loizenai.jwtauthentication.repository.Bon_PrepRepository;
import com.loizenai.jwtauthentication.services.Bon_PrepService;

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
public class Bon_PrepController {

    @Autowired
    private Bon_PrepService service;

    @Autowired
    Bon_PrepRepository repository;

    @GetMapping("/bonPreps")
    public ResponseEntity<List<BonPrep>> getAllBonpreps() {
        List<BonPrep> bonPreps = new ArrayList<>();
        try {
            service.getBonPreps().forEach(bonPreps::add);

            if (bonPreps.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(bonPreps, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/bonPreps/{NUM_BON}")
    public ResponseEntity<BonPrep> getBonprepById(@PathVariable("NUM_BON") String numBon) {
        Optional<BonPrep> bonPrepData = repository.findById(numBon);

        if (bonPrepData.isPresent()) {
            return new ResponseEntity<>(bonPrepData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/bonPreps")
    public ResponseEntity<BonPrep> postBonprep(@RequestBody BonPrep bonPrep) {
        try {
            String NewNomprenomCli = bonPrep.getNomprenomCli();
            String last_concat = NewNomprenomCli.concat(" : ").concat(Long.toString(RandomTest1()));
            bonPrep.setNomprenomCli(last_concat);
            service.addBonPrep(bonPrep);
            return new ResponseEntity<>(bonPrep, HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @DeleteMapping("/bonPreps/{NUM_BON}")
    public ResponseEntity<HttpStatus> deleteBonprep(@PathVariable("NUM_BON") String numBon) {
        try {
            service.deleteBonPrep(numBon);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @DeleteMapping("/bonPreps")
    public ResponseEntity<HttpStatus> deleteAllBonpreps() {
        try {
            repository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }


/**select list add */
@GetMapping(value = "/bonPreps/allList")
public ResponseEntity<List<String>> getBonPrepOfAdd() {
    try {
        List<String> BonPrepAllList = service.getBonPrepOfAdd();

        if (BonPrepAllList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);   /** pour afficher les bon preparation drop list */
        }
        return new ResponseEntity<>(BonPrepAllList, HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }
}

/**select list add */

    //searsh with FK_keys******************
    
    @GetMapping(value = "bonPreps/NumBonPrep/{numBonPp}")
    public ResponseEntity<List<BonPrep>> getAllBonPrepByNumBonPre(@PathVariable String numBonPp) {
        try {
            List<BonPrep> BonPrepByNumBonP= service.getAllBonPrepByNumBonPre(numBonPp);

            if (BonPrepByNumBonP.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);     /** pour afficher les bon preparation par num_preparation saisi mouch kémél*/
            }
            return new ResponseEntity<>(BonPrepByNumBonP, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
    @GetMapping(value = "/bonPreps/dateBetween/{startDate}to{endDate}")
    public ResponseEntity<List<BonPrep>> getAllBonPrepBydateBetween(@PathVariable String startDate,@PathVariable String endDate) {
        try {
            List<BonPrep> BonPrepByDateBetween= service.getAllBonPrepBydateBetween(startDate,endDate);

            if (BonPrepByDateBetween.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);     /** pour afficher les bon preparation entre 2 date */
            }
            return new ResponseEntity<>(BonPrepByDateBetween, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
    @GetMapping(value = "bonPreps/ByClient/{codcli}")
    public ResponseEntity<List<BonPrep>> getAllBonPrepByClient(@PathVariable String codcli) {
        try {
            List<BonPrep> BonPrepByClient= service.getAllBonPrepByClient(codcli);

            if (BonPrepByClient.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);     /** pour afficher les bon preparation par code client */
            }
            return new ResponseEntity<>(BonPrepByClient, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
    @GetMapping(value = "bonPreps/pointage/{Pointage}")
    public ResponseEntity<List<BonPrep>> getAllBonPrepByPointage(@PathVariable String Pointage) {
        try {
            List<BonPrep> BonPrepByPointage= service.getAllBonPrepByPointage(Pointage);

            if (BonPrepByPointage.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);    /** if all bon sortie all pointer ,Pointage té5ou valeur vrais ijibhom ilkoll */
            }
            return new ResponseEntity<>(BonPrepByPointage, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
    @GetMapping(value = "bonPreps/NatLiv/{NatLiv}")
    public ResponseEntity<List<BonPrep>> getAllBonPrepByNatLivraison(@PathVariable String NatLiv) {
        try {
            List<BonPrep> BonPrepByNatLiv= service.getAllBonPrepByNatLivraison(NatLiv);

            if (BonPrepByNatLiv.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);    /** if all bon sortie all pointer ,Pointage té5ou valeur vrais ijibhom ilkoll */
            }
            return new ResponseEntity<>(BonPrepByNatLiv, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
    @GetMapping(value = "bonPreps/pointeur/{Pointeur}")
    public ResponseEntity<List<BonPrep>> getAllBonPrepByPointeur(@PathVariable String Point) {
        try {
            List<BonPrep> BonPrepByPointeur= service.getAllBonPrepByPointeur(Point);

            if (BonPrepByPointeur.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);    /** pour afficher les bon preparation par pointeur */
            }
            return new ResponseEntity<>(BonPrepByPointeur, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
    @GetMapping(value = "bonPreps/AIDEMAG/{AideMag}")
    public ResponseEntity<List<BonPrep>> getAllBonPrepByAideMag(@PathVariable String AideMag) {
        try {
            List<BonPrep> BonPrepByAideMage= service.getAllBonPrepByAideMag(AideMag);

            if (BonPrepByAideMage.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);    /** pour afficher les bon preparation par aide_mag */
            }
            return new ResponseEntity<>(BonPrepByAideMage, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
    @GetMapping(value = "bonPreps/CENTRE/{Centre}")
    public ResponseEntity<List<BonPrep>> getAllBonPrepByCentre(@PathVariable String Centre) {
        try {
            List<BonPrep> BonPrepByCentre = service.getAllBonPrepByCentre(Centre);

            if (BonPrepByCentre.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);    /** pour afficher les bon preparation par centre */
            }
            return new ResponseEntity<>(BonPrepByCentre, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
    @GetMapping(value = "bonPreps/user_Id/{userId}")
    public ResponseEntity<List<BonPrep>> getAllBonPrepByUserId(@PathVariable String userId) {
        try {
            List<BonPrep> BonPrepByUserId = service.getAllBonPrepByUserId(userId);

            if (BonPrepByUserId.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);    /** pour afficher les bon preparation par userId */
            }
            return new ResponseEntity<>(BonPrepByUserId, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping(value = "bonPreps/num_doc/{numdoc}")
    public ResponseEntity<List<BonPrep>> getAllBonPrepByNumDoc(@PathVariable String numdoc) {
        try {
            List<BonPrep> BonPrepBynumdoc= service.getAllBonPrepByNumDoc(numdoc);

            if (BonPrepBynumdoc.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);    /** pour afficher les bon preparation par numdoc */
            }
            return new ResponseEntity<>(BonPrepBynumdoc, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }


// end for the searsh of FK_Keys*******************

    @PutMapping("/bonPreps/{NUM_BON}")
    public ResponseEntity<BonPrep> updateBonPrep(@PathVariable("NUM_BON") String numBon, @RequestBody BonPrep bonprep) {
        Optional<BonPrep> bonPrepData = repository.findById(numBon);

        if (bonPrepData.isPresent()) {
            BonPrep _bonPrep = bonPrepData.get();
            
            _bonPrep.setDatBon(bonprep.getDatBon());

            _bonPrep.setNomprenomCli(bonprep.getNomprenomCli());

            _bonPrep.setRaison(bonprep.getRaison());
            _bonPrep.setBrutHt(bonprep.getBrutHt());
            _bonPrep.setTauxRem(bonprep.getTauxRem());
            _bonPrep.setMontRem(bonprep.getMontRem());
            _bonPrep.setNetHt(bonprep.getNetHt());
            _bonPrep.setMontTva(bonprep.getMontTva());
            _bonPrep.setTotTtc(bonprep.getTotTtc());
            _bonPrep.setXbase0(bonprep.getXbase0());
            _bonPrep.setXbase6(bonprep.getXbase6());
            _bonPrep.setXbase10(bonprep.getXbase10());
            _bonPrep.setXbase17(bonprep.getXbase17());
            _bonPrep.setXbase29(bonprep.getXbase29());
            _bonPrep.setXbase7(bonprep.getXbase7());
            _bonPrep.setXbase12(bonprep.getXbase12());
            _bonPrep.setXbase21(bonprep.getXbase21());
            _bonPrep.setXbase36(bonprep.getXbase36());
            _bonPrep.setXtva6(bonprep.getXtva6());
            _bonPrep.setXtva10(bonprep.getXtva10());
            _bonPrep.setXtva17(bonprep.getXtva17());
            _bonPrep.setXtva29(bonprep.getXtva29());
            _bonPrep.setXtva7(bonprep.getXtva7());
            _bonPrep.setXtva12(bonprep.getXtva12());
            _bonPrep.setXtva21(bonprep.getXtva21());
            _bonPrep.setXtva36(bonprep.getXtva36());
            _bonPrep.setPlusV(bonprep.getPlusV());
            _bonPrep.setTauxRes(bonprep.getTauxRes());
            _bonPrep.setMontTrs(bonprep.getMontTrs());
            _bonPrep.setLiv(bonprep.getLiv());
            _bonPrep.setPointage(bonprep.getPointage());
            _bonPrep.setNatLiv(bonprep.getNatLiv());
            _bonPrep.setNatDoc(bonprep.getNatDoc());
            _bonPrep.setCodeTva(bonprep.getCodeTva());
            _bonPrep.setXbase19(bonprep.getXbase19());
            _bonPrep.setXtva19(bonprep.getXtva19());
            _bonPrep.setXbase13(bonprep.getXbase13());
            _bonPrep.setXtva13(bonprep.getXtva13());
            _bonPrep.setXbase7A(bonprep.getXbase7A());
            _bonPrep.setXtva7A(bonprep.getXtva7A());
            _bonPrep.setAdresse(bonprep.getAdresse());
            _bonPrep.setPoint(bonprep.getPoint());
            _bonPrep.setAideMag(bonprep.getAideMag());
            _bonPrep.setEmbal(bonprep.getEmbal());
            _bonPrep.setPrep(bonprep.getPrep());
            _bonPrep.setPoste(bonprep.getPoste());
            _bonPrep.setCentre(bonprep.getCentre());
            _bonPrep.setXbase19(bonprep.getXbase19());
            _bonPrep.setXtva19(bonprep.getXtva19());
            _bonPrep.setXbase13(bonprep.getXbase13());
            _bonPrep.setXtva13(bonprep.getXtva13());
            _bonPrep.setXbase7A(bonprep.getXbase7A());
            _bonPrep.setXtva7A(bonprep.getXtva7A());
            _bonPrep.setAven_tage(bonprep.getAven_tage());
            _bonPrep.setUser(bonprep.getUser());

            return new ResponseEntity<>(service.updateBonPrep(_bonPrep), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
  
    
    @PutMapping("/bonPreps/Prix/{NUM_BON}")
    public ResponseEntity<BonPrep> updateBonPrepPrix(@PathVariable("NUM_BON") String numBon, @RequestBody BonPrep bonprep) {
        Optional<BonPrep> bonPrepData = repository.findById(numBon);

        if (bonPrepData.isPresent()) {
            BonPrep _bonPrep = bonPrepData.get();
            
            _bonPrep.setBrutHt(bonprep.getBrutHt());
            _bonPrep.setNetHt(bonprep.getNetHt());
            _bonPrep.setTotTtc(bonprep.getTotTtc());
            
            return new ResponseEntity<>(service.updateBonPrep(_bonPrep), HttpStatus.OK);
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







          /**  statistique  Bar Bon liv */ 

          @GetMapping("/bonPreps/SumBar1")
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
          @GetMapping("/bonPreps/SumBar2")
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
          @GetMapping("/bonPreps/SumBar3")
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
          @GetMapping("/bonPreps/SumBar4")
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
          @GetMapping("/bonPreps/SumBar5")
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
          @GetMapping("/bonPreps/SumBar6")
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
          @GetMapping("/bonPreps/SumBar7")
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




             /**  statistique Pie */ 
   @GetMapping("/bonPreps/SumC")
   public ResponseEntity<Optional<Integer>> getSumC() {
       try {
           Optional<Integer> SumC = service.getSumC();  /** pour get Sum Quantité de Livraison */
           if (SumC.isEmpty()) {
               return new ResponseEntity<>(HttpStatus.NO_CONTENT);
           }
           return new ResponseEntity<>(SumC, HttpStatus.OK);
       } catch (Exception e) {
           return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
       }
   }     
   @GetMapping("/bonPreps/SumL")
   public ResponseEntity<Optional<Integer>> getSumL() {
       try {
           Optional<Integer> SumL = service.getSumL();  /** pour get Sum Quantité de Livraison */
           if (SumL.isEmpty()) {
               return new ResponseEntity<>(HttpStatus.NO_CONTENT);
           }
           return new ResponseEntity<>(SumL, HttpStatus.OK);
       } catch (Exception e) {
           return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
       }
   } 


        /**  statistique Pie */ 
   @GetMapping("/bonPreps/SumD1")
   public ResponseEntity<Optional<Integer>> getSumD1() {
       try {
           Optional<Integer> SumD1 = service.getSumD1();  /** pour get Sum Quantité de Livraison */
           if (SumD1.isEmpty()) {
               return new ResponseEntity<>(HttpStatus.NO_CONTENT);
           }
           return new ResponseEntity<>(SumD1, HttpStatus.OK);
       } catch (Exception e) {
           return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
       }
   }     
   @GetMapping("/bonPreps/SumD2")
   public ResponseEntity<Optional<Integer>> getSumD2() {
       try {
           Optional<Integer> SumD2 = service.getSumD2();  /** pour get Sum Quantité de Livraison */
           if (SumD2.isEmpty()) {
               return new ResponseEntity<>(HttpStatus.NO_CONTENT);
           }
           return new ResponseEntity<>(SumD2, HttpStatus.OK);
       } catch (Exception e) {
           return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
       }
   } 
   @GetMapping("/bonPreps/SumD3")
   public ResponseEntity<Optional<Integer>> getSumD3() {
       try {
           Optional<Integer> SumD3 = service.getSumD3();  /** pour get Sum Quantité de Livraison */
           if (SumD3.isEmpty()) {
               return new ResponseEntity<>(HttpStatus.NO_CONTENT);
           }
           return new ResponseEntity<>(SumD3, HttpStatus.OK);
       } catch (Exception e) {
           return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
       }
   } 
   @GetMapping("/bonPreps/SumD4")
   public ResponseEntity<Optional<Integer>> getSumD4() {
       try {
           Optional<Integer> SumD4 = service.getSumD4();  /** pour get Sum Quantité de Livraison */
           if (SumD4.isEmpty()) {
               return new ResponseEntity<>(HttpStatus.NO_CONTENT);
           }
           return new ResponseEntity<>(SumD4, HttpStatus.OK);
       } catch (Exception e) {
           return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
       }
   } 
}

