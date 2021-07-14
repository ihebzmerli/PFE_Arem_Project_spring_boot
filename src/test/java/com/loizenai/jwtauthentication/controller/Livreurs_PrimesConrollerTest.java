package com.loizenai.jwtauthentication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.loizenai.jwtauthentication.repository.livreurs_primesRepository;
import com.loizenai.jwtauthentication.services.livreurs_primesService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class Livreurs_PrimesConrollerTest {
   
    
    @Autowired
    private livreurs_primesService service;

    @Autowired
    livreurs_primesRepository repository;
    
}
