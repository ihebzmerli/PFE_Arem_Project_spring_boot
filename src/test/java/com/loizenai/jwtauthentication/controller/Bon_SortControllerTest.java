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
    public void testGetAllBonSorties() {
    HttpHeaders headers = new HttpHeaders();
       HttpEntity<String> entity = new HttpEntity<String>(null, headers);
       ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/bonSorts",
       HttpMethod.GET, entity, String.class);  
       assertNotNull(response.getBody());
   }

   @Test
   @Order(3)
   @Rollback(value = false)
   public void testGetBonSortieById() {
    BonSort bonSort = restTemplate.getForObject(getRootUrl() + "/bonSorts/NNNNNnnnnNN10", BonSort.class);
       System.out.println(bonSort.getNumBon());
       assertNotNull(bonSort);
   }

   @Test
   @Order(4)
   @Rollback(value = false)
   public void testCreateBonSortie() {
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    timestamp=new Timestamp(timestamp.getTime()+ (1000 * 60 * 60 * 1));
   
   
	BonSort bonSort = new BonSort();
    bonSort.setNumBon("NNNNNnnnnNN10");
    bonSort.setDatBon(timestamp);
       bonSort.setRaison("adresse client work here");
       bonSort.setPoste("poste work here");
       bonSort.setNetHt(new BigDecimal(11));
       bonSort.setBrutHt(new BigDecimal(11));
       bonSort.setTotTtc(new BigDecimal(11));

       ResponseEntity<BonSort> postResponse = restTemplate.postForEntity(getRootUrl() + "/bonSorts", bonSort, BonSort.class);
       assertNotNull(postResponse);
       assertNotNull(postResponse.getBody());
   }

   @Test
   @Order(5)
   @Rollback(value = false)
   public void testUpdateBonSortie() {
       String id = "NNNNNnnnnNN1010";
       BonSort bonSort = restTemplate.getForObject(getRootUrl() + "/bonSorts/" + id, BonSort.class);
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
   
   
       bonSort.setNumBon("NNNNNnnnnNN10");
       bonSort.setDatBon(timestamp);
 
       bonSort.setRaison("adresse client work here");
       bonSort.setPoste("poste work here");
       bonSort.setNetHt(new BigDecimal(11));
       bonSort.setBrutHt(new BigDecimal(11));
       bonSort.setTotTtc(new BigDecimal(11));

       restTemplate.put(getRootUrl() + "/bonSorts/" + id, bonSort);
       BonSort updatedbonSort = restTemplate.getForObject(getRootUrl() + "/bonSorts/" + id, BonSort.class);
       assertNotNull(updatedbonSort);
   }

   @Test
   @Order(6)
   @Rollback(value = false)
   public void testDeleteBonSortie() {
        String id = "NNNNNnnnnNN10";
        BonSort bonSort = restTemplate.getForObject(getRootUrl() + "/bonSorts/" + id, BonSort.class);
        assertNotNull(bonSort);
        restTemplate.delete(getRootUrl() + "/bonSorts/" + id);
        try {
            bonSort = restTemplate.getForObject(getRootUrl() + "/bonSorts/" + id, BonSort.class);
        } catch (final HttpClientErrorException e) {
             assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
   }

}