package com.loizenai.jwtauthentication.services;

import java.util.List;
import java.util.Optional;

import com.loizenai.jwtauthentication.model.Achats;
import com.loizenai.jwtauthentication.repository.AchatsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AchatsService {
 
            
    @Autowired
    private AchatsRepository repository;


    public List<Achats> getAchatss(){
        return repository.findAll();
    }

    public List<Achats> getAchatsOfAddPrep(){
        return repository.getAchatsOfAddPrep();
    }
    public Achats updateAchats(Achats achats){
        return repository.save(achats);
    }
    
    public List<Achats> getAllAchatsBydateBetween(String startDate,String endDate){
        return repository.getAllAchatsBydateBetween(startDate,endDate);
    }

    public void ChangeAchatToValidate(long numDocAchat){
        repository.ChangeAchatToValidate(numDocAchat);
    }

    public void ChangeAchatToNotValidate(long numDocAchat){
        repository.ChangeAchatToNotValidate(numDocAchat);
    }

    /**statistique Pie Achats */
public Optional<Integer> getSumP1(){
    return repository.getSumP1();
}
public Optional<Integer> getSumP2(){
    return repository.getSumP2();
}
public Optional<Integer> getSumV1(){
    return repository.getSumV1();
}
public Optional<Integer> getSumV2(){
    return repository.getSumV2();
}


/**statistique Bar Achats */
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
