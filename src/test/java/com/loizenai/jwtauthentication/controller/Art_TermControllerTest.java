package com.loizenai.jwtauthentication.controller;

import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;
import java.sql.Timestamp;

import com.loizenai.jwtauthentication.SpringBootJwtAuthenticationExamplesApplication;
import com.loizenai.jwtauthentication.model.ArtTerm;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity; 
import org.springframework.web.client.HttpClientErrorException;
import org.junit.jupiter.api.Order;
import org.springframework.test.annotation.Rollback;

@SpringBootTest(classes = SpringBootJwtAuthenticationExamplesApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class Art_TermControllerTest {
  
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
    public void testGetAllEmployees() {
    HttpHeaders headers = new HttpHeaders();
       HttpEntity<String> entity = new HttpEntity<String>(null, headers);
       ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/artTerms",
       HttpMethod.GET, entity, String.class);  
       assertNotNull(response.getBody());
   }

   @Test
   @Order(3)
   @Rollback(value = false)
   public void testGetEmployeeById() {
    ArtTerm employee = restTemplate.getForObject(getRootUrl() + "/artTerms/1", ArtTerm.class);
       System.out.println(employee.getNumBonFac());
       assertNotNull(employee);
   }
}
