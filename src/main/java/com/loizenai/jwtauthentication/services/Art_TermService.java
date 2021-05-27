package com.loizenai.jwtauthentication.services;

import com.loizenai.jwtauthentication.model.ArtTerm;
import com.loizenai.jwtauthentication.repository.AchatsRepository;
import com.loizenai.jwtauthentication.repository.Art_TermRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class Art_TermService {
    
    @Autowired
    private Art_TermRepository repository;

    public List<ArtTerm> getArtTerms(){
        return repository.findAll();
    }

    public void addArtTerm(ArtTerm prime){
        repository.save(prime);
    }

    public ArtTerm updateArtTerm(ArtTerm prime){
       return repository.save(prime);
    }

    public void deleteArtTerm(String id){
        repository.deleteById(id);
    }

    public List<ArtTerm> getArtTermForBonLiv(String num_bon_liv){
        return repository.getArtTermForBonLiv(num_bon_liv);
    }
}
