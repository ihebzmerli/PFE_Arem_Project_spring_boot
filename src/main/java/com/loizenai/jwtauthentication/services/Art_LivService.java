package com.loizenai.jwtauthentication.services;

import java.util.List;
import java.util.Optional;

import com.loizenai.jwtauthentication.model.ArtLiv;
import com.loizenai.jwtauthentication.repository.Art_LivRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Art_LivService {
        
    @Autowired
    private Art_LivRepository repository;

    public List<ArtLiv> getArtLivs(){
        return repository.findAll();
    }

    public void addArtLiv(ArtLiv artLiv){
        repository.save(artLiv);
    }

    public ArtLiv updateArtLiv(ArtLiv artLiv){
       return repository.save(artLiv);
    }

    public void deleteArtLiv(long id){
        repository.deleteById(id);
    }
    public List<ArtLiv> getArtLivForBonLiv(String num_bon_liv){
        return repository.getArtLivForBonLiv(num_bon_liv);
    }

    public Optional<Integer> getSumQutByBLach(String num_bon_liv){
        return repository.getSumQutByBLach(num_bon_liv);
    }
    public Optional<Integer> getSumQutByBLht(String num_bon_liv){
        return repository.getSumQutByBLht(num_bon_liv);
    }

    public Optional<Integer> getSumQutByBLAREM(String num_bon_liv){
        return repository.getSumQutByBLAREM(num_bon_liv);
    }
}
