package com.loizenai.jwtauthentication.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;
import java.sql.Timestamp;

import com.loizenai.jwtauthentication.SpringBootJwtAuthenticationExamplesApplication;
import com.loizenai.jwtauthentication.model.Prime;
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
public class PrimeControllerTest {

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
       ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/primes",
       HttpMethod.GET, entity, String.class);  
       assertNotNull(response.getBody());
   }

   @Test
   @Order(3)
   @Rollback(value = false)
   public void testGetEmployeeById() {
    Prime employee = restTemplate.getForObject(getRootUrl() + "/primes/11", Prime.class);
       System.out.println(employee.getId());
       assertNotNull(employee);
   }

   @Test
   @Order(4)
   @Rollback(value = false)
   public void testCreateEmployee() {
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    timestamp=new Timestamp(timestamp.getTime()+ (1000 * 60 * 60 * 1));
   
   
	Prime employee = new Prime();
       employee.setId(11);
       employee.setRaison("nom prenom client work here");
       
       employee.setCategorie("nom prenom client work here");
       employee.setObjMin(new BigDecimal(11));


       employee.setDerMvt(timestamp);
       employee.setArtSpec("adresse client work here");
       employee.setPrime(new BigDecimal(11));
       employee.setBloc("adresse client work here");
       employee.setMarge(new BigDecimal(11));

       ResponseEntity<Prime> postResponse = restTemplate.postForEntity(getRootUrl() + "/primes", employee, Prime.class);
       assertNotNull(postResponse);
       assertNotNull(postResponse.getBody());
   }

   @Test
   @Order(5)
   @Rollback(value = false)
   public void testUpdateEmployee() {
       long id = 11;
       Prime employee = restTemplate.getForObject(getRootUrl() + "/primes/" + id, Prime.class);

       Timestamp timestamp = new Timestamp(System.currentTimeMillis());
       timestamp=new Timestamp(timestamp.getTime()+ (1000 * 60 * 60 * 1));

       
       employee.setId(11);
       employee.setRaison("nom prenom client work here");
       
       employee.setCategorie("nom prenom client work here");
       employee.setObjMin(new BigDecimal(11));


       employee.setDerMvt(timestamp);
       employee.setArtSpec("adresse client work here");
       employee.setPrime(new BigDecimal(11));
       employee.setBloc("adresse client work here");
       employee.setMarge(new BigDecimal(11));

       restTemplate.put(getRootUrl() + "/primes/" + id, employee);
       Prime updatedEmployee = restTemplate.getForObject(getRootUrl() + "/primes/" + id, Prime.class);
       assertNotNull(updatedEmployee);
   }

   @Test
   @Order(6)
   @Rollback(value = false)
   public void testDeleteEmployee() {
        long id = 11;
        Prime employee = restTemplate.getForObject(getRootUrl() + "/primes/" + id, Prime.class);
        assertNotNull(employee);
        restTemplate.delete(getRootUrl() + "/primes/" + id);
        try {
             employee = restTemplate.getForObject(getRootUrl() + "/primes/" + id, Prime.class);
        } catch (final HttpClientErrorException e) {
             assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
   }

}
