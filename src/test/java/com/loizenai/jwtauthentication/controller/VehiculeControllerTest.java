package com.loizenai.jwtauthentication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.loizenai.jwtauthentication.repository.VehiculeRepository;
import com.loizenai.jwtauthentication.services.VehiculeService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class VehiculeControllerTest {
  
    
    @Autowired
    private VehiculeService service;

    @Autowired
    VehiculeRepository repository;


}