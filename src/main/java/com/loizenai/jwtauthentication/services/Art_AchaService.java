package com.loizenai.jwtauthentication.services;

import java.util.List;

import com.loizenai.jwtauthentication.model.ArtAcha;
import com.loizenai.jwtauthentication.model.ArtTerm;
import com.loizenai.jwtauthentication.repository.Art_AchaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Art_AchaService {
    
    @Autowired
    private Art_AchaRepository repository;


    public List<ArtAcha> getBonLivs(){
        return repository.findAll();
    }


    /** start les searsh from repository */

    public List<ArtAcha> getAllArtAchaByNumDocAchats(String num_doc){
        return repository.getAllArtAchaByNumDocAchats(num_doc);
    }

    /** end searsh */
    public List<ArtAcha> getArtAchaForAchats(String num_doc_achat){
        return repository.getArtAchaForAchats(num_doc_achat);
    }


    public ArtAcha updateArtAcha(ArtAcha artAcha){
        return repository.save(artAcha);
    }
    
}
