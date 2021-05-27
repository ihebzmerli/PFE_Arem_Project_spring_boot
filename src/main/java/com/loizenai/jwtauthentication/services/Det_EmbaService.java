package com.loizenai.jwtauthentication.services;

import java.util.List;

import com.loizenai.jwtauthentication.model.DetEmba;
import com.loizenai.jwtauthentication.repository.Det_EmbaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Det_EmbaService {
        
    @Autowired
    private Det_EmbaRepository repository;

    public List<DetEmba> getDetEmbas(){
        return repository.findAll();
    }

    public void addDetEmba(DetEmba detEmba){
        repository.save(detEmba);
    }

    public DetEmba updateDetEmba(DetEmba detEmba){
       return repository.save(detEmba);
    }

    public void deleteDetEmba(long id){
        repository.deleteById(id);
    }
    
    public List<DetEmba> getAllDetEmbaByBPrep(String Nbon_prep){
        return repository.getAllDetEmbaByBPrep(Nbon_prep);
    }

    public List<DetEmba> getAllDetEmbaByArtLiv(String idArtliv){
        return repository.getAllDetEmbaByArtLiv(idArtliv);
    }
}
