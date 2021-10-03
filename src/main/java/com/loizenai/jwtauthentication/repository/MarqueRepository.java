package com.loizenai.jwtauthentication.repository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import javax.transaction.Transactional;

import com.loizenai.jwtauthentication.model.Marque;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface MarqueRepository extends JpaRepository<Marque, Long> {

    @Query(value = "SELECT `code` FROM `marque` WHERE `marque_id` LIKE %:marque_id%", nativeQuery = true)
    public Optional<String> getTestMarque(@Param("marque_id") Long marque_id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM `model` WHERE `marque_id` LIKE %:marque_id%", nativeQuery = true)
    public void getAllModelByMarque(@Param("marque_id") Long marque_id);
}
