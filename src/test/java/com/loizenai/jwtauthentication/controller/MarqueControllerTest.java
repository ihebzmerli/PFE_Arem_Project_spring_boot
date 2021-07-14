package com.loizenai.jwtauthentication.controller;

import java.io.IOException;

import com.loizenai.jwtauthentication.repository.MarqueRepository;
import com.loizenai.jwtauthentication.services.MarqueService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class MarqueControllerTest {
    
    @Autowired
    private MarqueService service;

    @Autowired
    MarqueRepository repository;

}
