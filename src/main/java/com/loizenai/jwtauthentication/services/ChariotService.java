package com.loizenai.jwtauthentication.services;

import java.util.List;
import java.util.Optional;
import com.loizenai.jwtauthentication.model.Chariot;
import com.loizenai.jwtauthentication.repository.ChariotRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChariotService {
        
    @Autowired
    private ChariotRepository repository;

    public List<Chariot> getChariots(){
        return repository.findAll();
    }

    public Chariot addChariot(Chariot chariot){
        return repository.save(chariot);
    }

    public Chariot updateChariot(Chariot chariot){
        return repository.save(chariot);
    }

    public Optional<Chariot> getChariot(long numChar){
        return repository.findById(numChar);
    }

    public void deleteChariot(long numChar){
        repository.deleteById(numChar);
    }


    public void ChangeChariotEtatOccuper(long numChar){
        repository.ChangeChariotEtatOccuper(numChar);
    }

    public void ChangeChariotEtatEnAttent(long numChar){
        repository.ChangeChariotEtatEnAttent(numChar);
    }
/** add  drop down list */

public List<Chariot> getChariotOfAddForBonPrep(){
    return repository.getChariotOfAddForBonPrep();
}

/** end drop down list */


/**searsh global for chariot */
    public List<Chariot> getAllChariotByArticle(String IdArtPrep){
        return repository.getAllChariotByArticle(IdArtPrep);
    }

    public List<Chariot> getAllChariotBydateBetween(String startDate,String endDate){
        return repository.getAllChariotBydateBetween(startDate,endDate);
    }


    public Optional<Integer> getLastIdChariot(){
        return repository.getLastIdChariot();
    }


/**searsh global for chariot */   



/**statistique Pie Bon Liv  */

public Optional<Integer> getSumCha1(){
    return repository.getSumCha1();
}
public Optional<Integer> getSumCha2(){
    return repository.getSumCha2();
}
public Optional<Integer> getSumCha3(){
    return repository.getSumCha3();
}
}
