package com.loizenai.jwtauthentication.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.loizenai.jwtauthentication.model.SuitAff;
import com.loizenai.jwtauthentication.repository.Suit_AffRepository;

@Service
public class Suit_AffService {
            
    @Autowired
    private Suit_AffRepository repository;


    public List<SuitAff> getSuit_Affs(){
        return repository.findAll();
    }

/** add  drop down list */

public List<SuitAff> getSuitAffOfAddPrep(){
    return repository.getSuitAffOfAddPrep();
}

/** end drop down list */
}
