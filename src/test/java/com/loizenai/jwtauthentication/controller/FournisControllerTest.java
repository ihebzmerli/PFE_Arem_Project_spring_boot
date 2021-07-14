package com.loizenai.jwtauthentication.controller;

import com.loizenai.jwtauthentication.repository.FournisRepository;
import com.loizenai.jwtauthentication.services.FournisService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class FournisControllerTest {
    
    @Autowired
    private FournisService service;

    @Autowired
    FournisRepository repository;



}
