package com.loizenai.jwtauthentication.repository;
import org.springframework.stereotype.Repository;

import com.loizenai.jwtauthentication.model.Marque;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface MarqueRepository extends JpaRepository<Marque, Long> {
    
}
