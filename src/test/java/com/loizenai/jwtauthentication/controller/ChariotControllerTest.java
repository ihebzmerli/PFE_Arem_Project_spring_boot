package com.loizenai.jwtauthentication.controller;

import com.loizenai.jwtauthentication.repository.ChariotRepository;
import com.loizenai.jwtauthentication.services.ChariotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;





@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class ChariotControllerTest {

    @Autowired
    private ChariotService service;

    @Autowired
    ChariotRepository repository;

}
