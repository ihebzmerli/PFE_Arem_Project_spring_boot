package com.loizenai.jwtauthentication.controller;

import com.loizenai.jwtauthentication.repository.Det_EmbaRepository;
import com.loizenai.jwtauthentication.services.Det_EmbaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class Det_EmbaControllerTest {

    @Autowired
    private Det_EmbaService service;

    @Autowired
    Det_EmbaRepository repository;

}
