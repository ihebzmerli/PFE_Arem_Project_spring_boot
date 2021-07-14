package com.loizenai.jwtauthentication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.loizenai.jwtauthentication.repository.Art_LivRepository;
import com.loizenai.jwtauthentication.services.Art_LivService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class Art_LivControllerTest {
  
    
    @Autowired
    private Art_LivService service;

    @Autowired
    Art_LivRepository repository;

}
