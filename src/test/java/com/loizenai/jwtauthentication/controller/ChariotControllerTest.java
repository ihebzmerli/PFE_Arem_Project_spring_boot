package com.loizenai.jwtauthentication.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;
import java.sql.Timestamp;

import com.loizenai.jwtauthentication.SpringBootJwtAuthenticationExamplesApplication;
import com.loizenai.jwtauthentication.model.Chariot;
import com.loizenai.jwtauthentication.model.Chariot.ETAT_CHAR;

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
public class ChariotControllerTest {

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
       ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/chariots",
       HttpMethod.GET, entity, String.class);  
       assertNotNull(response.getBody());
   }

   @Test
   @Order(3)
   @Rollback(value = false)
   public void testGetEmployeeById() {
	Chariot employee = restTemplate.getForObject(getRootUrl() + "/chariots/1111", Chariot.class);
       System.out.println(employee.getNumChar());
       assertNotNull(employee);
   }

   @Test
   @Order(4)
   @Rollback(value = false)
   public void testCreateEmployee() {
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    timestamp=new Timestamp(timestamp.getTime()+ (1000 * 60 * 60 * 1));
   
   
	Chariot employee = new Chariot();
       employee.setNumChar(11);
       employee.setDatchariot(timestamp);
       
       employee.setEtat_char(Chariot.ETAT_CHAR.en_attente);
       employee.setCallChariot(timestamp);

       ResponseEntity<Chariot> postResponse = restTemplate.postForEntity(getRootUrl() + "/chariots", employee, Chariot.class);
       assertNotNull(postResponse);
       assertNotNull(postResponse.getBody());
   }

   @Test
   @Order(5)
   @Rollback(value = false)
   public void testUpdateEmployee() {
       long id = 1111;
       Chariot employee = restTemplate.getForObject(getRootUrl() + "/chariots/" + id, Chariot.class);
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
   
       employee.setNumChar(11);
       employee.setDatchariot(timestamp);
       
       employee.setEtat_char(Chariot.ETAT_CHAR.en_attente);
       employee.setCallChariot(timestamp);

       restTemplate.put(getRootUrl() + "/chariots/" + id, employee);
       Chariot updatedEmployee = restTemplate.getForObject(getRootUrl() + "/chariots/" + id, Chariot.class);
       assertNotNull(updatedEmployee);
   }

   @Test
   @Order(6)
   @Rollback(value = false)
   public void testDeleteEmployee() {
        long id = 1111;
        Chariot employee = restTemplate.getForObject(getRootUrl() + "/chariots/" + id, Chariot.class);
        assertNotNull(employee);
        restTemplate.delete(getRootUrl() + "/chariots/" + id);
        try {
             employee = restTemplate.getForObject(getRootUrl() + "/chariots/" + id, Chariot.class);
        } catch (final HttpClientErrorException e) {
             assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
   }

}
