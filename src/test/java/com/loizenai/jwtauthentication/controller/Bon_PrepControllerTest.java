package com.loizenai.jwtauthentication.controller;

import com.loizenai.jwtauthentication.repository.Bon_PrepRepository;
import com.loizenai.jwtauthentication.services.Bon_PrepService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class Bon_PrepControllerTest {

    @Autowired
    private Bon_PrepService service;

    @Autowired
    Bon_PrepRepository repository;

}

