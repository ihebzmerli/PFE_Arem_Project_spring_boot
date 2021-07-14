package com.loizenai.jwtauthentication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.loizenai.jwtauthentication.repository.AffaireRepository;
import com.loizenai.jwtauthentication.services.AffaireService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class AffaireControllerTest {
      
    
    @Autowired
    private AffaireService service;

    @Autowired
    AffaireRepository repository;

}
