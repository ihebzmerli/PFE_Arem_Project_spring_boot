package com.loizenai.jwtauthentication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.loizenai.jwtauthentication.repository.Livreur_ExpideRepository;
import com.loizenai.jwtauthentication.services.Livreur_ExpideService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class Livreur_ExpideControllerTest {
   
    
    @Autowired
    private Livreur_ExpideService service;

    @Autowired
    Livreur_ExpideRepository repository;
    

}
