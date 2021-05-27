package com.loizenai.jwtauthentication.services;

import java.util.List;

import com.loizenai.jwtauthentication.model.ArtSort;
import com.loizenai.jwtauthentication.repository.Art_SortRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Art_SortService {
     
    @Autowired
    private Art_SortRepository repository;

    public List<ArtSort> getArtSorts(){
        return repository.findAll();
    }

    public void addArtSort(ArtSort artSort){
        repository.save(artSort);
    }

    public ArtSort updateArtSort(ArtSort artSort){
        return repository.save(artSort);
    }

    public void deleteArtSort(Long id){
        repository.deleteById(id);
    }   

    public List<ArtSort> getArtSortForBonSort(String num_bon_sort){
        return repository.getArtSortForBonSort(num_bon_sort);
    }   
}
