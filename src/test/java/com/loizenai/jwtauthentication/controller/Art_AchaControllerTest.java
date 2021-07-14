package com.loizenai.jwtauthentication.controller;


import com.loizenai.jwtauthentication.repository.Art_AchaRepository;
import com.loizenai.jwtauthentication.services.Art_AchaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class Art_AchaControllerTest {

    @Autowired
    Art_AchaService service;
    
    @Autowired
    Art_AchaRepository repository;

}