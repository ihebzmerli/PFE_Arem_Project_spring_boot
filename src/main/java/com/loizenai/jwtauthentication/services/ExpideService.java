package com.loizenai.jwtauthentication.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.loizenai.jwtauthentication.model.BonLiv;
import com.loizenai.jwtauthentication.model.Expide;
import com.loizenai.jwtauthentication.model.Livreur;
import com.loizenai.jwtauthentication.model.Livreur_Expide;
import com.loizenai.jwtauthentication.repository.ExpideRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpideService {
        
    @Autowired
    private ExpideRepository repository;

    public List<Expide> getExpides(){
        return repository.findAll();
    }

    public void addExpide(Expide expide){
        
        repository.save(expide);
    }

    public Expide updateExpide(Expide expide){
       return repository.save(expide);
    }

    public void deleteExpide(long id){
        repository.deleteById(id);
    }
/** add  drop down list */

public List<Date> getExpideOfAdd(){
    return repository.getExpideOfAdd();
}

public List<Date> getExpideOfAddForBonPrep(){
    return repository.getExpideOfAddForBonPrep();
}

/** end drop down list */

/** start les searsh from repository */

    public List<Expide>getAllExpideByTypDoc(String typeDoc){
        return repository.getAllExpideByTypDoc(typeDoc);
    }
    
    public List<Expide>getAllExpideByMatricule(String matricule){
        return repository.getAllExpideByMatricule(matricule);
    }
    public List<Expide>getAllExpideByTransp(String transporter){
        return repository.getAllExpideByTransp(transporter);
    }
    
    public List<Expide>getAllExpideByTypExp(String typExp){
        return repository.getAllExpideByTypExp(typExp);
    }

    public List<Expide>getAllExpideBydateEXBetween(String startDate,String endDate){
        return repository.getAllExpideBydateEXBetween(startDate,endDate);
    }



/** end les searsh from repository */








/**statistique Pie Bon Liv  */

public Optional<Integer> getSumT1(){
    return repository.getSumT1();
}
public Optional<Integer> getSumT2(){
    return repository.getSumT2();
}

/**statistique BAR  horizontale  */

public Optional<Integer> getSumM11(){
    return repository.getSumM11();
}
public Optional<Integer> getSumM12(){
    return repository.getSumM12();
}
public Optional<Integer> getSumM13(){
    return repository.getSumM13();
}
public Optional<Integer> getSumM14(){
    return repository.getSumM14();
}
public Optional<Integer> getSumM15(){
    return repository.getSumM15();
}
public Optional<Integer> getSumM16(){
    return repository.getSumM16();
}
public Optional<Integer> getSumM17(){
    return repository.getSumM17();
}
public Optional<Integer> getSumM18(){
    return repository.getSumM18();
}
public Optional<Integer> getSumM19(){
    return repository.getSumM19();
}
public Optional<Integer> getSumM110(){
    return repository.getSumM110();
}
public Optional<Integer> getSumM111(){
    return repository.getSumM111();
}
public Optional<Integer> getSumM112(){
    return repository.getSumM112();
}



public Optional<Integer> getSumM21(){
    return repository.getSumM21();
}
public Optional<Integer> getSumM22(){
    return repository.getSumM22();
}
public Optional<Integer> getSumM23(){
    return repository.getSumM23();
}
public Optional<Integer> getSumM24(){
    return repository.getSumM24();
}
public Optional<Integer> getSumM25(){
    return repository.getSumM25();
}
public Optional<Integer> getSumM26(){
    return repository.getSumM26();
}
public Optional<Integer> getSumM27(){
    return repository.getSumM27();
}
public Optional<Integer> getSumM28(){
    return repository.getSumM28();
}
public Optional<Integer> getSumM29(){
    return repository.getSumM29();
}
public Optional<Integer> getSumM210(){
    return repository.getSumM210();
}
public Optional<Integer> getSumM211(){
    return repository.getSumM211();
}
public Optional<Integer> getSumM212(){
    return repository.getSumM212();
}





//** statistique expide bar annnées */
public Optional<Integer> getSumA11(){
    return repository.getSumA11();
}
public Optional<Integer> getSumA12(){
    return repository.getSumA12();
}
public Optional<Integer> getSumA13(){
    return repository.getSumA13();
}
public Optional<Integer> getSumA14(){
    return repository.getSumA14();
}
public Optional<Integer> getSumA15(){
    return repository.getSumA15();
}
public Optional<Integer> getSumA16(){
    return repository.getSumA16();
}
public Optional<Integer> getSumA17(){
    return repository.getSumA17();
}

public Optional<Integer> getSumA21(){
    return repository.getSumA11();
}
public Optional<Integer> getSumA22(){
    return repository.getSumA12();
}
public Optional<Integer> getSumA23(){
    return repository.getSumA13();
}
public Optional<Integer> getSumA24(){
    return repository.getSumA14();
}
public Optional<Integer> getSumA25(){
    return repository.getSumA15();
}
public Optional<Integer> getSumA26(){
    return repository.getSumA16();
}
public Optional<Integer> getSumA27(){
    return repository.getSumA17();
}

}
