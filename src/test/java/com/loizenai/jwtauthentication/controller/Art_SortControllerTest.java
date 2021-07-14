package com.loizenai.jwtauthentication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.loizenai.jwtauthentication.repository.Art_SortRepository;
import com.loizenai.jwtauthentication.services.Art_SortService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class Art_SortControllerTest {
    @Autowired
    private Art_SortService service;

    @Autowired
    Art_SortRepository repository;

}

