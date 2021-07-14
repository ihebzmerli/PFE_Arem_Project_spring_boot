package com.loizenai.jwtauthentication.controller;
import com.loizenai.jwtauthentication.repository.UserRepository;
import com.loizenai.jwtauthentication.services.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class UserControllerTest {
    
    @Autowired
    private UserService service;

    @Autowired
    UserRepository userRepository;
	@Autowired
	PasswordEncoder encoder;


}
