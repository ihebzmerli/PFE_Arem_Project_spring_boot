package com.loizenai.jwtauthentication.controller;

import com.loizenai.jwtauthentication.model.BonLiv;
import com.loizenai.jwtauthentication.model.EtatLiv;
import com.loizenai.jwtauthentication.model.EtatLiv.CONFIRMATION;
import com.loizenai.jwtauthentication.repository.Bon_LivRepository;
import com.loizenai.jwtauthentication.repository.Etat_LivRepository;
import com.loizenai.jwtauthentication.services.Bon_LivService;
import com.loizenai.jwtauthentication.services.Etat_LivService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class Etat_LivController {

    @Autowired
    private Etat_LivService service;

    @Autowired
    private Bon_LivService serviceBonLiv;

    @Autowired
    Etat_LivRepository repository;

    @GetMapping("/etatLivs")
    public ResponseEntity<List<EtatLiv>> getAllEtatLivs() {
        List<EtatLiv> etatLivs = new ArrayList<>();
        try {
            service.getEtatLivs().forEach(etatLivs::add);

            if (etatLivs.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(etatLivs, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/etatLivs/{id}")
    public ResponseEntity<EtatLiv> getEtatLivById(@PathVariable("id") long id) {
        Optional<EtatLiv> etatLivData = repository.findById(id);

        if (etatLivData.isPresent()) {
            return new ResponseEntity<>(etatLivData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/etatLivs")
    public ResponseEntity<EtatLiv> postEtatliv(@RequestBody EtatLiv etatLiv) {
        try {
            service.addEtatLiv(etatLiv);
            return new ResponseEntity<>(etatLiv, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @DeleteMapping("/etatLivs/{id}")
    public ResponseEntity<HttpStatus> deleteEtatliv(@PathVariable("id") long id) {
        try {
            service.deleteEtatLiv(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @DeleteMapping("/etatLivs")
    public ResponseEntity<HttpStatus> deleteAllEtatLivs() {
        try {
            repository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    //searsh with FK_keys******************
    @GetMapping("/etatLivs/etatLiv_Region/{region}")
    public ResponseEntity<List<EtatLiv>> getAllEtatLivByRegion(@PathVariable String region) {
        try {
            List<EtatLiv> etatLivByZone= service.getAllEtatLivByRegion(region);  /** pour afficher les etat de livraison by region */
    
            if (etatLivByZone.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(etatLivByZone, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
    @GetMapping("/etatLivs/etatLiv_Date/{startDate}to{endDate}")
    public ResponseEntity<List<EtatLiv>> getAllEtatLivBydateBetween(@PathVariable String startDate,@PathVariable String endDate) {
        try {
            List<EtatLiv> EtaLivByDateBetween= service.getAllEtatLivBydateBetween(startDate,endDate);  /** pour afficher les etat de livraison entre 2 date */
    
            if (EtaLivByDateBetween.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(EtaLivByDateBetween, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
    @GetMapping("/etatLivs/etatLiv_BL/{bon_liv}")
    public ResponseEntity<List<EtatLiv>> getAllEtatLivByBL(@PathVariable String bon_liv) {
        try {
            List<EtatLiv> EtaLivByBL= service.getAllEtatLivByBL(bon_liv);  /** pour afficher les etat de livraison entre 2 date */
    
            if (EtaLivByBL.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(EtaLivByBL, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }






    // end for the searsh of FK_Keys*******************
    @PutMapping("/etatLivs/{id}")
    public ResponseEntity<EtatLiv> updateEtatLiv(@PathVariable("id") long id, @RequestBody EtatLiv etatliv) {
        Optional<EtatLiv> etatLivData = repository.findById(id);

        if (etatLivData.isPresent()) {
            EtatLiv _etatLiv = etatLivData.get();

            _etatLiv.setRegion(etatliv.getRegion());
            if(_etatLiv.getConfirmation()!=etatliv.getConfirmation()){
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                _etatLiv.setDate(timestamp); 
            }
            _etatLiv.setConfirmation(etatliv.getConfirmation());

            _etatLiv.setBonLiv(etatliv.getBonLiv());
            CONFIRMATION test=etatliv.getConfirmation();
            if(test==EtatLiv.CONFIRMATION.recu_est_verifier){
                Timestamp timestamp2 = new Timestamp(System.currentTimeMillis());
                BonLiv bonliv = etatliv.getBonLiv();
                bonliv.setCronoTime(timestamp2);
                serviceBonLiv.updateBonLiv(bonliv);
            }

            return new ResponseEntity<>(service.updateEtatLiv(_etatLiv), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/etatLivs/chronometre/{endDate}")
    public ResponseEntity<Optional<Integer>> getEtatCronometre(@PathVariable("endDate") String endDate,Timestamp timestawa ) {
        try {
            Optional<Integer> chronometre= service.getEtatCronometre(endDate,timestawa.toString()); 

            if (chronometre.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(chronometre, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

















          /**  statistique  X-ANEX  */ 

          @GetMapping("/etatLivs/SumBar1")
          public ResponseEntity<Optional<Integer>> getSumBar1() {
              try {
                  Optional<Integer> SumBar1 = service.getSumBar1();  /** pour get Sum Quantité de Livraison */
                  if (SumBar1.isEmpty()) {
                      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                  }
                  return new ResponseEntity<>(SumBar1, HttpStatus.OK);
              } catch (Exception e) {
                  return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
              }
          }
          @GetMapping("/etatLivs/SumBar2")
          public ResponseEntity<Optional<Integer>> getSumBar2() {
              try {
                  Optional<Integer> SumBar2 = service.getSumBar2();  /** pour get Sum Quantité de Livraison */
                  if (SumBar2.isEmpty()) {
                      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                  }
                  return new ResponseEntity<>(SumBar2, HttpStatus.OK);
              } catch (Exception e) {
                  return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
              }
          }
          @GetMapping("/etatLivs/SumBar3")
          public ResponseEntity<Optional<Integer>> getSumBar3() {
              try {
                  Optional<Integer> SumBar3 = service.getSumBar3();  /** pour get Sum Quantité de Livraison */
                  if (SumBar3.isEmpty()) {
                      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                  }
                  return new ResponseEntity<>(SumBar3, HttpStatus.OK);
              } catch (Exception e) {
                  return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
              }
          }
          @GetMapping("/etatLivs/SumBar4")
          public ResponseEntity<Optional<Integer>> getSumBar4() {
              try {
                  Optional<Integer> SumBar4 = service.getSumBar4();  /** pour get Sum Quantité de Livraison */
                  if (SumBar4.isEmpty()) {
                      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                  }
                  return new ResponseEntity<>(SumBar4, HttpStatus.OK);
              } catch (Exception e) {
                  return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
              }
          }
          @GetMapping("/etatLivs/SumBar5")
          public ResponseEntity<Optional<Integer>> getSumBar5() {
              try {
                  Optional<Integer> SumBar5 = service.getSumBar5();  /** pour get Sum Quantité de Livraison */
                  if (SumBar5.isEmpty()) {
                      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                  }
                  return new ResponseEntity<>(SumBar5, HttpStatus.OK);
              } catch (Exception e) {
                  return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
              }
          }
          @GetMapping("/etatLivs/SumBar6")
          public ResponseEntity<Optional<Integer>> getSumBar6() {
              try {
                  Optional<Integer> SumBar6 = service.getSumBar6();  /** pour get Sum Quantité de Livraison */
                  if (SumBar6.isEmpty()) {
                      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                  }
                  return new ResponseEntity<>(SumBar6, HttpStatus.OK);
              } catch (Exception e) {
                  return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
              }
          }
          @GetMapping("/etatLivs/SumBar7")
          public ResponseEntity<Optional<Integer>> getSumBar7() {
              try {
                  Optional<Integer> SumBar7 = service.getSumBar7();  /** pour get Sum Quantité de Livraison */
                  if (SumBar7.isEmpty()) {
                      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                  }
                  return new ResponseEntity<>(SumBar7, HttpStatus.OK);
              } catch (Exception e) {
                  return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
              }
          }
          @GetMapping("/etatLivs/SumBar8")
          public ResponseEntity<Optional<Integer>> getSumBar8() {
              try {
                  Optional<Integer> SumBar8 = service.getSumBar8();  /** pour get Sum Quantité de Livraison */
                  if (SumBar8.isEmpty()) {
                      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                  }
                  return new ResponseEntity<>(SumBar8, HttpStatus.OK);
              } catch (Exception e) {
                  return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
              }
          }
          @GetMapping("/etatLivs/SumBar9")
          public ResponseEntity<Optional<Integer>> getSumBar9() {
              try {
                  Optional<Integer> SumBar9 = service.getSumBar9();  /** pour get Sum Quantité de Livraison */
                  if (SumBar9.isEmpty()) {
                      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                  }
                  return new ResponseEntity<>(SumBar9, HttpStatus.OK);
              } catch (Exception e) {
                  return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
              }
          }
          @GetMapping("/etatLivs/SumBar10")
          public ResponseEntity<Optional<Integer>> getSumBar10() {
              try {
                  Optional<Integer> SumBar10 = service.getSumBar10();  /** pour get Sum Quantité de Livraison */
                  if (SumBar10.isEmpty()) {
                      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                  }
                  return new ResponseEntity<>(SumBar10, HttpStatus.OK);
              } catch (Exception e) {
                  return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
              }
          }
          @GetMapping("/etatLivs/SumBar11")
          public ResponseEntity<Optional<Integer>> getSumBar11() {
              try {
                  Optional<Integer> SumBar11 = service.getSumBar11();  /** pour get Sum Quantité de Livraison */
                  if (SumBar11.isEmpty()) {
                      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                  }
                  return new ResponseEntity<>(SumBar11, HttpStatus.OK);
              } catch (Exception e) {
                  return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
              }
          }
          @GetMapping("/etatLivs/SumBar12")
          public ResponseEntity<Optional<Integer>> getSumBar12() {
              try {
                  Optional<Integer> SumBar12 = service.getSumBar12();  /** pour get Sum Quantité de Livraison */
                  if (SumBar12.isEmpty()) {
                      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                  }
                  return new ResponseEntity<>(SumBar12, HttpStatus.OK);
              } catch (Exception e) {
                  return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
              }
          }




          /******************** */
          @GetMapping("/etatLivs/SumBar21")
          public ResponseEntity<Optional<Integer>> getSumBar21() {
              try {
                  Optional<Integer> SumBar21 = service.getSumBar21();  /** pour get Sum Quantité de Livraison */
                  if (SumBar21.isEmpty()) {
                      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                  }
                  return new ResponseEntity<>(SumBar21, HttpStatus.OK);
              } catch (Exception e) {
                  return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
              }
          }
          @GetMapping("/etatLivs/SumBar22")
          public ResponseEntity<Optional<Integer>> getSumBar22() {
              try {
                  Optional<Integer> SumBar22 = service.getSumBar22();  /** pour get Sum Quantité de Livraison */
                  if (SumBar22.isEmpty()) {
                      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                  }
                  return new ResponseEntity<>(SumBar22, HttpStatus.OK);
              } catch (Exception e) {
                  return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
              }
          }
          @GetMapping("/etatLivs/SumBar23")
          public ResponseEntity<Optional<Integer>> getSumBar23() {
              try {
                  Optional<Integer> SumBar23 = service.getSumBar23();  /** pour get Sum Quantité de Livraison */
                  if (SumBar23.isEmpty()) {
                      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                  }
                  return new ResponseEntity<>(SumBar23, HttpStatus.OK);
              } catch (Exception e) {
                  return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
              }
          }
          @GetMapping("/etatLivs/SumBar24")
          public ResponseEntity<Optional<Integer>> getSumBar24() {
              try {
                  Optional<Integer> SumBar24 = service.getSumBar24();  /** pour get Sum Quantité de Livraison */
                  if (SumBar24.isEmpty()) {
                      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                  }
                  return new ResponseEntity<>(SumBar24, HttpStatus.OK);
              } catch (Exception e) {
                  return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
              }
          }
          @GetMapping("/etatLivs/SumBar25")
          public ResponseEntity<Optional<Integer>> getSumBar25() {
              try {
                  Optional<Integer> SumBar25 = service.getSumBar25();  /** pour get Sum Quantité de Livraison */
                  if (SumBar25.isEmpty()) {
                      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                  }
                  return new ResponseEntity<>(SumBar25, HttpStatus.OK);
              } catch (Exception e) {
                  return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
              }
          }
          @GetMapping("/etatLivs/SumBar26")
          public ResponseEntity<Optional<Integer>> getSumBar26() {
              try {
                  Optional<Integer> SumBar26 = service.getSumBar26();  /** pour get Sum Quantité de Livraison */
                  if (SumBar26.isEmpty()) {
                      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                  }
                  return new ResponseEntity<>(SumBar26, HttpStatus.OK);
              } catch (Exception e) {
                  return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
              }
          }
          @GetMapping("/etatLivs/SumBar27")
          public ResponseEntity<Optional<Integer>> getSumBar27() {
              try {
                  Optional<Integer> SumBar27 = service.getSumBar27();  /** pour get Sum Quantité de Livraison */
                  if (SumBar27.isEmpty()) {
                      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                  }
                  return new ResponseEntity<>(SumBar27, HttpStatus.OK);
              } catch (Exception e) {
                  return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
              }
          }
          @GetMapping("/etatLivs/SumBar28")
          public ResponseEntity<Optional<Integer>> getSumBar28() {
              try {
                  Optional<Integer> SumBar28 = service.getSumBar28();  /** pour get Sum Quantité de Livraison */
                  if (SumBar28.isEmpty()) {
                      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                  }
                  return new ResponseEntity<>(SumBar28, HttpStatus.OK);
              } catch (Exception e) {
                  return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
              }
          }
          @GetMapping("/etatLivs/SumBar29")
          public ResponseEntity<Optional<Integer>> getSumBar29() {
              try {
                  Optional<Integer> SumBar29 = service.getSumBar29();  /** pour get Sum Quantité de Livraison */
                  if (SumBar29.isEmpty()) {
                      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                  }
                  return new ResponseEntity<>(SumBar29, HttpStatus.OK);
              } catch (Exception e) {
                  return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
              }
          }
          @GetMapping("/etatLivs/SumBar210")
          public ResponseEntity<Optional<Integer>> getSumBar210() {
              try {
                  Optional<Integer> SumBar210 = service.getSumBar210();  /** pour get Sum Quantité de Livraison */
                  if (SumBar210.isEmpty()) {
                      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                  }
                  return new ResponseEntity<>(SumBar210, HttpStatus.OK);
              } catch (Exception e) {
                  return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
              }
          }
          @GetMapping("/etatLivs/SumBar211")
          public ResponseEntity<Optional<Integer>> getSumBar211() {
              try {
                  Optional<Integer> SumBar211 = service.getSumBar211();  /** pour get Sum Quantité de Livraison */
                  if (SumBar211.isEmpty()) {
                      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                  }
                  return new ResponseEntity<>(SumBar211, HttpStatus.OK);
              } catch (Exception e) {
                  return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
              }
          }
          @GetMapping("/etatLivs/SumBar212")
          public ResponseEntity<Optional<Integer>> getSumBar212() {
              try {
                  Optional<Integer> SumBar212 = service.getSumBar212();  /** pour get Sum Quantité de Livraison */
                  if (SumBar212.isEmpty()) {
                      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                  }
                  return new ResponseEntity<>(SumBar212, HttpStatus.OK);
              } catch (Exception e) {
                  return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
              }
          }
          /*************** */

          @GetMapping("/etatLivs/SumBar31")
          public ResponseEntity<Optional<Integer>> getSumBar31() {
              try {
                  Optional<Integer> SumBar31 = service.getSumBar31();  /** pour get Sum Quantité de Livraison */
                  if (SumBar31.isEmpty()) {
                      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                  }
                  return new ResponseEntity<>(SumBar31, HttpStatus.OK);
              } catch (Exception e) {
                  return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
              }
          }
          @GetMapping("/etatLivs/SumBar32")
          public ResponseEntity<Optional<Integer>> getSumBar32() {
              try {
                  Optional<Integer> SumBar32 = service.getSumBar32();  /** pour get Sum Quantité de Livraison */
                  if (SumBar32.isEmpty()) {
                      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                  }
                  return new ResponseEntity<>(SumBar32, HttpStatus.OK);
              } catch (Exception e) {
                  return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
              }
          }
          @GetMapping("/etatLivs/SumBar33")
          public ResponseEntity<Optional<Integer>> getSumBar33() {
              try {
                  Optional<Integer> SumBar33 = service.getSumBar33();  /** pour get Sum Quantité de Livraison */
                  if (SumBar33.isEmpty()) {
                      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                  }
                  return new ResponseEntity<>(SumBar33, HttpStatus.OK);
              } catch (Exception e) {
                  return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
              }
          }
          @GetMapping("/etatLivs/SumBar34")
          public ResponseEntity<Optional<Integer>> getSumBar34() {
              try {
                  Optional<Integer> SumBar34 = service.getSumBar34();  /** pour get Sum Quantité de Livraison */
                  if (SumBar34.isEmpty()) {
                      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                  }
                  return new ResponseEntity<>(SumBar34, HttpStatus.OK);
              } catch (Exception e) {
                  return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
              }
          }
          @GetMapping("/etatLivs/SumBar35")
          public ResponseEntity<Optional<Integer>> getSumBar35() {
              try {
                  Optional<Integer> SumBar35 = service.getSumBar35();  /** pour get Sum Quantité de Livraison */
                  if (SumBar35.isEmpty()) {
                      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                  }
                  return new ResponseEntity<>(SumBar35, HttpStatus.OK);
              } catch (Exception e) {
                  return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
              }
          }
          @GetMapping("/etatLivs/SumBar36")
          public ResponseEntity<Optional<Integer>> getSumBar36() {
              try {
                  Optional<Integer> SumBar36 = service.getSumBar36();  /** pour get Sum Quantité de Livraison */
                  if (SumBar36.isEmpty()) {
                      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                  }
                  return new ResponseEntity<>(SumBar36, HttpStatus.OK);
              } catch (Exception e) {
                  return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
              }
          }
          @GetMapping("/etatLivs/SumBar37")
          public ResponseEntity<Optional<Integer>> getSumBar37() {
              try {
                  Optional<Integer> SumBar37 = service.getSumBar37();  /** pour get Sum Quantité de Livraison */
                  if (SumBar37.isEmpty()) {
                      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                  }
                  return new ResponseEntity<>(SumBar37, HttpStatus.OK);
              } catch (Exception e) {
                  return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
              }
          }
          @GetMapping("/etatLivs/SumBar38")
          public ResponseEntity<Optional<Integer>> getSumBar38() {
              try {
                  Optional<Integer> SumBar38 = service.getSumBar38();  /** pour get Sum Quantité de Livraison */
                  if (SumBar38.isEmpty()) {
                      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                  }
                  return new ResponseEntity<>(SumBar38, HttpStatus.OK);
              } catch (Exception e) {
                  return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
              }
          }
          @GetMapping("/etatLivs/SumBar39")
          public ResponseEntity<Optional<Integer>> getSumBar39() {
              try {
                  Optional<Integer> SumBar39 = service.getSumBar39();  /** pour get Sum Quantité de Livraison */
                  if (SumBar39.isEmpty()) {
                      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                  }
                  return new ResponseEntity<>(SumBar39, HttpStatus.OK);
              } catch (Exception e) {
                  return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
              }
          }
          @GetMapping("/etatLivs/SumBar310")
          public ResponseEntity<Optional<Integer>> getSumBar310() {
              try {
                  Optional<Integer> SumBar310 = service.getSumBar310();  /** pour get Sum Quantité de Livraison */
                  if (SumBar310.isEmpty()) {
                      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                  }
                  return new ResponseEntity<>(SumBar310, HttpStatus.OK);
              } catch (Exception e) {
                  return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
              }
          }
          @GetMapping("/etatLivs/SumBar311")
          public ResponseEntity<Optional<Integer>> getSumBar311() {
              try {
                  Optional<Integer> SumBar311 = service.getSumBar311();  /** pour get Sum Quantité de Livraison */
                  if (SumBar311.isEmpty()) {
                      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                  }
                  return new ResponseEntity<>(SumBar311, HttpStatus.OK);
              } catch (Exception e) {
                  return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
              }
          }
          @GetMapping("/etatLivs/SumBar312")
          public ResponseEntity<Optional<Integer>> getSumBar312() {
              try {
                  Optional<Integer> SumBar312 = service.getSumBar312();  /** pour get Sum Quantité de Livraison */
                  if (SumBar312.isEmpty()) {
                      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                  }
                  return new ResponseEntity<>(SumBar312, HttpStatus.OK);
              } catch (Exception e) {
                  return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
              }
          }


          /***** */




          @GetMapping("/etatLivs/SumBar41")
          public ResponseEntity<Optional<Integer>> getSumBar41() {
              try {
                  Optional<Integer> SumBar41 = service.getSumBar41();  /** pour get Sum Quantité de Livraison */
                  if (SumBar41.isEmpty()) {
                      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                  }
                  return new ResponseEntity<>(SumBar41, HttpStatus.OK);
              } catch (Exception e) {
                  return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
              }
          }
          @GetMapping("/etatLivs/SumBar42")
          public ResponseEntity<Optional<Integer>> getSumBar42() {
              try {
                  Optional<Integer> SumBar42 = service.getSumBar42();  /** pour get Sum Quantité de Livraison */
                  if (SumBar42.isEmpty()) {
                      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                  }
                  return new ResponseEntity<>(SumBar42, HttpStatus.OK);
              } catch (Exception e) {
                  return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
              }
          }
          @GetMapping("/etatLivs/SumBar43")
          public ResponseEntity<Optional<Integer>> getSumBar43() {
              try {
                  Optional<Integer> SumBar43 = service.getSumBar43();  /** pour get Sum Quantité de Livraison */
                  if (SumBar43.isEmpty()) {
                      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                  }
                  return new ResponseEntity<>(SumBar43, HttpStatus.OK);
              } catch (Exception e) {
                  return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
              }
          }
          @GetMapping("/etatLivs/SumBar44")
          public ResponseEntity<Optional<Integer>> getSumBar44() {
              try {
                  Optional<Integer> SumBar44 = service.getSumBar44();  /** pour get Sum Quantité de Livraison */
                  if (SumBar44.isEmpty()) {
                      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                  }
                  return new ResponseEntity<>(SumBar44, HttpStatus.OK);
              } catch (Exception e) {
                  return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
              }
          }
          @GetMapping("/etatLivs/SumBar45")
          public ResponseEntity<Optional<Integer>> getSumBar45() {
              try {
                  Optional<Integer> SumBar45 = service.getSumBar45();  /** pour get Sum Quantité de Livraison */
                  if (SumBar45.isEmpty()) {
                      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                  }
                  return new ResponseEntity<>(SumBar45, HttpStatus.OK);
              } catch (Exception e) {
                  return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
              }
          }
          @GetMapping("/etatLivs/SumBar46")
          public ResponseEntity<Optional<Integer>> getSumBar46() {
              try {
                  Optional<Integer> SumBar46 = service.getSumBar46();  /** pour get Sum Quantité de Livraison */
                  if (SumBar46.isEmpty()) {
                      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                  }
                  return new ResponseEntity<>(SumBar46, HttpStatus.OK);
              } catch (Exception e) {
                  return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
              }
          }
          @GetMapping("/etatLivs/SumBar47")
          public ResponseEntity<Optional<Integer>> getSumBar47() {
              try {
                  Optional<Integer> SumBar47 = service.getSumBar47();  /** pour get Sum Quantité de Livraison */
                  if (SumBar47.isEmpty()) {
                      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                  }
                  return new ResponseEntity<>(SumBar47, HttpStatus.OK);
              } catch (Exception e) {
                  return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
              }
          }
          @GetMapping("/etatLivs/SumBar48")
          public ResponseEntity<Optional<Integer>> getSumBar48() {
              try {
                  Optional<Integer> SumBar48 = service.getSumBar48();  /** pour get Sum Quantité de Livraison */
                  if (SumBar48.isEmpty()) {
                      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                  }
                  return new ResponseEntity<>(SumBar48, HttpStatus.OK);
              } catch (Exception e) {
                  return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
              }
          }
          @GetMapping("/etatLivs/SumBar49")
          public ResponseEntity<Optional<Integer>> getSumBar49() {
              try {
                  Optional<Integer> SumBar49 = service.getSumBar49();  /** pour get Sum Quantité de Livraison */
                  if (SumBar49.isEmpty()) {
                      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                  }
                  return new ResponseEntity<>(SumBar49, HttpStatus.OK);
              } catch (Exception e) {
                  return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
              }
          }
          @GetMapping("/etatLivs/SumBar410")
          public ResponseEntity<Optional<Integer>> getSumBar410() {
              try {
                  Optional<Integer> SumBar410 = service.getSumBar410();  /** pour get Sum Quantité de Livraison */
                  if (SumBar410.isEmpty()) {
                      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                  }
                  return new ResponseEntity<>(SumBar410, HttpStatus.OK);
              } catch (Exception e) {
                  return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
              }
          }
          @GetMapping("/etatLivs/SumBar411")
          public ResponseEntity<Optional<Integer>> getSumBar411() {
              try {
                  Optional<Integer> SumBar411 = service.getSumBar411();  /** pour get Sum Quantité de Livraison */
                  if (SumBar411.isEmpty()) {
                      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                  }
                  return new ResponseEntity<>(SumBar411, HttpStatus.OK);
              } catch (Exception e) {
                  return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
              }
          }
          @GetMapping("/etatLivs/SumBar412")
          public ResponseEntity<Optional<Integer>> getSumBar412() {
              try {
                  Optional<Integer> SumBar412 = service.getSumBar412();  /** pour get Sum Quantité de Livraison */
                  if (SumBar412.isEmpty()) {
                      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                  }
                  return new ResponseEntity<>(SumBar412, HttpStatus.OK);
              } catch (Exception e) {
                  return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
              }
          }
}
