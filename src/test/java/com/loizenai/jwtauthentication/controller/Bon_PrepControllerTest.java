package com.loizenai.jwtauthentication.controller;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;
import java.sql.Timestamp;

import com.loizenai.jwtauthentication.SpringBootJwtAuthenticationExamplesApplication;
import com.loizenai.jwtauthentication.model.BonPrep;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import org.junit.jupiter.api.Order;
import org.springframework.test.annotation.Rollback;

@SpringBootTest(classes = SpringBootJwtAuthenticationExamplesApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class Bon_PrepControllerTest {

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
       ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/bonPreps",
       HttpMethod.GET, entity, String.class);  
       assertNotNull(response.getBody());
   }

   @Test
   @Order(3)
   @Rollback(value = false)
   public void testGetEmployeeById() {
       BonPrep employee = restTemplate.getForObject(getRootUrl() + "/bonPreps/NNNNNnnnnNN10", BonPrep.class);
       System.out.println(employee.getNumBon());
       assertNotNull(employee);
   }

   @Test
   @Order(4)
   @Rollback(value = false)
   public void testCreateEmployee() {
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    timestamp=new Timestamp(timestamp.getTime()+ (1000 * 60 * 60 * 1));
   
   
    BonPrep employee = new BonPrep();
    employee.setNumBon("NNNNNnnnnNN10");
    employee.setDatBon(timestamp);
    
    employee.setNomprenomCli("nom prenom client work here");
    employee.setRaison("adresse client work here");
    employee.setPoste("poste work here");
    employee.setNetHt(new BigDecimal(11));
    employee.setBrutHt(new BigDecimal(11));
    employee.setTotTtc(new BigDecimal(11));

       ResponseEntity<BonPrep> postResponse = restTemplate.postForEntity(getRootUrl() + "/bonPreps", employee, BonPrep.class);
       assertNotNull(postResponse);
       assertNotNull(postResponse.getBody());
   }

   @Test
   @Order(5)
   @Rollback(value = false)
   public void testUpdateEmployee() {
       String id = "NNNNNnnnnNN1010";
       BonPrep employee = restTemplate.getForObject(getRootUrl() + "/bonPreps/" + id, BonPrep.class);
/*
       <dependency>
       <groupId>org.apache.httpcomponents</groupId>
       <artifactId>httpclient</artifactId>
       <version>4.5.6</version>
       <scope>test</scope>
        </dependency>
*/
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        timestamp=new Timestamp(timestamp.getTime()+ (1000 * 60 * 60 * 1));
        employee.setNumBon("NNNNNnnnnNN10");
        employee.setDatBon(timestamp);
        
        employee.setNomprenomCli("nom prenom client work here");
        employee.setRaison("adresse client work here");
        employee.setPoste("poste work here");
        employee.setNetHt(new BigDecimal(11));
        employee.setBrutHt(new BigDecimal(11));
        employee.setTotTtc(new BigDecimal(11));
 

       restTemplate.put(getRootUrl() + "/bonPreps/" + id, employee);
       BonPrep updatedEmployee = restTemplate.getForObject(getRootUrl() + "/bonPreps/" + id, BonPrep.class);
       assertNotNull(updatedEmployee);
   }

   @Test
   @Order(6)
   @Rollback(value = false)
   public void testDeleteEmployee() {
        String id = "NNNNNnnnnNN10";
        BonPrep employee = restTemplate.getForObject(getRootUrl() + "/bonPreps/" + id, BonPrep.class);
        assertNotNull(employee);
        restTemplate.delete(getRootUrl() + "/bonPreps/" + id);
        try {
             employee = restTemplate.getForObject(getRootUrl() + "/bonPreps/" + id, BonPrep.class);
        } catch (final HttpClientErrorException e) {
             assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
   }

}

