package com.loizenai.jwtauthentication.services;

import java.util.List;

import com.loizenai.jwtauthentication.model.Fournis;
import com.loizenai.jwtauthentication.repository.FournisRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FournisService {

    @Autowired
    private FournisRepository repository;

    public List<Fournis> getFourniss(){
        return repository.findAll();
    }

    public List<Long> getFournisOfAdd(){
        return repository.getFournisOfAdd();
    }
    
}
