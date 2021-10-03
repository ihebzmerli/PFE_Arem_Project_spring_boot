package com.loizenai.jwtauthentication.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;
import java.sql.Timestamp;

import com.loizenai.jwtauthentication.SpringBootJwtAuthenticationExamplesApplication;
import com.loizenai.jwtauthentication.model.livreurs_primes;
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
public class Livreurs_PrimesConrollerTest {

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
       ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/livreurs_primes",
       HttpMethod.GET, entity, String.class);  
       assertNotNull(response.getBody());
   }

   @Test
   @Order(3)
   @Rollback(value = false)
   public void testGetEmployeeById() {
    livreurs_primes employee = restTemplate.getForObject(getRootUrl() + "/livreurs_primes/11", livreurs_primes.class);
       System.out.println(employee.getId_livreur_prime());
       assertNotNull(employee);
   }

   @Test
   @Order(4)
   @Rollback(value = false)
   public void testCreateEmployee() {
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    timestamp=new Timestamp(timestamp.getTime()+ (1000 * 60 * 60 * 1));
   
   
	livreurs_primes employee = new livreurs_primes();
       employee.setId_livreur_prime(11);
       employee.setId_livreur((long) 11);
       
       employee.setId_prime((long) 11);

       ResponseEntity<livreurs_primes> postResponse = restTemplate.postForEntity(getRootUrl() + "/livreurs_primes", employee, livreurs_primes.class);
       assertNotNull(postResponse);
       assertNotNull(postResponse.getBody());
   }

   @Test
   @Order(5)
   @Rollback(value = false)
   public void testUpdateEmployee() {
       long id = 11;
       livreurs_primes employee = restTemplate.getForObject(getRootUrl() + "/livreurs_primes/" + id, livreurs_primes.class);

       Timestamp timestamp = new Timestamp(System.currentTimeMillis());
       timestamp=new Timestamp(timestamp.getTime()+ (1000 * 60 * 60 * 1));
              employee.setId_livreur_prime(11);
       employee.setId_livreur((long) 11);
       
       employee.setId_prime((long) 11);
       
       restTemplate.put(getRootUrl() + "/livreurs_primes/" + id, employee);
       livreurs_primes updatedEmployee = restTemplate.getForObject(getRootUrl() + "/livreurs_primes/" + id, livreurs_primes.class);
       assertNotNull(updatedEmployee);
   }

   @Test
   @Order(6)
   @Rollback(value = false)
   public void testDeleteEmployee() {
        long id = 11;
        livreurs_primes employee = restTemplate.getForObject(getRootUrl() + "/livreurs_primes/" + id, livreurs_primes.class);
        assertNotNull(employee);
        restTemplate.delete(getRootUrl() + "/livreurs_primes/" + id);
        try {
             employee = restTemplate.getForObject(getRootUrl() + "/livreurs_primes/" + id, livreurs_primes.class);
        } catch (final HttpClientErrorException e) {
             assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
   }

}
