package com.loizenai.jwtauthentication.controller;

import com.loizenai.jwtauthentication.model.BonLiv;
import com.loizenai.jwtauthentication.model.Expide;
import com.loizenai.jwtauthentication.model.Livreur;
import com.loizenai.jwtauthentication.model.Livreur_Expide;
import com.loizenai.jwtauthentication.repository.ExpideRepository;
import com.loizenai.jwtauthentication.services.ExpideService;
import com.loizenai.jwtauthentication.services.Livreur_ExpideService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class ExpideController {

    @Autowired
    private ExpideService service;
    @Autowired
    private Livreur_ExpideService serviceLivreurExpide;

    @Autowired
    ExpideRepository repository;

    @GetMapping("/expides")
    public ResponseEntity<List<Expide>> getAllExpides() {
        List<Expide> expides = new ArrayList<>();
        try {
            service.getExpides().forEach(expides::add);

            if (expides.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(expides, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/expides/{id}")
    public ResponseEntity<Expide> getExpideById(@PathVariable("id") long id) {
        Optional<Expide> expideData = repository.findById(id);

        if (expideData.isPresent()) {
            return new ResponseEntity<>(expideData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping(value = "/expides")
    public ResponseEntity<Expide> postExpide(@RequestBody Expide expide) {
        try {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            expide.setDatExpedition(timestamp);
            service.addExpide(expide);
            return new ResponseEntity<>(expide, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }
    @DeleteMapping("/expides/{id}")
    public ResponseEntity<HttpStatus> deleteExpide(@PathVariable("id") long id) {
        try {
            service.deleteExpide(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
    @DeleteMapping("/expides")
    public ResponseEntity<HttpStatus> deleteAllExpides() {
        try {
            repository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    //searsh with FK_keys******************

    @GetMapping("/expides/expide_TyDc/{typeDoc}")
    public ResponseEntity<List<Expide>> getAllExpideByTypDoc(@PathVariable String typeDoc) {
        try {
            List<Expide> ExpideByTD= service.getAllExpideByTypDoc(typeDoc);  /** pour afficher les expidition by type document */
    
            if (ExpideByTD.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(ExpideByTD, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }


    @GetMapping("/expides/expide_Transp/{transporter}")
    public ResponseEntity<List<Expide>> getAllExpideByTransp(@PathVariable String transporter) {
        try {
            List<Expide> ExpideByTrasp= service.getAllExpideByTransp(transporter);  /** pour afficher les expidition by transporter*/
    
            if (ExpideByTrasp.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(ExpideByTrasp, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping("/expides/expide_TyEx/{typExp}")
    public ResponseEntity<List<Expide>> getAllExpideByTypExp(@PathVariable String typExp) {
        try {
            List<Expide> ExpideByTyExp= service.getAllExpideByTypExp(typExp);  /** pour afficher les expidition by type expedition*/
    
            if (ExpideByTyExp.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(ExpideByTyExp, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping("/expides/expide_Date/{startDate}to{endDate}")
    public ResponseEntity<List<Expide>> getAllExpideBydateEXBetween(@PathVariable String startDate,@PathVariable String endDate) {
        try {
            List<Expide> ExpideByDateBetween= service.getAllExpideBydateEXBetween(startDate,endDate);  /** pour afficher les expidition entre 2 date */
    
            if (ExpideByDateBetween.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(ExpideByDateBetween, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }


/**select list add */

@GetMapping(value = "/expides/allList")
public ResponseEntity<List<Date>> getExpideOfAdd() {
    try {
        List<Date> ExpideAllList = service.getExpideOfAdd();

        if (ExpideAllList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);   /** pour afficher les expidition drop list */
        }
        return new ResponseEntity<>(ExpideAllList, HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }
}

@GetMapping(value = "/bonPreps/allListExpide")
public ResponseEntity<List<Date>> getExpideOfAddForBonPrep() {
    try {
        List<Date> ExpideAllList = service.getExpideOfAddForBonPrep();

        if (ExpideAllList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);   /** pour afficher les expidition drop list */
        }
        return new ResponseEntity<>(ExpideAllList, HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }
}

/**select list add */


// end for the searsh of FK_Keys*******************
    @PutMapping("/expides/{id}")
    public ResponseEntity<Expide> updateExpide(@PathVariable("id") long id, @RequestBody Expide expide) {
        Optional<Expide> expideData = repository.findById(id);

        if (expideData.isPresent()) {
            Expide _expide = expideData.get();
            _expide.setDatExpedition(expide.getDatExpedition());
            _expide.setTypExp(expide.getTypExp());
            _expide.setTransp(expide.getTransp());
            _expide.setMatAgent(expide.getMatAgent());
            _expide.setTypeDoc(expide.getTypeDoc());
            _expide.setUser(expide.getUser());
            return new ResponseEntity<>(service.updateExpide(_expide), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }





    @GetMapping("/expides/LastId")
    public ResponseEntity<Optional<Integer>> getLastId() {
        try {
            Optional<Integer> lastId = service.getLastId();  
            if (lastId.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(lastId, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }


    
             /**  statistique  Pie Chariot*/ 

             @GetMapping("/expides/SumT1")
             public ResponseEntity<Optional<Integer>> getSumT1() {
                 try {
                     Optional<Integer> SumT1 = service.getSumT1();  /** pour get Sum Quantité d'expedition */
                     if (SumT1.isEmpty()) {
                         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                     }
                     return new ResponseEntity<>(SumT1, HttpStatus.OK);
                 } catch (Exception e) {
                     return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
                 }
             }
             @GetMapping("/expides/SumT2")
             public ResponseEntity<Optional<Integer>> getSumT2() {
                 try {
                     Optional<Integer> SumT2 = service.getSumT2();  /** pour get Sum Quantité d'expedition */
                     if (SumT2.isEmpty()) {
                         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                     }
                     return new ResponseEntity<>(SumT2, HttpStatus.OK);
                 } catch (Exception e) {
                     return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
                 }
             }






             /**  statistique  Bar Horizontale*/ 

             @GetMapping("/expides/SumM11")
             public ResponseEntity<Optional<Integer>> getSumM11() {
                 try {
                     Optional<Integer> SumM11 = service.getSumM11();  /** pour get Sum Quantité d'expedition */
                     if (SumM11.isEmpty()) {
                         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                     }
                     return new ResponseEntity<>(SumM11, HttpStatus.OK);
                 } catch (Exception e) {
                     return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
                 }
             }
             @GetMapping("/expides/SumM12")
             public ResponseEntity<Optional<Integer>> getSumM12() {
                 try {
                     Optional<Integer> SumM12 = service.getSumM12();  /** pour get Sum Quantité d'expedition */
                     if (SumM12.isEmpty()) {
                         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                     }
                     return new ResponseEntity<>(SumM12, HttpStatus.OK);
                 } catch (Exception e) {
                     return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
                 }
             }
             @GetMapping("/expides/SumM13")
             public ResponseEntity<Optional<Integer>> getSumM13() {
                 try {
                     Optional<Integer> SumM13 = service.getSumM13();  /** pour get Sum Quantité d'expedition */
                     if (SumM13.isEmpty()) {
                         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                     }
                     return new ResponseEntity<>(SumM13, HttpStatus.OK);
                 } catch (Exception e) {
                     return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
                 }
             }
             @GetMapping("/expides/SumM14")
             public ResponseEntity<Optional<Integer>> getSumM14() {
                 try {
                     Optional<Integer> SumM14 = service.getSumM14();  /** pour get Sum Quantité d'expedition */
                     if (SumM14.isEmpty()) {
                         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                     }
                     return new ResponseEntity<>(SumM14, HttpStatus.OK);
                 } catch (Exception e) {
                     return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
                 }
             }  
             @GetMapping("/expides/SumM15")
             public ResponseEntity<Optional<Integer>> getSumM15() {
                 try {
                     Optional<Integer> SumM5 = service.getSumM15();  /** pour get Sum Quantité d'expedition */
                     if (SumM5.isEmpty()) {
                         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                     }
                     return new ResponseEntity<>(SumM5, HttpStatus.OK);
                 } catch (Exception e) {
                     return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
                 }
             }
             @GetMapping("/expides/SumM16")
             public ResponseEntity<Optional<Integer>> getSumM16() {
                 try {
                     Optional<Integer> SumM16 = service.getSumM16();  /** pour get Sum Quantité d'expedition */
                     if (SumM16.isEmpty()) {
                         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                     }
                     return new ResponseEntity<>(SumM16, HttpStatus.OK);
                 } catch (Exception e) {
                     return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
                 }
             }

             @GetMapping("/expides/SumM17")
             public ResponseEntity<Optional<Integer>> getSumM17() {
                 try {
                     Optional<Integer> SumM17 = service.getSumM17();  /** pour get Sum Quantité d'expedition */
                     if (SumM17.isEmpty()) {
                         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                     }
                     return new ResponseEntity<>(SumM17, HttpStatus.OK);
                 } catch (Exception e) {
                     return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
                 }
             }

             @GetMapping("/expides/SumM18")
             public ResponseEntity<Optional<Integer>> getSumM18() {
                 try {
                     Optional<Integer> SumM18 = service.getSumM18();  /** pour get Sum Quantité d'expedition */
                     if (SumM18.isEmpty()) {
                         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                     }
                     return new ResponseEntity<>(SumM18, HttpStatus.OK);
                 } catch (Exception e) {
                     return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
                 }
             }
             @GetMapping("/expides/SumM19")
             public ResponseEntity<Optional<Integer>> getSumM19() {
                 try {
                     Optional<Integer> SumM19 = service.getSumM19();  /** pour get Sum Quantité d'expedition */
                     if (SumM19.isEmpty()) {
                         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                     }
                     return new ResponseEntity<>(SumM19, HttpStatus.OK);
                 } catch (Exception e) {
                     return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
                 }
             }
             @GetMapping("/expides/SumM110")
             public ResponseEntity<Optional<Integer>> getSumM110() {
                 try {
                     Optional<Integer> SumM110 = service.getSumM110();  /** pour get Sum Quantité d'expedition */
                     if (SumM110.isEmpty()) {
                         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                     }
                     return new ResponseEntity<>(SumM110, HttpStatus.OK);
                 } catch (Exception e) {
                     return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
                 }
             }

             @GetMapping("/expides/SumM111")
             public ResponseEntity<Optional<Integer>> getSumM111() {
                 try {
                     Optional<Integer> SumM111 = service.getSumM111();  /** pour get Sum Quantité d'expedition */
                     if (SumM111.isEmpty()) {
                         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                     }
                     return new ResponseEntity<>(SumM111, HttpStatus.OK);
                 } catch (Exception e) {
                     return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
                 }
             }
             @GetMapping("/expides/SumM112")
             public ResponseEntity<Optional<Integer>> getSumM112() {
                 try {
                     Optional<Integer> SumM112 = service.getSumM112();  /** pour get Sum Quantité d'expedition */
                     if (SumM112.isEmpty()) {
                         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                     }
                     return new ResponseEntity<>(SumM112, HttpStatus.OK);
                 } catch (Exception e) {
                     return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
                 }
             }






                          /**  statistique  Bar Horizontale*/ 

                          @GetMapping("/expides/SumM21")
                          public ResponseEntity<Optional<Integer>> getSumM21() {
                              try {
                                  Optional<Integer> SumM21 = service.getSumM21();  /** pour get Sum Quantité d'expedition */
                                  if (SumM21.isEmpty()) {
                                      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                                  }
                                  return new ResponseEntity<>(SumM21, HttpStatus.OK);
                              } catch (Exception e) {
                                  return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
                              }
                          }
                          @GetMapping("/expides/SumM22")
                          public ResponseEntity<Optional<Integer>> getSumM22() {
                              try {
                                  Optional<Integer> SumM22 = service.getSumM22();  /** pour get Sum Quantité d'expedition */
                                  if (SumM22.isEmpty()) {
                                      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                                  }
                                  return new ResponseEntity<>(SumM22, HttpStatus.OK);
                              } catch (Exception e) {
                                  return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
                              }
                          }
                          @GetMapping("/expides/SumM23")
                          public ResponseEntity<Optional<Integer>> getSumM23() {
                              try {
                                  Optional<Integer> SumM23 = service.getSumM23();  /** pour get Sum Quantité d'expedition */
                                  if (SumM23.isEmpty()) {
                                      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                                  }
                                  return new ResponseEntity<>(SumM23, HttpStatus.OK);
                              } catch (Exception e) {
                                  return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
                              }
                          }
                          @GetMapping("/expides/SumM24")
                          public ResponseEntity<Optional<Integer>> getSumM24() {
                              try {
                                  Optional<Integer> SumM24 = service.getSumM24();  /** pour get Sum Quantité d'expedition */
                                  if (SumM24.isEmpty()) {
                                      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                                  }
                                  return new ResponseEntity<>(SumM24, HttpStatus.OK);
                              } catch (Exception e) {
                                  return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
                              }
                          }  
                          @GetMapping("/expides/SumM25")
                          public ResponseEntity<Optional<Integer>> getSumM25() {
                              try {
                                  Optional<Integer> SumM25 = service.getSumM25();  /** pour get Sum Quantité d'expedition */
                                  if (SumM25.isEmpty()) {
                                      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                                  }
                                  return new ResponseEntity<>(SumM25, HttpStatus.OK);
                              } catch (Exception e) {
                                  return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
                              }
                          }
                          @GetMapping("/expides/SumM26")
                          public ResponseEntity<Optional<Integer>> getSumM26() {
                              try {
                                  Optional<Integer> SumM26 = service.getSumM26();  /** pour get Sum Quantité d'expedition */
                                  if (SumM26.isEmpty()) {
                                      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                                  }
                                  return new ResponseEntity<>(SumM26, HttpStatus.OK);
                              } catch (Exception e) {
                                  return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
                              }
                          }
             
                          @GetMapping("/expides/SumM27")
                          public ResponseEntity<Optional<Integer>> getSumM27() {
                              try {
                                  Optional<Integer> SumM27 = service.getSumM27();  /** pour get Sum Quantité d'expedition */
                                  if (SumM27.isEmpty()) {
                                      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                                  }
                                  return new ResponseEntity<>(SumM27, HttpStatus.OK);
                              } catch (Exception e) {
                                  return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
                              }
                          }
             
                          @GetMapping("/expides/SumM28")
                          public ResponseEntity<Optional<Integer>> getSumM28() {
                              try {
                                  Optional<Integer> SumM28 = service.getSumM28();  /** pour get Sum Quantité d'expedition */
                                  if (SumM28.isEmpty()) {
                                      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                                  }
                                  return new ResponseEntity<>(SumM28, HttpStatus.OK);
                              } catch (Exception e) {
                                  return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
                              }
                          }
                          @GetMapping("/expides/SumM29")
                          public ResponseEntity<Optional<Integer>> getSumM29() {
                              try {
                                  Optional<Integer> SumM29 = service.getSumM29();  /** pour get Sum Quantité d'expedition */
                                  if (SumM29.isEmpty()) {
                                      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                                  }
                                  return new ResponseEntity<>(SumM29, HttpStatus.OK);
                              } catch (Exception e) {
                                  return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
                              }
                          }
                          @GetMapping("/expides/SumM210")
                          public ResponseEntity<Optional<Integer>> getSumM210() {
                              try {
                                  Optional<Integer> SumM210 = service.getSumM210();  /** pour get Sum Quantité d'expedition */
                                  if (SumM210.isEmpty()) {
                                      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                                  }
                                  return new ResponseEntity<>(SumM210, HttpStatus.OK);
                              } catch (Exception e) {
                                  return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
                              }
                          }
             
                          @GetMapping("/expides/SumM211")
                          public ResponseEntity<Optional<Integer>> getSumM211() {
                              try {
                                  Optional<Integer> SumM211 = service.getSumM111();  /** pour get Sum Quantité d'expedition */
                                  if (SumM211.isEmpty()) {
                                      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                                  }
                                  return new ResponseEntity<>(SumM211, HttpStatus.OK);
                              } catch (Exception e) {
                                  return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
                              }
                          }
                          @GetMapping("/expides/SumM212")
                          public ResponseEntity<Optional<Integer>> getSumM212() {
                              try {
                                  Optional<Integer> SumM212 = service.getSumM212();  /** pour get Sum Quantité d'expedition */
                                  if (SumM212.isEmpty()) {
                                      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                                  }
                                  return new ResponseEntity<>(SumM212, HttpStatus.OK);
                              } catch (Exception e) {
                                  return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
                              }
                          }





//** statistique expide bar annnées */




@GetMapping("/expides/SumA11")
public ResponseEntity<Optional<Integer>> getSumA11() {
    try {
        Optional<Integer> SumA11 = service.getSumA11();  /** pour get Sum Quantité d'expedition */
        if (SumA11.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(SumA11, HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }
}
@GetMapping("/expides/SumA12")
public ResponseEntity<Optional<Integer>> getSumA12() {
    try {
        Optional<Integer> SumA12 = service.getSumA12();  /** pour get Sum Quantité d'expedition */
        if (SumA12.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(SumA12, HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }
}
@GetMapping("/expides/SumA13")
public ResponseEntity<Optional<Integer>> getSumA13() {
    try {
        Optional<Integer> SumA13 = service.getSumA13();  /** pour get Sum Quantité d'expedition */
        if (SumA13.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(SumA13, HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }
}
@GetMapping("/expides/SumA14")
public ResponseEntity<Optional<Integer>> getSumA14() {
    try {
        Optional<Integer> SumA14 = service.getSumA14();  /** pour get Sum Quantité d'expedition */
        if (SumA14.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(SumA14, HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }
}
@GetMapping("/expides/SumA15")
public ResponseEntity<Optional<Integer>> getSumA15() {
    try {
        Optional<Integer> SumA15 = service.getSumA15();  /** pour get Sum Quantité d'expedition */
        if (SumA15.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(SumA15, HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }
}
@GetMapping("/expides/SumA16")
public ResponseEntity<Optional<Integer>> getSumA16() {
    try {
        Optional<Integer> SumA16 = service.getSumA16();  /** pour get Sum Quantité d'expedition */
        if (SumA16.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(SumA16, HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }
}
@GetMapping("/expides/SumA17")
public ResponseEntity<Optional<Integer>> getSumA17() {
    try {
        Optional<Integer> SumA17 = service.getSumA17();  /** pour get Sum Quantité d'expedition */
        if (SumA17.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(SumA17, HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }
}




@GetMapping("/expides/SumA21")
public ResponseEntity<Optional<Integer>> getSumA21() {
    try {
        Optional<Integer> SumA21 = service.getSumA21();  /** pour get Sum Quantité d'expedition */
        if (SumA21.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(SumA21, HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }
}
@GetMapping("/expides/SumA22")
public ResponseEntity<Optional<Integer>> getSumA22() {
    try {
        Optional<Integer> SumA22 = service.getSumA22();  /** pour get Sum Quantité d'expedition */
        if (SumA22.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(SumA22, HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }
}
@GetMapping("/expides/SumA23")
public ResponseEntity<Optional<Integer>> getSumA23() {
    try {
        Optional<Integer> SumA23 = service.getSumA23();  /** pour get Sum Quantité d'expedition */
        if (SumA23.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(SumA23, HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }
}
@GetMapping("/expides/SumA24")
public ResponseEntity<Optional<Integer>> getSumA24() {
    try {
        Optional<Integer> SumA24 = service.getSumA24();  /** pour get Sum Quantité d'expedition */
        if (SumA24.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(SumA24, HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }
}
@GetMapping("/expides/SumA25")
public ResponseEntity<Optional<Integer>> getSumA25() {
    try {
        Optional<Integer> SumA25 = service.getSumA25();  /** pour get Sum Quantité d'expedition */
        if (SumA25.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(SumA25, HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }
}
@GetMapping("/expides/SumA26")
public ResponseEntity<Optional<Integer>> getSumA26() {
    try {
        Optional<Integer> SumA26 = service.getSumA26();  /** pour get Sum Quantité d'expedition */
        if (SumA26.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(SumA26, HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }
}
@GetMapping("/expides/SumA27")
public ResponseEntity<Optional<Integer>> getSumA27() {
    try {
        Optional<Integer> SumA27 = service.getSumA27();  /** pour get Sum Quantité d'expedition */
        if (SumA27.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(SumA27, HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }
}
}