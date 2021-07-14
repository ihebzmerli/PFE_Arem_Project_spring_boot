package com.loizenai.jwtauthentication.controller;

import com.loizenai.jwtauthentication.repository.Etat_LivRepository;
import com.loizenai.jwtauthentication.services.Bon_LivService;
import com.loizenai.jwtauthentication.services.Etat_LivService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class Etat_LivControllerTest {

    @Autowired
    private Etat_LivService service;

    @Autowired
    private Bon_LivService serviceBonLiv;

    @Autowired
    Etat_LivRepository repository;


}
