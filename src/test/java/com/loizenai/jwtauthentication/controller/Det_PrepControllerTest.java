package com.loizenai.jwtauthentication.controller;

import com.loizenai.jwtauthentication.repository.Det_PrepRepository;
import com.loizenai.jwtauthentication.services.Det_PrepService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class Det_PrepControllerTest {


    @Autowired
    private Det_PrepService service;

    @Autowired
    Det_PrepRepository repository;

}
