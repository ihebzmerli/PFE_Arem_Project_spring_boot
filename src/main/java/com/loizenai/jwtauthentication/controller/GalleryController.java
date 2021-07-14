package com.loizenai.jwtauthentication.controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import com.loizenai.jwtauthentication.model.Gallery;
import com.loizenai.jwtauthentication.repository.GalleryRepository;
import com.loizenai.jwtauthentication.services.GalleryService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class GalleryController {
    
    @Autowired
    private GalleryService service;

    @Autowired
    GalleryRepository repository;

    @GetMapping("/gallerys")
    public ResponseEntity<List<Gallery>> getAllGallerys() {
        List<Gallery> gallerys = new ArrayList<>();
        try {
            service.getGallerys().forEach(gallerys::add);

            if (gallerys.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(gallerys, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/gallerys/{id}")
    public ResponseEntity<Gallery> getGalleryById(@PathVariable("id") long id) {
        Optional<Gallery> galleryData = repository.findById(id);

        if (galleryData.isPresent()) {
            return new ResponseEntity<>(galleryData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/gallerys")
    public ResponseEntity<Gallery> postGallery(@RequestBody Gallery gallery) {
        try {
            service.addGallery(gallery);
            return new ResponseEntity<>(gallery, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @DeleteMapping("/gallerys/{id}")
    public ResponseEntity<HttpStatus> deleteGallery(@PathVariable("id") long id) {
        try {
            service.deleteGallery(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @DeleteMapping("/gallerys")
    public ResponseEntity<HttpStatus> deleteAllGallerys() {
        try {
            repository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }

    }
}
