package com.loizenai.jwtauthentication.controller;

import com.loizenai.jwtauthentication.repository.LivreurRepository;
import com.loizenai.jwtauthentication.services.LivreurService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class LivreurControllerTest {

    @Autowired
    private LivreurService service;

    @Autowired
    LivreurRepository repository;


}
