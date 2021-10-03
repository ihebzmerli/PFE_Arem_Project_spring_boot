package com.loizenai.jwtauthentication.controller;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;
import java.sql.Timestamp;

import com.loizenai.jwtauthentication.SpringBootJwtAuthenticationExamplesApplication;
import com.loizenai.jwtauthentication.model.Rectif;
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
public class RectifControllerTest {

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
       ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/rectifs",
       HttpMethod.GET, entity, String.class);  
       assertNotNull(response.getBody());
   }

   @Test
   @Order(3)
   @Rollback(value = false)
   public void testGetEmployeeById() {
    Rectif employee = restTemplate.getForObject(getRootUrl() + "/rectifs/11", Rectif.class);
       System.out.println(employee.getId_rectif());
       assertNotNull(employee);
   }

   @Test
   @Order(4)
   @Rollback(value = false)
   public void testCreateEmployee() {
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    timestamp=new Timestamp(timestamp.getTime()+ (1000 * 60 * 60 * 1));
   
   
	Rectif employee = new Rectif();
       employee.setId_rectif(11);
       employee.setDate(timestamp);
       employee.setDatReclam(timestamp);
       employee.setDatRepon(timestamp);
       employee.setDatClotur(timestamp);
       employee.setObserv("nom prenom client work here");
       
       employee.setTypMvt("nom prenom client work here");
       employee.setNumRec(11);
       employee.setReclam(true);
       employee.setCloture(true);
       employee.setObsReclam("adresse client work here");

       ResponseEntity<Rectif> postResponse = restTemplate.postForEntity(getRootUrl() + "/rectifs", employee, Rectif.class);
       assertNotNull(postResponse);
       assertNotNull(postResponse.getBody());
   }

   @Test
   @Order(5)
   @Rollback(value = false)
   public void testUpdateEmployee() {
       long id = 11;
       Rectif employee = restTemplate.getForObject(getRootUrl() + "/rectifs/" + id, Rectif.class);

       Timestamp timestamp = new Timestamp(System.currentTimeMillis());
       timestamp=new Timestamp(timestamp.getTime()+ (1000 * 60 * 60 * 1));
       
       employee.setId_rectif(11);
       employee.setDate(timestamp);
       employee.setDatReclam(timestamp);
       employee.setDatRepon(timestamp);
       employee.setDatClotur(timestamp);
       employee.setObserv("nom prenom client work here");
       
       employee.setTypMvt("nom prenom client work here");
       employee.setNumRec(11);
       employee.setReclam(true);
       employee.setCloture(true);
       employee.setObsReclam("adresse client work here");

       restTemplate.put(getRootUrl() + "/rectifs/" + id, employee);
       Rectif updatedEmployee = restTemplate.getForObject(getRootUrl() + "/rectifs/" + id, Rectif.class);
       assertNotNull(updatedEmployee);
   }

   @Test
   @Order(6)
   @Rollback(value = false)
   public void testDeleteEmployee() {
        long id = 11;
        Rectif employee = restTemplate.getForObject(getRootUrl() + "/rectifs/" + id, Rectif.class);
        assertNotNull(employee);
        restTemplate.delete(getRootUrl() + "/rectifs/" + id);
        try {
             employee = restTemplate.getForObject(getRootUrl() + "/rectifs/" + id, Rectif.class);
        } catch (final HttpClientErrorException e) {
             assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
   }

}