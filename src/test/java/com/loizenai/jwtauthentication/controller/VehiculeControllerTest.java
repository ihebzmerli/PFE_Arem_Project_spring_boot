package com.loizenai.jwtauthentication.controller;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;

import com.loizenai.jwtauthentication.SpringBootJwtAuthenticationExamplesApplication;
import com.loizenai.jwtauthentication.model.Vehicule;
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
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.client.reactive.ClientHttpResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.HttpClientErrorException;

import javassist.Loader.Simple;

import org.junit.jupiter.api.Order;
import org.springframework.test.annotation.Rollback;


@SpringBootTest(classes = SpringBootJwtAuthenticationExamplesApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class VehiculeControllerTest {

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
       ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/vehicules",
       HttpMethod.GET, entity, String.class);  
       assertNotNull(response.getBody());
   }

   @Test
   @Order(3)
   @Rollback(value = false)
   public void testGetEmployeeById() {
    Vehicule employee = restTemplate.getForObject(getRootUrl() + "/vehicules/1111", Vehicule.class);
       System.out.println(employee.getMatricule());
       assertNotNull(employee);
   }

   @Test
   @Order(4)
   @Rollback(value = false)
   public void testCreateEmployee() {
/* 
    SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
    requestFactory.setOutputStreaming(false);
    System.out.println(requestFactory);
*/
/*
    template.setRequestFactory(new SimpleClientHttpRequestFactory());
    template.setErrorHandler(new DefaultResponseErrorHandler(){
        public boolean hasError(ClientHttpResponse response) throws IOException{
            HttpStatus statusCode =response.getStatusCode();
            return statusCode.series() ==HttpStatus.Series.SERVER_ERROR;
        }
    });
*/
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    timestamp=new Timestamp(timestamp.getTime()+ (1000 * 60 * 60 * 1));
   
   
	Vehicule employee = new Vehicule();
       employee.setMatricule("1111");
       employee.setMatAgent((long) 1111);
       
       employee.setCouleur("Couleur vehicule work here");
       employee.setDt1Mc(timestamp);


       employee.setDtAcq(timestamp);
       employee.setPattc(new BigDecimal(11));
       employee.setDtFAss(timestamp);
       employee.setDtFVisit(timestamp);
       employee.setDrKmVida(new BigDecimal(11));
       employee.setDrKmCh(new BigDecimal(11));
       employee.setObservation(Vehicule.OBSERVATION.au_stock);
       employee.setDt1Mc2(timestamp);

       ResponseEntity<Vehicule> postResponse = restTemplate.postForEntity(getRootUrl() + "/vehicules", employee, Vehicule.class);
       assertNotNull(postResponse);
       assertNotNull(postResponse.getBody());
   }

   @Test
   @Order(5)
   @Rollback(value = false)
   public void testUpdateEmployee() {
       long id = 11;
       Vehicule employee = restTemplate.getForObject(getRootUrl() + "/vehicules/" + id, Vehicule.class);

       Timestamp timestamp = new Timestamp(System.currentTimeMillis());
       timestamp=new Timestamp(timestamp.getTime()+ (1000 * 60 * 60 * 1));

       employee.setMatricule("1111");
       employee.setMatAgent((long) 1111);
       
       employee.setCouleur("Couleur vehicule work here");
       employee.setDt1Mc(timestamp);


       employee.setDtAcq(timestamp);
       employee.setPattc(new BigDecimal(11));
       employee.setDtFAss(timestamp);
       employee.setDtFVisit(timestamp);
       employee.setDrKmVida(new BigDecimal(11));
       employee.setDrKmCh(new BigDecimal(11));
       employee.setObservation(Vehicule.OBSERVATION.au_stock);
       employee.setDt1Mc2(timestamp);

       restTemplate.put(getRootUrl() + "/vehicules/" + id, employee);
       Vehicule updatedEmployee = restTemplate.getForObject(getRootUrl() + "/vehicules/" + id, Vehicule.class);
       assertNotNull(updatedEmployee);
   }

   @Test
   @Order(6)
   @Rollback(value = false)
   public void testDeleteEmployee() {
        long id = 11;
        Vehicule employee = restTemplate.getForObject(getRootUrl() + "/vehicules/" + id, Vehicule.class);
        assertNotNull(employee);
        restTemplate.delete(getRootUrl() + "/vehicules/" + id);
        try {
             employee = restTemplate.getForObject(getRootUrl() + "/vehicules/" + id, Vehicule.class);
        } catch (final HttpClientErrorException e) {
             assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
   }

}