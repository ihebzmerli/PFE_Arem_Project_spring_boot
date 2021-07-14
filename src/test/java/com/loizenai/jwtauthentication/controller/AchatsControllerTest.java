package com.loizenai.jwtauthentication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.loizenai.jwtauthentication.repository.AchatsRepository;
import com.loizenai.jwtauthentication.services.AchatsService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class AchatsControllerTest {
      
    
    @Autowired
    private AchatsService service;

    @Autowired
    AchatsRepository repository;

}
