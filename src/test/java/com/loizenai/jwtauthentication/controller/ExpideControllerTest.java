package com.loizenai.jwtauthentication.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;
import java.sql.Timestamp;

import com.loizenai.jwtauthentication.SpringBootJwtAuthenticationExamplesApplication;
import com.loizenai.jwtauthentication.model.Expide;

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
import org.junit.jupiter.api.Order;
import org.springframework.test.annotation.Rollback;

@SpringBootTest(classes = SpringBootJwtAuthenticationExamplesApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ExpideControllerTest {

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
       ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/expides",
       HttpMethod.GET, entity, String.class);  
       assertNotNull(response.getBody());
   }

   @Test
   @Order(3)
   @Rollback(value = false)
   public void testGetEmployeeById() {
	Expide employee = restTemplate.getForObject(getRootUrl() + "/expides/1111", Expide.class);
       System.out.println(employee.getId());
       assertNotNull(employee);
   }

   @Test
   @Order(4)
   @Rollback(value = false)
   public void testCreateEmployee() {
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    timestamp=new Timestamp(timestamp.getTime()+ (1000 * 60 * 60 * 1));
   
   
	Expide employee = new Expide();
       employee.setId(1111);
       employee.setDatExpedition(timestamp);
       employee.setTypExp(Expide.TYPEXP.livraison_voiture);
       employee.setTransp("Transp test work");

       employee.setMatAgent((long)1111);
       employee.setTypeDoc("TypeDoc test work");
       ResponseEntity<Expide> postResponse = restTemplate.postForEntity(getRootUrl() + "/expides", employee, Expide.class);
       assertNotNull(postResponse);
       assertNotNull(postResponse.getBody());
   }

   @Test
   @Order(5)
   @Rollback(value = false)
   public void testUpdateEmployee() {
       long id = 1111;
       Expide employee = restTemplate.getForObject(getRootUrl() + "/expides/" + id, Expide.class);

       Timestamp timestamp = new Timestamp(System.currentTimeMillis());
       timestamp=new Timestamp(timestamp.getTime()+ (1000 * 60 * 60 * 1));
       employee.setId(1111);
       employee.setDatExpedition(timestamp);
       employee.setTypExp(Expide.TYPEXP.livraison_voiture);
       employee.setTransp("Transp test work");

       employee.setMatAgent((long)1111);
       restTemplate.put(getRootUrl() + "/expides/" + id, employee);
       Expide updatedEmployee = restTemplate.getForObject(getRootUrl() + "/expides/" + id, Expide.class);
       assertNotNull(updatedEmployee);
   }

   @Test
   @Order(6)
   @Rollback(value = false)
   public void testDeleteEmployee() {
        long id = 1111;
        Expide employee = restTemplate.getForObject(getRootUrl() + "/expides/" + id, Expide.class);
        assertNotNull(employee);
        restTemplate.delete(getRootUrl() + "/expides/" + id);
        try {
             employee = restTemplate.getForObject(getRootUrl() + "/expides/" + id, Expide.class);
        } catch (final HttpClientErrorException e) {
             assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
   }

}