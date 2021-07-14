package com.loizenai.jwtauthentication.controller;

import com.loizenai.jwtauthentication.repository.Bon_LivRepository;
import com.loizenai.jwtauthentication.services.Bon_LivService;
import com.loizenai.jwtauthentication.services.Etat_LivService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class Bon_LivControllerTest {

    @Autowired
    private Bon_LivService service;

    @Autowired
    private Etat_LivService serviceEtat;

    @Autowired
    Bon_LivRepository repository;

}
