package com.loizenai.jwtauthentication.controller;

import com.loizenai.jwtauthentication.repository.RectifRepository;
import com.loizenai.jwtauthentication.services.RectifService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class RectifControllerTest {

    @Autowired
    private RectifService service;

    @Autowired
    RectifRepository repository;

}