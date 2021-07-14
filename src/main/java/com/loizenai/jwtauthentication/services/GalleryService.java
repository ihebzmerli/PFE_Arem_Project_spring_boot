package com.loizenai.jwtauthentication.services;
import java.util.List;
import java.util.Optional;

import com.loizenai.jwtauthentication.model.Gallery;
import com.loizenai.jwtauthentication.repository.GalleryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GalleryService {
            
    @Autowired
    private GalleryRepository repository;

    public List<Gallery> getGallerys(){
        return repository.findAll();
    }

    public void addGallery(Gallery gallery){
        repository.save(gallery);
    }

    public Gallery updateGallery(Gallery gallery){
        return repository.save(gallery);
    }

    public void deleteGallery(long id){
        repository.deleteById(id);
    }
}
