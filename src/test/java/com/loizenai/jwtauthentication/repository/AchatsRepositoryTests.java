package com.loizenai.jwtauthentication.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.Rollback;

import javax.sql.DataSource;

import com.loizenai.jwtauthentication.model.Achats;
import com.loizenai.jwtauthentication.model.Achats.PRET;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AchatsRepositoryTests {
/*   
    
    
    @Autowired
    private AchatsRepository achatsRepository;

    // JUnit test for saveEmployee

    @Autowired
    private TestEntityManager entityManager;
  
    @Autowired
    TutorialRepository repository;
  
    @Test
    @Order(1)
    @Rollback(value = false)
    public void should_find_no_tutorials_if_repository_is_empty() {
      Iterable<Tutorial> tutorials = repository.findAll();
  
      assertThat(tutorials).isEmpty();
    }
  
    @Test
    @Order(2)
    @Rollback(value = false)
    public void should_store_a_tutorial() {
      Tutorial tutorial = repository.save(new Tutorial("Tut title", "Tut desc", true));
  
      assertThat(tutorial).hasFieldOrPropertyWithValue("title", "Tut title");
      assertThat(tutorial).hasFieldOrPropertyWithValue("description", "Tut desc");
      assertThat(tutorial).hasFieldOrPropertyWithValue("published", true);
    }
  
    @Test
    @Order(3)
    @Rollback(value = false)
    public void should_find_all_tutorials() {
      Tutorial tut1 = new Tutorial("Tut#1", "Desc#1", true);
      entityManager.persist(tut1);
  
      Tutorial tut2 = new Tutorial("Tut#2", "Desc#2", false);
      entityManager.persist(tut2);
  
      Tutorial tut3 = new Tutorial("Tut#3", "Desc#3", true);
      entityManager.persist(tut3);
  
      Iterable<Tutorial> tutorials = repository.findAll();
  
      assertThat(tutorials).hasSize(3).contains(tut1, tut2, tut3);
    }
  
    @Test
    @Order(4)
    @Rollback(value = false)
    public void should_find_tutorial_by_id() {
      Tutorial tut1 = new Tutorial("Tut#1", "Desc#1", true);
      entityManager.persist(tut1);
  
      Tutorial tut2 = new Tutorial("Tut#2", "Desc#2", false);
      entityManager.persist(tut2);
  
      Tutorial foundTutorial = repository.findById(tut2.getId()).get();
  
      assertThat(foundTutorial).isEqualTo(tut2);
    }
  
    @Test
    @Order(5)
    @Rollback(value = false)
    public void should_find_published_tutorials() {
      Tutorial tut1 = new Tutorial("Tut#1", "Desc#1", true);
      entityManager.persist(tut1);
  
      Tutorial tut2 = new Tutorial("Tut#2", "Desc#2", false);
      entityManager.persist(tut2);
  
      Tutorial tut3 = new Tutorial("Tut#3", "Desc#3", true);
      entityManager.persist(tut3);
  
      Iterable<Tutorial> tutorials = repository.findByPublished(true);
  
      assertThat(tutorials).hasSize(2).contains(tut1, tut3);
    }
  
    @Test
    @Order(6)
    @Rollback(value = false)
    public void should_find_tutorials_by_title_containing_string() {
      Tutorial tut1 = new Tutorial("Spring Boot Tut#1", "Desc#1", true);
      entityManager.persist(tut1);
  
      Tutorial tut2 = new Tutorial("Java Tut#2", "Desc#2", false);
      entityManager.persist(tut2);
  
      Tutorial tut3 = new Tutorial("Spring Data JPA Tut#3", "Desc#3", true);
      entityManager.persist(tut3);
  
      Iterable<Tutorial> tutorials = repository.findByTitleContaining("ring");
  
      assertThat(tutorials).hasSize(2).contains(tut1, tut3);
    }
  
    @Test
    @Order(7)
    @Rollback(value = false)
    public void should_update_tutorial_by_id() {
      Tutorial tut1 = new Tutorial("Tut#1", "Desc#1", true);
      entityManager.persist(tut1);
  
      Tutorial tut2 = new Tutorial("Tut#2", "Desc#2", false);
      entityManager.persist(tut2);
  
      Tutorial updatedTut = new Tutorial("updated Tut#2", "updated Desc#2", true);
  
      Tutorial tut = repository.findById(tut2.getId()).get();
      tut.setTitle(updatedTut.getTitle());
      tut.setDescription(updatedTut.getDescription());
      tut.setPublished(updatedTut.isPublished());
      repository.save(tut);
  
      Tutorial checkTut = repository.findById(tut2.getId()).get();
      
      assertThat(checkTut.getId()).isEqualTo(tut2.getId());
      assertThat(checkTut.getTitle()).isEqualTo(updatedTut.getTitle());
      assertThat(checkTut.getDescription()).isEqualTo(updatedTut.getDescription());
      assertThat(checkTut.isPublished()).isEqualTo(updatedTut.isPublished());
    }
  
    @Test
    @Order(8)
    @Rollback(value = false)
    public void should_delete_tutorial_by_id() {
      Tutorial tut1 = new Tutorial("Tut#1", "Desc#1", true);
      entityManager.persist(tut1);
  
      Tutorial tut2 = new Tutorial("Tut#2", "Desc#2", false);
      entityManager.persist(tut2);
  
      Tutorial tut3 = new Tutorial("Tut#3", "Desc#3", true);
      entityManager.persist(tut3);
  
      repository.deleteById(tut2.getId());
  
      Iterable<Tutorial> tutorials = repository.findAll();
  
      assertThat(tutorials).hasSize(2).contains(tut1, tut3);
    }
  
    @Test
    @Order(9)
    @Rollback(value = false)
    public void should_delete_all_tutorials() {
      entityManager.persist(new Tutorial("Tut#1", "Desc#1", true));
      entityManager.persist(new Tutorial("Tut#2", "Desc#2", false));
  
      repository.deleteAll();
  
      assertThat(repository.findAll()).isEmpty();
    }
    */
}
