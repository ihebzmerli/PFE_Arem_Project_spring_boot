package com.loizenai.jwtauthentication.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;
import java.sql.Timestamp;

import com.loizenai.jwtauthentication.SpringBootJwtAuthenticationExamplesApplication;
import com.loizenai.jwtauthentication.model.Livreur;
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
public class LivreurControllerTest {

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
       ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/livreurs",
       HttpMethod.GET, entity, String.class);  
       assertNotNull(response.getBody());
   }

   @Test
   @Order(3)
   @Rollback(value = false)
   public void testGetEmployeeById() {
    Livreur employee = restTemplate.getForObject(getRootUrl() + "/livreurs/11", Livreur.class);
       System.out.println(employee.getId_livreur());
       assertNotNull(employee);
   }

   @Test
   @Order(4)
   @Rollback(value = false)
   public void testCreateEmployee() {
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    timestamp=new Timestamp(timestamp.getTime()+ (1000 * 60 * 60 * 1));
   
   
	Livreur employee = new Livreur();
       employee.setId_livreur(11);
       employee.setNom("Nom client work here");
       
       employee.setNumrec((long) 11);
       employee.setCentre("adresse client work here");
       employee.setDatreclam(timestamp);
       employee.setDatrepon(timestamp);
       employee.setDate(timestamp);
       employee.setObjectif((long) 11);
       employee.setObsreclam("obsreclam work here");
       employee.setObserv("Observ work here");
       employee.setPrixach((long) 11);
       employee.setQutart((long) 11);
       employee.setReclam((long) 11);
       employee.setTypmvt("Typmvt work here");
       employee.setNature(Livreur.NATURE.EN_MISSION);
       ResponseEntity<Livreur> postResponse = restTemplate.postForEntity(getRootUrl() + "/livreurs", employee, Livreur.class);
       assertNotNull(postResponse);
       assertNotNull(postResponse.getBody());
   }

   @Test
   @Order(5)
   @Rollback(value = false)
   public void testUpdateEmployee() {
       long id = 11;
       Livreur employee = restTemplate.getForObject(getRootUrl() + "/livreurs/" + id, Livreur.class);

       Timestamp timestamp = new Timestamp(System.currentTimeMillis());
       timestamp=new Timestamp(timestamp.getTime()+ (1000 * 60 * 60 * 1));
       
       employee.setId_livreur(11);
       employee.setNom("Nom client work here");
       
       employee.setNumrec((long) 11);
       employee.setCentre("adresse client work here");
       employee.setDatreclam(timestamp);
       employee.setDatrepon(timestamp);
       employee.setDate(timestamp);
       employee.setObjectif((long) 11);
       employee.setObsreclam("obsreclam work here");
       employee.setObserv("Observ work here");
       employee.setPrixach((long) 11);
       employee.setQutart((long) 11);
       employee.setReclam((long) 11);
       employee.setTypmvt("Typmvt work here");
       employee.setNature(Livreur.NATURE.EN_MISSION);
       restTemplate.put(getRootUrl() + "/livreurs/" + id, employee);
       Livreur updatedEmployee = restTemplate.getForObject(getRootUrl() + "/livreurs/" + id, Livreur.class);
       assertNotNull(updatedEmployee);
   }

   @Test
   @Order(6)
   @Rollback(value = false)
   public void testDeleteEmployee() {
        long id = 11;
        Livreur employee = restTemplate.getForObject(getRootUrl() + "/livreurs/" + id, Livreur.class);
        assertNotNull(employee);
        restTemplate.delete(getRootUrl() + "/livreurs/" + id);
        try {
             employee = restTemplate.getForObject(getRootUrl() + "/livreurs/" + id, Livreur.class);
        } catch (final HttpClientErrorException e) {
             assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
   }

}
