package com.loizenai.jwtauthentication.services;

import java.util.List;
import java.util.Optional;

import com.loizenai.jwtauthentication.model.Livreur_Expide;
import com.loizenai.jwtauthentication.repository.Livreur_ExpideRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Livreur_ExpideService {
    
    @Autowired
    private Livreur_ExpideRepository repository;

    public List<Livreur_Expide> getLivreur_Expide(){
        return repository.findAll();
    }

    public void addLivreur_Expide(Livreur_Expide livreur_expide){
        repository.save(livreur_expide);
    }

    public Livreur_Expide updateLivreur_Expide(Livreur_Expide livreur_expide){
       return repository.save(livreur_expide);
    }

    public void deleteLivreur_Expide(long id_livreur_expide){
        repository.deleteById(id_livreur_expide);
    }

    public List<Livreur_Expide>getAllLivreursAndBonliv(String id_expide){
        return repository.getAllLivreursAndBonliv(id_expide);
    }
    public Optional<Livreur_Expide> getAllLivreursAndBonliv2(String id_expide){
        return repository.getAllLivreursAndBonliv2(id_expide);
    }
}
