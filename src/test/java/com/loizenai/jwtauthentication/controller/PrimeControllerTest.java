package com.loizenai.jwtauthentication.controller;

import com.loizenai.jwtauthentication.repository.PrimeRepository;
import com.loizenai.jwtauthentication.services.PrimeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class PrimeControllerTest {

    @Autowired
    private PrimeService service;

    @Autowired
    PrimeRepository repository;

}
