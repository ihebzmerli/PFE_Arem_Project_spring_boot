package com.loizenai.jwtauthentication.controller;

import com.loizenai.jwtauthentication.repository.Bon_SortRepository;
import com.loizenai.jwtauthentication.services.Bon_SortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class Bon_SortControllerTest{

    @Autowired
    private Bon_SortService service;

    @Autowired
    Bon_SortRepository repository;

}