package com.loizenai.jwtauthentication.services;

import java.util.List;
import java.util.Optional;

import com.loizenai.jwtauthentication.model.BonPrep;
import com.loizenai.jwtauthentication.repository.Bon_PrepRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Bon_PrepService {
      
    @Autowired
    private Bon_PrepRepository repository;

    public List<BonPrep> getBonPreps(){
        return repository.findAll();
    }

    public void addBonPrep(BonPrep bonPrep){
        repository.save(bonPrep);
    }

    public BonPrep updateBonPrep(BonPrep bonPrep){
        return repository.save(bonPrep);
    }

    public void deleteBonPrep(String numBon){
        repository.deleteById(numBon);
    }  



/** add  drop down list */

public List<String> getBonPrepOfAdd(){
    return repository.getBonPrepOfAdd();
}

/** end drop down list */


    /** start les searsh from repository */
    
    public List<BonPrep> getAllBonPrepByNumBonPre(String numBonPp){
        return repository.getAllBonPrepByNumBonPre(numBonPp);
    }

    public List<BonPrep> getAllBonPrepBydateBetween(String startDate,String endDate){
        return repository.getAllBonPrepBydateBetween(startDate,endDate);
    }

    public List<BonPrep> getAllBonPrepByClient(String codcli){
        return repository.getAllBonPrepByClient(codcli);
    }

    public List<BonPrep> getAllBonPrepByPointage(String Pointage){
        return repository.getAllBonPrepByPointage(Pointage);
    }

    public List<BonPrep> getAllBonPrepByNatLivraison(String NatLiv){
        return repository.getAllBonPrepByNatLivraison(NatLiv);
    }

    public List<BonPrep> getAllBonPrepByPointeur(String Point){
        return repository.getAllBonPrepByPointeur(Point);
    }

    public List<BonPrep> getAllBonPrepByAideMag(String AideMag){
        return repository.getAllBonPrepByAideMag(AideMag);
    }

    public List<BonPrep> getAllBonPrepByCentre(String Centre){
        return repository.getAllBonPrepByCentre(Centre);
    }

    public List<BonPrep> getAllBonPrepByUserId(String userId){
        return repository.getAllBonPrepByUserId(userId);
    }

    public List<BonPrep> getAllBonPrepByNumDoc(String numdoc){
        return repository.getAllBonPrepByNumDoc(numdoc);
    }
    /** end searsh */







/**statistique bar horisontale */

public Optional<Integer> getSumD1(){
    return repository.getSumD1();
}
public Optional<Integer> getSumD2(){
    return repository.getSumD2();
}
public Optional<Integer> getSumD3(){
    return repository.getSumD3();
}
public Optional<Integer> getSumD4(){
    return repository.getSumD4();
}
/**statistique pie */

public Optional<Integer> getSumC(){
    return repository.getSumC();
}
public Optional<Integer> getSumL(){
    return repository.getSumL();
}
        /**statistique Bar Bon Liv */

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
