package com.loizenai.jwtauthentication.controller;

import com.loizenai.jwtauthentication.repository.ExpideRepository;
import com.loizenai.jwtauthentication.services.ExpideService;
import com.loizenai.jwtauthentication.services.Livreur_ExpideService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class ExpideControllerTest {

    @Autowired
    private ExpideService service;
    @Autowired
    private Livreur_ExpideService serviceLivreurExpide;

    @Autowired
    ExpideRepository repository;


}