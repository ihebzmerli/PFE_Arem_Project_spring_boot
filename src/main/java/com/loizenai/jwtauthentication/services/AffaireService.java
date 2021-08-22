package com.loizenai.jwtauthentication.services;

import java.util.List;
import java.util.Optional;

import com.loizenai.jwtauthentication.model.Affaire;
import com.loizenai.jwtauthentication.repository.AffaireRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AffaireService {
 
            
    @Autowired
    private AffaireRepository repository;

    public List<Affaire> getAffaires(){
        return repository.findAll();
    }

    public List<Affaire> getAffairesOfAddPrep(){
        return repository.getAffairesOfAddPrep();
    }

    public List<Affaire> getAllAffaireBydateBetween(String startDate,String endDate){
        return repository.getAllAffaireBydateBetween(startDate,endDate);
    }

/**statistique Bar Article stk */
public List<Long> getSumAvg1(){
    return repository.getSumAvg1();
}
public List<Float> getSumAvg2(){
    return repository.getSumAvg2();
}


/**statistique Bar Article stk */
public Optional<Float> getSumBar1(){
    return repository.getSumBar1();
}
public Optional<Float> getSumBar2(){
    return repository.getSumBar2();
}
public Optional<Float> getSumBar3(){
    return repository.getSumBar3();
}
public Optional<Float> getSumBar4(){
    return repository.getSumBar4();
}
public Optional<Float> getSumBar5(){
    return repository.getSumBar5();
}
public Optional<Float> getSumBar6(){
    return repository.getSumBar6();
}
public Optional<Float> getSumBar7(){
    return repository.getSumBar7();
}
}
