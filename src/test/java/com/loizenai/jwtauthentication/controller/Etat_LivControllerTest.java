package com.loizenai.jwtauthentication.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;
import java.sql.Timestamp;

import com.loizenai.jwtauthentication.SpringBootJwtAuthenticationExamplesApplication;
import com.loizenai.jwtauthentication.model.EtatLiv;

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
public class Etat_LivControllerTest {

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
       ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/etatLivs",
       HttpMethod.GET, entity, String.class);  
       assertNotNull(response.getBody());
   }

   @Test
   @Order(3)
   @Rollback(value = false)
   public void testGetEmployeeById() {
	EtatLiv employee = restTemplate.getForObject(getRootUrl() + "/etatLivs/1111", EtatLiv.class);
       System.out.println(employee.getId());
       assertNotNull(employee);
   }

   @Test
   @Order(4)
   @Rollback(value = false)
   public void testCreateEmployee() {
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    timestamp=new Timestamp(timestamp.getTime()+ (1000 * 60 * 60 * 1));
   
   
	EtatLiv employee = new EtatLiv();
       employee.setId(1111);
       employee.setDate(timestamp);
       employee.setConfirmation(EtatLiv.CONFIRMATION.recu_est_verifier);
       employee.setRegion("Region test work");

       ResponseEntity<EtatLiv> postResponse = restTemplate.postForEntity(getRootUrl() + "/etatLivs", employee, EtatLiv.class);
       assertNotNull(postResponse);
       assertNotNull(postResponse.getBody());
   }

   @Test
   @Order(5)
   @Rollback(value = false)
   public void testUpdateEmployee() {
       long id = 1111;
       EtatLiv employee = restTemplate.getForObject(getRootUrl() + "/etatLivs/" + id, EtatLiv.class);

       Timestamp timestamp = new Timestamp(System.currentTimeMillis());
       timestamp=new Timestamp(timestamp.getTime()+ (1000 * 60 * 60 * 1));

       employee.setId(1111);
       employee.setDate(timestamp);
       employee.setConfirmation(EtatLiv.CONFIRMATION.recu_est_verifier);
       employee.setRegion("Region test work");

       restTemplate.put(getRootUrl() + "/etatLivs/" + id, employee);
       EtatLiv updatedEmployee = restTemplate.getForObject(getRootUrl() + "/etatLivs/" + id, EtatLiv.class);
       assertNotNull(updatedEmployee);
   }

   @Test
   @Order(6)
   @Rollback(value = false)
   public void testDeleteEmployee() {
        long id = 1111;
        EtatLiv employee = restTemplate.getForObject(getRootUrl() + "/etatLivs/" + id, EtatLiv.class);
        assertNotNull(employee);
        restTemplate.delete(getRootUrl() + "/etatLivs/" + id);
        try {
             employee = restTemplate.getForObject(getRootUrl() + "/etatLivs/" + id, EtatLiv.class);
        } catch (final HttpClientErrorException e) {
             assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
   }

}
