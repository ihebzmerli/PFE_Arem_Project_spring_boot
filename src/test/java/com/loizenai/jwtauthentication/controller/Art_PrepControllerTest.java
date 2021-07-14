package com.loizenai.jwtauthentication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.loizenai.jwtauthentication.repository.Art_PrepRepository;
import com.loizenai.jwtauthentication.services.Art_PrepService;
import com.loizenai.jwtauthentication.services.ChariotService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class Art_PrepControllerTest {
  
    @Autowired
    private Art_PrepService service;

    @Autowired
    private ChariotService chariotService;

    @Autowired
    Art_PrepRepository repository;

}
