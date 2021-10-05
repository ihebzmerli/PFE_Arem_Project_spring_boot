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
    public void testGetAllArticles() {
    HttpHeaders headers = new HttpHeaders();
       HttpEntity<String> entity = new HttpEntity<String>(null, headers);
       ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/articles",
       HttpMethod.GET, entity, String.class);  
       assertNotNull(response.getBody());
   }

   @Test
   @Order(3)
   @Rollback(value = false)
   public void testGetArticleById() {
       Article article = restTemplate.getForObject(getRootUrl() + "/articles/NNNNNnnnnNN10", Article.class);
       System.out.println(article.getCodArt());
       assertNotNull(article);
   }

   @Test
   @Order(4)
   @Rollback(value = false)
   public void testCreateArticle() {
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    timestamp=new Timestamp(timestamp.getTime()+ (1000 * 60 * 60 * 1));
   
   
       Article article = new Article();
       article.setCodArt("NNNNNnnnnNN10");
       article.setDesArt("Description de l article work here");
       
       article.setRefOrg("RefOrg de l article work here");
       article.setRefRem("RefRem de l article work here");
       article.setCodNgp("Description de l article work here");
       article.setCodFrs(111111);
       article.setQutStk(11);
       article.setQutStk2(11);
       article.setUnitVen((short) 11);
       article.setStkGar(11);
       article.setStkIni(11);
       article.setQutMax(11);
       article.setQutMin(11);
       article.setQutDep(11);
       article.setPrixMin(new BigDecimal(11));
       article.setCours(new BigDecimal(11));
       article.setCoef((short) 11);
       article.setDerPAch(new BigDecimal(11));
       article.setPrixAch((float) 11);
       article.setPrixVen((float) 11);
       article.setRemise(new BigDecimal(11));
       article.setPrixArem((float) 11);
       article.setTva(new BigDecimal(11));
       article.setCumulVen((long) 11);
       article.setCumulAch((long) 11);
       article.setDerAch(timestamp);
       article.setDerMvt(timestamp);
       article.setpValu(new BigDecimal(11));
       article.setUnitInv((long) 11);
       article.setQutV1(11);
       article.setQutV2(11);
       article.setQutV3(11);
       

       article.setDatRup(timestamp);
       article.setDatPAch(timestamp);
       article.setDatCreat(timestamp);




       ResponseEntity<Article> postResponse = restTemplate.postForEntity(getRootUrl() + "/articles", article, Article.class);
       assertNotNull(postResponse);
       assertNotNull(postResponse.getBody());
   }

   @Test
   @Order(5)
   @Rollback(value = false)
   public void testUpdateArticle() {
       String id = "NNNNNnnnnNN1010";
       Article article = restTemplate.getForObject(getRootUrl() + "/articles/" + id, Article.class);
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
   
   
       article.setCodArt("NNNNNnnnnNN1010");
       article.setDesArt("Description de l article work here");
       
       article.setRefOrg("RefOrg de l article work here");
       article.setRefRem("RefRem de l article work here");
       article.setCodNgp("Description de l article work here");
       article.setCodFrs(111111);
       article.setQutStk(11);
       article.setQutStk2(11);
       article.setUnitVen((short) 11);
       article.setStkGar(11);
       article.setStkIni(11);
       article.setQutMax(11);
       article.setQutMin(11);
       article.setQutDep(11);
       article.setPrixMin(new BigDecimal(11));
       article.setCours(new BigDecimal(11));
       article.setCoef((short) 11);
       article.setDerPAch(new BigDecimal(11));
       article.setPrixAch((float) 11);
       article.setPrixVen((float) 11);
       article.setRemise(new BigDecimal(11));
       article.setPrixArem((float) 11);
       article.setTva(new BigDecimal(11));
       article.setCumulVen((long) 11);
       article.setCumulAch((long) 11);
       article.setDerAch(timestamp);
       article.setDerMvt(timestamp);
       article.setpValu(new BigDecimal(11));
       article.setUnitInv((long) 11);
       article.setQutV1(11);
       article.setQutV2(11);
       article.setQutV3(11);
       

       article.setDatRup(timestamp);
       article.setDatPAch(timestamp);
       article.setDatCreat(timestamp);


       restTemplate.put(getRootUrl() + "/articles/" + id, article);
       Article updatedArticle = restTemplate.getForObject(getRootUrl() + "/articles/" + id, Article.class);
       assertNotNull(updatedArticle);
   }

   @Test
   @Order(6)
   @Rollback(value = false)
   public void testDeleteArticle() {
        String id = "NNNNNnnnnNN10";
        Article article = restTemplate.getForObject(getRootUrl() + "/articles/" + id, Article.class);
        assertNotNull(article);
        restTemplate.delete(getRootUrl() + "/articles/" + id);
        try {
             article = restTemplate.getForObject(getRootUrl() + "/articles/" + id, Article.class);
        } catch (final HttpClientErrorException e) {
             assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
   }

}
