package com.loizenai.jwtauthentication.services;

import java.util.List;
import java.util.Optional;

import com.loizenai.jwtauthentication.model.ArtPrep;
import com.loizenai.jwtauthentication.repository.Art_PrepRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Art_PrepService {
        
    @Autowired
    private Art_PrepRepository repository;

    public List<ArtPrep> getArtPreps(){
        return repository.findAll();
    }

    public void addArtPrep(ArtPrep artPrep){
        repository.save(artPrep);
    }

    public ArtPrep updateArtPrep(ArtPrep artPrep){
       return repository.save(artPrep);
    }

    public void deleteArtPrep(long id){
        repository.deleteById(id);
    }

    public void ChronoChariotPointage(long num_char){
        repository.ChronoChariotPointage(num_char);
    }
    public void ChangeChrono(long num_char){
        repository.ChangeChrono(num_char);
    }
    
    
    public List<ArtPrep> getArtPrepForBonPrep(String num_bon_prep){
        return repository.getArtPrepForBonPrep(num_bon_prep);
    }
    public List<ArtPrep> getArtPrepByChariot(String num_char){
        return repository.getArtPrepByChariot(num_char);
    }

    public Optional<Integer> getSumQutByBPach(String num_bon_prep){
        return repository.getSumQutByBPach(num_bon_prep);
    }
    public Optional<Integer> getSumQutByBPht(String num_bon_prep){
        return repository.getSumQutByBPht(num_bon_prep);
    }
    public Optional<Integer> getSumQutByBPAREM(String num_bon_prep){
        return repository.getSumQutByBPAREM(num_bon_prep);
    }
}
