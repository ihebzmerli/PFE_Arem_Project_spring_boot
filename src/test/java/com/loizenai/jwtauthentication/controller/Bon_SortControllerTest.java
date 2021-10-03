package com.loizenai.jwtauthentication.controller;

import com.loizenai.jwtauthentication.repository.Bon_SortRepository;
import com.loizenai.jwtauthentication.services.Bon_SortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;
import java.sql.Timestamp;

import com.loizenai.jwtauthentication.SpringBootJwtAuthenticationExamplesApplication;
import com.loizenai.jwtauthentication.model.BonSort;
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
public class Bon_SortControllerTest{

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
       ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/bonSorts",
       HttpMethod.GET, entity, String.class);  
       assertNotNull(response.getBody());
   }

   @Test
   @Order(3)
   @Rollback(value = false)
   public void testGetEmployeeById() {
    BonSort employee = restTemplate.getForObject(getRootUrl() + "/bonSorts/NNNNNnnnnNN10", BonSort.class);
       System.out.println(employee.getNumBon());
       assertNotNull(employee);
   }

   @Test
   @Order(4)
   @Rollback(value = false)
   public void testCreateEmployee() {
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    timestamp=new Timestamp(timestamp.getTime()+ (1000 * 60 * 60 * 1));
   
   
	BonSort employee = new BonSort();
       employee.setNumBon("NNNNNnnnnNN10");
       employee.setDatBon(timestamp);
       employee.setRaison("adresse client work here");
       employee.setPoste("poste work here");
       employee.setNetHt(new BigDecimal(11));
       employee.setBrutHt(new BigDecimal(11));
       employee.setTotTtc(new BigDecimal(11));

       ResponseEntity<BonSort> postResponse = restTemplate.postForEntity(getRootUrl() + "/bonSorts", employee, BonSort.class);
       assertNotNull(postResponse);
       assertNotNull(postResponse.getBody());
   }

   @Test
   @Order(5)
   @Rollback(value = false)
   public void testUpdateEmployee() {
       String id = "NNNNNnnnnNN1010";
       BonSort employee = restTemplate.getForObject(getRootUrl() + "/bonSorts/" + id, BonSort.class);
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
 
       employee.setRaison("adresse client work here");
       employee.setPoste("poste work here");
       employee.setNetHt(new BigDecimal(11));
       employee.setBrutHt(new BigDecimal(11));
       employee.setTotTtc(new BigDecimal(11));

       restTemplate.put(getRootUrl() + "/bonSorts/" + id, employee);
       BonSort updatedEmployee = restTemplate.getForObject(getRootUrl() + "/bonSorts/" + id, BonSort.class);
       assertNotNull(updatedEmployee);
   }

   @Test
   @Order(6)
   @Rollback(value = false)
   public void testDeleteEmployee() {
        String id = "NNNNNnnnnNN10";
        BonSort employee = restTemplate.getForObject(getRootUrl() + "/bonSorts/" + id, BonSort.class);
        assertNotNull(employee);
        restTemplate.delete(getRootUrl() + "/bonSorts/" + id);
        try {
             employee = restTemplate.getForObject(getRootUrl() + "/bonSorts/" + id, BonSort.class);
        } catch (final HttpClientErrorException e) {
             assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
   }

}