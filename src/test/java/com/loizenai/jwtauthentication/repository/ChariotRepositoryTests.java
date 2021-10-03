package com.loizenai.jwtauthentication.repository;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.sql.Timestamp;

import com.loizenai.jwtauthentication.model.Chariot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ChariotRepositoryTests {
    
    @Autowired
    private TestEntityManager entityManager;
  
    @Autowired
    ChariotRepository repository;
  
    @Test
    @Order(1)
    @Rollback(value = false)
    public void should_find_no_tutorials_if_repository_is_empty() {
      Iterable<Chariot> tutorials = repository.findAll();
  
      assertNotNull(tutorials);
      //assertThat(tutorials).isEmpty();
    }
  
    @Test
    @Order(2)
    @Rollback(value = false)
    public void should_store_a_tutorial() {
        
       Timestamp timestamp = new Timestamp(System.currentTimeMillis());
       timestamp=new Timestamp(timestamp.getTime()+ (1000 * 60 * 60 * 1));
        Chariot tutorial = repository.save(new Chariot((long) 111,timestamp,timestamp,Chariot.ETAT_CHAR.en_attente));
        
        assertAll("heading", 
        () -> 
        assertNotNull(tutorial, () -> "the Chariot should not be null"),
        () -> 
        assertEquals(tutorial, new Chariot((long) 111,new Timestamp(new Timestamp(System.currentTimeMillis()).getTime()+ (1000 * 60 * 60 * 1)),new Timestamp(new Timestamp(System.currentTimeMillis()).getTime()+ (1000 * 60 * 60 * 1)),Chariot.ETAT_CHAR.en_attente)), 
        () -> 
        assertNotEquals(tutorial, new Chariot((long) 111,new Timestamp(new Timestamp(System.currentTimeMillis()).getTime()+ (1000 * 60 * 60 * 1)),new Timestamp(new Timestamp(System.currentTimeMillis()).getTime()+ (1000 * 60 * 60 * 1)),Chariot.ETAT_CHAR.en_panne))
        );
      /*
      assertThat(tutorial).hasFieldOrPropertyWithValue("title", "Tut title");
      assertThat(tutorial).hasFieldOrPropertyWithValue("description", "Tut desc");
      assertThat(tutorial).hasFieldOrPropertyWithValue("published", true);
      */
    }
  /*
    @Test
    @Order(3)
    @Rollback(value = false)
    public void should_find_all_tutorials() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        timestamp=new Timestamp(timestamp.getTime()+ (1000 * 60 * 60 * 1));

      Chariot tut1 = new Chariot((long) 111,timestamp,timestamp,Chariot.ETAT_CHAR.en_attente);
      entityManager.persist(tut1);
  
      Chariot tut2 = new Chariot((long) 111,timestamp,timestamp,Chariot.ETAT_CHAR.en_attente);
      entityManager.persist(tut2);
  
      Chariot tut3 = new Chariot((long) 111,timestamp,timestamp,Chariot.ETAT_CHAR.en_attente);
      entityManager.persist(tut3);
  
      Iterable<Chariot> tutorials = repository.findAll();
      assertEquals(tutorials,tut1, tut2, tut3);
      //assertThat(tutorials).hasSize(3).contains(tut1, tut2, tut3);
    }
  
    @Test
    @Order(4)
    @Rollback(value = false)
    public void should_find_tutorial_by_id() {

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        timestamp=new Timestamp(timestamp.getTime()+ (1000 * 60 * 60 * 1));

      Chariot tut1 = new Chariot((long) 111,timestamp,timestamp,Chariot.ETAT_CHAR.en_attente);
      entityManager.persist(tut1);
  
      Chariot tut2 = new Chariot((long) 111,timestamp,timestamp,Chariot.ETAT_CHAR.en_attente);
      entityManager.persist(tut2);
  
      Chariot foundTutorial = repository.findById(tut2.getId()).get();
  
      assertThat(foundTutorial).isEqualTo(tut2);
    }
  
    @Test
    @Order(5)
    @Rollback(value = false)
    public void should_find_published_tutorials() {

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        timestamp=new Timestamp(timestamp.getTime()+ (1000 * 60 * 60 * 1));

      Chariot tut1 = new Chariot((long) 111,timestamp,timestamp,Chariot.ETAT_CHAR.en_attente);
      entityManager.persist(tut1);
  
      Chariot tut2 = new Chariot((long) 111,timestamp,timestamp,Chariot.ETAT_CHAR.en_attente);
      entityManager.persist(tut2);
  
      Chariot tut3 = new Chariot((long) 111,timestamp,timestamp,Chariot.ETAT_CHAR.en_attente);
      entityManager.persist(tut3);
  
      Iterable<Chariot> tutorials = repository.findByPublished(true);
  
      assertThat(tutorials).hasSize(2).contains(tut1, tut3);
    }
  
    @Test
    @Order(6)
    @Rollback(value = false)
    public void should_find_tutorials_by_title_containing_string() {

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        timestamp=new Timestamp(timestamp.getTime()+ (1000 * 60 * 60 * 1));

      Chariot tut1 = new Chariot((long) 111,timestamp,timestamp,Chariot.ETAT_CHAR.en_attente);
      entityManager.persist(tut1);
  
      Chariot tut2 = new Chariot((long) 111,timestamp,timestamp,Chariot.ETAT_CHAR.en_attente);
      entityManager.persist(tut2);
  
      Chariot tut3 = new Chariot((long) 111,timestamp,timestamp,Chariot.ETAT_CHAR.en_attente);
      entityManager.persist(tut3);
  
      Iterable<Chariot> tutorials = repository.findByTitleContaining("ring");
  
      assertThat(tutorials).hasSize(2).contains(tut1, tut3);
    }
  
    @Test
    @Order(7)
    @Rollback(value = false)
    public void should_update_tutorial_by_id() {

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        timestamp=new Timestamp(timestamp.getTime()+ (1000 * 60 * 60 * 1));

      Chariot tut1 = new Chariot((long) 111,timestamp,timestamp,Chariot.ETAT_CHAR.en_attente);
      entityManager.persist(tut1);
  
      Chariot tut2 = new Chariot((long) 111,timestamp,timestamp,Chariot.ETAT_CHAR.en_attente);
      entityManager.persist(tut2);
  
      Chariot updatedTut = new Chariot((long) 111,timestamp,timestamp,Chariot.ETAT_CHAR.en_attente);
  
      Chariot tut = repository.findById(tut2.getId()).get();
      tut.setTitle(updatedTut.getTitle());
      tut.setDescription(updatedTut.getDescription());
      tut.setPublished(updatedTut.isPublished());
      repository.save(tut);
  
      Chariot checkTut = repository.findById(tut2.getId()).get();
      
      assertThat(checkTut.getId()).isEqualTo(tut2.getId());
      assertThat(checkTut.getTitle()).isEqualTo(updatedTut.getTitle());
      assertThat(checkTut.getDescription()).isEqualTo(updatedTut.getDescription());
      assertThat(checkTut.isPublished()).isEqualTo(updatedTut.isPublished());
    }
  
    @Test
    @Order(8)
    @Rollback(value = false)
    public void should_delete_tutorial_by_id() {

      Timestamp timestamp = new Timestamp(System.currentTimeMillis());
      timestamp=new Timestamp(timestamp.getTime()+ (1000 * 60 * 60 * 1));

      Chariot tut1 = new Chariot((long) 111,timestamp,timestamp,Chariot.ETAT_CHAR.en_attente);
      entityManager.persist(tut1);
  
      Chariot tut2 = new Chariot((long) 111,timestamp,timestamp,Chariot.ETAT_CHAR.en_attente);
      entityManager.persist(tut2);
  
      Chariot tut3 = new Chariot((long) 111,timestamp,timestamp,Chariot.ETAT_CHAR.en_attente);
      entityManager.persist(tut3);
  
      repository.deleteById(tut2.getId());
  
      Iterable<Chariot> tutorials = repository.findAll();
  
      assertThat(tutorials).hasSize(2).contains(tut1, tut3);
    }
  
    @Test
    @Order(9)
    @Rollback(value = false)
    public void should_delete_all_tutorials() {

      Timestamp timestamp = new Timestamp(System.currentTimeMillis());
      timestamp=new Timestamp(timestamp.getTime()+ (1000 * 60 * 60 * 1)); 


      entityManager.persist(new Chariot((long) 111,timestamp,timestamp,Chariot.ETAT_CHAR.en_attente));
      entityManager.persist(new Chariot((long) 111,timestamp,timestamp,Chariot.ETAT_CHAR.en_attente));
  
      repository.deleteAll();
  
      assertThat(repository.findAll()).isEmpty();
    }
    */
}
