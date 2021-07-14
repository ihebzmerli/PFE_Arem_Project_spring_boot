package com.loizenai.jwtauthentication.repository;

import java.util.List;

import com.loizenai.jwtauthentication.model.Model;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface ModelRepository extends JpaRepository<Model, Long> {
    

    @Query(value = "SELECT * FROM `model` WHERE marque_id = (:marque_id)", nativeQuery = true)
    public List<Model> getAllModelByMarque(@Param("marque_id") Long marque_id);
}