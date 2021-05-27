package com.loizenai.jwtauthentication.services;

import java.util.List;

import com.loizenai.jwtauthentication.model.Marque;
import com.loizenai.jwtauthentication.repository.MarqueRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarqueService {
    

    @Autowired
    private MarqueRepository repository;

    
    public List<Marque> getMarques(){
        return repository.findAll();
    }

    public void addMarque(Marque prime){
        repository.save(prime);
    }

    public Marque updateMarque(Marque prime){
       return repository.save(prime);
    }

    public void deleteMarque(Long id){
        repository.deleteById(id);
    }
}
