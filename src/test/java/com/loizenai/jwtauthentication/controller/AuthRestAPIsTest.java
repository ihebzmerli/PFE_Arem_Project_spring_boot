package com.loizenai.jwtauthentication.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;
import java.sql.Timestamp;

import com.loizenai.jwtauthentication.SpringBootJwtAuthenticationExamplesApplication;
import com.loizenai.jwtauthentication.message.request.LoginForm;
import com.loizenai.jwtauthentication.message.request.SignUpForm;
import com.loizenai.jwtauthentication.model.User;

import org.junit.jupiter.api.Order;
import org.springframework.test.annotation.Rollback;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;

@SpringBootTest(classes = SpringBootJwtAuthenticationExamplesApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AuthRestAPIsTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    private String getRootUrl() {
        return "http://localhost:" + port;
    }

    @Test
    @Order(1)
    @Rollback(value = false)
    public void contextLoads() {

    }

   @Test
   @Order(2)
   @Rollback(value = false)
   public void testCreateEmployee() {
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    timestamp=new Timestamp(timestamp.getTime()+ (1000 * 60 * 60 * 1));
   
   
	SignUpForm employee = new SignUpForm();
       employee.setUsername("NNNNNnnnnNN10");
       employee.setPassword("pawssword123");
	   employee.setDateDeNaissance(timestamp);
	   employee.setDateRec(timestamp);
	   employee.setDateContrat(timestamp);
       employee.setDateDebutConge(timestamp);
	   employee.setDateFinConge(timestamp);
	   employee.setCodUser(11111);
	   employee.setDerMvt(timestamp);
	   employee.setDatFFac(timestamp);
	   employee.setDateDeNaissance(timestamp);

       ResponseEntity<User> postResponse = restTemplate.postForEntity(getRootUrl() + "/signup", employee, User.class);
       assertNotNull(postResponse);
       assertNotNull(postResponse.getBody());
   }
}