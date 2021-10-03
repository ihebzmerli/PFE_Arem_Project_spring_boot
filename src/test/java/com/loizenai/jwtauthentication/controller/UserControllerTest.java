package com.loizenai.jwtauthentication.controller;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;
import java.sql.Timestamp;

import com.loizenai.jwtauthentication.SpringBootJwtAuthenticationExamplesApplication;
import com.loizenai.jwtauthentication.model.User;
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
public class UserControllerTest {

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
       ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/utilisateurs",
       HttpMethod.GET, entity, String.class);  
       assertNotNull(response.getBody());
   }

   @Test
   @Order(3)
   @Rollback(value = false)
   public void testGetEmployeeById() {
    User employee = restTemplate.getForObject(getRootUrl() + "/utilisateurs/11", User.class);
       System.out.println(employee.getId());
       assertNotNull(employee);
   }

   @Test
   @Order(4)
   @Rollback(value = false)
   public void testCreateEmployee() {
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    timestamp=new Timestamp(timestamp.getTime()+ (1000 * 60 * 60 * 1));
   
   
	User employee = new User();
       employee.setId((long) 11);
       employee.setFirstname("firstname prenom client work here");
       employee.setLastname("lastname prenom client work here");
       employee.setUsername("username prenom client work here");
       employee.setEmail("username prenom client work here");
       employee.setPassword("paswword prenom client work here");
       
       employee.setDateDeNaissance(timestamp);
       employee.setAddress("Address prenom client work here");
       employee.setTelephone(11);
       employee.setPseudo("Pseudo prenom client work here");
       employee.setDateRec(timestamp);
       employee.setTypeContrat(User.TypeContrat.CDD);

       employee.setDateContrat(timestamp);

       employee.setFamille("Famille prenom client work here");
       employee.setHeuresDeTravail(timestamp);
       employee.setObjectifParJour((float) 11);
       employee.setDateDebutConge(timestamp);
       employee.setDateFinConge(timestamp);
       employee.setTypeConge(User.TypeConge.indefini);
       employee.setPrimeStock((float) 11);
       employee.setAuthorisation(User.Authorisation.Allow);
       employee.setDateLastForgot(timestamp);
       employee.setShowPassword("show pwd prenom client work here");


       ResponseEntity<User> postResponse = restTemplate.postForEntity(getRootUrl() + "/utilisateurs", employee, User.class);
       assertNotNull(postResponse);
       assertNotNull(postResponse.getBody());
   }

   @Test
   @Order(5)
   @Rollback(value = false)
   public void testUpdateEmployee() {
       long id = 11;
       User employee = restTemplate.getForObject(getRootUrl() + "/utilisateurs/" + id, User.class);

       Timestamp timestamp = new Timestamp(System.currentTimeMillis());
       timestamp=new Timestamp(timestamp.getTime()+ (1000 * 60 * 60 * 1));
       employee.setId((long) 11);
       employee.setFirstname("firstname prenom client work here");
       employee.setLastname("lastname prenom client work here");
       employee.setUsername("username prenom client work here");
       employee.setEmail("username prenom client work here");
       employee.setPassword("paswword prenom client work here");
       
       employee.setDateDeNaissance(timestamp);
       employee.setAddress("Address prenom client work here");
       employee.setTelephone(11);
       employee.setPseudo("Pseudo prenom client work here");
       employee.setDateRec(timestamp);
       employee.setTypeContrat(User.TypeContrat.CDD);

       employee.setDateContrat(timestamp);

       employee.setFamille("Famille prenom client work here");
       employee.setHeuresDeTravail(timestamp);
       employee.setObjectifParJour((float) 11);
       employee.setDateDebutConge(timestamp);
       employee.setDateFinConge(timestamp);
       employee.setTypeConge(User.TypeConge.indefini);
       employee.setPrimeStock((float) 11);
       employee.setAuthorisation(User.Authorisation.Allow);
       employee.setDateLastForgot(timestamp);
       employee.setShowPassword("show pwd prenom client work here");


       restTemplate.put(getRootUrl() + "/utilisateurs/" + id, employee);
       User updatedEmployee = restTemplate.getForObject(getRootUrl() + "/utilisateurs/" + id, User.class);
       assertNotNull(updatedEmployee);
   }

   @Test
   @Order(6)
   @Rollback(value = false)
   public void testDeleteEmployee() {
        long id = 11;
        User employee = restTemplate.getForObject(getRootUrl() + "/utilisateurs/" + id, User.class);
        assertNotNull(employee);
        restTemplate.delete(getRootUrl() + "/utilisateurs/" + id);
        try {
             employee = restTemplate.getForObject(getRootUrl() + "/utilisateurs/" + id, User.class);
        } catch (final HttpClientErrorException e) {
             assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
   }

}
