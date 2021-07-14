package com.loizenai.jwtauthentication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.loizenai.jwtauthentication.repository.Art_TermRepository;
import com.loizenai.jwtauthentication.services.Art_TermService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class Art_TermControllerTest {
    
    
    @Autowired
    private Art_TermService service;

    @Autowired
    Art_TermRepository repository;

}
