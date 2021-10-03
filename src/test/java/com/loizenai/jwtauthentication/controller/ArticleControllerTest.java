package com.loizenai.jwtauthentication.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;
import java.sql.Timestamp;

import com.loizenai.jwtauthentication.SpringBootJwtAuthenticationExamplesApplication;
import com.loizenai.jwtauthentication.model.Article;
import com.loizenai.jwtauthentication.repository.ArticleRepository;
import com.loizenai.jwtauthentication.services.ArticleService;

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
public class ArticleControllerTest {

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
       ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/articles",
       HttpMethod.GET, entity, String.class);  
       assertNotNull(response.getBody());
   }

   @Test
   @Order(3)
   @Rollback(value = false)
   public void testGetEmployeeById() {
       Article employee = restTemplate.getForObject(getRootUrl() + "/articles/NNNNNnnnnNN10", Article.class);
       System.out.println(employee.getCodArt());
       assertNotNull(employee);
   }

   @Test
   @Order(4)
   @Rollback(value = false)
   public void testCreateEmployee() {
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    timestamp=new Timestamp(timestamp.getTime()+ (1000 * 60 * 60 * 1));
   
   
       Article employee = new Article();
       employee.setCodArt("NNNNNnnnnNN10");
       employee.setDesArt("Description de l article work here");
       
       employee.setRefOrg("RefOrg de l article work here");
       employee.setRefRem("RefRem de l article work here");
       employee.setCodNgp("Description de l article work here");
       employee.setCodFrs(111111);
       employee.setQutStk(11);
       employee.setQutStk2(11);
       employee.setUnitVen((short) 11);
       employee.setStkGar(11);
       employee.setStkIni(11);
       employee.setQutMax(11);
       employee.setQutMin(11);
       employee.setQutDep(11);
       employee.setPrixMin(new BigDecimal(11));
       employee.setCours(new BigDecimal(11));
       employee.setCoef((short) 11);
       employee.setDerPAch(new BigDecimal(11));
       employee.setPrixAch((float) 11);
       employee.setPrixVen((float) 11);
       employee.setRemise(new BigDecimal(11));
       employee.setPrixArem((float) 11);
       employee.setTva(new BigDecimal(11));
       employee.setCumulVen((long) 11);
       employee.setCumulAch((long) 11);
       employee.setDerAch(timestamp);
       employee.setDerMvt(timestamp);
       employee.setpValu(new BigDecimal(11));
       employee.setUnitInv((long) 11);
       employee.setQutV1(11);
       employee.setQutV2(11);
       employee.setQutV3(11);
       

       employee.setDatRup(timestamp);
       employee.setDatPAch(timestamp);
       employee.setDatCreat(timestamp);




       ResponseEntity<Article> postResponse = restTemplate.postForEntity(getRootUrl() + "/articles", employee, Article.class);
       assertNotNull(postResponse);
       assertNotNull(postResponse.getBody());
   }

   @Test
   @Order(5)
   @Rollback(value = false)
   public void testUpdateEmployee() {
       String id = "NNNNNnnnnNN1010";
       Article employee = restTemplate.getForObject(getRootUrl() + "/articles/" + id, Article.class);
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
   
   
       employee.setCodArt("NNNNNnnnnNN1010");
       employee.setDesArt("Description de l article work here");
       
       employee.setRefOrg("RefOrg de l article work here");
       employee.setRefRem("RefRem de l article work here");
       employee.setCodNgp("Description de l article work here");
       employee.setCodFrs(111111);
       employee.setQutStk(11);
       employee.setQutStk2(11);
       employee.setUnitVen((short) 11);
       employee.setStkGar(11);
       employee.setStkIni(11);
       employee.setQutMax(11);
       employee.setQutMin(11);
       employee.setQutDep(11);
       employee.setPrixMin(new BigDecimal(11));
       employee.setCours(new BigDecimal(11));
       employee.setCoef((short) 11);
       employee.setDerPAch(new BigDecimal(11));
       employee.setPrixAch((float) 11);
       employee.setPrixVen((float) 11);
       employee.setRemise(new BigDecimal(11));
       employee.setPrixArem((float) 11);
       employee.setTva(new BigDecimal(11));
       employee.setCumulVen((long) 11);
       employee.setCumulAch((long) 11);
       employee.setDerAch(timestamp);
       employee.setDerMvt(timestamp);
       employee.setpValu(new BigDecimal(11));
       employee.setUnitInv((long) 11);
       employee.setQutV1(11);
       employee.setQutV2(11);
       employee.setQutV3(11);
       

       employee.setDatRup(timestamp);
       employee.setDatPAch(timestamp);
       employee.setDatCreat(timestamp);


       restTemplate.put(getRootUrl() + "/articles/" + id, employee);
       Article updatedEmployee = restTemplate.getForObject(getRootUrl() + "/articles/" + id, Article.class);
       assertNotNull(updatedEmployee);
   }

   @Test
   @Order(6)
   @Rollback(value = false)
   public void testDeleteEmployee() {
        String id = "NNNNNnnnnNN10";
        Article employee = restTemplate.getForObject(getRootUrl() + "/articles/" + id, Article.class);
        assertNotNull(employee);
        restTemplate.delete(getRootUrl() + "/articles/" + id);
        try {
             employee = restTemplate.getForObject(getRootUrl() + "/articles/" + id, Article.class);
        } catch (final HttpClientErrorException e) {
             assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
   }

}
