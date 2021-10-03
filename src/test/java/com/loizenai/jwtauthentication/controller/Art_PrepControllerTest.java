package com.loizenai.jwtauthentication.controller;

import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;
import java.sql.Timestamp;

import com.loizenai.jwtauthentication.SpringBootJwtAuthenticationExamplesApplication;
import com.loizenai.jwtauthentication.model.ArtLiv;
import com.loizenai.jwtauthentication.model.ArtPrep;

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
public class Art_PrepControllerTest {

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
       ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/artPreps",
       HttpMethod.GET, entity, String.class);  
       assertNotNull(response.getBody());
   }

   @Test
   @Order(3)
   @Rollback(value = false)
   public void testGetEmployeeById() {
    ArtPrep employee = restTemplate.getForObject(getRootUrl() + "/artPreps/1", ArtPrep.class);
       System.out.println(employee.getId());
       assertNotNull(employee);
   }

   @Test
   @Order(4)
   @Rollback(value = false)
   public void testCreateEmployee() {
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    timestamp=new Timestamp(timestamp.getTime()+ (1000 * 60 * 60 * 1));
   
   
       ArtPrep employee = new ArtPrep();
       
       employee.setRemise(new BigDecimal(11));
       employee.setPrixHt(new BigDecimal(11));
       employee.setPrixArem(new BigDecimal(11));
       employee.setTva(new BigDecimal(11));
       employee.setTotHt(new BigDecimal(11));
       employee.setMarge(new BigDecimal(11));
       employee.setTypArt("typArt de l artPreps work here");
       employee.setCumulRet(11);
       employee.setPrixAch(new BigDecimal(11));
       employee.setRemExp(new BigDecimal(11));
       employee.setPoste("poste de l artPreps work here");
       employee.setCentre("centre de l artPreps work here");

       employee.setNumBon("N bon_liv de l artPreps work here");
       employee.setCodArt("CodArt de l artPreps work here");

       employee.setQutStk(11);
       employee.setQutStk2(11);
       employee.setStkGar(11);
       employee.setStkIni(11);
       employee.setAnalStk(11);
       employee.setNbjStk(11);
       employee.setvSstk(11);
       employee.setComStk(11);
       employee.setXanalStk(11);
       employee.setStkAtrsf(11);
       employee.setStkTrsf(11);
       employee.setStkReel(11);   
       employee.setStkRes(11);
       employee.setStkNp(11);


       ResponseEntity<ArtPrep> postResponse = restTemplate.postForEntity(getRootUrl() + "/artPreps", employee, ArtPrep.class);
       assertNotNull(postResponse);
       assertNotNull(postResponse.getBody());
   }

   @Test
   @Order(5)
   @Rollback(value = false)
   public void testUpdateEmployee() {
       String id = "NNNNNnnnnNN1010";
       ArtPrep employee = restTemplate.getForObject(getRootUrl() + "/artPreps/" + id, ArtPrep.class);

       Timestamp timestamp = new Timestamp(System.currentTimeMillis());
       timestamp=new Timestamp(timestamp.getTime()+ (1000 * 60 * 60 * 1));
 
       
       employee.setRemise(new BigDecimal(11));
       employee.setPrixHt(new BigDecimal(11));
       employee.setPrixArem(new BigDecimal(11));
       employee.setTva(new BigDecimal(11));
       employee.setTotHt(new BigDecimal(11));
       employee.setMarge(new BigDecimal(11));
       employee.setTypArt("typArt de l ArtLiv work here");
       employee.setCumulRet(11);
       employee.setPrixAch(new BigDecimal(11));
       employee.setRemExp(new BigDecimal(11));
       employee.setPoste("poste de l ArtLiv work here");
       employee.setCentre("centre de l ArtLiv work here");

       employee.setNumBon("N bon_liv de l ArtLiv work here");
       employee.setCodArt("CodArt de l ArtLiv work here");

       employee.setQutStk(11);
       employee.setQutStk2(11);
       employee.setStkGar(11);
       employee.setStkIni(11);
       employee.setAnalStk(11);
       employee.setNbjStk(11);
       employee.setvSstk(11);
       employee.setComStk(11);
       employee.setXanalStk(11);
       employee.setStkAtrsf(11);
       employee.setStkTrsf(11);
       employee.setStkReel(11);   
       employee.setStkRes(11);
       employee.setStkNp(11);


       restTemplate.put(getRootUrl() + "/artPreps/" + id, employee);
       ArtPrep updatedEmployee = restTemplate.getForObject(getRootUrl() + "/artPreps/" + id, ArtPrep.class);
       assertNotNull(updatedEmployee);
   }

   @Test
   @Order(6)
   @Rollback(value = false)
   public void testDeleteEmployee() {
        Integer id = 11;
        ArtPrep employee = restTemplate.getForObject(getRootUrl() + "/artPreps/" + id, ArtPrep.class);
        assertNotNull(employee);
        restTemplate.delete(getRootUrl() + "/artPreps/" + id);
        try {
             employee = restTemplate.getForObject(getRootUrl() + "/artPreps/" + id, ArtPrep.class);
        } catch (final HttpClientErrorException e) {
             assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
   }
}
